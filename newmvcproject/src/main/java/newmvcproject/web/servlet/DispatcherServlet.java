package newmvcproject.web.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//아주 큰 규모의 웹 애플리케이션에서 모든 요청을 이 서블릿에서 받는다.
public class DispatcherServlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	Properties props;

	
	//요청이 들어오기전에 처리할 준비를 해야함.
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		String realPath =  context.getRealPath(config.getInitParameter("contextConfigLocation"));
		
		try(FileInputStream fis = new FileInputStream(realPath)){
			props = new Properties();
			props.load(fis); // stream 대입
			
		}
		catch(Exception e){
			e.getStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doRequest(request, response);
	}

	//get이던 post던 요청 처리
	protected void doRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.debug("메서드 호출");
		//클라이언트의 요청 uri를 이용하여 mapping 파일을 검색하고 value를 변환한다.
		String uri = request.getRequestURI();
		String className = props.getProperty(uri);
		logger.debug("요청에 동작할 uri는" +  uri);
		logger.debug("요청에 동작할 컨트롤러는"+ className);
		Controller controller= null;
		//한위 컨트롤러가 3,4단계를 완료한 시점이므로, 하위 컨트롤러가 반환한 키워드로 다시 매칭
		//파일을 검색하자!!
		
		
		
		//텍스트에 불과한 className을 실제 클래스로 로드한다.
		try {
			Class clazz = Class.forName(className);
			controller = (Controller)clazz.newInstance(); //new 연산말고도, 메서드로도 인스턴스를 생성할 수 있다. 
			
			controller.execute(request, response); //하위 컨트롤러 동작 !!
			
			String viewName = controller.getViewName();
			String viewPage = props.getProperty(viewName);
			
			//포워딩이란 클라이언트에게 응답정보로 재접속을 강요하는것이 아니라
			//응답을 보류한 상태로 현재의 요청의흐름을 서버에 또 다른 서블릿이나 JSP 에게 전달하는방법
			RequestDispatcher dis = request.getRequestDispatcher(viewPage);
			dis.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void destroy() {
	
	}
}
