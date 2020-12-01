package com.ugly.agri.service;

import com.ugly.agri.vo.ImageFileVO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Slf4j
@Getter
@Service
@RequiredArgsConstructor
public class FileService {
    public static final String MAIN_NAME = "_mainImage.jpg";
    public static final String THUMBNAIL_NAME = "_thumbnailImage.jpg";

    private final ProductService productService;

    @Value("${resources.location}")
    private String resourcesLocation;

    @Value("${resources.uri_path}")
    private String resourcesUriPath;

    @Transactional
    public void createProductImg(Long id, List<MultipartFile> fileList) throws IOException {
        ImageFileVO imageFileVO = makeImageFileVO(id);
        upload(fileList, imageFileVO);
        productService.updateProductImage(imageFileVO);
    }

    private void upload(List<MultipartFile> fileList, ImageFileVO imageFileVO) throws IOException {
        createImageFile(fileList.get(0), imageFileVO.getMainImageFullPath());
        createImageFile(fileList.get(1), imageFileVO.getThumbnailImageFullPath());
    }

    private void createImageFile(MultipartFile file, String path) throws IOException {
        log.info("originalFileName = {}, saveFileName = {}", file.getOriginalFilename(), path);
        file.transferTo(new File(path));
    }

    public ImageFileVO makeImageFileVO(Long id) throws FileNotFoundException {
        String fullPath = ResourceUtils.getFile(resourcesLocation).getAbsolutePath();
        log.info("basePath = {}, fullPath = {}", resourcesLocation, fullPath);
        return ImageFileVO.builder()
                .product_id(id)
                .mainImageFullPath(fullPath + File.separator + id + MAIN_NAME)
                .thumbnailImageFullPath(fullPath + File.separator + id + THUMBNAIL_NAME)
                .mainImageUrlPath(resourcesUriPath + File.separator + id + MAIN_NAME)
                .thumbnailImageUrlPath(resourcesUriPath+ File.separator + id + THUMBNAIL_NAME)
                .build();
    }
}