package com.jeeno.springbootlogin.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * 权限决策器
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/31 9:26
 */
@Slf4j
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        Iterator<ConfigAttribute> iterator = collection.iterator();
        while (iterator.hasNext()){
            ConfigAttribute configAttribute = iterator.next();
            //访问该请求url需要的角色信息
            String needRole = configAttribute.getAttribute();
            // 对于登录即可访问的资源，校验当前用户是否登录
            if ("ROLE_login".equals(needRole)){
                //判断是否登陆，没有登陆时authentication是AnonymousAuthenticationToken接口实现类的对象
                if (authentication instanceof AnonymousAuthenticationToken){
                    throw new BadCredentialsException("未登录");
                }
                return;
            }
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            //如果匹配上了资源信息，就拿登陆用户的权限信息来对比是否存在于已匹配的角色集合中
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)){
                    return;
                }
            }
        }
        // 始终没有匹配，即权限不足
        throw new AccessDeniedException("权限不足");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
