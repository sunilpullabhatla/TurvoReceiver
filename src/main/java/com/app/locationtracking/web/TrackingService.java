package com.app.locationtracking.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.locationtracking.entity.TrackingInfo;

@Service
public class TrackingService {

	@Autowired
	TrackingRepository trackingRepository;
	
	
	  public String loadDataAsset(TrackingInfo trackingInfo) {
		 TrackingInfo ti = trackingRepository.save(trackingInfo);
		 return ""+ti.getSno();
	    }
	    
	    
	    
	    public String loadDataMobile(TrackingInfo trackingInfo) {
	    	 TrackingInfo ti = 	trackingRepository.save(trackingInfo);
	    	 return ""+ti.getSno();
	    }
    
	    public List<Object[]> getAssetCalls(String id,String trackingType,Date stDt, Date endDt) {
	    	return trackingRepository.findByAssertDateRange(id,trackingType,stDt,endDt);
	    }
	    
	    public List<Object[]> getMobileCalls(long id,String trackingType,Date stDt, Date endDt) {
	    	return trackingRepository.findByMobileDateRange(id,trackingType,stDt,endDt);
	    }
	
	
}
