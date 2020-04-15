package utils;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Used to log information for the Interceptor design pattern.
 * @author Calvin Novicki
 *
 */
public class LoggingInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@AroundInvoke
	public Object methodInterceptor(InvocationContext context) throws Exception {
		
		System.out.println("Interception Call To " + context.getTarget().getClass() + "." + context.getMethod().getName() + "()");
		
		return context.proceed();
		
	}
	
}
