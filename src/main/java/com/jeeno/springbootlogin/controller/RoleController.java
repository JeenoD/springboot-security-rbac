package com.jeeno.springbootlogin.controller;

import com.jeeno.springbootlogin.pojo.ReturnDTO;
import com.jeeno.springbootlogin.repository.PermissionRepository;
import com.jeeno.springbootlogin.service.IPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 角色及其授权url相关的控制层接口
 * @author Jeeno
 * @version 1.0.0
 * @date 2019/12/20 00:09
 */
@Slf4j
@RestController
public class RoleController {

    @Resource
    private IPermissionService permissionService;

    @GetMapping("/all")
    public ReturnDTO getAllPermissions() {
        return ReturnDTO.builder().status(ReturnDTO.StatusEnum.SUCCESS).msg("操作成功").data(permissionService.getAll()).build();
    }
}
