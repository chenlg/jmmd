/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmmd.core.domain.task;

import com.jmmd.core.persistant.po.task.TaskPO;

/**
 * Reason:	 任务领域接口类. 
 * 
 * @author chenlg
 * @version $Id: TaskDomain.java, v 0.1 2014年4月16日 下午4:21:48 chenlg Exp $
 * @since    JDK 1.7
 */
public interface TaskDomain {

    /**
     * 根据taskId 获取任务记录对象.
     */
    TaskPO getTask(Integer taskId);

    /**
     * 根据任务对象新增记录.
     */
    void saveTask(TaskPO taskPO);

    /**
     * 根据taskId 删除任务记录.
     */
    void deleteTask(Integer taskId);

}
