package com.app.locationtracking.web;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.locationtracking.entity.VehicleDriver;

public interface VehicleDriverRepository extends MongoRepository<VehicleDriver,String>{
	
	
	public String findTopStatusByVehicleIdAndDriverIdOrderByStartDateTime(String vehicleId,String driverId);
	
	 public VehicleDriver findById(String tripId);

}
