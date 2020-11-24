package com.ugly.agri.service;

import com.google.common.collect.Lists;
import com.ugly.agri.domain.Product;
import com.ugly.agri.dto.MainDTO;
import com.ugly.agri.dto.ProductDTO;
import com.ugly.agri.dto.SearchProductDTO;
import com.ugly.agri.repository.ProductRepository;
import com.ugly.agri.repository.ProductRepositorySupport;
import com.ugly.agri.type.CategoryType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainService {
    private final ProductRepositorySupport productRepositorySupport;
    private final ProductRepository productRepository;

    // 메인 데이터 조회 (카테고리 + 추천 상품 + 시세보다 저렴한 상품 + 연관 상품)
    public MainDTO getMainData() {
        // 카테고리
        List<String> categoryNameList = Stream.of(CategoryType.values())
                .map(m -> m.getCategoryName())
                .collect(Collectors.toList());

        // 추천 상품
        List<ProductDTO> recommendProductList = getRecommendProductList();

        // 시세보다 저렴한 상품
        List<ProductDTO> cheapProductList = getCheapProductList();

        // 연관 상품
        List<ProductDTO> relatedProductList = getRelatedProductList(categoryNameList);

        return MainDTO.builder()
                .categoryNameList(categoryNameList)
                .recommendProductList(recommendProductList)
                .cheapProductList(cheapProductList)
                .relatedProductList(relatedProductList)
                .build();
    }

    // 상품 리스트를 랜덤하게 돌려서 리턴
    private List<ProductDTO> getRecommendProductList() {
        return getProductDTOList(SearchProductDTO.builder().build());
    }

    // 전체 상품 리스트를 돌면서 당일 평균 가격보다 50% 이하인 상품들만 추출
    private List<ProductDTO> getCheapProductList() {
        List<Product> productList = productRepository.findByIsDeletedFalse();
        List<ProductDTO> productDTOList = Lists.newArrayList();

        List<Product> filteredProductList = productList.stream()
                .filter(product -> Integer.parseInt(product.getRetailProduct().getTodayAvgPrice().replaceAll(",", "")) / 2 > product.getPrice())
                .collect(Collectors.toList());
        Collections.shuffle(filteredProductList);
        filteredProductList.forEach(product -> productDTOList.add(ProductDTO.of(product)));

        return productDTOList.stream().limit(5).collect(Collectors.toList());
    }

    // 카테고리 리스트를 랜덤하게 돌려서 나온 카테고리에 맞는 상품들을 추천 리스트로 리턴
    private List<ProductDTO> getRelatedProductList(List<String> categoryNameList) {
        Collections.shuffle(categoryNameList);
        return getProductDTOList(SearchProductDTO.builder().categoryName(categoryNameList.get(0)).build());
    }

    private List<ProductDTO> getProductDTOList(SearchProductDTO searchProductDTO) {
        List<Product> productList = productRepositorySupport.findByCondition(searchProductDTO);
        List<ProductDTO> productDTOList = Lists.newArrayList();

        productList.forEach(product -> productDTOList.add(ProductDTO.of(product)));
        Collections.shuffle(productDTOList);
        return productDTOList.stream().limit(5).collect(Collectors.toList());
    }
}
