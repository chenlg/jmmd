/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmmd.test.manager.task;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jmmd.biz.manager.bo.task.TaskBO;
import com.jmmd.biz.manager.handle.task.impl.TaskManagerHandle;
import com.jmmd.core.domain.task.TaskDomain;
import com.jmmd.core.persistant.repository.task.TaskMybatisDao;

/**
 * Reason:	 Mockito 单元测试.
 *  
 *   <p>增加代码覆盖率
 *   
 * @author chenlg
 */
public class TaskManagerClientTest {
    
    @InjectMocks
    private TaskManagerHandle taskManager;

    @Mock
    private TaskDomain taskDomain;

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
        TaskBO taskBO = new TaskBO();
        taskBO.setStatus(Boolean.TRUE);
        taskBO.setTaskCode("task Code");
        taskBO.setTaskName("task Name");

        taskManager.saveTask(taskBO);
        Mockito.verify(taskDao, Mockito.never()).delete(new Integer(1));
    }
}
