package org.springboot.demo.mapper;

import org.springboot.demo.domain.City;

import java.util.List;

public interface CityMapper {
    City getCityInfo(String cityName);

    List<City> getAllCityInfo();

    Integer insertCityInfo(City city);

    void deleteCityInfoByName(String cityName);
}
