package mall2.notice.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import mall2.domain.Notice;

//애플리케이션 설계 분야에서 CRUD 를 수행하는 역할을 가리켜 repository라고 한다.
//@EnableMVC 에의 @Controllerm,@Service,@Componenet,@Repository 등을 찾아 인스턴스 생성하여 싱글톤으로 관리한다.
@Repository
@Slf4j
public class MybatisNoticeDAO implements NoticeDAO {

	@Override
	public List selectAll() {
		log.debug("DAO의 selectAll 도달하였음");
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
