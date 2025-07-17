package mall.model.category;

import java.util.List;

import mall.domain.TopCategory;

public interface TopCategoryDAO {
    public List<TopCategory> selectAll();
    public TopCategory select(int topcategory_id); // 오타 수정됨
}
