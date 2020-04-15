package business;

import java.security.MessageDigest;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import beans.User;
import data.DataAccessInterface;
import exceptions.UserNotFoundException;
import utils.LoggingInterceptor;

/**
 * Service for the user.
 * 
 * @author Ali Cooper
 * @author Calvin Novicki
 * 
 */
@Interceptors(LoggingInterceptor.class)
@Stateless
@Local(UserBusinessInterface.class)
@LocalBean
public class UserBusinessService implements UserBusinessInterface {
	
	/**
	 * Injects the data service.
	 */
	@Inject
    private DataAccessInterface<User> service;
	
	/**
	 * Cache for the user.
	 */
	@Inject
	private UserCache cache;

	/**
	 * Adds a user.
	 */
    @Override
    public User addUser(User user) {
    	
    	String password = user.getPassword();
    	
		password = encrypt(password);

		user.setPassword(password);

		service.create(user);
		
        return user;
        
    }

    /*
     * Gets a user from the data base.
     */
    @Override
    public User getUser(User user) throws UserNotFoundException {
    	
    	String[] values = {user.getUsername()};
    	
    	User newUser = cache.getObject(user);
    	
    	if(newUser != null) {
    		
    		return newUser;
    		
    	}
    	
    	newUser = service.read(values);
    	
    	if(service.read(values) == null) {
    	
    		throw new UserNotFoundException();
    		
    	}
    		
    	else {
    		
    		cache.putObject(newUser);
    	
    		return service.read(values);
		
    	}
    	
    }
    
    /**
     * Encrypts the user's password.
     */
	@Override
	public String encrypt(String base) {
		//Try block.
	    try{
	    	//For SHA-256.
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        //UTF-8
	        byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        //Creates a hex string.
	        StringBuffer hexString = new StringBuffer();
	        //Encrypts
	        for (byte element : hash) {
	        	//Converts to hex.
	            String hex = Integer.toHexString(0xff & element);
	            //Appends 0.
	            if(hex.length() == 1) {
	            	//Appends 0.
	            	hexString.append('0');
	            
	            }
	            //Appends the hash.
	            hexString.append(hex);
	            
	        }
	        //Returns the hash.
	        return hexString.toString();
	        
	    }
	    //Catch block.
	    catch(Exception ex) {
	       //Throws runtime exception.
	       throw new RuntimeException(ex);
	       
	    }
	    
	}

}
