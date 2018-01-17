package com.app.locationtracking.web;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.app.locationtracking.entity.TrackingInfo;
import com.app.locationtracking.entity.VehicleDriver;

@Service
public class TrackingService {

	@Autowired
	TrackingRepository trackingRepository;
	@Autowired
	VehicleDriverRepository vehicleDriverRepository;
	
	
	public String startTrip(VehicleDriver vehicleDriver) {
		
			vehicleDriver.setStartDateTime(new Date());
			vehicleDriver.setStatus("Started");
			
			VehicleDriver vd = vehicleDriverRepository.save(vehicleDriver);
			  
			return "Trip Started successfully. Your Trip Id:"+vd.getId();
	}
	
	
	
	  public String loadDataAsset(TrackingInfo trackingInfo) {
		 trackingRepository.save(trackingInfo);
		 return "Inserted successfully";
	    }
	    
	    
	 
	    public List<TrackingInfo> getAssetCalls(String id,Date stDt, Date endDt) {
	    	return trackingRepository.findByIdAndCurrDateTimeBetween(id,stDt,endDt);
	    }
	    
	    
	    public String endTrip(String tripId) {
			
	    	VehicleDriver vd = vehicleDriverRepository.findById(tripId);
	    		
	    	if(vd != null) {
			vd.setEndDateTime(new Date());
			vd.setStatus("ended");
			
			vehicleDriverRepository.save(vd);
			  
			return "Trip Ended successfully";
	    	}else {
	    		return "Trip Id doesn't exists";
	    	}
	    	
	}
	  	
}
