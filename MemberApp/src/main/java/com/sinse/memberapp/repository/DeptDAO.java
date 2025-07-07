package com.sinse.memberapp.repository;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sinse.memberapp.mybatis.MyBatisConfig;


public class DeptDAO {
	MyBatisConfig config=MyBatisConfig.getInstance();
	
	//부서 정보 가져오기 
	public List selectAll() {
		SqlSession sqlSession=config.getSqlSession();
		List list=sqlSession.selectList("Dept.selectAll");
		sqlSession.close();
		return list;
	}
}






