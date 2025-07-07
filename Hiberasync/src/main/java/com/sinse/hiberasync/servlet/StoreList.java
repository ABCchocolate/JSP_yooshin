package com.sinse.hiberasync.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sinse.hiberasync.exception.StoreException;
import com.sinse.hiberasync.repository.StoreDAO;

public class StoreList extends HttpServlet{
	StoreDAO storeDAO = new StoreDAO();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		try {
		List list = storeDAO.selectAll();
		out.print(gson.toJson(list)); //client가 받을 json 문자욜
		
		}catch(StoreException e) {
			e.printStackTrace();
		}

	}
}
