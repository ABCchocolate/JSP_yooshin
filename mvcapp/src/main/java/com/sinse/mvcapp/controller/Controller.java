package com.sinse.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	//모든하위 컨트롤러들이 업무수행을 진행할 때 호출 메서드를 정의한다.
	//모든 하위 컨트롤러들이, 어떤 페이지를 검색해야 할지를 DispatcherServlet에게 알려주기 위한 메서드를 정의한다.
	public void execute(HttpServletRequest Request, HttpServletResponse response)throws ServletException,IOException;
	
	public String getViewPage();
}
