package mall.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mall.model.product.SizeService;

@Controller
public class SizeController {
	
	@Autowired
	private SizeService sizeSevice;
	
	@GetMapping("/admin/size/list")
	@ResponseBody //response.setContentType("application/Type")
	public List selectAll() {
		List sizeList = sizeSevice.selectAll();
		//jsp 로 가져갈 것이 없기 때문에, 저장할 필요가 없다.
		return sizeList;
	}
}
