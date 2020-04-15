 package beans;

/**
 * Creates a <b>User</b> with a first name, last name, email, username, and password. The user is created
 * via a JSON file pulled via the REST API from the game's enterprise website.
 * @author Calvin Novicki
 *
 */
public class User {
	
	/**
	 * This is the <b>User</b> username.
	 */
	private String username;
	
	/**
	 * This is the <b>User</b> password.
	 */
	private String password;
	
	/**
	 * Creates a new default <b>User</b>
	 */
	public User() {
		
		
		
	}
	
	/**
	 * Creates a new <b>User</b> with a username and password.
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		//Instantiates the username.
		this.username = username;
		//Instantiates the password.
		this.password = password;
		
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
	
}
