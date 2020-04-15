package exceptions;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * This is the exception mapper used for any not found exceptions, and they just go to a Not Found status.
 * @author Calvin Novicki
 *
 */
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

	/**
	 * This is the response the client receives.
	 */
	@Override
	public Response toResponse(NotFoundException arg0) {
		//Returns the response with a +not found status.
		return Response.status(Status.NOT_FOUND).entity("Resource could not be found").build();
	
	}

}
