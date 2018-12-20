package org.springboot.shiro.dao.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "sys_role")
public class Role {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "role_name")
    private String roleName;
}
