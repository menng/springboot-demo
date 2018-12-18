package org.springboot.shiro.dao.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity(name = "sys_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = -5878967711830522129L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "permission")
    private String permission;
}
