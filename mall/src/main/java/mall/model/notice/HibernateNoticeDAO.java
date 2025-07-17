package mall.model.notice;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import mal.exception.MallException;
import mall.domain.Notice;

@Slf4j
@Repository
public class HibernateNoticeDAO implements NoticeDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Notice> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Notice",Notice.class);
		
		return query.getResultList();
	}

	@Override
	public Notice select(int notice_id) {
		
		return null;
	}
	
	@Override
	public void insert(Notice notice)throws MallException{
		try {
		sessionFactory.getCurrentSession().saveOrUpdate(notice);
		
		}
		catch(HibernateException e){
			e.printStackTrace();
			log.error("등록 실패~!~!!",e.getMessage());
			throw new MallException("등록 실패~~~");
		}
	}

	@Override
	public void update(Notice notice) {
	
		
	}

	@Override
	public void delete(int notice_id) {
		// TODO Auto-generated method stub
		
	}

}
