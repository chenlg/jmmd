/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmmd.biz.manager.bo.task;

import java.io.Serializable;

/**
 * Reason:	 业务层任务对象.
 * 
 * @author chenlg
 * @version $Id: TaskBO.java, v 0.1 2014年4月16日 下午4:15:09 chenlg Exp $
 * @since    JDK 1.7
 */
public class TaskBO implements Serializable {

    /**  */
    private static final long serialVersionUID = -2690127816025138010L;

    /**
     * 任务主键
     */
    private Integer           taskId;

    /**
     * 任务别名
     */
    private String            taskName;

    /**
     * 任务代码
     */
    private String            taskCode;

    /**
     * 任务状态
     */
    private Boolean           status;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
