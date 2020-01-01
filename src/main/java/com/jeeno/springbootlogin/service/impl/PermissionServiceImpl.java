package com.jeeno.springbootlogin.service.impl;

import com.jeeno.springbootlogin.pojo.dos.PermissionDO;
import com.jeeno.springbootlogin.repository.PermissionRepository;
import com.jeeno.springbootlogin.service.IPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 资源相关的业务层接口的实现类
 *
 * @author Jeeno
 * @version 1.0.0
 * @date 2019/12/20 00:12
 */
@Slf4j
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Resource
    private PermissionRepository permissionRepository;

    @Override
    public List<PermissionDO> getAll() {
        return permissionRepository.findAllPermissions();
    }
}
