package mall.admin.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
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
                         @RequestParam("photo") MultipartFile photo) {

        ServletContext context = request.getServletContext();
        String savePath = context.getRealPath("/resources/data/");
        log.debug("업로드 경로: {}", savePath);

        String savedFilename = fileManager.save(photo, savePath);
        log.debug("저장된 파일명: {}", savedFilename);

        // TODO: 여기서 savedFilename을 상품 정보와 함께 DB에 저장하는 로직 추가

        return "redirect:/admin/product/list";
    }
}
