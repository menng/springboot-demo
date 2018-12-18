package org.springboot.shiro.service;

import org.springboot.shiro.dao.domain.User;
import org.springboot.shiro.dto.UserInfo;

public interface UserService {

    UserInfo findByUsername(String username);
}
