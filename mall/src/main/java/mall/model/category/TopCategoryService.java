package mall.model.category;

import java.util.List;

import mall.domain.TopCategory;

//controller가 느슨하게 서비스를 보유하려면 (DI) 인터페이스정
public interface TopCategoryService {
	public List selectAll();
	public TopCategory select(int topcategory_id);

}
