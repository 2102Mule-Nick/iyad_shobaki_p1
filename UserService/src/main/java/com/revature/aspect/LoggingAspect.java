package com.revature.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
	
	private Logger log;

	@Autowired
	public void setLog(Logger log) {
		this.log = log;
	}
	
	@Pointcut("execution(* com.revature..service..*(..)) || "
			+ "execution(* com.revature..dao..*(..)) || "
			+ "execution(* com.revature..controller..*(..))")
	public void pointcutForAllMethods() {
		//Hook - empty to hold an annotation
	}
	
//	//@Before("pointcutForAllMethods()")
//	@Before("execution(public * com.revature.service.UserServiceImpl.*(..))")
//	public void logBeforeAllMethods(JoinPoint jp) {
//		String methodName = jp.getSignature().getName();
//		String argString = Arrays.toString(jp.getArgs());
//		//String returnedValues = jp.getSignature().toString();
//		log.info("Just called UserService " + methodName + " Method. Parameters were passed " + argString);
//	}
//	
//	@AfterReturning(pointcut ="execution(public * com.revature.service.UserServiceImpl.*(..))", returning ="returnedValue")
//	public void logAfterAllMethods(JoinPoint jp, Object returnedValue) {
//		String methodName = jp.getSignature().getName();
//		log.info("Returned value after calling UserService " + methodName + ". Returned value: " + returnedValue.toString());
//	}
	
	@Around("pointcutForAllMethods()")
	public Object loggingAllAdvice(ProceedingJoinPoint pjp) throws Throwable {

		log.info("Method called: "+ pjp.getSignature().getClass() + "." + pjp.getSignature().getName());
		log.info("Real class: " + pjp.getTarget().getClass());
		log.info("Parameters passed: " + Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		try {
			
			result = pjp.proceed();
		} catch (Exception e) {
			log.warn(e.getMessage());
		}
		
		log.info("Values returned successfully!" );//+ result);
		
		return result;
	}
	
	
}
