package com.sinse.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트의 글쓰기 요청을 처리하는 서버측의 서블릿 정의
public class WriteServlet extends HttpServlet{
	
	//클라이언트의 요청이 post 방식인 경우 dopost로 받아야한다.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	    req.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=utf-8");
	    //text/html 과 같은 파일의 종류, 유형을 가리켜 마임타입이라고 합니다. 
	    
	    
		//요청을 받고 ,
		//응답 정보를 만들어야한다.(응답은 서버가 한다.)
		String title = req.getParameter("title");//제목
		String writer = req.getParameter("writer");//글쓴
		String content= req.getParameter("content");//내용
		
		System.out.println("title is " + title + "\n" + "writer is " + writer + "\n" + "content is " + content + "\n");
	
		PrintWriter out = resp.getWriter();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		//DB 연동
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","shop","12341234");
			StringBuffer sql  = new StringBuffer();
			sql.append("insert into notice(title, writer,content) values (?,?,?)");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
			
			int result = pstmt.executeUpdate(); //DML 수행
			if(result > 0) {
				//문자열을 적재해놓으면 응답정보를 만들 때 고양이가 참고한다.
				
				out.print("<script>");
				out.print("alert('글등록 완료');");
				out.print("location.href = '/notice/list';");
				out.print("</script>");
			}
			else {
				out.print("<script>");
				out.print("alert('글등록실패 완료');");
				out.print("history.back();");
				out.print("</script>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
}
