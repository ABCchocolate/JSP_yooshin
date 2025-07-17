package springapp2.login;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
		MemberService memberService = context.getBean(MemberService.class);
		memberService.join("yooshin");
	}
}
