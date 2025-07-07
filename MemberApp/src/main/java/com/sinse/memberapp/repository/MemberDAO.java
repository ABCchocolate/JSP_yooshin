package com.sinse.memberapp.repository;

import org.apache.ibatis.session.SqlSession;

import com.sinse.memberapp.exception.MemberNotFounException;
import com.sinse.memberapp.model.Member;
import com.sinse.memberapp.mybatis.MyBatisConfig;

public class MemberDAO {
	MyBatisConfig config = MyBatisConfig.getInstance();
	
	public Member login(Member member) throws MemberNotFounException{
		SqlSession sqlSession = config.getSqlSession();
		Member obj = sqlSession.selectOne("login", member);
		if(obj == null) {
			throw new MemberNotFounException("로그인 실패~");
		}
		sqlSession.close();
		return obj;
	}
}
