package com.ugly.agri.config;

import com.google.common.collect.Lists;
import com.ugly.agri.domain.Comment;
import com.ugly.agri.domain.RetailProduct;
import com.ugly.agri.domain.User;
import com.ugly.agri.repository.*;
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
    private final RetailProductRepository retailProductRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;

    @Bean
    public Server h2TcpServer() throws SQLException {
        return Server.createTcpServer().start();
    }

    @Bean
    public void setTestData() throws IOException {
        crawling();
        List<User> userList = userRepository.saveAll(getUserList());
        commentRepository.saveAll(getCommentList(userList));
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
                .userId("admin")
                .password("admin")
                .name("관리자")
                .isSeller(true)
                .build());

        list.add(User.builder()
                .userId("chu")
                .password("admin")
                .name("추대윤")
                .isSeller(true)
                .build());

        list.add(User.builder()
                .userId("lee")
                .password("admin")
                .name("이태호")
                .isSeller(false)
                .build());

        return list;
    }

    private List<Comment> getCommentList(List<User> userList) {
        List<Comment> list = Lists.newArrayList();

        list.add(Comment.builder()
                .user(userList.get(0))
                .product(null)
                .comment("난 관리자다")
                .build());

        list.add(Comment.builder()
                .user(userList.get(1))
                .product(null)
                .comment("난 판매자다")
                .build());

        list.add(Comment.builder()
                .user(userList.get(2))
                .product(null)
                .comment("난 구매자다")
                .build());

        return list;
    }
}