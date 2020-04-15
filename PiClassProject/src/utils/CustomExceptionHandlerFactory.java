package utils;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * Factory for the custom exception.
 * @author Calvin Novicki
 *
 */
public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory {
	
	/*
	 * Parent factory.
	 */
	 private ExceptionHandlerFactory parent;
	 
	 /**
	  * Creates a new custom exception handler factory.
	  * @param parent
	  */
	 public CustomExceptionHandlerFactory(ExceptionHandlerFactory parent) {
		 
		 this.parent = parent;
	 
	 }

	//********************************************************************************//
	/*
	 * GETTERS AND SETTERS
	 */
	//********************************************************************************// 
	 
	@Override
	public ExceptionHandler getExceptionHandler() {
		
		return new CustomExceptionHandler(this.parent.getExceptionHandler());
		
	}
	
}
