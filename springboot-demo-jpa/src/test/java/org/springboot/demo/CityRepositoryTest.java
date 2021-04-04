package org.springboot.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class CityRepositoryTest {

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void testFindAll() {
        Iterable<City> iterable = cityRepository.findAll();
        iterable.forEach(city -> {
            log.info("{}", city.getCityName());
        });
    }
}
