package org.springboot.demo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "city")
public class CityB {

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
