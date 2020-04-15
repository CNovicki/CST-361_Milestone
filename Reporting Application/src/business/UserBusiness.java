package business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.User;

/**
 * Service for users.
 * @author Calvin Novicki
 *
 */
public class UserBusiness {
	
	/**
	 * Used for REST.
	 */
	private StringBuffer response = new StringBuffer();
	
	/**
	 * Jackson library for REST.
	 */
	private ObjectMapper mapper;
	
	/**
	 * the User.
	 */
	private User user;
				
	/**
	 * Creates a new user service.
	 */
	public UserBusiness() {
						
		response = new StringBuffer();
		
		mapper = new ObjectMapper();
		
		user = null;
			
	}
	
	/**
	 * Gets a user via REST.
	 * @param username
	 * @return
	 */
	public User getUser(String username) {
				
		try {
				
			URL url = new URL("http://localhost:8080/PiClassProject/rest/user/getuserj/" + username);
			
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
											
			user = mapper.readValue(newString, User.class);
			
		}	
			
		catch (IOException e) {
		
			e.printStackTrace();
					
		}
		
		return user;

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

	public User getUser() {
	
		return user;
	
	}

	public void setUser(User user) {
	
		this.user = user;
	
	}

}
