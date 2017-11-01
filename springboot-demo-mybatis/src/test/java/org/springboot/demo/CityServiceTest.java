package org.springboot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.demo.domain.City;
import org.springboot.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceTest {

    @Autowired
    private CityService cityService;

    @Test
    public void contextLoads() {
        List<City> city = cityService.getAllCityInfo();
        if (city != null && city.size() > 0) {
            System.out.println(city.size());
        }
        System.out.println("test");
    }
}
