package org.springboot.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springboot.demo.domain.CityA;
import org.springboot.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = JpaApplication.class)
public class CityRepositoryTest {

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void testFindAll() {
        Iterable<CityA.City> iterable = cityRepository.findAll();
        iterable.forEach(city -> {
            log.info("{}", city.getCityName());
        });
    }
}
