package com.app.locationtracking.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;



@Document(collection = "trackingInfo")
public class TrackingInfo {

	@NotNull
	private String id;
	@NotNull
	private String deviceType;
	@NotNull
	private double latitude;
	@NotNull
	private double longitude;
	@NotNull
    private double speed;
	@NotNull
    @Indexed(direction=IndexDirection.ASCENDING)
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Date currDateTime;
    private String additionalInfo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public Date getCurrDateTime() {
		return currDateTime;
	}

	public void setCurrDateTime(Date currDateTime) {
		this.currDateTime = currDateTime;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	
	@Override
	public String toString() {
		return "TrackingInfo [id=" + id + ", deviceType=" + deviceType + ", latitude=" + latitude + ", longitude=" + longitude + ", speed=" + speed + ", currDateTime=" + currDateTime + ", additionalInfo=" + additionalInfo + "]";
	}

	
	


	
	
    
}
