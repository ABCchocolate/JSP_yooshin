<%@page import="com.sinse.memberapp.repository.DeptDAO"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.sinse.mvcapp.mybatis.MyBatisConfig"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	MyBatisConfig Config = MyBatisConfig.getInstance();
	SqlSession sqlSession = Config.getSqlSession();
	out.print(sqlSession);
	
	
%>
