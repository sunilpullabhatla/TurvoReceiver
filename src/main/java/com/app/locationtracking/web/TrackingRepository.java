package com.app.locationtracking.web;


import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.app.locationtracking.entity.TrackingInfo;
import com.app.locationtracking.entity.VehicleDriver;

@Repository
public interface TrackingRepository extends MongoRepository<TrackingInfo,Integer>  {

	  public List<TrackingInfo> findByIdAndCurrDateTimeBetween(String id,Date stDt, Date endDt);
	 
	
}

