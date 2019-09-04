package org.springboot.demo.service.impl;

import org.springboot.demo.domain.City;
import org.springboot.demo.mapper.CityMapper;
import org.springboot.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public City getCityInfo(String cityName) {
        return cityMapper.getCityInfo(cityName);
    }

    @Override
    public List<City> getAllCityInfo() {
        return cityMapper.getAllCityInfo();
    }

    @Override
    public List<City> getAllCityInfo(Integer pageNo, Integer pageSize) {
        return cityMapper.getAllCityInfo();
    }

    @Override
    public Integer addCityInfo(City city) {
        return cityMapper.insertCityInfo(city);
    }
}
