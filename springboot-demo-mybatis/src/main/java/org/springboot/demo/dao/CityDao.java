package org.springboot.demo.dao;

import org.springboot.demo.domain.City;

import java.util.List;

public interface CityDao {
    City getCityInfo(String cityName);

    List<City> getAllCityInfo();

    Integer insertCityInfo(City city);

    void deleteCityInfoByName(String cityName);
}
