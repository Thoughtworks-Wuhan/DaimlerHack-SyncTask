package com.daimler.entity.vehicle;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CarRepository extends CrudRepository<Car, Long> {

}
