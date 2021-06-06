package org.springboot.demo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "city")
public class CityA {

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

    @Data
    @Entity
    @Table(name = "city")
    public static class City {

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
}
