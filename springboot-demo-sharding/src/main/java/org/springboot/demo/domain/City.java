package org.springboot.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private Integer id;
    private Integer provinceId;
    private String cityName;
    private String description;
}
