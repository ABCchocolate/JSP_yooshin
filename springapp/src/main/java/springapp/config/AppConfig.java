package springapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springapp.cook.Cook;
import springapp.cook.Fripan;
import springapp.cook.Induction;

/*
 * 전통적인 스프링의 개발 방식에서는 주로 XML이 사용되었으나,
 * spring 2.5버전부터 java 클래스에도 설정이 가능한 즉 어노테이션 기반의 설정방식을 지원하기 시작하여
 * 현재 스프링 부트에 이르러서는 자바 기반 설정이 대세이다. 
 */



@Configuration
public class AppConfig {
	//spring의 관리대상이되는 클래스를 전통적으로 bean 이라고 한다.
	@Bean
	public Fripan fripan(){
		return new Fripan();
	}
	
	@Bean
	public Induction induction() {
		return new Induction();
	}
	
	@Bean
	//요리사 빈을 생성자 주입으로 위빙한다.(weaving)
	public Cook cook() {
		return new Cook(induction()); //생성자 주입
	}
	
}
