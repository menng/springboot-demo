package org.springboot.shiro.dao.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity(name = "sys_role_permission")
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 7123420483732914099L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "permission_id")
    private Integer permissionId;
}
