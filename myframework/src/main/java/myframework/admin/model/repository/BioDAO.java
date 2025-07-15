package myframework.admin.model.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import myframework.exception.BioException;
import myframework.mybatis.MybatisConfig;
import myframework.staff.model.domain.Bio;

public class BioDAO {
	
	MybatisConfig config = MybatisConfig.getInstance();
	public List selectAll() {
		return null;
	}
	public Bio select(int id) {
		return null;
	}
	public void update(int id) {
		
	}
	public void insert(SqlSession sqlSession,Bio bio)throws BioException {
		
		int result = sqlSession.insert("Bio.insert",bio);
		if(result < 1) {
			throw new BioException("Staff의 신체정보 등록에 실패했습니다.");
		}
		
	}
	public void delete(int id) {
		
	}
}
