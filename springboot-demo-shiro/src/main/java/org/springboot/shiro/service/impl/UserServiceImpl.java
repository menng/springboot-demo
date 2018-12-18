package org.springboot.shiro.service.impl;

import org.springboot.shiro.dao.PermissionRepository;
import org.springboot.shiro.dao.RolePermissionRepository;
import org.springboot.shiro.dao.RoleRepository;
import org.springboot.shiro.dao.UserRepository;
import org.springboot.shiro.dao.UserRoleRepository;
import org.springboot.shiro.dao.domain.Permission;
import org.springboot.shiro.dao.domain.Role;
import org.springboot.shiro.dao.domain.RolePermission;
import org.springboot.shiro.dao.domain.User;
import org.springboot.shiro.dao.domain.UserRole;
import org.springboot.shiro.dto.RoleDto;
import org.springboot.shiro.dto.UserInfo;
import org.springboot.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public UserInfo findByUsername(String username) {
        UserInfo userInfo = new UserInfo();

        // 用户
        User user = userRepository.findByUsername(username);
        userInfo.setId(user.getId());
        userInfo.setUsername(user.getUsername());
        userInfo.setPassword(user.getPassword());

        // 角色
        List<UserRole> userRoles = userRoleRepository.findAllByUserId(user.getId());
        if (userRoles != null && userRoles.size() > 0) {
            List<Integer> roleIds = new ArrayList<>();
            userRoles.stream().forEach(userRole -> {
                roleIds.add(userRole.getRoleId());
            });

            List<Role> roles = roleRepository.findAllByIdIsIn(roleIds);
            if (roles != null && roles.size() > 0) {
                List<RoleDto> roleDtos = new ArrayList<>();
                roles.stream().forEach(role -> {
                    RoleDto roleDto = new RoleDto();
                    roleDto.setRoleName(role.getRoleName());
                    roleDto.setRoleId(role.getId());

                    // 权限
                    List<RolePermission> rolePermissions = rolePermissionRepository.findAllByRoleId(role.getId());
                    if (rolePermissions != null && rolePermissions.size() > 0) {
                        List<Integer> permissionIds = new ArrayList<>();
                        rolePermissions.stream().forEach(rolePermission -> {
                            permissionIds.add(rolePermission.getPermissionId());
                        });

                        List<Permission> permissions = permissionRepository.findAllByIdIsIn(permissionIds);
                        roleDto.setPermissions(permissions);
                    }

                    roleDtos.add(roleDto);
                });

                userInfo.setRoles(roleDtos);
            }
        }

        return userInfo;
    }
}
