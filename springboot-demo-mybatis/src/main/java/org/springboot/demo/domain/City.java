package org.springboot.demo.domain;

public class City {
    private Integer id;
    private Integer provinceId;
    private String cityName;
    private String description;

    public City() {}

    public City(Integer provinceId, String cityName, String description) {
        this.provinceId = provinceId;
        this.cityName = cityName;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
