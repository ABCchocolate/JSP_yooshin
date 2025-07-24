package mall.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import mall.domain.Cart;

@Slf4j
@Controller
public class CartController {
	//장바구니 담기 요청 !!
	@PostMapping("/cart/regist")
	public String regist(@ModelAttribute Cart cart) {
		log.debug("상품명은 " +cart.getProduct().getProduct_id());
		log.debug("개수는 " +cart.getEa());
		log.debug("회원명은 " +cart.getMember_id());
		log.debug("색상은 " +cart.getSelectedColor());
		log.debug("사이즈 " +cart.getSelectedSize());
	
		return "ok";
	}
}
