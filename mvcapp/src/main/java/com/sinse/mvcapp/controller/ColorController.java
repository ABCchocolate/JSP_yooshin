package com.sinse.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinse.mvcapp.color.model.ColorManager;

/*
 * MVC 패턴에 의해 디자인과 로직을 분리시키려면, 중간에 중재자가 나서야 하므로, 코드에서 분리
 * JSP 는 View로서 사용되어질 예정이기 때문에 ...... servlet을 사용한다.
 * 
 */
public class ColorController extends HttpServlet{
	ColorManager colorManager = new ColorManager();
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//controller의 5대 업무: 1) 요청을 받아야한다. 2)요청을 분석해야한다. 3)직접 일하지 않는다. 4) 결과에 보여질 데이터를 보관해야한다. 5) 알맞는 결과를 보여준다.
			String color = request.getParameter("color"); 
			if(color == null)color ="";	
			String result = colorManager.getAdvice(color);
	}		
}
