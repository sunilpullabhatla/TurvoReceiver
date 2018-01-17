package com.app.locationtracking.test;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.app.locationtracking.entity.Driver;
@Component
@Repository
public interface DriverRepository extends MongoRepository<Driver,Integer> {

}
