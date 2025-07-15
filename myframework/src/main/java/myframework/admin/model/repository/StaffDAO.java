package myframework.admin.model.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import myframework.exception.StaffException;
import myframework.mybatis.MybatisConfig;
import myframework.staff.model.domain.Staff;

public class StaffDAO {
	MybatisConfig config = MybatisConfig.getInstance();
	
	public List selectAll() {
		return null;
	}
	public Staff select(int id) {
		return null;
	}
	public void update(int id) {
		
	}
	public void insert(SqlSession sqlSession, Staff staff) throws StaffException{
		
		int result = sqlSession.insert("Staff.insert",staff);
		if(result < 1) {
			throw new StaffException("직원 등록 실패");
		}
	}
	
	public void delete(int id) {
		
	}
}
