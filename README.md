
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


<br>
<h3>Rest API's :</h3>
<ol>
<li>URL: /tracker/startTrip <br>
Method : POST <br>
Response : {string} identified as Id <br>
Request Body : <br>
{<br>
 "vehicleId":String,<br>
 "driverId":String<br>
}<br>


Maps Vehicle id with Driver Id and Starts a new trip with 'Trip Id'.
</li>

<li>URL: /tracker/trackingInfo <br>
Method : POST <br>
Response : {string} Success / Failure <br>
Request Body : <br>
{<br>
	"deviceType":String,	<br>
	"id":String,<br>
	"latitude":double,<br>
	"longitude":double,<br>
	"speed":double,<br>
	"currDateTime":Java.util.Date,<br>
	"additionalInfo":String<br>
}<br>

Receives the data sent by IOT Device / Mobile Number / any other Device and stores it into Database. 
</li>
<li>URL: /tracker/getAssets/{Id}/{FromDate(YYYYMMDD)}/{ToDate(YYYYMMDD)}<br>
Method : GET <br>
Response : Consolidated view of pings from a given device within a given date range. <br>

</li>
<br>
<li>URL: /tracker/endTrip/{TripId}<br>
Method : PUT <br>
Response : {string} Success / Failure <br>

Updates the trip status as Ended for a given TripId and captured the end time.<br> 
</li>

</ol>

