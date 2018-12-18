package org.springboot.shiro.service;

import org.springboot.shiro.dao.domain.User;
import org.springboot.shiro.dto.UserInfo;

public interface UserService {

    /**
     * 根据用户名获取用户信息，包括角色和权限
     */
    UserInfo findByUsername(String username);
}
