package mall2.notice.model;

import java.util.List;

import mall2.domain.Notice;

/*
 * MYBATIS, Hibernate, JDBC 이건 상관없이 최상위 Notice DAO 를 가지고 올 수 있도록 한다.
 * DAO 들의 최상위 DAO가 될 수 있다.
 */

public interface NoticeDAO {
	public List selectAll();
	public Notice select(int notice_id);
	public void insert(Notice notice);
	public void update(Notice notice);
	public void delete(int notice_id);
}
