package org.springboot.demo.repository;

import org.springboot.demo.domain.CityA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityARepository extends CrudRepository<CityA, Long> {

}
