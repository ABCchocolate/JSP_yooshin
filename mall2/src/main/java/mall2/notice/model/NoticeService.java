package mall2.notice.model;

import java.util.List;

import org.springframework.stereotype.Service;

import mall2.domain.Notice;

public interface NoticeService {
	public List selectAll();
	public Notice select(int notice_id);
	
	//?? 왜 insert가 아니라 regist인지 여쭤보기
	//두 개 이상의 DAO 를 대상으로 업무를 진행할 경우 insert보다 상위의 개념인 등록을 표현하는 메서드 명으로 가는 것이 좋다.
	public void regist(Notice notice);
	
	public void update(Notice notice);
	public void delete(int notice_id);
}
