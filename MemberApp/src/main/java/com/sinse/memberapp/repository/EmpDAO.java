package com.sinse.memberapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sinse.memberapp.mybatis.MyBatisConfig;

public class EmpDAO {
	MyBatisConfig config = MyBatisConfig.getInstance();
	
	public List selectAll() {
		SqlSession sqlSession = config.getSqlSession();
		List list = sqlSession.selectList("Emp.selectAll");
		sqlSession.close();
		return list;
	}
}
