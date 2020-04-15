package utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

/**
 * Used to handle custom exceptions.
 * @author Calvin Novicki
 *
 */
public class CustomExceptionHandler extends ExceptionHandlerWrapper {
	
	/**
	 * The exception handler.
	 */
	private ExceptionHandler wrapped;

	/**
	 * Creates a custom exception handler.
	 * @param exception
	 */
	CustomExceptionHandler(ExceptionHandler exception) {
		
		this.wrapped = exception;
	
	}

	/**
	 * Handles the exception.
	 */
	@Override
    public void handle() throws FacesException {
		
        Iterator<ExceptionQueuedEvent> queue = getUnhandledExceptionQueuedEvents().iterator();

        while(queue.hasNext()) {
        	
            ExceptionQueuedEvent item = queue.next();
            
            ExceptionQueuedEventContext exceptionQueuedEventContext = (ExceptionQueuedEventContext) item.getSource();
            
            
            try {
            	
                Throwable throwable = exceptionQueuedEventContext.getException();
                
                StringWriter sw = new StringWriter();
                
                PrintWriter pw = new PrintWriter(sw);
                
                throwable.printStackTrace(pw);

                FacesContext context = FacesContext.getCurrentInstance();
                
                Map<String, Object> requestMap = context.getExternalContext().getRequestMap();
                
                NavigationHandler nav = context.getApplication().getNavigationHandler();
                
                requestMap.put("error-message", throwable.getMessage());
                
                requestMap.put("error-stack", sw.toString());
                
                nav.handleNavigation(context, null, "Error.xhtml");
                
                context.renderResponse();
            
            } 
            
            finally {
            	
                queue.remove();
            
            }
            
        }
        
	}
	
	//********************************************************************************//
	/*
	 * GETTERS AND SETTERS
	 */
	//********************************************************************************//
	
	@Override
	public ExceptionHandler getWrapped() {
		
		return wrapped;
		
	}
	
}
