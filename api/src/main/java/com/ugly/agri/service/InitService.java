package com.ugly.agri.service;

import com.google.common.collect.Lists;
import com.ugly.agri.domain.*;
import com.ugly.agri.repository.*;
import com.ugly.agri.type.CategoryType;
import com.ugly.agri.vo.ImageFileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InitService {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final RetailProductRepository retailProductRepository;

    private final FileService fileService;

    public void setTestData() throws FileNotFoundException {
        deleteDate();
        insertDate();
        //        crawling();
    }

    private void deleteDate() {
        reviewRepository.deleteAll();
        orderRepository.deleteAll();
        productRepository.deleteAll();
        retailProductRepository.deleteAll();
        userRepository.deleteAll();
    }

    private void insertDate() throws FileNotFoundException {
        List<User> userList = userRepository.saveAll(getUserList());
        List<Product> productList = productRepository.saveAll(
                getProductList(userList, retailProductRepository.saveAll(getRetailProductList())));
        orderRepository.saveAll(getOrderList(userList, productList));
        reviewRepository.saveAll(getCommentList(userList, productList));

    }

    public void crawling() throws IOException {
        String url = "http://www.kamis.or.kr/customer/price/retail/catalogue.do";
        Document doc = Jsoup.connect(url).get();

        Elements elements = doc.select("table#itemTable_1 tbody tr");

        for (Element tr : elements) {
            Elements tds = tr.select("td");
            if (tds.size() > 0) {
                if (tds.get(2).text().equals("상품")) {
                    RetailProduct retailProduct = RetailProduct.builder()
                            .name(tds.get(0).text())
                            .kind(tds.get(1).text())
                            .grade(tds.get(2).text())
                            .todayAvgPrice(tds.get(3).text())
                            .oneDayAvgPrice(tds.get(4).text())
                            .oneWeekAvgPrice(tds.get(5).text())
                            .twoWeekAvgPrice(tds.size() >= 9 ? tds.get(6).text() : "0")
                            .oneMonthAvgPrice(tds.size() >= 9 ? tds.get(7).text() : "0")
                            .oneYearAvgPrice(tds.size() >= 9 ? tds.get(8).text() : "0")
                            .build();
                    retailProductRepository.save(retailProduct);
                }
            }
        }
    }

    private List<User> getUserList() {
        List<User> list = Lists.newArrayList();

        list.add(User.builder()
                .email("admin")
                .password("admin")
                .name("관리자")
                .build());

        list.add(User.builder()
                .email("chu")
                .password("admin")
                .name("추대윤")
                .build());

        list.add(User.builder()
                .email("lee")
                .password("admin")
                .name("이태호")
                .build());

        return list;
    }

    private List<RetailProduct> getRetailProductList() {
        List<RetailProduct> list = Lists.newArrayList();

        list.add(RetailProduct.builder()
                .name("사과")
                .kind("후지(10개)")
                .grade("상품")
                .todayAvgPrice("27,138")
                .oneDayAvgPrice("27,507")
                .oneWeekAvgPrice("29,582")
                .twoWeekAvgPrice("29,782")
                .oneMonthAvgPrice("-")
                .oneYearAvgPrice("19,225")
                .build());

        list.add(RetailProduct.builder()
                .name("감자")
                .kind("수미(100g)")
                .grade("상품")
                .todayAvgPrice("300")
                .oneDayAvgPrice("296")
                .oneWeekAvgPrice("295")
                .twoWeekAvgPrice("293")
                .oneMonthAvgPrice("294")
                .oneYearAvgPrice("217")
                .build());

        list.add(RetailProduct.builder()
                .name("고구마")
                .kind("밤(1kg)")
                .grade("상품")
                .todayAvgPrice("5,776")
                .oneDayAvgPrice("5,579")
                .oneWeekAvgPrice("5,617")
                .twoWeekAvgPrice("5,809")
                .oneMonthAvgPrice("5,736")
                .oneYearAvgPrice("4,289")
                .build());

        return list;
    }

    private List<Product> getProductList(List<User> userList, List<RetailProduct> retailProductList) throws FileNotFoundException {
        List<Product> list = Lists.newArrayList();

        ImageFileVO imageFileVO = fileService.makeImageFileVO(1L);
        list.add(Product.builder()
                .user(userList.get(1))
                .title("못난이 사과")
                .category(CategoryType.AGRICULTURAL_PRODUCTS)
                .productionArea("광주")
                .productionDate(LocalDate.now().minusDays(100))
                .price(10000L)
                .introduction("흠집이 좀 있는데 단맛이 많아서 일반사과랑 맛이 똑같습니다.")
                .retailProduct(retailProductList.get(0))
                .origin("국내산")
                .producer("해남화산농협")
                .storageMethod("냉장고")
                .weightPerUnit("3kg")
                .composition("사과 3kg")
                .mainImagePath(imageFileVO.getMainImageUrlPath())
                .thumbnailImagePath(imageFileVO.getThumbnailImageUrlPath())
                .build());

        imageFileVO = fileService.makeImageFileVO(2L);
        list.add(Product.builder()
                .user(userList.get(1))
                .title("못난이 감자")
                .category(CategoryType.AGRICULTURAL_PRODUCTS)
                .productionArea("대구")
                .productionDate(LocalDate.now().minusDays(10))
                .price(20000L)
                .introduction("크기가 좀 작지만 맛있습니다!")
                .retailProduct(retailProductList.get(1))
                .origin("미국")
                .producer("감자회사")
                .storageMethod("상온")
                .weightPerUnit("5kg")
                .composition("감자 5kg")
                .mainImagePath(imageFileVO.getMainImageUrlPath())
                .thumbnailImagePath(imageFileVO.getThumbnailImageUrlPath())
                .build());

        imageFileVO = fileService.makeImageFileVO(3L);
        list.add(Product.builder()
                .user(userList.get(1))
                .title("못난이 고구마")
                .category(CategoryType.AGRICULTURAL_PRODUCTS)
                .productionArea("부산")
                .productionDate(LocalDate.now().minusDays(50))
                .price(30000L)
                .introduction("에어프라이어에 해서 먹으면 맛있습니다~")
                .retailProduct(retailProductList.get(2))
                .origin("국내산")
                .producer("충남농협")
                .storageMethod("냉장고")
                .weightPerUnit("2kg")
                .composition("고구마 2kg")
                .mainImagePath(imageFileVO.getMainImageUrlPath())
                .thumbnailImagePath(imageFileVO.getThumbnailImageUrlPath())
                .build());

        return list;
    }

    private List<Order> getOrderList(List<User> userList, List<Product> productList) {
        List<Order> list = Lists.newArrayList();

        list.add(Order.builder()
                .user(userList.get(1))
                .product(productList.get(0))
                .quantity(1)
                .paymentPrice((int) (productList.get(0).getPrice() * 1))
                .build());

        list.add(Order.builder()
                .user(userList.get(2))
                .product(productList.get(1))
                .quantity(5)
                .paymentPrice((int) (productList.get(1).getPrice() * 5))
                .build());

        list.add(Order.builder()
                .user(userList.get(2))
                .product(productList.get(2))
                .quantity(10)
                .paymentPrice((int) (productList.get(2).getPrice() * 10))
                .build());

        return list;
    }

    private List<Review> getCommentList(List<User> userList, List<Product> productList) {
        List<Review> list = Lists.newArrayList();

        list.add(Review.builder()
                .user(userList.get(0))
                .product(productList.get(0))
                .content("난 관리자다")
                .grade(5)
                .build());

        list.add(Review.builder()
                .user(userList.get(1))
                .product(productList.get(1))
                .content("난 판매자다")
                .grade(3)
                .build());

        list.add(Review.builder()
                .user(userList.get(2))
                .product(productList.get(1))
                .content("난 구매자다")
                .grade(4)
                .build());

        return list;
    }
}