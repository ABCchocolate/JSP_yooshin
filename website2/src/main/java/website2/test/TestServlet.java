package website2.test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TestServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
	    resp.setContentType("text/html; charset=utf-8");
	    PrintWriter out = resp.getWriter();
	    out.println("제발 성공해라..");
	}
}
