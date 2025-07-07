package com.sinse.hiberasync.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.sinse.hiberasync.exception.StoreException;
import com.sinse.hiberasync.model.Store;
import com.sinse.hiberasync.repository.StoreDAO;
import com.sinse.hiberasync.util.Message;

public class StoreDetail extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(getClass());
	StoreDAO storeDAO = new StoreDAO();
	Gson gson = new Gson();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		int store_id = Integer.parseInt(request.getParameter("store_id"));
		PrintWriter out = response.getWriter();
		Message msg = new Message();
		logger.debug("store_id" + store_id);
		try {
		Store store = storeDAO.select(store_id);
		out.print(gson.toJson(store));
		}
		catch(StoreException e){
			e.printStackTrace();
			msg.setResult("fail");
			msg.setMsg(e.getMessage());
			out.print(gson.toJson(msg));
		}
	}
}
