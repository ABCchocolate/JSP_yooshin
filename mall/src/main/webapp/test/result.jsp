<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String name =(String)session.getAttribute("name");
	String nick = (String)application.getAttribute("nick");
	String area = (String)request.getAttribute("area");
	String tel  = (String)application.getAttribute("tel");
	
	out.println("session에 담은 나의 이름은 " + name + "\n");
	out.println("applicationdp 담은 나의 별명은 " + nick + "\n");
	out.println("request에 담은 나의 주소는 "+ area);
	out.println("servletContext에 담은 나의 전화번호" + tel);
%>