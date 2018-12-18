package org.springboot.shiro.dao;

import org.springboot.shiro.dao.domain.Permission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Integer> {

    List<Permission> findAllByIdIsIn(List<Integer> ids);
}
