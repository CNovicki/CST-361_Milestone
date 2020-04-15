package beans;

/**
 * Used for REST services.
 * @author Calvin Novicki
 *
 */
public class ResponseModel {
	
	/**
	 * The status of the request.
	 */
	private int status;
	
	/**
	 * The message for the request.
	 */
	private String message;
	
	/**
	 * Initializes the data.
	 * @param status
	 * @param message
	 */
	public ResponseModel(int status, String message) {
		
		this.status = status;
	
		this.message = message;
	
	}
	
	//********************************************************************************//
	/*
	 * GETTERS AND SETTERS
	 */
	//********************************************************************************//

	public int getStatus() {
	
		return status;
	
	}
	
	public void setStatus(int status) {
	
		this.status = status;
	
	}
	
	public String getMessage() {
	
		return message;
	
	}
	
	public void setMessage(String message) {

		this.message = message;
	
	}

}
