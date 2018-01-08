package com.app.locationtracking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "driver")
public class Driver {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int driverId;
    private String driverName;
    
    @Column(unique = true)
	private long driverMobileNo;

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public long getDriverMobileNo() {
		return driverMobileNo;
	}

	public void setDriverMobileNo(long driverMobileNo) {
		this.driverMobileNo = driverMobileNo;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", driverName=" + driverName + ", driverMobileNo=" + driverMobileNo
				+ "]";
	}
	
	
}
