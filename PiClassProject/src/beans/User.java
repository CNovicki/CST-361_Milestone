package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Contains values needed for a user account, including memeberID, firstName, lastName, email, an Address object, phoneNumber, username,
 * and password. All values are string values, with the exception of Address, which uses its own helper class.
 * @author Calvin Novicki
 */
@ManagedBean
@SessionScoped
public class User {
	
	/**
	 * This is the username; it is created with the entered email during registration.
	 */
	@NotBlank(message="required")
	@Size(min=4, max=20, message="The Username Requires a Minimum of 4 Characters")
	private String username;
	
	/**
	 * This is the password. The password is used as the key to encrypt the username using a polyalphabetic cipher.
	 * The password will also be encrypted.
	 */
	@NotBlank(message="required")
	@Size(min=8, max=20, message="The Password Requires a Minimum of 8 Characters")
	private String password;
		
	/**
	 * This if the user is logged in, false otherwise.
	 */
	@JsonIgnore
	private boolean loggedIn;
	
	/**
	 * This is the login text to be displayed in the view.
	 */
	@JsonIgnore
	private String loginText;
	
	/**
	 * Creates a new User with no parameters, so the memberID, firstName, lastName, email, address, phoneNumber, username,
	 * and password all have no value, and can be added with a form.
	 */
	public User() {

		username = "";

		password = "";

		loggedIn = false;

		loginText = "Login";
		
	}
	
	/**
	 * Creates a new User and instantiates the memberId, addressId, loginId, firstName, lastName, email, address, phoneNumber, username, password, isLoggedIn, and isModerator.
	 * @param loginId
	 * @param username
	 * @param password

	 */
	public User(String username, String password) {

		this.username = username;

		this.password = password;

		this.loggedIn = false;

		this.loginText = "Login";
		
	}

	//********************************************************************************//
	/*
	 * GETTERS AND SETTERS
	 */
	//********************************************************************************//

	public String getUsername() {
		
		return username;
		
	}

	public void setUsername(String username) {
		
		this.username = username;
		
	}

	public String getPassword() {
		
		return password;
		
	}

	public void setPassword(String password) {
		
		this.password = password;
				
	}

	public boolean getLoggedIn() {
		
		return loggedIn;
		
	}

	public void setLoggedIn(boolean loggedIn) {
		
		this.loggedIn = loggedIn;
		
	}

	public String getLoginText() {
	
		return loginText;
	
	}

	public void setLoginText(String loginText) {
	
		this.loginText = loginText;
	
	}

}
