package com.jeeno.springbootlogin.pojo.dos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色表对应的实体类
 *
 * @author Jeeno
 * @version 1.0.0
 * @date 2019/12/19 23:07
 */
@Setter
@Getter
@Entity
@Table(name = "role_info")
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RoleDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色编码
     */
    private String code;
    /**
     * 父节点id
     */
    private Long pid;
    /**
     * 级别
     */
    private Integer level;

    // 双向绑定会在json化的时候陷入死循环导致堆栈溢出，所以这里注释了，只保留单向的绑定
//    @ManyToMany(targetEntity = UserDO.class, mappedBy = "roles")
//    @JsonIgnoreProperties
//    private Set<UserDO> users = new HashSet<>();

//    @ManyToMany(targetEntity = PermissionDO.class, fetch = FetchType.EAGER)
//    @JoinTable(name = "role_permission_relation", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "permission_id")})
//    private Set<PermissionDO> permissions;

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RoleDO) {
            return code.equals(((RoleDO) obj).getCode());
        }
        return false;
    }
}
