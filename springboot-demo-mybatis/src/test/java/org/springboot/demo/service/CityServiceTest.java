package org.springboot.demo.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.demo.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CityServiceTest {

    private static final Logger log = LoggerFactory.getLogger(CityServiceTest.class);

    @Autowired
    private CityService cityService;

    @Test
    public void testGetAllCityInfo() {
        List<City> cities = cityService.getAllCityInfo();
        for(City city: cities) {
            log.info("cityName={}", city.getCityName());
        }
    }

    @Test
    public void testGetAllCityInfo2() {
        List<City> cities = cityService.getAllCityInfo(1, 1);
        for(City city: cities) {
            log.info("cityName={}", city.getCityName());
        }
    }
}
