/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmmd.biz.manager.handle.task;

import com.jmmd.biz.manager.bo.task.TaskBO;

/**
 * Reason:	 业务处理接口类. 
 * 
 * @author chenlg
 * @version $Id: TaskManagerHandle.java, v 0.1 2014年4月18日 下午4:57:38 chenlg Exp $
 * @since    JDK 1.7
 */
public interface TaskManager {

    /**
     * 根据taskId 获取任务记录对象.
     * 
     * @param taskId
     * @return {@link TaskBO}
     */
    TaskBO getTask(Integer taskId);

    /**
     * 根据任务对象新增记录.
     * 
     * @param taskBO
     * @return 
     */
    Boolean saveTask(TaskBO taskBO);

    /**
     * 根据taskId 删除任务记录.
     * 
     * @param taskId
     * @return
     */
    Boolean deleteTask(Integer taskId);
}
