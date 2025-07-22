package mall.domain;

import lombok.Data;

@Data
public class ProductImg {
	private int product_img_id;
	private String filename; //어던 이미지 명을
	private Product product; //어떤 상품
	
}
