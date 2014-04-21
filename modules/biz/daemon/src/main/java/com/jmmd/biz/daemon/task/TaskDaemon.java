/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmmd.biz.daemon.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.jmmd.biz.manager.bo.task.TaskBO;
import com.jmmd.biz.manager.handle.task.TaskManager;

/**
 * Reason:	被Spring各种Scheduler反射调用的Service POJO.
 * 
 * @author chenlg
 * @version $Id: TaskDaemonHandel.java, v 0.1 2014年4月18日 下午2:56:52 chenlg Exp $
 * @since    JDK 1.7
 */
@Component("taskDaemon")
public class TaskDaemon {

    private static Logger logger = LoggerFactory.getLogger(TaskDaemon.class);

    @Autowired
    @Qualifier("taskManager")
    private TaskManager   taskManager;

    /**
     * 被Spring的Quartz MethodInvokingJobDetailFactoryBean反射执行
     */
    public void execute() {
        logger.info("守护任务开始!");
        TaskBO taskBO = new TaskBO();
        taskBO.setStatus(Boolean.TRUE);
        taskBO.setTaskCode("task code");
        taskBO.setTaskName("task china");
        Boolean result = taskManager.saveTask(taskBO);
        logger.info("守护任务执行结果:{}",result);
    }

}
