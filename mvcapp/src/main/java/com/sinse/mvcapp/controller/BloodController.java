package com.sinse.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinse.mvcapp.blood.model.BloodManager;

public class BloodController implements Controller{
    BloodManager manager = new BloodManager();

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 파라미터 받기
        String blood = request.getParameter("bloodType");

        // 로직 처리
        String bloodType = manager.getAdvice(blood);

        // 결과를 request에 담기 (일회성 데이터)
        request.setAttribute("bloodType", bloodType);

//        // 결과 JSP로 포워딩
//        request.getRequestDispatcher("/blood/result/view").forward(request, response);
        
    }

	@Override
	public String getViewPage() {
		
		return "/blood/result/view";
	}
}
