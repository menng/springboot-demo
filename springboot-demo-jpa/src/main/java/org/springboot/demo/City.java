package org.springboot.demo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "province_id")
    private Long provinceId;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "description")
    private String description;
}
