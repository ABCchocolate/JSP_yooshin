package test;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener{

	//web Container(톰캣)가 가동될 때 동작하는 메서드이다.
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("서버 가동 되었습니다.");
		//애플리케이션 수준의 객체의 ServletContext에 나의 이름을 저장한다.
		ServletContext context = sce.getServletContext();
		context.setAttribute("tel", "010-1234-1234");
		//spring에 사용 될 빈즈들을 인스턴스화 시켜서 보관하자!
		
	}
	
	//web Container(톰캣)이 중단될 때 작동하는 메서드이다.
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("서버 중단 되었습닌다.");
		
	}

}
