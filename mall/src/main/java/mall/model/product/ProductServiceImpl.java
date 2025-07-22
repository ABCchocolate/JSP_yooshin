package mall.model.product;


import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import mall.domain.Color;
import mall.domain.Product;
import mall.domain.ProductColor;
import mall.domain.ProductImg;
import mall.domain.ProductSize;
import mall.exception.ProductException;
import mall.util.FileManager;


@Service
public class ProductServiceImpl implements ProductService{

    private final CommonsMultipartResolver multipartResolver;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private ProductColorDAO productColorDAO;
	
	@Autowired
	private ProductSizeDAO productSizeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	private ProductImgDAO productImgDAO;

    ProductServiceImpl(CommonsMultipartResolver multipartResolver) {
        this.multipartResolver = multipartResolver;
    }
	
	@Override
	@Transactional //아래의 DAO가 가진 메서드 중 DML 작업 시 하나라도 exception이 발생하며
	//rollback을시켜준다.
	//상품등ㄹㄱ 색상등록 사이즈등록 이미지등록 파일저장
	public void regist(Product product, String savePath) {
		productDAO.insert(product);
		
	for(ProductColor productColor:product.getColorList()) {
			productColor.setProduct(product);
			productColorDAO.insert(productColor);
		}
	
	for(ProductSize productSize:product.getSizeList()) {
		productSize.setProduct(product);
		productSizeDAO.insert(productSize);
	}
	

	fileManager.save(product, savePath);
	
	//5) 이미지 파일명도 채워진 상태리므로 db저장
	List<ProductImg> imgList= product.getImgList();
	
	for(ProductImg productImg : imgList) {
		productImg.setProduct(product);
		productImgDAO.insert(productImg);
	}
}
}