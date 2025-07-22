package mall.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import mall.domain.Product;
import mall.domain.ProductImg;
import mall.exception.UploadException;
@Slf4j
@Component
public class FileManager {
	public void save(Product product,String savePath) throws UploadException{
		//MultipartFile 변수와 html 이름이 동일하면 매핑됨 
				MultipartFile[] photo = product.getPhoto();
				
				
				log.debug("업로드 한 파일의 수는 "+photo.length);
				List<E> imgList = new ArrayList();
				
				try {
					for(int i = 0; i< photo.length; i++) {
						log.debug("원본 파일명은 " + photo[i].getOriginalFilename());
						String ori = photo[i].getOriginalFilename();
						String ext = ori.substring(ori.lastIndexOf(".")+1, ori.length());
						//개발자가 원하는 파일 명 생성하기
						try {
							Thread.sleep(10);
						}catch(InterruptedException e) {
							e.printStackTrace();
						}
						long time = System.currentTimeMillis();
						String filename = time+"."+ext;
						
						//생성한 파일명을 DB에 저장하기 위해서 Product의 ImgList에 보관하자.
						ProductImg productImg = new ProductImg();
						productImg.setFilename(filename);//이미지명 저장
						imgList.add(productImg);
						product.setImgList(imgList);
						
						//realPath 를 사용하려면, 앱의 전반적인 전역적 정보를 가진 객체인 ServletContext가 필요함
						File file = new File(savePath + File.separator + filename);
						log.debug("업로드된 파일 경오" + savePath);
						
						photo[i].transferTo(file);
					
						} 
					}
				catch (Exception e) {
					e.printStackTrace();
					throw new UploadException("이미지 파일 업로드 실패", e);
				}
		}
}
