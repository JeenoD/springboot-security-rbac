package com.jeeno.springbootlogin.pojo.dos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * 资源权限表对应实体
 *
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/19 17:21
 */
@Data
@Entity
@Table(name = "permission_info")
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源描述
     */
    private String description;
    /**
     * 资源url
     */
    private String url;
    /**
     * 父id
     */
    private Long pid;

    @ManyToMany(targetEntity = RoleDO.class, fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission_relation", joinColumns = {@JoinColumn(name = "permission_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<RoleDO> roles;

}
