package com.app.locationtracking.web;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.locationtracking.entity.TrackingInfo;

@Repository
public interface TrackingRepository extends JpaRepository<TrackingInfo,Integer>  {

	@Query(value = "select Date(t.currDateTime) , count(t) from com.app.locationtracking.entity.TrackingInfo t where vehicle.vehicleId= :id and deviceType = :trackingType and date(t.currDateTime) between :stDt and :endDt  group by date(t.currDateTime)")
	List<Object[]> findByAssertDateRange(@Param("id") String id,@Param("trackingType") String trackingType,@Param("stDt") Date stDt,@Param("endDt") Date endDt);
	
	@Query(value = "select Date(t.currDateTime) , count(t) from com.app.locationtracking.entity.TrackingInfo t where driver.driverMobileNo= :id and deviceType = :trackingType and date(t.currDateTime) between :stDt and :endDt  group by date(t.currDateTime)")
	List<Object[]> findByMobileDateRange(@Param("id") long id,@Param("trackingType") String trackingType,@Param("stDt") Date stDt,@Param("endDt") Date endDt);
}
