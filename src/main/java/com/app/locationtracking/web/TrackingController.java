package com.app.locationtracking.web;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.locationtracking.entity.TrackingInfo;
import com.app.locationtracking.entity.VehicleDriver;


@RestController
@RequestMapping(value = "/tracker",consumes=MediaType.APPLICATION_JSON_VALUE )
public class TrackingController {

	@Autowired
	TrackingService trackingService;
	
	@PostMapping(path="/startTrip")
    public String startTrip(@RequestBody VehicleDriver vehicleDriver) {
 
    	return trackingService.startTrip(vehicleDriver);
    }
	
    @PostMapping(path="/trackingInfo")
    public String loadDataAsset(@RequestBody TrackingInfo trackingInfo) {
  
    	return trackingService.loadDataAsset(trackingInfo);
    }
    
   
	@GetMapping(path="/getAssets/{id}/{stDt}/{endDt}")
	public List<TrackingInfo> getAssetCalls(@PathVariable("id") String id,@PathVariable("stDt") @DateTimeFormat(pattern = "yyyyMMdd") Date stDt, @PathVariable("endDt") @DateTimeFormat(pattern = "yyyyMMdd") Date endDt ){
		
		return trackingService.getAssetCalls(id,stDt, endDt);
	}
	
	@PutMapping(path="/endTrip/{tripId}")
    public String endTrip(@PathVariable String tripId) {
 
    	return trackingService.endTrip(tripId);
    }
	

}
