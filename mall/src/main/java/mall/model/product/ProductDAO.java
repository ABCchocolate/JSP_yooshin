package mall.model.product;

import mall.domain.Color;
import mall.domain.Product;

public interface ProductDAO {
	public void insert(Product product);
	public void insertColor(Color color);
}
