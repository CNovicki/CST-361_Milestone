package business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.SensorData;

/**
 * Service for sensor data.
 * @author Calvin Novicki
 *
 */
public class SensorDataBusiness {
	
	/**
	 * Used for REST.
	 */
	private StringBuffer response;
	
	/**
	 * Jackson library used for REST.
	 */
	private ObjectMapper mapper;
				
	/**
	 * Creates a new sensor data service.
	 */
	public SensorDataBusiness() {
						
		response = new StringBuffer();
		
		mapper = new ObjectMapper();
					
	}
	
	public SensorData getSensorData(String pressure, String temperature, String date) {
		
		SensorData sensorData = null;
		
		try {
			
			URL url = new URL("http://137.152.83.105:80/rest/weather/getsensordataj/" + pressure + "/" + temperature + "/" + date);
			
			String readLine = null;
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			while((readLine = reader.readLine()) != null) {
				
				response.append(readLine);
				
			}
			
			String newString = response.toString();
						
			newString = newString.replace("status", "");
			
			newString = newString.replace("message", "");
			
			newString = newString.replace("data", "");
			
			int index = newString.indexOf("{", newString.indexOf("{") + 1);
							
			newString = newString.substring(index);
				
			newString = newString.substring(0, newString.length() - 1);
			
			reader.close();
											
			sensorData = mapper.readValue(newString, SensorData.class);
			
		}	
			
		catch (IOException e) {
		
			e.printStackTrace();
					
		}
		
		return sensorData;
		
	}
	
	/**
	 * Gets all the sensor data via REST.
	 * @return
	 */
	public SensorData[] getAllSensorData() {
		
		SensorData[] sensorData = null;
				
		try {
				
			URL url = new URL("http://137.152.83.105:80/rest/weather/getallsensordataj");
			
			String readLine = null;
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			while((readLine = reader.readLine()) != null) {
				
				response.append(readLine);
				
			}
			
			String newString = response.toString();
						
			newString = newString.replace("status", "");
			
			newString = newString.replace("message", "");
			
			newString = newString.replace("data", "");
			
			int index = newString.indexOf("{", newString.indexOf("{") + 1);
							
			newString = newString.substring(index);
				
			newString = "[" + newString.substring(0, newString.length() - 1);
						
			reader.close();
											
			sensorData = mapper.readValue(newString, SensorData[].class);
			
		}	
			
		catch (IOException e) {
		
			e.printStackTrace();
					
		}
		
		return sensorData;

	}
	
	/**
	 * Writes all sensor data via REST.
	 * @param sensorData
	 */
	public void writeSensorData(SensorData sensorData) {
		
		try {
									
			ObjectMapper objectMapper = new ObjectMapper();
			
			String requestBody = objectMapper.writeValueAsString(sensorData);
			
			System.out.println(requestBody);
			
			URL url = new URL("http://137.152.83.105:80/rest/weather/savesensordataj");
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("POST");
			
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			
			connection.setRequestProperty("Accept", "application/json");
			
			connection.setDoOutput(true);
			
			OutputStream stream = connection.getOutputStream();
			
			byte[] input = requestBody.getBytes("utf-8");
			
			stream.write(input, 0, input.length);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			
			StringBuilder response = new StringBuilder();
			
			String responseLine = null;
			
			while ((responseLine = reader.readLine()) != null) {
			
				response.append(responseLine.trim());
 
			}
			
			stream.close();
													
		}	
			
		catch (IOException e) {
		
			e.printStackTrace();
					
		}
				
	}
	
	//********************************************************************************//
	/*
	 * GETTERS AND SETTERS
	 */
	//********************************************************************************//
	
	public StringBuffer getResponse() {
		
		return response;
		
	}

	public void setResponse(StringBuffer response) {
		
		this.response = response;
		
	}

	public ObjectMapper getMapper() {
	
		return mapper;
	
	}
	
	public void setMapper(ObjectMapper mapper) {
	
		this.mapper = mapper;
	
	}

}
