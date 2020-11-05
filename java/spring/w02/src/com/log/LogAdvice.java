package com.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	@Before("execution(* com..*Service.*(..))")
	public void logger1(JoinPoint jp) {
		System.out.println("Start logger1 ... ");
		System.out.println("[LOG] START");
		System.out.println(jp.getSignature().getName());
		System.out.println(jp.getArgs()[0].toString());
		System.out.println("[LOG] END logger1 ....");
	}

	@AfterReturning(pointcut = "execution(* com..*Service.*(..))", returning = "obj")
	public void logger2(JoinPoint jp) {
		System.out.println("Start logger2 ... ");
		System.out.println("[LOG] START");
		System.out.println(jp.getSignature().getName());
		System.out.println(jp.getArgs()[0].toString());
		System.out.println("[LOG] END logger2 ....");
	}

	@Around("execution(* com..*Service.*(..))")
	public Object logger3(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		System.out.println("[LOG3] START");
		result = pjp.proceed();
		System.out.println("[LOG3] END");
				
		return result;
	}
}
