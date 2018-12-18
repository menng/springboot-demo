package org.springboot.shiro.dto;

import lombok.Data;
import org.springboot.shiro.dao.domain.Permission;

import java.io.Serializable;
import java.util.List;

@Data
public class RoleDto implements Serializable {

    private static final long serialVersionUID = -5254717778111437785L;

    /**
     * 角色Id
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 权限
     */
    List<Permission> permissions;
}
