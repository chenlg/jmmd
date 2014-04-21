/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmmd.core.domain.task.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jmmd.core.domain.task.TaskDomain;
import com.jmmd.core.persistant.po.task.TaskPO;
import com.jmmd.core.persistant.repository.task.TaskMybatisDao;

/**
 * Reason:	 任务领域接口实现类. 
 * 
 * @author chenlg
 * @version $Id: TaskDomainImpl.java, v 0.1 2014年4月16日 下午4:22:45 chenlg Exp $
 * @since    JDK 1.7
 */
@Component("taskDomain")
@Transactional(readOnly = true)
public class TaskDomainImpl implements TaskDomain {

    @Autowired
    private TaskMybatisDao taskDao;

    /**
     * @see com.jmmd.core.domain.task.TaskDomain#getTask(java.lang.Integer)
     */
    @Override
    public TaskPO getTask(Integer taskId) {
        return taskDao.get(taskId);
    }

    /**
     * @see com.jmmd.core.domain.task.TaskDomain#saveTask(com.jmmd.core.persistant.po.task.TaskPO)
     */
    @Override
    @Transactional(readOnly = false)
    public void saveTask(TaskPO taskPO) {
        taskDao.save(taskPO);
    }

    /**
     * @see com.jmmd.core.domain.task.TaskDomain#deleteTask(java.lang.Integer)
     */
    @Override
    @Transactional(readOnly = false)
    public void deleteTask(Integer taskId) {
        taskDao.delete(taskId);
    }

}
