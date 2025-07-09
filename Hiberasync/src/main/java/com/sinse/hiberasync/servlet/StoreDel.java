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
import com.sinse.hiberasync.repository.StoreDAO;
import com.sinse.hiberasync.util.Message;

public class StoreDel extends HttpServlet{
	Logger logger = LoggerFactory.getLogger(getClass());
	StoreDAO storeDAO = new StoreDAO();
	Message message = new Message();
	Gson gson = new Gson();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String store_id = request.getParameter("store_id");
		logger.debug("STOREID = "+ store_id);
		
		
		try {
		storeDAO.delete(Integer.parseInt(store_id));
		}
		catch(StoreException e) {
			e.printStackTrace();
			message.setMsg(e.getMessage());
			out.print(gson.toJson(message));
		}
	}
}
