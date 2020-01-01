package com.jeeno.springbootlogin.service;

import com.jeeno.springbootlogin.pojo.dos.PermissionDO;

import java.util.List;

/**
 * 资源相关的业务层接口
 *
 * @author Jeeno
 * @version 1.0.0
 * @date 2019/12/20 00:11
 */
public interface IPermissionService {

    /**
     * 获取所有的资源信息
     *
     * @return List
     */
    List<PermissionDO> getAll();
}
