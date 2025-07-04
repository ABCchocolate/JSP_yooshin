package tls.study.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {
	private static MyBatisConfig instance;
	private SqlSessionFactory sqlSessionFactory;
	private MyBatisConfig() {
		String resource = "tls/study/mybatis/generatorConfig.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =
					  new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static MyBatisConfig getinstance() {
		if(instance == null) {
			instance = new MyBatisConfig();
		}
		return instance;
	}
	
	public SqlSession sqlSession() {
		return  sqlSessionFactory.openSession();
	}
	
}
