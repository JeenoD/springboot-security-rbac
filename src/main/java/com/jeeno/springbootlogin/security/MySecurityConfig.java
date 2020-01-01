package com.jeeno.springbootlogin.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.annotation.Resource;

/**
 * security 核心配置类
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/19 14:10
 */
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private SecurityMetadataSource securityMetadataSource;

    @Resource
    private MyAccessDecisionManager accessDecisionManager;

    @Resource
    private MyAccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 登录配置
        http.formLogin().permitAll();

        http.authorizeRequests()
                // 配置上动态权限校验的后置处理器
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <T extends FilterSecurityInterceptor> T postProcess(T o) {
                        o.setSecurityMetadataSource(securityMetadataSource);
                        o.setAccessDecisionManager(accessDecisionManager);
                        return o;
                    }
                })
                .and()
                // 登录配置
                    .formLogin().permitAll();

        // 无权限时的处理逻辑（用户登录后）
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);

        // 禁用csrf校验防护
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) {
        // 排除对静态资源的拦截(需要在properties中配置静态资源映射)
        web.ignoring().antMatchers("/static/**");
        // 首页放行
        web.ignoring().antMatchers("/", "/index");
    }

}
