package com.sinse.memberapp.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//mybatis-config.xml 을 읽어들여, 개발 시 쿼리문을 수행할 수 있는 객체인 SqlSession을 
//sqlSessionFactory로 부터 얻게 해주는 유틸 클래

//mybatis 내부적으로 JDBC 를 사용한다. 하지만 개발자가 상투적인 JDBC 파일을 일일히 작성하지 않게하기 위해 코드를 숨겨놓고 
//그 대신 SqlSession 을 통해 쿼리를 수행하도록함.
public class MyBatisConfig {
	private static MyBatisConfig instance;
	private SqlSessionFactory sqlSessionFactory;

	private MyBatisConfig() {
		String resource = "com/sinse/memberapp/mybatis/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =
					new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static MyBatisConfig getInstance() {
		if (instance == null) {
			instance = new MyBatisConfig();
		}
		return instance;
	}

	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

}
