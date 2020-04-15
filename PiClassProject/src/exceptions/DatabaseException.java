package exceptions;

/**
 * Exception when database cannot connect.
 * @author Calvin Novicki
 *
 */
public class DatabaseException extends RuntimeException {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a database exception.
	 * @param e
	 */
	public DatabaseException(Throwable e) {
		
		super(e);
		
	}
	
}
