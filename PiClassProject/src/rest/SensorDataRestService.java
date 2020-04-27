package rest;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.ResponseDataModel;
import beans.SensorData;
import business.SensorDataBusinessInterface;
import exceptions.DataNotFoundException;

/**
 * This API is responsible for getting and posting temperature data too and from the database. 
 * @author Calvin Novicki
 *
 */
@RequestScoped
@Path("/weather")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public class SensorDataRestService {

	/**
	 * The interface that is injected.
	 */
	@Inject
	private SensorDataBusinessInterface service;
	
	/**
	 * Gets the sensor data via JSON with specific parameters.
	 * @param pressure
	 * @param temperatureInFahrenheit
	 * @param timestamp
	 * @return
	 */
	@GET
	@Path("/getsensordataj/{pressure}/{temperatureInFahrenheit}/{timestamp}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseDataModel<SensorData> getSensorDataJ(@PathParam("pressure") double pressure, @PathParam("temperatureInFahrenheit") double temperatureInFahrenheit, @PathParam("timestamp") String timestamp) {
		
		SensorData sensorData = new SensorData(pressure, temperatureInFahrenheit, timestamp);
		
		try {
			
			sensorData = service.getSensorData(sensorData);
			
			ResponseDataModel<SensorData> response = new ResponseDataModel<>(0, "Success", sensorData);
			
			return response;
			
			
		}
		
		catch(DataNotFoundException e) {
			
			ResponseDataModel<SensorData> response = new ResponseDataModel<>(-1, "Data Not Found", new SensorData());
			
			return response;
			
		}
		
		catch(Exception e) {
			
			ResponseDataModel<SensorData> response = new ResponseDataModel<>(-2, "System Exception", new SensorData());
			
			return response;
			
		}
				
	}
	
	/**
	 * Gets sensor data via XML with specific parameters.
	 * @param pressure
	 * @param temperatureInFahrenheit
	 * @param timestamp
	 * @return
	 */
	@GET
	@Path("/getsensordatax/{pressure}/{temperatureInFahrenheit}/{timestamp}")
	@Produces(MediaType.APPLICATION_XML)
	public ResponseDataModel<SensorData> getSensorDataX(@PathParam("pressure") double pressure, @PathParam("temperatureInFahrenheit") double temperatureInFahrenheit, @PathParam("timestamp") String timestamp) {
		
		SensorData sensorData = new SensorData(pressure, temperatureInFahrenheit, timestamp);
		
		try {
			
			sensorData = service.getSensorData(sensorData);
			
			ResponseDataModel<SensorData> response = new ResponseDataModel<>(0, "Success", sensorData);
			
			return response;
			
			
		}
		
		catch(DataNotFoundException e) {
			
			ResponseDataModel<SensorData> response = new ResponseDataModel<>(-1, "Data Not Found", new SensorData());
			
			return response;
			
		}
		
		catch(Exception e) {
			
			ResponseDataModel<SensorData> response = new ResponseDataModel<>(-2, "System Exception", new SensorData());
			
			return response;
			
		}
				
	}
	
	/**
	 * Gets all sensor data via JSON.
	 * @return
	 */
	@GET
	@Path("/getallsensordataj")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseDataModel<SensorData> getAllSensorDataJ() {
		
		List<SensorData> sensorData = new ArrayList<>();
		
		try {
			
			sensorData = service.getAllSensorData();
			
			ResponseDataModel<SensorData> response = new ResponseDataModel<>(0, "Success", sensorData);
			
			return response;
			
			
		}
		
		catch(DataNotFoundException e) {
			
			ResponseDataModel<SensorData> response = new ResponseDataModel<>(-1, "Data Not Found", new ArrayList<>());
			
			return response;
			
		}
		
		catch(Exception e) {
			
			ResponseDataModel<SensorData> response = new ResponseDataModel<>(-2, "System Exception", new ArrayList<>());
			
			return response;
			
		}
				
	}
	
	/**
	 * Gets all sensor data via XML.
	 * @return
	 */
	@GET
	@Path("/getallsensordatax")
	@Produces(MediaType.APPLICATION_XML)
	public ResponseDataModel<SensorData> getAllSensorDataX() {
		
		List<SensorData> sensorData = new ArrayList<>();
		
		try {
			
			sensorData = service.getAllSensorData();
			
			ResponseDataModel<SensorData> response = new ResponseDataModel<>(0, "Success", sensorData);
			
			return response;
			
			
		}
		
		catch(DataNotFoundException e) {
			
			ResponseDataModel<SensorData> response = new ResponseDataModel<>(-1, "Data Not Found", new ArrayList<>());
			
			return response;
			
		}
		
		catch(Exception e) {
			
			ResponseDataModel<SensorData> response = new ResponseDataModel<>(-2, "System Exception", new ArrayList<>());
			
			return response;
			
		}
				
	}
	
	/**
	 * Posts the data to the database.
	 * @param sensorData
	 * @return
	 */
	@POST
	@Path("/postsensordataj")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String postSensorDataJ(SensorData sensorData) {
		
		String response = "The data has been saved";
		
		service.addSensorData(sensorData);
		
		return response;
		
	}
	
	/**
	 * Posts the data to the database.
	 * @param sensorData
	 * @return
	 */
	@POST
	@Path("/postsensordatax")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public String postSensorDataX(SensorData sensorData) {
		
		String response = "The data has been saved";
		
		service.addSensorData(sensorData);
		
		return response;
		
	}
	
}
