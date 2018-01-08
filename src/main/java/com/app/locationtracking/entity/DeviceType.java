package com.app.locationtracking.entity;

public enum DeviceType {
	GPS_DEVICE ("GPS_DEVICE"), MOBILE ("MOBILE");
	
private String deviceType;

private DeviceType(String deviceType) { 
    this.deviceType = deviceType; 
}

public String getDeviceType() {
	return deviceType;
}



}
