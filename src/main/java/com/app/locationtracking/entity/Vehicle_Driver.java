package com.app.locationtracking.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "vehicle_driver")
public class Vehicle_Driver {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sno;
	
	@ManyToOne
	@JoinColumn(name = "vehicleId")
    private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name = "driverId")
    private Driver driver;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date startDateTime;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date endDateTime;
    private String tripStatus;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}



	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	
	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Vehicle_Driver [sno=" + sno + ", vehicle=" + vehicle + ", driver=" + driver + ", startDateTime="
				+ startDateTime + ", endDateTime=" + endDateTime + ", tripStatus=" + tripStatus + "]";
	}
	
    
	
}
