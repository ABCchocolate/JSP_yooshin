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
import com.sinse.hiberasync.model.FoodType;
import com.sinse.hiberasync.model.Store;
import com.sinse.hiberasync.repository.StoreDAO;
import com.sinse.hiberasync.util.Message;

//맛집 정보 수정 요청을 처리하는 서블릿
public class StoreEdit extends HttpServlet{
	Logger logger = LoggerFactory.getLogger(getClass());
	StoreDAO storeDAO = new StoreDAO();
	Message message = new Message();
	Gson gson = new Gson();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String store_id = request.getParameter("store_id");
		String store_name = request.getParameter("store_name");
		String tel= request.getParameter("tel");
		String food_type_id = request.getParameter("food_type_id");
		
		logger.debug("가게아이디는 "+ store_id);
		logger.debug("가게이름" + store_name);
		logger.debug("전화번호" + tel);
		logger.debug("업종아이디" +food_type_id);		
		
		Store store = new Store();
		FoodType foodtype=  new FoodType();
	
		store.setStore_id(Integer.parseInt(store_id));
		store.setStore_name(store_name);
		store.setTel(tel);
		
		foodtype.setFood_type_id(Integer.parseInt(food_type_id));
		store.setFoodType(foodtype);
		
		response.setContentType("application/json;");
		
		try {
			storeDAO.update(store);
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			message.setMsg("등록~ 성공!");
			message.setResult("success");
			
		}
		catch(StoreException e) {
			e.getStackTrace();
			message.setMsg(e.getMessage());
			message.setResult("fail");
			
			
			
		}
		out.print(gson.toJson(message));
	}
}
