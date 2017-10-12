package org.springboot.demo.controller;

import org.springboot.demo.domain.City;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/param")
public class ParamController {

    @GetMapping("/base")
    public String getBaseParam(String a, Integer b) {
        return a + "-" + b;
    }

    @PostMapping("/bean")
    public String getBeanParam(City city) {
        return city.getCityName() + "-" + city.getDescription();
    }

    @PostMapping("/beanHasList")
    public String getBeanHasListParam(@RequestBody City city) {
        return city.getCityName() + "-" + city.getList().size();
    }

    @PostMapping("/list")
    public String getListParam(@RequestParam("list[]") List<String> list, Integer a) {
        return list.size() + "-" + a;
    }

    @PostMapping("/beanList")
    public String getBeanListParam(@RequestBody List<City> list) {
        return list.size() + "";
    }
}
