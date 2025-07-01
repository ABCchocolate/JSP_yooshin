package com.sinse.mysite.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter; // 누락된 import 추가

public class MyName extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8"); // 응답 형식 지정!!!
        PrintWriter out = response.getWriter();
        out.print("this is my first app!");
    }
}


//서블릿 매핑....