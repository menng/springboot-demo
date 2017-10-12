package org.springboot.demo.service.impl;

import org.springboot.demo.dao.CityDao;
import org.springboot.demo.domain.City;
import org.springboot.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public City getCityInfo(String cityName) {
        return cityDao.getCityInfo(cityName);
    }

    @Override
    public List<City> getAllCityInfo() {
        return cityDao.getAllCityInfo();
    }

    @Override
    public Integer addCityInfo(City city) {
        return cityDao.insertCityInfo(city);
    }
}
