package org.springboot.demo.transaction;

import org.springboot.demo.domain.CityB;
import org.springboot.demo.repository.CityBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TransactionServiceChildBImpl implements TransactionServiceChildB{

    @Autowired
    private CityBRepository repository;

    @Transactional
    public void save(CityB city) {
        repository.save(city);
    }
}
