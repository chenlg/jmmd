/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmmd.core.persistant.repository.task;

import com.jmmd.core.persistant.po.task.TaskPO;
import com.jmmd.core.persistant.repository.MyBatisRepository;

/**
 * Reason:  通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * 
 * @author chenlg
 * @version $Id: TaskMybatisDao.java, v 0.1 2014年4月16日 下午4:17:03 chenlg Exp $
 * @since    JDK 1.7
 * @see org.mybatis.spring.mapper.MapperScannerConfigurer
 */
@MyBatisRepository
public interface TaskMybatisDao {

    /**
     *  Reason: Repository 层API省略.
     */
    TaskPO get(Integer taskId);
    
    /**
     *  Reason: Repository 层API省略.
     */
    void save(TaskPO taskPO);

    /**
     *  Reason: Repository 层API省略.
     */
    void delete(Integer taskId);
}
