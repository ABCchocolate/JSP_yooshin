package tls.study.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tls.study.model.News;
import tls.study.mybatis.MyBatisConfig;

public class NewsDAO {
	MyBatisConfig config = MyBatisConfig.getinstance();
	public List selectAll() {
		SqlSession sqlSession = config.sqlSession();
		List list = sqlSession.selectList("News.selectAll");
		sqlSession.close();
		return list;
	}
	
	public News select(int news_id) {
		return null;
	}
	
	public void update() {
		
	}
	public void delete() {
		
	}
}
