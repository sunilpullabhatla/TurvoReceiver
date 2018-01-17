package com.app.locationtracking.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.app.locationtracking.entity.Driver;
import com.app.locationtracking.entity.Vehicle;



public class TestDataReceiveService extends TurvoReceiverApplicationTests {

	

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private VehicleRepository vehicleRepository;
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testServices() throws Exception {
		
		String vehicleId= "AP"+new Random().nextInt(10000);
		long mno = 9000000000l+new Random().nextInt(100000);
		
		Driver dr = new Driver();
		
		dr.setDriverMobileNo(mno);
		dr.setDriverName("sunil");
		
		Driver driver = driverRepository.save(dr);
		
		Vehicle v = new Vehicle();
		v.setVehicleId(vehicleId);
		v.setVehicleModel("Verna");
		
		vehicleRepository.save(v);
		
		String vehicleDriver="{\n" + 
				" \"vehicleId\":\""+vehicleId+"\",\n" + 
				" \"driverId\":\""+driver.getDriverId()+"\"\n" + 
				"}\n" + 
				"";
		
		String exampleData= "{\n" + 
				"	\"deviceType\":\"Mobile\",	\n" + 
				"	\"id\":\""+mno+"\",\n" + 
				"	\"latitude\":17.385044,\n" + 
				"	\"longitude\":78.486671,\n" + 
				"	\"currLocation\":\"KPHB\",\n" + 
				"	\"speed\":45,\n" + 
				"	\"currDateTime\":\"2018-01-06T06:33:35.280Z\",\n" + 
				"	\"additionalInfo\":\"XYZ\"\n" + 
				"}";
		
		
		mockMvc.perform(post("/tracker/startTrip").content(vehicleDriver).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
		mockMvc.perform(post("/tracker/trackingInfo").content(exampleData).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
		mockMvc.perform(get("/tracker/getAssets/"+mno+"/20180104/20180106").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
		mockMvc.perform(put("/tracker/endTrip/5").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}
