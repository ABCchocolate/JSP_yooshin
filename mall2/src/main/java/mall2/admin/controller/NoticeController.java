package mall2.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import mall2.notice.model.NoticeService;

@Controller
@Slf4j
public class NoticeController {
	//규모가 작은 프로젝트에서는 상관없으나, 규모가 엄청 큰 대규모에서는 유지보수 시간이 곧비용이므로,
	//최대한 유지보수성을 높이려면 객체와 객체들간의 has a 관계는 느슨할 수록 좋다.(상위 자료형으로 보유할 수록 느슨해진다.)
	
	//spring Container로 부터 인스턴스를 받아온다.
	@Qualifier("mybatisNoticeDAO") //spring Container가 보유한 여러 인스턴스 중 원하는 아이디를 넣는다.
	@Autowired
	NoticeService noticeService;
	
	
   //목록 요청 처리, 특정 uri에 매핑되는 대상을 컨트롤러 클래스로 처리하는 것이 아니라 메서드로 처리하기 위함
   @RequestMapping("/notice/list")
   public ModelAndView selectAll() {
      //3단계: DB에서 가져오기
      //4단계: 결과 저장
      //ModelAndView 객체는 Model과 View를 합쳐놓은 객체임
      //Model 객체에 정보를 담으면 request.setAttribute()와 동일한 효과
      //View에는 DispatcherServlet에게 전달할 페이지 파일명이 아닌 이름을 전달하는 용도
      ModelAndView mav = new ModelAndView();
      mav.setViewName("notice/list");
      
      log.debug("목록 요청 처리");
      noticeService.selectAll();
      return mav;
   }
   //상세보기 요청 처리
   //글 등록 요청 처리
   //글 수정 요청 처리
   //글 삭제 요청 처리
}
