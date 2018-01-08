package com.app.locationtracking.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "trackingInfo")
public class TrackingInfo {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sno;
	private String deviceType;
	
	@ManyToOne
	@JoinColumn(name = "vehicleId")
    private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name = "driverMobileNo" , referencedColumnName = "driverMobileNo")
    private Driver driver;
	
	
	private double latitude;
	private double longitude;
    private String currLocation;
    private double speed;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date currDateTime;
    private String additionalInfo;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
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

	public String getCurrLocation() {
		return currLocation;
	}

	public void setCurrLocation(String currLocation) {
		this.currLocation = currLocation;
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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Override
	public String toString() {
		return "TrackingInfo [sno=" + sno + ", deviceType=" + deviceType + ", vehicle=" + vehicle + ", driver=" + driver
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", currLocation=" + currLocation + ", speed="
				+ speed + ", currDateTime=" + currDateTime + ", additionalInfo=" + additionalInfo + "]";
	}

	


	
	
    
}
