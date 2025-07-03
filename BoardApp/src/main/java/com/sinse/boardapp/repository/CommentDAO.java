package com.sinse.boardapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sinse.boardapp.exception.CommentException;
import com.sinse.boardapp.model.Comment;
import com.sinse.boardapp.model.News;
import com.sinse.boardapp.mybatis.MybatisConfig;

//DAO의 존재는 그대로 유지하되, DAO의 CRUD 메서드 안에 상투적 JDBC 코드를 작성하지 말자
//MyBatis 프레임워크와 Hibernate 프레임워크를 이용하기 때문이다.

public class CommentDAO {
	
	MybatisConfig config = MybatisConfig.getInstance();
	
	//해당 뉴스기사에 속하는 댓글만 가지고 오기
	public List selectByNewsId(int news_id) {
		SqlSession sqlSession = config.getSqlSession();
		List list = sqlSession.selectList("Comment.selectByNewsId", news_id);
		sqlSession.close();
		
		return list;
	}
	
	//모든 레코드 가져오기
	public List selectAll() {
		return null;
	};
	
	//한 건 가져오기
	public News select(int comment_id) {
		return null;
	};
	
	//한 건 넣기
	public void insert(Comment comment) throws CommentException {
		SqlSession sqlSession = config.getSqlSession();
		int result = sqlSession.insert("Comment.insert", comment);
		
		if(result < 1) {
			throw new CommentException("등록 실패~!");
		}
		sqlSession.commit();
		sqlSession.close();
		
	};
	
	
	//한건 수정
	public void update(Comment comment) {};
	
	//한 건 삭제
	public void delete(int comment_id) {};
}
