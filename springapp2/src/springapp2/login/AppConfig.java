package springapp2.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages = "springapp2.login")
public class AppConfig {
	
	@Bean
	public MemberService memeberService() {
		return new MemberService();
	}
}
