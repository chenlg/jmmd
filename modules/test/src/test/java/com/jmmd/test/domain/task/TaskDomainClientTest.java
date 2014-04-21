/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmmd.test.domain.task;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jmmd.core.domain.task.impl.TaskDomainImpl;
import com.jmmd.core.persistant.po.task.TaskPO;
import com.jmmd.core.persistant.repository.task.TaskMybatisDao;

/**
 * Reason:	 Mockito 单元测试.
 *  
 *   <p>增加代码覆盖率
 *   
 * @author chenlg
 */
public class TaskDomainClientTest {

    @InjectMocks
    private TaskDomainImpl taskDomain;

    @Mock
    private TaskMybatisDao taskDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void saveTask() {
        TaskPO taskPO = new TaskPO();
        taskPO.setStatus(Boolean.TRUE);
        taskPO.setTaskCode("task Code");
        taskPO.setTaskName("task Name");

        taskDomain.saveTask(taskPO);
        Mockito.verify(taskDao, Mockito.never()).delete(new Integer(1));
    }
}
