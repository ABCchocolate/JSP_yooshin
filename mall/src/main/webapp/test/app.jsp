<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//웹 요청 처리 흐름에서, 데이터를 저장 할 수 있는 객체의 종류에는 다음과 같은 것들이 있다.
	//1. HttpServletrequest :요청 처리가 끝날 때까
	//2. HttpSession :세션의 유지시간까지
	//3. ServletContext : 에플리케이션이 실행되는 동안 유지된다. 톰캣 키고 톰캣이 꺼질 때까지 유지된다.
		
	session.setAttribute("name", "yooshin");	
	application.setAttribute("nick", "doremi");
	request.setAttribute("area","anyang");
%>