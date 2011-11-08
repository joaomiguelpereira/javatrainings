package eu.jpereira.trainings.jee6.cdi.events.interceptors;


import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import eu.jpereira.trainings.jee6.cdi.events.bindings.LoggedParameters;


@Interceptor
@LoggedParameters
public class LoggedParametersInterceptor {

	@AroundInvoke
	public Object logParameters(InvocationContext ic) throws Exception {
		System.out.println("Entering method: " + getFullMethodInfo(ic));
		System.out.println("Parameters: "+getParameterList(ic));
		try {
			Object result = ic.proceed();
			System.out.println("Exiting method: " + getFullMethodInfo(ic));
			return result;
		} catch (Exception e) {
			System.out.println("Throwing exception from method: "
					+ getFullMethodInfo(ic));
			throw e;
		}
	}

	
	private String getParameterList(InvocationContext ic) {
		Object[] parameters = ic.getParameters();
		
		
		StringBuilder paramSb = new StringBuilder();
		if (parameters.length==0) {
			paramSb.append("No parameters");
		} else {
			for (Object param: parameters ) {
				paramSb.append("( [");
				paramSb.append(param.getClass().getSimpleName());
				paramSb.append("] {");
				paramSb.append(param.toString());
				paramSb.append("})");
			}
			
		}
		return paramSb.toString();
		
	}
	private String getFullMethodInfo(InvocationContext ic) {
		StringBuilder sb = new StringBuilder();
		sb.append(ic.getMethod().getDeclaringClass().getName());
		sb.append(":");
		sb.append(ic.getMethod().getName());
		return sb.toString();

	}
}
