package com.ugly.agri.service;

import com.google.common.collect.Lists;
import com.ugly.agri.domain.Product;
import com.ugly.agri.dto.ProductDTO;
import com.ugly.agri.dto.RequestProductDTO;
import com.ugly.agri.dto.SearchProductDTO;
import com.ugly.agri.exception.CustomException;
import com.ugly.agri.repository.ProductRepository;
import com.ugly.agri.repository.ProductRepositorySupport;
import com.ugly.agri.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductRepositorySupport productRepositorySupport;
    private final UserService userService;

    public List<ProductDTO> getProductsByCondition(SearchProductDTO searchProductDTO) {
        List<Product> productList = productRepositorySupport.findByCondition(searchProductDTO);
        List<ProductDTO> productDTOList = Lists.newArrayList();

        productList.forEach(product -> productDTOList.add(ProductDTO.of(product)));
        return productDTOList;
    }

    public ProductDTO getProduct(Long id) {
        return ProductDTO.of(searchProduct(id));
    }

    public ProductDTO createProduct(RequestProductDTO requestProductDTO) {
        return ProductDTO.of(
                productRepository.save(
                        requestProductDTO.toEntity(userService.searchUser(requestProductDTO.getUserDTO().getId()))));
    }

    public ProductDTO updateProduct(Long id, RequestProductDTO requestProductDTO) {
        Product product = searchProduct(id);

        product.setName(requestProductDTO.getName());
        product.setPrice(requestProductDTO.getPrice());
        product.setComment(requestProductDTO.getComment());
        product.setImageUrl(requestProductDTO.getImageUrl());
        product.setCategory(requestProductDTO.getCategory());

        return ProductDTO.of(productRepository.save(product));
    }

    public void deleteProduct(Long id) {
        Product product = searchProduct(id);
        product.setIsDeleted(true);
        productRepository.save(product);
    }

    private Product searchProduct(Long id) {
        return productRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_EXIST_PRODUCT));
    }
}