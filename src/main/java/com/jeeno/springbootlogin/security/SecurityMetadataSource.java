package com.jeeno.springbootlogin.security;

import com.jeeno.springbootlogin.pojo.dos.PermissionDO;
import com.jeeno.springbootlogin.pojo.dos.RoleDO;
import com.jeeno.springbootlogin.repository.PermissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 资源所需要的角色信息组装
 *
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/19 19:15
 */
@Slf4j
@Component
public class SecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Resource
    private PermissionRepository permissionRepository;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        log.debug("SecurityMetadataSource");
        //请求的url
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        // 获取当前资源所需要的角色信息
        List<PermissionDO> list = permissionRepository.findAllPermissions();
        for (PermissionDO permission : list) {
            if (antPathMatcher.match(permission.getUrl(), requestUrl) && !permission.getRoles().isEmpty()) {
                Set<RoleDO> set = permission.getRoles();
                String[] arr = new String[set.size()];
                Set<String> needRoles = set.stream().map(RoleDO::getCode).collect(Collectors.toSet());
                return SecurityConfig.createList(needRoles.toArray(arr));
            }
        }
        // 默认的"需要登录"角色
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }

}
