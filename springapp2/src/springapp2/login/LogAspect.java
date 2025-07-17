package springapp2.login;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	
	@Before("execution(* springapp2.login.MemberService.*(..))")
	
	public void logBefore(JoinPoint jp) {
	    System.out.println("[AOP] 실행 메서드: " + jp.getSignature());
	}

}
