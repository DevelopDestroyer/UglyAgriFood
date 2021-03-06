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

    public void setTestData() throws IOException {
        //        crawling();

        List<User> userList = userRepository.saveAll(getUserList());
        List<Product> productList = productRepository.saveAll(
                getProductList(userList, retailProductRepository.saveAll(getRetailProductList())));
        orderRepository.saveAll(getOrderList(userList, productList));
        reviewRepository.saveAll(getCommentList(userList, productList));
    }

    public void deleteDate() {
        reviewRepository.deleteAll();
        orderRepository.deleteAll();
        productRepository.deleteAll();
        retailProductRepository.deleteAll();
        userRepository.deleteAll();
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

    private List<Product> getProductList(List<User> userList, List<RetailProduct> retailProductList)
            throws FileNotFoundException {
        List<Product> list = Lists.newArrayList();

        ImageFileVO imageFileVO = fileService.makeImageFileVO(1L);
        list.add(Product.builder()
                .user(userList.get(1))
                .title("맛만 좋은 못난이 사과!! 2kg")
                .category(CategoryType.AGRICULTURAL_PRODUCTS)
                .productionArea("광주")
                .productionDate(LocalDate.now().minusDays(30))
                .price(13000L)
                .introduction("흠집이 좀 있는데 단맛이 많아서 일반사과랑 맛이 똑같습니다.")
                .retailProduct(retailProductList.get(0))
                .origin("국내산")
                .producer("해남화산농협")
                .storageMethod("냉장고")
                .weightPerUnit("2kg")
                .composition("사과 2kg, 1개")
                .mainImagePath(imageFileVO.getMainImageUrlPath())
                .thumbnailImagePath(imageFileVO.getThumbnailImageUrlPath())
                .build());

        imageFileVO = fileService.makeImageFileVO(2L);
        list.add(Product.builder()
                .user(userList.get(1))
                .title("작고 맛있는 못난이 감자, 5kg")
                .category(CategoryType.AGRICULTURAL_PRODUCTS)
                .productionArea("대구")
                .productionDate(LocalDate.now().minusDays(10))
                .price(8200L)
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
                .title("국내산 햇 꿀밤고구마, 1kg, 1박스")
                .category(CategoryType.AGRICULTURAL_PRODUCTS)
                .productionArea("부산")
                .productionDate(LocalDate.now().minusDays(5))
                .price(5050L)
                .introduction("해남꿀고구마 유명한거 다들 아시죠?\n" +
                        "그중 저희 가문의 영광 고구마가 제일인것도 아시죠오?\n\n" +
                        "비옥한 황토밭에서 해풍맞고 자란 해남 꿀고무마!\n\n" +
                        "한번 맛보세요.")
                .retailProduct(retailProductList.get(2))
                .origin("국내산")
                .producer("해남화산농협")
                .storageMethod("상온보관")
                .weightPerUnit("1kg")
                .composition("고구마 1kg, 1개")
                .mainImagePath(imageFileVO.getMainImageUrlPath())
                .thumbnailImagePath(imageFileVO.getThumbnailImageUrlPath())
                .build());

        imageFileVO = fileService.makeImageFileVO(4L);
        list.add(Product.builder()
                .user(userList.get(1))
                .title("맛있는 양배추, 1포기")
                .category(CategoryType.AGRICULTURAL_PRODUCTS)
                .productionArea("충주")
                .productionDate(LocalDate.now().minusDays(3))
                .price(4000L)
                .introduction("무농약으로 인증 받은 꼬꼬마 양배추입니다.")
                .retailProduct(retailProductList.get(3))
                .origin("국내산")
                .producer("하늘과땅")
                .storageMethod("냉장고")
                .weightPerUnit("200G")
                .composition("양배추 1포기")
                .mainImagePath(imageFileVO.getMainImageUrlPath())
                .thumbnailImagePath(imageFileVO.getThumbnailImageUrlPath())
                .build());

        imageFileVO = fileService.makeImageFileVO(5L);
        list.add(Product.builder()
                .user(userList.get(1))
                .title("크기가 엄청 큰 맛있는 수박 입니다. 1개")
                .category(CategoryType.AGRICULTURAL_PRODUCTS)
                .productionArea("진주")
                .productionDate(LocalDate.now().minusDays(6))
                .price(12000L)
                .introduction("상처가 좀 있지만 맛은 최고 입니다.")
                .retailProduct(retailProductList.get(4))
                .origin("국내산")
                .producer("진주과일바구니")
                .storageMethod("냉장고")
                .weightPerUnit("800G")
                .composition("수박 1개")
                .mainImagePath(imageFileVO.getMainImageUrlPath())
                .thumbnailImagePath(imageFileVO.getThumbnailImageUrlPath())
                .build());

        imageFileVO = fileService.makeImageFileVO(6L);
        list.add(Product.builder()
                .user(userList.get(1))
                .title("맛있는 오이 10개")
                .category(CategoryType.AGRICULTURAL_PRODUCTS)
                .productionArea("전주")
                .productionDate(LocalDate.now().minusDays(7))
                .price(4000L)
                .introduction("달고 맛있습니다.")
                .retailProduct(retailProductList.get(5))
                .origin("국내산")
                .producer("충남 공주")
                .storageMethod("냉장고")
                .weightPerUnit("500g")
                .composition("오이 10개")
                .mainImagePath(imageFileVO.getMainImageUrlPath())
                .thumbnailImagePath(imageFileVO.getThumbnailImageUrlPath())
                .build());

        imageFileVO = fileService.makeImageFileVO(7L);
        list.add(Product.builder()
                .user(userList.get(1))
                .title("못나고 맛있는 토마토 1kg")
                .category(CategoryType.AGRICULTURAL_PRODUCTS)
                .productionArea("충주")
                .productionDate(LocalDate.now().minusDays(1))
                .price(2500L)
                .introduction("못생겼지만 정말 달고 맛있습니다.\n끝내줘요!")
                .retailProduct(retailProductList.get(6))
                .origin("국내산")
                .producer("충주")
                .storageMethod("냉장고")
                .weightPerUnit("1kg")
                .composition("토마토 1kg")
                .mainImagePath(imageFileVO.getMainImageUrlPath())
                .thumbnailImagePath(imageFileVO.getThumbnailImageUrlPath())
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
                .kind("수미(1kg)")
                .grade("상품")
                .todayAvgPrice("9300")
                .oneDayAvgPrice("9296")
                .oneWeekAvgPrice("9295")
                .twoWeekAvgPrice("9293")
                .oneMonthAvgPrice("9294")
                .oneYearAvgPrice("9217")
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

        list.add(RetailProduct.builder()
                .name("양배추")
                .kind("양배추(1포기)")
                .grade("상품")
                .todayAvgPrice("4,499")
                .oneDayAvgPrice("4,646")
                .oneWeekAvgPrice("5,713")
                .twoWeekAvgPrice("5,992")
                .oneMonthAvgPrice("6,186")
                .oneYearAvgPrice("4,033")
                .build());

        list.add(RetailProduct.builder()
                .name("수박")
                .kind("수박(1개)")
                .grade("상품")
                .todayAvgPrice("17,294")
                .oneDayAvgPrice("17,481")
                .oneWeekAvgPrice("16,927")
                .twoWeekAvgPrice("15,237")
                .oneMonthAvgPrice("16,947")
                .oneYearAvgPrice("25,503")
                .build());

        list.add(RetailProduct.builder()
                .name("오이")
                .kind("가시계통(10개)")
                .grade("상품")
                .todayAvgPrice("8,276")
                .oneDayAvgPrice("7,707")
                .oneWeekAvgPrice("7,451")
                .twoWeekAvgPrice("6,587")
                .oneMonthAvgPrice("10,406")
                .oneYearAvgPrice("8,925")
                .build());

        list.add(RetailProduct.builder()
                .name("토마토")
                .kind("토마토(1kg)")
                .grade("상품")
                .todayAvgPrice("5,120")
                .oneDayAvgPrice("5,396")
                .oneWeekAvgPrice("5,817")
                .twoWeekAvgPrice("8,290")
                .oneMonthAvgPrice("5,396")
                .oneYearAvgPrice("4,587")
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
                .content("싼 가격에 잘 샀어요. 맛있어여.")
                .grade(5)
                .build());

        list.add(Review.builder()
                .user(userList.get(1))
                .product(productList.get(1))
                .content("흠집이 있지만, 맛만 좋네요. 굿!")
                .grade(3)
                .build());

        list.add(Review.builder()
                .user(userList.get(2))
                .product(productList.get(1))
                .content("맛만 좋네 앱 짱이네요. 자주 애용할게요!")
                .grade(4)
                .build());

        return list;
    }
}
