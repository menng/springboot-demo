package org.springboot.shiro.dao;

import org.springboot.shiro.dao.domain.RolePermission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionRepository extends CrudRepository<RolePermission, Integer> {

    List<RolePermission> findAllByRoleId(Integer roleId);
}
