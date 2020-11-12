package com.ugly.agri.config;

import com.google.common.collect.Lists;
import com.ugly.agri.domain.*;
import com.ugly.agri.repository.*;
import com.ugly.agri.type.CategoryType;
import lombok.RequiredArgsConstructor;
import org.h2.tools.Server;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Configuration
@Profile("local")
@RequiredArgsConstructor
public class H2Configuration {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;
    private final RetailProductRepository retailProductRepository;

    @Bean
    public Server h2TcpServer() throws SQLException {
        return Server.createTcpServer().start();
    }

    @Bean
    public void setTestData() throws IOException {
        crawling();
        List<User> userList = userRepository.saveAll(getUserList());
        List<Product> productList = productRepository.saveAll(
                getProductList(userList, retailProductRepository.saveAll(getRetailProductList())));
        orderRepository.saveAll(getOrderList(userList, productList));
        commentRepository.saveAll(getCommentList(userList, productList));
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
                            .twoWeekAvgPrice(tds.get(6).text())
                            .oneMonthAvgPrice(tds.get(7).text())
                            .oneYearAvgPrice(tds.get(8).text())
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
                .isSeller(true)
                .build());

        list.add(User.builder()
                .email("chu")
                .password("admin")
                .name("추대윤")
                .isSeller(true)
                .build());

        list.add(User.builder()
                .email("lee")
                .password("admin")
                .name("이태호")
                .isSeller(false)
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

    private List<Product> getProductList(List<User> userList, List<RetailProduct> retailProductList) {
        List<Product> list = Lists.newArrayList();

        list.add(Product.builder()
                .user(userList.get(1))
                .name("못난이 사과")
                .price(10000L)
                .imageUrl("img/0.jpg")
                .category(CategoryType.AGRICULTURAL_PRODUCTS)
                .retailProduct(retailProductList.get(0))
                .build());

        list.add(Product.builder()
                .user(userList.get(1))
                .name("못난이 감자")
                .price(20000L)
                .imageUrl("img/1.jpg")
                .category(CategoryType.AGRICULTURAL_PRODUCTS)
                .retailProduct(retailProductList.get(1))
                .build());

        list.add(Product.builder()
                .user(userList.get(1))
                .name("못난이 고구마")
                .price(30000L)
                .imageUrl("img/2.jpg")
                .category(CategoryType.AGRICULTURAL_PRODUCTS)
                .retailProduct(retailProductList.get(2))
                .build());

        return list;
    }

    private List<Order> getOrderList(List<User> userList, List<Product> productList) {
        List<Order> list = Lists.newArrayList();

        list.add(Order.builder()
                .userId(userList.get(1))
                .product(productList.get(0))
                .quantity(1)
                .build());

        list.add(Order.builder()
                .userId(userList.get(2))
                .product(productList.get(1))
                .quantity(5)
                .build());

        list.add(Order.builder()
                .userId(userList.get(2))
                .product(productList.get(2))
                .quantity(10)
                .build());

        return list;
    }

    private List<Comment> getCommentList(List<User> userList, List<Product> productList) {
        List<Comment> list = Lists.newArrayList();

        list.add(Comment.builder()
                .user(userList.get(0))
                .product(productList.get(0))
                .comment("난 관리자다")
                .build());

        list.add(Comment.builder()
                .user(userList.get(1))
                .product(productList.get(1))
                .comment("난 판매자다")
                .build());

        list.add(Comment.builder()
                .user(userList.get(2))
                .product(productList.get(1))
                .comment("난 구매자다")
                .build());

        return list;
    }
}