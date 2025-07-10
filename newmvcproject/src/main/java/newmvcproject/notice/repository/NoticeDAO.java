package newmvcproject.notice.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import newmvcproject.exception.NoticeException;
import newmvcproject.mybatis.MybatisConfig;
import newmvcproject.notice.domain.Notice;
import newmvcproject.pool.PoolManager;

public class NoticeDAO {
	PoolManager poolManager = PoolManager.getInstance();
	MybatisConfig config = MybatisConfig.getInstance();
	
	//select all record
	public List<Notice> selectAll() {
		SqlSession sqlSession = config.getSqlSession();
		List list = sqlSession.selectList("Notice.selectAll");
		sqlSession.close();
		return list;
	}
	
	
	//select one record
	// Notice 객체에 notice_id 값이 미리 세팅되어 있다고 가정
	public Notice select(int notice_id) {
		SqlSession sqlSession = config.getSqlSession();
		Notice notice = sqlSession.selectOne("Notice.select", notice_id);
		sqlSession.close();
		return notice;
	}


	
	//insert one record
	public void insert(Notice notice) throws NoticeException{
		SqlSession sqlSession = config.getSqlSession();
		int result = sqlSession.insert("Notice.insert",notice);
		sqlSession.commit(); //Confirmation DML Transaction
		sqlSession.close();
		if (result < 1) {
			throw new NoticeException("등록을 실패하였습니다.");
		}
	}
	//update a number of records
	public void update(Notice notice) throws NoticeException {
		SqlSession session = MybatisConfig.getInstance().getSqlSession();
		int result = session.update("Notice.update", notice);
		session.commit();
		session.close();

		if (result < 1) {
			throw new NoticeException("수정 실패");
		}
	}

	public void delete(int notice_id) {
		SqlSession sqlSession = config.getSqlSession();
		int result = sqlSession.delete("Notice.delete", notice_id);
		sqlSession.commit();
		sqlSession.close();
		if(result <1 ) {
			throw new NoticeException("삭제를 실패했습니다.");
		}
	}
}
