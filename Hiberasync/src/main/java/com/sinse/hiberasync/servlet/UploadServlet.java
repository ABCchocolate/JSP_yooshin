package com.sinse.hiberasync.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UploadServlet extends HttpServlet{
	Logger logger = LoggerFactory.getLogger(getClass());
	String uploadPath;
	
	//이 서브릿에 instance가 생성될 때 서블릿에 초기화를 담당하는 메서드인 init()을 이용하면 개발자가
	//이 서블릿의 원하는 정보를 전달할 수 있다.
	@Override
	public void init(ServletConfig config) throws ServletException {
	    // this.uploadPath로 필드에 값을 넣어야 함
	    this.uploadPath = config.getServletContext().getRealPath(config.getInitParameter("uploadPath"));
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String uploadPath = this.getServletContext().getRealPath("/data"); //jsp
		logger.debug("저장할 실제 경로는 " + uploadPath);
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		
		//클라이언트의 요청을 분석(파싱)
		try {
			List<FileItem> list = servletFileUpload.parseRequest(request);
			logger.debug("전송된컴포넌트의 수는" + list.size());
			
			for(FileItem item: list) {
				if(!item.isFormField()) {
					//text component
					logger.debug(item.getString("utf-8"));
					item.write(new File(uploadPath, item.getName()));
					
					//세션은웹 컨테이너가 생성한다.
					HttpSession session = request.getSession(); 
					session.setAttribute("img",item.getName());
				}
				else {
					//file component
					logger.debug("파일 명은 " + item.getName());
				}
			}
			//클라이언트의 브라우저로 하여금, 이미지를 볼 수 있는 jsp를 재요청하게 만들자.
			response.sendRedirect("/gallery/result.jsp"); //지정된 URL 로 클라이언트의 브라우저가 재요청 하게 만든다.
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
