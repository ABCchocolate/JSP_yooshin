package myframework.staff.model.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import myframework.admin.model.repository.BioDAO;
import myframework.admin.model.repository.StaffDAO;
import myframework.mybatis.MybatisConfig;
import myframework.staff.model.domain.Bio;

//서비스란 모델 파트의 업무를 추상화 즉.. 단순화 시켜서 컨트롤러가 상세히 모델 파트의 업무를 수행하지 않아도 되도록 만드는 존
//만일 이 서비스 객체가 없다면 controller가 모델 파트의 전문 영역을 담당해야하는 상황이 발생한다.
//이 경우, 컨트롤러와 모델 영역의 관계가 모호해지므로, 추후 컨트롤러가 교체된다면, 모델이 동작하지 않게된다.
public class StaffService {
	// CRUD
	MybatisConfig config = MybatisConfig.getInstance();
	StaffDAO staffDAO = new StaffDAO();
	BioDAO bioDAO = new BioDAO();

	
	public void regist(Bio bio) {
		// 두개의 업무를 이곳에서 실행시킨다.
		SqlSession sqlSession = config.getSqlSession();

		try {
			staffDAO.insert(sqlSession, bio.getStaff());// 일 시키기
			bioDAO.insert(sqlSession, bio);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
	}
}
