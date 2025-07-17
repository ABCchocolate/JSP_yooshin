package mall2.notice.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import mall2.domain.Notice;

//애플리케이션 설계 분야에서 CRUD 를 수행하는 역할을 가리켜 repository라고 한다.
@Repository
public class HibernateNoticeDAO implements NoticeDAO
{

	@Override
	public List selectAll() {
		
		return null;
	}

	@Override
	public Notice select(int notice_id) {
		
		return null;
	}

	@Override
	public void insert(Notice notice) {
		
		
	}

	@Override
	public void update(Notice notice) {
		
	}

	@Override
	public void delete(int notice_id) {
		
	}

}
