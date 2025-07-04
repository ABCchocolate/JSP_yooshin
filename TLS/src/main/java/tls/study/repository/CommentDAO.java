package tls.study.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tls.study.exception.CommentException;
import tls.study.model.Comment;
import tls.study.mybatis.MyBatisConfig;

public class CommentDAO {
	MyBatisConfig config = MyBatisConfig.getinstance();
	
	public void insert(Comment comment) throws CommentException{
		SqlSession sqlSession = config.sqlSession();
		int result = sqlSession.insert("Comment.insert",comment);
		if (result < 1) {
			throw new CommentException("등록 실패하였습니다.");
		}
		sqlSession.close();
	}
	
	
	public List selectByNewsId(int news_id) {
		SqlSession sqlSession = config.sqlSession();
		List list = sqlSession.selectList("Comment.selectByNewsId", news_id);
		sqlSession.close();
		
		return list;
	}
	
	public void delete() {
		
	}
	public void update() {
		
	}
}
