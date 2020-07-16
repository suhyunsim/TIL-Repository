package aop003;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	
	@Before("execution(* runSomething())")
	public void before(JoinPoint joinPoint) {
		System.out.println("얼굴인식 확인: 문 개방");
	}
	
	@After("execution(* runSomething())")
	public void after(JoinPoint joinPoint) {
		System.out.println("나감: 문 잠금");
	}

}
