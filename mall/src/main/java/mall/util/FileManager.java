package mall.util;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

    private static final Logger log = LoggerFactory.getLogger(FileManager.class);

    // photo: 업로드된 파일
    // savePath: 저장 경로 (ex: "C:/upload/product/")
    public String save(MultipartFile photo, String savePath) {
        // 원래 파일 이름
        String filename = photo.getOriginalFilename();
        if (filename == null || filename.isEmpty()) return null;

        // 확장자 추출
        String ext = filename.substring(filename.lastIndexOf(".") + 1);

        // 새 파일 이름 생성 (유일성 보장)
        String newName = System.currentTimeMillis() + "." + ext;

        // 실제 파일 객체 생성
        File file = new File(savePath, newName);

        try {
            // 실제 디스크에 저장
            photo.transferTo(file);
            log.debug("업로드 파일 경로: {}", file.getAbsolutePath());
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return null;
        }

        // 저장된 파일명을 반환 (DB 저장용)
        return newName;
    }
}
