package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import beans.User;
import exceptions.DatabaseException;
import utils.LoggingInterceptor;

/**
 * Data service for User.
 * @author Calvin Novicki
 *
 */
@Interceptors(LoggingInterceptor.class)
@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class UserDataService implements DataAccessInterface<User> {

	/**
	 * Creates a user.
	 */
	@Override
	public User create(User user) {
	
		Connection connection = null;
		
		try {
						
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String query = "INSERT INTO users (username, password) VALUES (?,?);";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, user.getUsername());
			
			preparedStatement.setString(2, user.getPassword());
						
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
		
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
			
			throw new DatabaseException(e);
			
		}
		
		finally {
			
			try {
				
				if(connection != null) {
					
					connection.close();
					
				}
				
			}
			
			catch(SQLException e){
				
		         e.printStackTrace();
		         
				throw new DatabaseException(e);

		    }
			
		}
		
		return user;
	
	}
	
	/**
	 * Reads a single user.
	 */
	@Override
	public User read(String[] values) {
		
		User user = null;
				
		Connection connection = null;

		try {
			
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String query = String.format("SELECT * FROM users WHERE username=?;");
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, values[0]);
						
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(!resultSet.next()) {
				
				resultSet.close();
				
				preparedStatement.close();
				
				return null;
				
			}
			
			user = new User(resultSet.getString("username"), resultSet.getString("password"));
									
			resultSet.close();
			
			preparedStatement.close();
			
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
			
			throw new DatabaseException(e);
						
		}
		
		finally {

			if(connection != null) {
				
				try {
					
					connection.close();
					
				} 
				
				catch (SQLException e) {
					
					e.printStackTrace();
					
					throw new DatabaseException(e);
										
				}
				
			}
			
		}
		
		return user;
			
	}

	/**
	 * Reads all users.
	 */
	@Override
	public List<User> readAll() {
	
		return null;
	
	}

	/**
	 * Updates a user.
	 */
	@Override
	public User update(User user) {
	
		return null;
	
	}

	/**
	 * Deletes a user.
	 */
	@Override
	public User delete(User user) {
	
		return null;
	
	}

}
