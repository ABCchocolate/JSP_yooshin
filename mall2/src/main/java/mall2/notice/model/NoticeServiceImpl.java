package mall2.notice.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mall2.domain.Notice;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDAO noticeDAO; //Mybatis를 사용한다고 하더라도 가능하면 상위 객체를 가져와서 사용해야한다.
	

	@Override
	public List selectAll() {
		log.debug("Servic 의 selectAll에 도달하였습니다.");
		noticeDAO.selectAll();
		return null;
	}

	@Override
	public Notice select(int notice_id) {
			return null;
	}

	@Override
	public void regist(Notice notice) {
		
		
	}

	@Override
	public void update(Notice notice) {
		
		
	}

	@Override
	public void delete(int notice_id) {
		
		
	}

}
