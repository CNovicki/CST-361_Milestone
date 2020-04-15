package controllers;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

import beans.User;
import business.AccountNavigationBusinessInterface;
import utils.LoggingInterceptor;

/**
 * Controller for the user.
 * 
 * @author Ali Cooper
 * @athor Calvin Novicki *Re-did
 */
@Interceptors(LoggingInterceptor.class)
@Named
@ViewScoped
public class UserController implements Serializable {
	
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Injects the account navigation service.
	 */
	@Inject
	private AccountNavigationBusinessInterface service;
	
	/**
	 * Registers the user.
	 * @param user
	 * @return
	 */
	public String register(User user) {
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		service.register(user);
		
		return "Login.xhtml";
		
	}
	
	/**
	 * Logs the user in.
	 * @param user
	 * @return
	 */
	public String login(User user) {
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		if(service.login(user) == 0) {
						
			return "DataPage.xhtml";
			
		}
		
		else {
		
			return "Login.xhtml";
		
		}
		
	}
	
	/**
	 * Checks if the user is logged in or not.
	 * @param user
	 * @return
	 */
	public String checkLoginStatus(User user) {
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		//If the user is not logged in.
		if(!user.getLoggedIn()) {
			//Returns the login page.
			return "Login.xhtml";
			
		}
		//Else if user is logged in.
		else {
			//Logs the user out.
			service.logout(user);
			//Returns the home page.	
			return "Home.xhtml";
			
		}
		
	}
	
}
