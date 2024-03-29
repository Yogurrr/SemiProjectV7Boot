package yogurrr.springboot.semiprojectv7.service;

import org.springframework.web.multipart.MultipartFile;
import yogurrr.springboot.semiprojectv7.model.Gallery;

import java.util.List;
import java.util.Map;

public interface GalleryService {

    Map<String, Object> newGallery(Gallery gallery);

    boolean newPdsAttach(List<MultipartFile> attachs, Map<String, Object> ginfo);

    Map<String, Object> readGallery(Integer cpg);

    Object readOneGallery(int gno);
}
