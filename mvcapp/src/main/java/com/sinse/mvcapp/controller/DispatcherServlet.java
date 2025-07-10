package com.sinse.mvcapp.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//모든 종류의 요청을 다 받을 수 있는 서블릿이다. 
//1차적으로 요청들을 분류해준다.
public class DispatcherServlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(getClass());
	FileInputStream fis;
	Properties props; //java.util 의 자식 중 properties라는 객체는 자신이 읽어들인 문자열이 만일 
	//=을 기준으로 key=value 형태로 되어있다면, 이것을 해석할 수 있는 객체임.
		
	//이 서블릿의 인스턴스가 생성될 때 초기화가 진행되고, 
	//초기화 진행시점에 설정파일로 부터, 
	//해당 요청에 어떤 하위 컨트롤러가 작동해야하는지 분석하여 요청을 전달하기 위해 
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		String realPath = context.getRealPath(config.getInitParameter("contextConfigLocation"));
		logger.debug(realPath);
		try {
			fis = new FileInputStream(context.getRealPath(config.getInitParameter("contextConfigLocation")));
			props = new Properties();
			props.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doRequest(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doRequest(request,response);
	}

	
	/*
	 * 매 요청마다 1:1 대응되는 매핑을 피하기 위해서 하나의 진입점으로 몰았으나,
	 * 진입점이 되는 클래스가 매 요청마다 1:1대응되는 if 조건문이 작성되고있다.
	 */
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Controller controller = null;
	
			//혈액형을 전문적으로 처리하는 컨트롤러에게 업무 분담!!
			// 요청에 대한 처리를 1:1 대응하는 객체로 처리하는 개발 패턴을 가리켜 Command Pattern이라고 한다.
//			controller = new BloodController();
			try {
				Class clazz= Class.forName(props.getProperty(request.getRequestURI()));
				controller = (Controller)clazz.newInstance();
				controller.execute(request, response);
				
				response.sendRedirect(props.getProperty(controller.getViewPage()));
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	@Override
	public void destroy() {
		if(fis !=null) {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
