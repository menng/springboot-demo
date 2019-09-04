package org.springboot.demo.controller;

import org.springboot.demo.domain.City;
import org.springboot.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by menng on 2019/09/04.
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping(value = "/info/add")
    public Integer addCityInfo(City city) {
        return cityService.addCityInfo(city);
    }
}
