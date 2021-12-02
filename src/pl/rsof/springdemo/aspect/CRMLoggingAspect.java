/*
 *  Company: RS
 *  Project: web-customer-tracker
 *  Created: 2 gru 2021  18:51:10
 *  Author:  RS 		
 */
package pl.rsof.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <p>Aspekt do logowania</p><p>2 gru 2021</p>
 * @author RS
 *
 */
@Aspect
@Component
public class CRMLoggingAspect {

	
	// logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	// pointcut - punkt przecięcia; .* - dowolna klasa, .* - dowolna metoda, .. - dowolna ilosc argumentow
	@Pointcut("execution(* pl.rsof.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* pl.rsof.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* pl.rsof.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	
	
	// @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		// method we are calling
		String method = joinPoint.getSignature().toShortString();
		logger.info("--> @Before, method calling: "+method);
		
		// arguments to the method
		Object[]args = joinPoint.getArgs();
		for(Object arg : args) {
			logger.info("====> @Before, method argument: "+arg);
		}
	}
	
	
	
	// @AfterReturning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		// method we are returning from
		String method = joinPoint.getSignature().toShortString();
		logger.info("---> @AfterReturning, from method: "+method);
		
		// date returned
		logger.info("=====> result: "+result);
	}
	
	
}
