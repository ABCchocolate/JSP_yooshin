package fileserver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class UploadServlet extends HttpServlet{

   //클라이언트의 요청이 Post방식이므로, doxx형 중 doPost()를 재정의 해야 함 
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      //response.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=utf-8");
      
      PrintWriter out = response.getWriter();
      out.print("post 요청 받음");

		// 소켓, 스트림
		// 라이브러리를 보통 ㅕㅇㄴ동해서 사용한다.
		// cos.jar 사용해보기!!
      int maxLimit = 8 * 1024 * 1024;
      
		MultipartRequest multi = new MultipartRequest(request,
				"/Users/bag-yusin/javaee_workspace/fileserver/src/main/webapp/data",maxLimit, "utf-8");
	}

}
