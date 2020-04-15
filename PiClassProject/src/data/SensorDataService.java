package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import beans.SensorData;
import exceptions.DatabaseException;
import utils.LoggingInterceptor;

/**
 * Data serivce for the sensor data.
 * @author Calvin Novicki
 *
 */
@Interceptors(LoggingInterceptor.class)
@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class SensorDataService implements DataAccessInterface<SensorData> {
	
	/**
	 * Creates the sensor data.
	 */
	@Override
	public SensorData create(SensorData sensorData) {
		
		Connection connection = null;
				
		try {
						
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String query = "INSERT INTO sensor_data (pressure, temperature, date) VALUES (?,?,?);";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setDouble(1, sensorData.getPressure());
			
			preparedStatement.setDouble(2, sensorData.getTemperatureInFahrenheit());
			
			preparedStatement.setString(3, sensorData.getTimestamp());
			
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
		
		return sensorData;
		
	}

	/**
	 * Reads a single sensor data entry.
	 */
	@Override
	public SensorData read(String[] values) {
	
		SensorData sensorData = null;
		
		Connection connection = null;

		try {
			
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String query = String.format("SELECT * FROM sensor_data WHERE pressure=? AND temperature=? AND date=?;");
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setDouble(1, Double.valueOf(values[0]));
			
			preparedStatement.setDouble(2, Double.valueOf(values[1]));

			preparedStatement.setString(3, values[2]);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(!resultSet.next()) {
				
				resultSet.close();
				
				preparedStatement.close();
				
				return null;
				
			}
			
			sensorData = new SensorData(resultSet.getDouble("pressure"), resultSet.getDouble("temperature"), resultSet.getString("date"));
						
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
		
		return sensorData;
		
	}
	
	/**
	 * Reads all sensor data.
	 */
	@Override
	public List<SensorData> readAll() {
		//The product that will be returned.
		List<SensorData> sensorData = new ArrayList<>();
		//Creates a new database connection.
		Connection connection = null;
		//Try block.		
		try {
			//Establishes the database connection.
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//This is the select query.
			String query = "SELECT * FROM sensor_data;";
			//Creates the statement.
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			//Creates the result set and executes the query.
			ResultSet resultSet = preparedStatement.executeQuery();
			//Moves the result set forward.
			while(resultSet.next()) {
				//Sets the product to the product of the database.			
				sensorData.add(new SensorData(resultSet.getDouble("pressure"), resultSet.getDouble("temperature"), resultSet.getString("date")));
				
			}
			//Closes the result set.
			resultSet.close();
			//Closes the statement.
			preparedStatement.close();
			
		}
		//Catches the SQLException.
		catch(SQLException e) {
			
			e.printStackTrace();
			//Throws the database exception.
			throw new DatabaseException(e);
			
		}
		//Finally block.
		finally {
			//If database connection is null.
			if(connection != null) {
				//Try block
				try {
					//Closes the database connection.
					connection.close();
					
				}
				//Catches the SQLException.
				catch(SQLException e) {
					
					e.printStackTrace();
					//Throws the new database exception.
					throw new DatabaseException(e);
				
				}
			
			}
			
		}
		//Returns the sensorData.
		return sensorData;
		
				
	}

	/**
	 * Updates sensor data.
	 */
	@Override
	public SensorData update(SensorData model) {
		// TODO Auto-generated method stub
		return null;
		
	}

	/**
	 * Deletes sensor data.
	 */
	@Override
	public SensorData delete(SensorData t) {
		
		return null;
		
	}

}
