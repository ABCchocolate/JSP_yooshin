package com.sinse.boardapp.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * mybaties의 설정 파일인 xml을 읽어드리며, 필요한 객체를 만들어낸다.
 */
public class MybatisConfig {
	SqlSessionFactory sqlSessionFactory;
	public MybatisConfig() {
		// TODO Auto-generated constructor stub
		String resource = "org/mybatis/example/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//앞으로는 쿼리문 시행시 preparedStatement 및 jdbc를 직접 호출하는 일은 하지 말자/
	//sql Session 이용하여 쿼리를 수행해야 한다.
	public SqlSession getSqlSession() {
		return null;
	}
}
