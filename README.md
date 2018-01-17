
<h1>Location Tracking System</h1>

<h3>Problem: </h3>A simple location tracker application that would receive data from IOT devices or mobile on location of a given vehicle.

<h3>Technical Stack:</h3>

Java - 1.8 <br>
Spring Boot - 1.4.7 <br>
Mongo DB 3.6<br>


<h3>Prerequisite:</h3>

Java 1.8 or higher installed<br>
Mongo DB 3.6 installed (https://www.mongodb.com)<br>
Maven installed (https://maven.apache.org/install.html)<br>


<h3>Run Application:</h3>
mvn clean install && java -jar target/TurvoReceiver-0.0.1-SNAPSHOT.jar


<h3>Assumption:</h3>
GPS Device or Mobile App is capable of sending current location and speed of vehicle by invoking a rest API. Devices are capable of sending location lat long with configurable frequency of pings. Devices are authenticated with the App


<h3>Class Diagram:</h3>




<br>
This Image Also Available in project
<br>
<h3>Rest API's :</h3>
<ol>
<li>URL: /track/asset <br>
Method : POST <br>
Response : {string} identified as Id <br>
Request Body : <br>
{<br>
  "vehicle":{"vehicleId":String},<br>
	"driver":{"driverId":int,"driverMobileNo":long},<br>
	"latitude":double,<br>
	"longitude":double,<br>
	"currLocation":String,<br>
	"speed":double,<br>
	"currDateTime":Java.Util.Date,<br>
	"additionalInfo":String<br>
}<br>

Receives the data sent by IOT Device and stores it into Database. 
</li>

<li>URL: /track/mobile <br>
Method : POST <br>
Response : {string} identified as Id <br>
Request Body : <br>
{<br>
  "vehicle":{"vehicleId":String},<br>
	"driver":{"driverId":int,"driverMobileNo":long},<br>
	"latitude":double,<br>
	"longitude":double,<br>
	"currLocation":String,<br>
	"speed":double,<br>
	"currDateTime":Java.Util.Date,<br>
	"additionalInfo":String<br>
}<br>

Receives the data sent by Mobile Number and stores it into Database. 
</li>
<li>URL: /getcalls/asset/{vehicleId}/{FromDate(YYYYMMDD)}/{ToDate(YYYYMMDD)}<br>
Method : GET <br>
Response : Consolidated view of Number of pings from a given device within a given date range. <br>
Example Response : [["2018-01-03",2],["2018-01-05",3]]<br>
</li>
<br>
<li>URL: /getcalls/mobile/{mobileNo}/{FromDate(YYYYMMDD)}/{ToDate(YYYYMMDD)}<br>
Method : GET <br>
Response : Consolidated view of Number of pings from a given mobile number within a given date range. <br>
Example Response : [["2018-01-04",2],["2018-01-05",3]]<br>
</li>

</ol>

