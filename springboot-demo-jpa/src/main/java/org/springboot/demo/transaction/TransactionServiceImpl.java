package org.springboot.demo.transaction;


import org.springboot.demo.domain.CityA;
import org.springboot.demo.domain.CityB;
import org.springboot.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionServiceChildA childA;
    @Autowired
    private TransactionServiceChildB childB;
    @Autowired
    private CityRepository cityRepository;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void save() {

        CityA cityA = new CityA();
        cityA.setProvinceId(1L);
        CityB cityB = new CityB();
        cityB.setProvinceId(1L);

        childA.save(cityA);
        childB.save(cityB);

        CityA.City city = new CityA.City();
        city.setId(1L);
        cityRepository.save(city);
    }
}
