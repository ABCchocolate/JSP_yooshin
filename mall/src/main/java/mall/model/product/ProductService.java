package mall.model.product;

import mall.domain.Product;

public interface ProductService {
	public void regist(Product product,String savePath); //모든 파일 업로드까지 담당합니다. 또한 트랜잭션까지 진행해야함.
}
