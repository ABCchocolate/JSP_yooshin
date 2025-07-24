package mall.domain;

import lombok.Data;

@Data
public class Cart {
	private int cart_id;
	private int ea;
	private int member_id;
	
	private Product product;

	//주문하고자 하는 상품의 색상
	private String selectedColor;
	
	//주문하고자 하는 상품의 사이즈
	private String selectedSize;
}
