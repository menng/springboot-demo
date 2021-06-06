package org.springboot.demo.transaction;

import org.springboot.demo.domain.CityA;
import org.springboot.demo.repository.CityARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TransactionServiceChildAImpl implements TransactionServiceChildA{

    @Autowired
    private CityARepository repository;

    @Transactional
    public void save(CityA city) {
        repository.save(city);
    }
}
