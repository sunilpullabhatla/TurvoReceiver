package com.app.locationtracking.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;


public class VehicleDriver {

	@Id
	private String id;
	@NotNull
	private String vehicleId;
	@NotNull
	private String driverId;
	@NotNull
	private Date startDateTime;
	@NotNull
	private Date endDateTime;
	@NotNull
	private String status;
	
	
	
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Vehicle_Driver [id=" + id + ", vehicleId=" + vehicleId + ", driverId=" + driverId + ", startDateTime="
				+ startDateTime + ", endDateTime=" + endDateTime + ", status=" + status + "]";
	}
	
	
}
