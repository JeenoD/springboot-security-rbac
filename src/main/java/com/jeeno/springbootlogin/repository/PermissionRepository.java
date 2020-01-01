package com.jeeno.springbootlogin.repository;

import com.jeeno.springbootlogin.pojo.dos.PermissionDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jeeno
 * @version 1.0.0
 * @date 2019/12/19 22:51
 */
@Repository
public interface PermissionRepository extends JpaRepository<PermissionDO, Long> {

    /**
     * 返回资源表所有数据的列表
     *
     * @return List
     */
    @Query(value = "select p from PermissionDO p")
    List<PermissionDO> findAllPermissions();

}
