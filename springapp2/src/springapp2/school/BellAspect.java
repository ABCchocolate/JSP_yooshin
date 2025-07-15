package springapp2.school;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Aspect 지향 프로그래밍의 개념 및 라이브러리는 스프링 것이 아니다.
//스프링이 개발되기 이전부터 IT 분야에 있던 개념이다. 그리고 자바 기반의 AOP 라이브러리도
//aspectj 라고 불리는 것이 있었다.

//asepctweaver 1.8.14
//aspectjrt 1.8.14
@Aspect
@Component //스프링이 이 객체를 자동으로 메모리에 올린다.
public class BellAspect {
	
	@Autowired //자동주입... 스프링 컨테이너 보유한 Bell 빈을 아래의 멤버변수에 자동으로 주입시키도록 한다.
	private Bell bell; //공통 코드를 가지고 와야함... 횡단점 관심사.
	
	@Before("execution(* Student.*(..))")
	public void ringBell() {
		bell.sound();
	}

	
	
}
