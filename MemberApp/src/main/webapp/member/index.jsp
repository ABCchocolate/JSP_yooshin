<%@page import="com.sinse.memberapp.model.Member"%>
<%@page import="com.sinse.memberapp.repository.MemberDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// 이 서블릿에 요청을 시도할 때, 웹 컨테이너에서는 무조건 세션 객체를 생성한다. 동시에 세션 아이디도 생성된다.
	// 세션 아이디는 톰캣이 보내는 응답 정보에 쿠키 형태로 존재한다,
	// 단 세션과 세션 아이디는 매 요청마다 만들어진게 아니라, 클라이언트가 요청 시 톰캣이 발급한 쿠키가 존재하지 않을떄
	// 요청 후 일정 시간 동안 아무런 재요청이 없을 때, 사용하지 않는 것으로 판단하여
	// 새롭게 세션을 할당한다.
	String id = session.getId(); //내가 할당 받은 아이
	out.print("지금 이 요청에 의해서 할당된 session id는? = " + id);
	
	/*
	If the requester on this page is a successful login person, the Session will contain a model object as a person named member.
	*/
	Member member = (Member)session.getAttribute("member");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%=member.getName() %>님 안녕하세요.

</body>
</html>