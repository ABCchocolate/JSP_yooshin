package com.sinse.memberapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sinse.memberapp.model.Dept;
import com.sinse.memberapp.mybatis.MyBatisConfig;

public class DeptDAO {
	MyBatisConfig configs=  MyBatisConfig.getInstance();
	public List selectAll() {
		SqlSession sqlSession = configs.getSqlSession();
		List list = sqlSession.selectList("Emp.selectAll");
		sqlSession.close();
		return list;
	}
}
