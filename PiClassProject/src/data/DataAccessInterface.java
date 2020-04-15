package data;

import java.util.List;

import javax.ejb.Local;

/**
 * Interface for Database Access Objects.
 * 
 * @author Ali Cooper
 * @author Calvin Novicki *Re-did
 *
 * @param <T>
 */
@Local
public interface DataAccessInterface<T> {
	
	/**
	 * URL for database.
	 */
	public final String URL = "jdbc:mysql://localhost:3306/cst_milestones";	
	
	/**
	 * username for the database.
	 */
	public final String USERNAME = "root";
	
	/**
	 * password for the database.
	 */
	public final String PASSWORD = "root";

	/**
	 * Creates data.
	 * @param model
	 * @return Optional boolean
	 */
    public T create(T t);

    
    /**
     * reads data.
     * @param id
     * @return
     */
    public T read(String[] values);
    
    /**
     * reads all data.
     * @return
     */
    public List<T> readAll();
    
    /**
     * updates data.
     * @param model
     */
    public T update(T t);
    
    /**
     * deletes data.
     * @param id
     * @return
     */
    public T delete(T t);
    
}
