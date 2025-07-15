package springapp2.school;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //XML 대신하여 스프링 컨테이너에게 빈을 관리하도록 부탁하는 설정파일이다.
@EnableAspectJAutoProxy 
@ComponentScan("springapp2.school") //컴포넌트들의 위치를 알려주는 애노테이
public class AppConfig {

	@Bean
	public Bell bell() { //<bean class = "~~.Bell" id = "bell"></bean>과 동일하다.
		return new Bell();
	}
	
	@Bean
	public Student student() {
		return new Student();
	}

}
