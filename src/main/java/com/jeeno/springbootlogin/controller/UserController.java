package com.jeeno.springbootlogin.controller;

import com.jeeno.springbootlogin.pojo.dos.UserDO;
import com.jeeno.springbootlogin.pojo.ReturnDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试用户权限的控制层接口
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/19 14:22
 */
@Slf4j
@RestController
public class UserController {

    @GetMapping("/info")
    public ReturnDTO<UserDO> info(@AuthenticationPrincipal UserDO userDO) {
        return ReturnDTO.<UserDO>builder().data(userDO).status(ReturnDTO.StatusEnum.SUCCESS).msg("操作成功").build();
    }

    @GetMapping("/prov")
    public ReturnDTO<String> hello() {
        return ReturnDTO.<String>builder().status(ReturnDTO.StatusEnum.SUCCESS).msg("操作成功").data("省级及以上用户使用").build();
    }

    @GetMapping("/admin")
    public ReturnDTO<String> admin() {
        return ReturnDTO.<String>builder().status(ReturnDTO.StatusEnum.SUCCESS).msg("操作成功").data("超管专属页面").build();
    }

    @GetMapping("/user")
    public ReturnDTO<String> user() {
        return ReturnDTO.<String>builder().status(ReturnDTO.StatusEnum.SUCCESS).msg("操作成功").data("普通用户个人中心").build();
    }

}
