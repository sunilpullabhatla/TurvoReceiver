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
	
	
	  public void loadDataAsset(TrackingInfo trackingInfo) {
		  trackingRepository.save(trackingInfo);
	    }
	    
	    
	    
	    public void loadDataMobile(TrackingInfo trackingInfo) {
	    	trackingRepository.save(trackingInfo);
	    }
    
	    public List<Object[]> getAssetCalls(String id,String trackingType,Date stDt, Date endDt) {
	    	return trackingRepository.findByAssertDateRange(id,trackingType,stDt,endDt);
	    }
	    
	    public List<Object[]> getMobileCalls(long id,String trackingType,Date stDt, Date endDt) {
	    	return trackingRepository.findByMobileDateRange(id,trackingType,stDt,endDt);
	    }
	
	
}
