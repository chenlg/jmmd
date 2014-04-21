/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmmd.test.repository.task;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.jmmd.core.persistant.po.task.TaskPO;
import com.jmmd.core.persistant.repository.task.TaskMybatisDao;
import com.jmmd.test.SpringTransactionalTestCase;

/**
 * Reason:	 Dao单元测试. 
 * 
 * @author chenlg
 */
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext-mybatis.xml" })
public class TaskMybatisDaoTest extends SpringTransactionalTestCase {

    @Autowired
    private TaskMybatisDao taskDao;

    @Test
    public void getTask() throws Exception {
        TaskPO task = taskDao.get(new Integer(1));
        assertThat(task).as("Task not found").isNotNull();
    }

    @Test
    public void saveTask() {
        TaskPO taskPO = new TaskPO();
        taskPO.setStatus(Boolean.TRUE);
        taskPO.setTaskCode("task code");
        taskPO.setTaskName("task name");

        int count = countRowsInTable("ss_task");
        taskDao.save(taskPO);
        Integer id = taskPO.getTaskId();

        assertThat(countRowsInTable("ss_task")).isEqualTo(count + 1);
        TaskPO result = taskDao.get(id);
        assertThat(result.getTaskCode()).isEqualTo(taskPO.getTaskCode());

        // delete
        taskDao.delete(id);
        assertThat(countRowsInTable("ss_task")).isEqualTo(count);
        assertThat(taskDao.get(id)).isNull();

    }

}
