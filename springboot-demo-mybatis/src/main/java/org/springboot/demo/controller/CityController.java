package org.springboot.demo.controller;

import org.springboot.demo.domain.City;
import org.springboot.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mengxy on 2017/10/12.
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/info/{cityName}", method = RequestMethod.GET)
    public City getCityInfo(@PathVariable("cityName") String cityName) {
        return cityService.getCityInfo(cityName);
    }

    @RequestMapping(value = "/info/all", method = RequestMethod.GET)
    public List<City> getAllCityInfo() {
        return cityService.getAllCityInfo();
    }

    @RequestMapping(value = "/info/add", method = RequestMethod.POST)
    public Integer addCityInfo(City city) {
        return cityService.addCityInfo(city);
    }
}