package org.springboot.demo.controller;

import org.springboot.demo.domain.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(Model model){
        // bean
        City city = new City();
        city.setCityName("北京");
        city.setDescription("没有北漂的人生是不完美的！");
        city.setProvinceId(110);
        city.setDate(new Date());

        // map
        Map<String, Object> map = new HashMap<>();
        map.put("like", 1);
        map.put("url", "/img/minato.jpg");
        map.put("thymeleaf", "thymeleaf");
        map.put("count", 110);
        map.put("role", "master");

        // list
        List<String> list = new ArrayList<>();
        list.add("故宫");
        list.add("长城");
        list.add("798艺术区");

        model.addAttribute("city", city);
        model.addAttribute("map", map);
        model.addAttribute("list", list);
        return "/thymeleaf";
    }

    @RequestMapping("/header")
    @ResponseBody
    public String requestHeader(@RequestHeader("token") String token) {
        return token;
    }

    @RequestMapping("/defaultheader")
    @ResponseBody
    public String defaultrequestHeader(@RequestHeader(value = "token", defaultValue = "defaultToken") String token) {
        return token;
    }
}
