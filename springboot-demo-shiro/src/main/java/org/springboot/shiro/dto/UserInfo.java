package org.springboot.shiro.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -5110701573392717862L;

    /**
     * 主键Id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色
     */
    private List<RoleDto> roles;
}
