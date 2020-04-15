package exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * This is the exception mapper used for any general exceptions, and they just go to a Bad Request status.
 * @author Calvin Novicki
 *
 */
@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Throwable> {

	/**
	 * This is the response the client receives.
	 */
	@Override
	public Response toResponse(Throwable arg0) {
		//Returns the response with a bad request status.
		return Response.status(Status.BAD_REQUEST).entity("Error: " + arg0.getMessage()).build();

	}
	
}
