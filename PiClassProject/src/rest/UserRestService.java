package rest;

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
import beans.User;
import business.UserBusinessInterface;
import exceptions.UserNotFoundException;

/**
 * This API is responsible for getting and posting temperature data too and from the database. 
 * @author Calvin Novicki
 *
 */
@RequestScoped
@Path("/user")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public class UserRestService {

	/**
	 * The interface that is injected.
	 */
	@Inject
	private UserBusinessInterface service;
	
	/**
	 * Gets a user via JSON with a username.
	 * @param username
	 * @return
	 */
	@GET
	@Path("/getuserj/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseDataModel<User> getUserJ(@PathParam("username") String username) {
		
		User user = new User();
		
		try {
			
			user.setUsername(username);
			
			user = service.getUser(user);
			
			System.out.println(user.getUsername());
			
			ResponseDataModel<User> response = new ResponseDataModel<>(0, "Success", user);
			
			return response;
			
			
		}
		
		catch(UserNotFoundException e) {
			
			ResponseDataModel<User> response = new ResponseDataModel<>(-1, "Data Not Found", new User());
			
			return response;
			
		}
		
		catch(Exception e) {
			
			ResponseDataModel<User> response = new ResponseDataModel<>(-2, "System Exception", new User());
			
			return response;
			
		}
				
	}
	
	/**
	 * Gets a user via XML with a username.
	 * @param username
	 * @return
	 */
	@GET
	@Path("/getuserx/{username}")
	@Produces(MediaType.APPLICATION_XML)
	public ResponseDataModel<User> getUserX(@PathParam("username") String username) {
		
		User user = null;
		
		try {
			
			user = service.getUser(user);
			
			ResponseDataModel<User> response = new ResponseDataModel<>(0, "Success", user);
			
			return response;
			
			
		}
		
		catch(UserNotFoundException e) {
			
			ResponseDataModel<User> response = new ResponseDataModel<>(-1, "Data Not Found", new User());
			
			return response;
			
		}
		
		catch(Exception e) {
			
			ResponseDataModel<User> response = new ResponseDataModel<>(-2, "System Exception", new User());
			
			return response;
			
		}
				
	}
	
	/**
	 * Posts the data to the database.
	 * @param user
	 * @return
	 */
	@POST
	@Path("/saveuserj")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String saveUserJ(User user) {
		
		String response = "The data has been saved";
		
		service.addUser(user);
		
		return response;
		
	}
	
	/**
	 * Posts the data to the database.
	 * @param user
	 * @return
	 */
	@POST
	@Path("/saveuserx")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public String saveUserX(User user) {
		
		String response = "The data has been saved";
		
		service.addUser(user);
		
		return response;
		
	}
	
}
