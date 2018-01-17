package com.app.locationtracking.entity;



import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "driver")
public class Driver {

	@Id
    private String driverId;
    private String driverName;
    @NotNull
    @Length(min=10,max=10,message="Mobile Number Shoud Contain 10 digits")
	private long driverMobileNo;

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
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
