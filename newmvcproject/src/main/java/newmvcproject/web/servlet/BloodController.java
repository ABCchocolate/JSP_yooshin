package newmvcproject.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import newmvcproject.blood.model.BloodManager;

public class BloodController implements Controller {
	BloodManager manager = new BloodManager();
	Logger logger =  LoggerFactory.getLogger(getClass());
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("bloodcontroller호출 성공");
		String blood = request.getParameter("bloodType");
		
		String result = manager.getAdvice(blood); //3단계 일시키기.
		
		//결과 저장(이 클래스에서 결고를 보여주는 것이 아니므로, 결과를 저장해야한다)
		//session에 담으면 데이터는 보여지지만, .do로 새롭게 들어오지 않을 경우 과거의 데이터를 보게된다. 
		//따라서 오늘부터는 request에 담아 forwarding을 사용하여 전달한다.
		request.setAttribute("msg", result);
		
		
	}

	@Override
	public String getViewName() {
		
		return "/blood/view";
	}
}
