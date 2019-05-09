package org.springboot.demo;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.demo.mapper.CityMapper;
import org.springboot.demo.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingApplicationTests {

    @Autowired
    private CityMapper cityMapper;

    @Test
    public void testSelect() {
        List<City> allCityInfo = cityMapper.getAllCityInfo();
        log.info("{}", JSON.toJSONString(allCityInfo));
    }

}
