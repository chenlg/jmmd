/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmmd.biz.manager.handle.task.impl;

import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.Validate;
import org.javasimon.aop.Monitored;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jmmd.biz.manager.bo.task.TaskBO;
import com.jmmd.biz.manager.handle.exception.ManagerExceptions;
import com.jmmd.biz.manager.handle.task.TaskManager;
import com.jmmd.common.utils.annotation.AspectLogger;
import com.jmmd.core.domain.task.TaskDomain;
import com.jmmd.core.persistant.po.task.TaskPO;

/**
 * Reason:	 业务处理实现类.
 * 
 * @author chenlg
 * @version $Id: TaskManagerHandle.java, v 0.1 2014年4月18日 下午4:59:33 chenlg Exp $
 * @since    JDK 1.7
 */
@Monitored
@Service("taskManager")
public class TaskManagerHandle implements TaskManager {

    private static Logger logger = LoggerFactory.getLogger(TaskManagerHandle.class);

    @Autowired
    @Qualifier("taskDomain")
    private TaskDomain    taskDomain;

    /** 
     * @see com.jmmd.biz.manager.handle.task.TaskManager#getTask(java.lang.Integer)
     */
    @Override
    @AspectLogger(value = "获取任务", discover = true)
    public TaskBO getTask(Integer taskId) {
        TaskBO taskBO = null;
        try {

            Validate.notNull(taskId, "id参数为空");

            TaskPO taskPO = taskDomain.getTask(taskId);

            Validate.notNull(taskPO, "任务不存在(id:" + taskId + ")");

            /*
             * 对象PO转BO
             */
            taskBO = new TaskBO();
            BeanUtils.copyProperties(taskPO, taskBO);

        } catch (NullPointerException e) {
            if (logger.isErrorEnabled())
                logger.error(e.getMessage());
        } catch (IllegalArgumentException e) {
            if (logger.isErrorEnabled())
                logger.error(e.getMessage());
        } catch (RuntimeException e) {
            if (logger.isErrorEnabled())
                logger.error(e.getMessage());
        }

        return taskBO;
    }

    /**
     * @see com.jmmd.biz.manager.handle.task.TaskManager#saveTask(com.jmmd.biz.manager.bo.task.TaskBO)
     */
    @Override
    @Transactional(readOnly = false)
    @AspectLogger(value = "保存任务", discover = true)
    public Boolean saveTask(TaskBO taskBO) {
        TaskPO taskPO = null;

        try {
            Validate.notNull(taskBO, "任务参数为空");

            taskPO = new TaskPO();
            BeanUtils.copyProperties(taskBO, taskPO);
            taskDomain.saveTask(taskPO);

            return Boolean.TRUE;
        } catch (ConstraintViolationException e) {
            if (logger.isErrorEnabled())
                logger.error(e.getMessage());
            return Boolean.FALSE;
        } catch (RuntimeException e) {
            if (ManagerExceptions.isCausedBy(e, DuplicateKeyException.class)) {
                String message = "新建任务参数存在唯一性冲突(任务:" + taskPO + ")";
                if (logger.isErrorEnabled())
                    logger.error(message, e.getMessage());
                return Boolean.FALSE;
            } else {
                if (logger.isErrorEnabled())
                    logger.error(e.getMessage());
                return Boolean.FALSE;
            }
        }
    }

    /** 
     * @see com.jmmd.biz.manager.handle.task.TaskManager#deleteTask(java.lang.Integer)
     */
    @Override
    @Transactional(readOnly = false)
    @AspectLogger(value = "删除任务", discover = true)
    public Boolean deleteTask(Integer taskId) {
        try {
            Validate.notNull(taskId, "任务主键参数为空");

            taskDomain.deleteTask(taskId);

            return Boolean.TRUE;
        } catch (ConstraintViolationException e) {
            if (logger.isErrorEnabled())
                logger.error(e.getMessage());
            return Boolean.FALSE;
        } catch (RuntimeException e) {
            if (logger.isErrorEnabled())
                logger.error(e.getMessage());
            return Boolean.FALSE;
        }
    }

}
