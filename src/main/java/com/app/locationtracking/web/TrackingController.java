package com.app.locationtracking.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.locationtracking.entity.DeviceType;
import com.app.locationtracking.entity.TrackingInfo;


@RestController
@RequestMapping(value = "/track" )
public class TrackingController {

	@Autowired
	TrackingService trackingService;
	
    @PostMapping(path="/asset",consumes=MediaType.APPLICATION_JSON_VALUE)
    public String loadDataAsset(@RequestBody TrackingInfo trackingInfo) {
    	trackingInfo.setDeviceType(DeviceType.GPS_DEVICE.getDeviceType());
    	return trackingService.loadDataAsset(trackingInfo);
    }
    
    
    @PostMapping(path="/mobile",consumes=MediaType.APPLICATION_JSON_VALUE)
    public String loadDataMobile(@RequestBody TrackingInfo trackingInfo) {
     	trackingInfo.setDeviceType(DeviceType.MOBILE.getDeviceType());
     	return trackingService.loadDataMobile(trackingInfo);
    }

	@GetMapping(path="/getcalls/asset/{id}/{stDt}/{endDt}")
	public List<Object[]> getAssetCalls(@PathVariable("id") String id,@PathVariable("stDt") @DateTimeFormat(pattern = "yyyyMMdd") Date stDt, @PathVariable("endDt") @DateTimeFormat(pattern = "yyyyMMdd") Date endDt ){
		
		return trackingService.getAssetCalls(id,DeviceType.GPS_DEVICE.getDeviceType(),stDt, endDt);
	}
	
	@GetMapping(path="/getcalls/mobile/{id}/{stDt}/{endDt}")
	public List<Object[]> getMobileCalls(@PathVariable("id") long id,@PathVariable("stDt") @DateTimeFormat(pattern = "yyyyMMdd") Date stDt, @PathVariable("endDt") @DateTimeFormat(pattern = "yyyyMMdd") Date endDt ){
		
		return trackingService.getMobileCalls(id,DeviceType.MOBILE.getDeviceType(),stDt, endDt);
	}
	
}
