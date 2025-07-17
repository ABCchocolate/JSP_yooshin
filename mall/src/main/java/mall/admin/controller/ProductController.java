package mall.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	@RequestMapping(value = "/admin/product/registform")
	public String getRegistform() {
		return "secure/product/regist";
	}
	
}
