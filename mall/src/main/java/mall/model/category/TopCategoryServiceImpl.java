package mall.model.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mall.domain.TopCategory;

@Service
public class TopCategoryServiceImpl implements TopCategoryService{
	@Qualifier("hibernateTopCategoryDAO") // ← 이게 HibernateTopCategoryDAO에 붙은 이름!
	@Autowired
	private TopCategoryDAO topCategoryDAO;
	
	@Transactional
	@Override
	public List selectAll() {
		return topCategoryDAO.selectAll();
		
	}
	
	@Override
	public TopCategory select(int toopcategory_id) {
		return null;
	}
}
