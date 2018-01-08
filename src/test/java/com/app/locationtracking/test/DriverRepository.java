package com.app.locationtracking.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.app.locationtracking.entity.Driver;
@Component
@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {

}
