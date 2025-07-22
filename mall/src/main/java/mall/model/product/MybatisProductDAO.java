package mall.model.product;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mall.domain.Color;
import mall.domain.Product;
import mall.exception.ProductException;

@Repository
public class MybatisProductDAO implements ProductDAO{
	
	//setter를 사용하여도 주입이 가능합니다.
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public void insert(Product product) throws ProductException{
		int result = sqlSessionTemplate.insert("Product.insert",product);
		if(result < 1) {
			throw new ProductException("등록 실패"); //실패되었음을 다른 계층에서도 알아야하기 때문에, 잡으면 안된다.
		}
	}


	@Override
	public void insertColor(Color color) {
		// TODO Auto-generated method stub
		
	}
	
}
