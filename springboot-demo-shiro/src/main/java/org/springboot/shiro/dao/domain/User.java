package org.springboot.shiro.dao.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "sys_user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String password;
}
