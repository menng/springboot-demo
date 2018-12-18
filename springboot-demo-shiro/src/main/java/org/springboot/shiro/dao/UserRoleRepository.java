package org.springboot.shiro.dao;

import org.springboot.shiro.dao.domain.User;
import org.springboot.shiro.dao.domain.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {

    /**
     * 根据userId获取所有角色
     */
    List<UserRole> findAllByUserId(Integer userId);
}
