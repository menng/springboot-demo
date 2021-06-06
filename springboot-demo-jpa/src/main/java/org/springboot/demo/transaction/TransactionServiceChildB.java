package org.springboot.demo.transaction;

import org.springboot.demo.domain.CityB;

public interface TransactionServiceChildB {

    void save(CityB city);
}
