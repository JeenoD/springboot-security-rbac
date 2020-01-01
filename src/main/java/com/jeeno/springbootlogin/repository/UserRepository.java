package com.jeeno.springbootlogin.repository;

import com.jeeno.springbootlogin.pojo.dos.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/19 17:24
 */
@Repository
public interface UserRepository extends JpaRepository<UserDO, Long> {

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return UserDO
     */
    UserDO findByUsername(String username);
}
