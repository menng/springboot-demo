package org.springboot.demo.repository;

import org.springboot.demo.domain.CityB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityBRepository extends CrudRepository<CityB, Long> {

}
