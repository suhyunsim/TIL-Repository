package aop002;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	
	@Before("execution(public void aop002.Boy.runSomething())")
	public void before(JoinPoint joinpoint) {
		System.out.println("얼굴인식 확인: 문 개방");
	}

}
