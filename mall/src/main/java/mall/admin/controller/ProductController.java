package mall.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import mall.domain.Product;
import mall.model.category.TopCategoryService;
import mall.util.FileManager;

@Slf4j
@Controller
public class ProductController {

    @Autowired
    private TopCategoryService topCategoryService;

    @Autowired
    private FileManager fileManager;

    @RequestMapping("/admin/product/registform")
    public String registform() {
        return "secure/product/regist";
    }

    @PostMapping("/admin/product/regist")
    public String regist(HttpServletRequest request, 
                         MultipartFile[] photo,Product product) {
    	log.debug("길" + photo.length);

    	return "redirect:/admin/admin/product/list";
    }
}
