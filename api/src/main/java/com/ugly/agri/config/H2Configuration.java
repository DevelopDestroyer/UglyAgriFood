package com.ugly.agri.config;

import com.google.common.collect.Lists;
import com.ugly.agri.domain.Comment;
import com.ugly.agri.domain.User;
import com.ugly.agri.repository.CommentRepository;
import com.ugly.agri.repository.OrderRepository;
import com.ugly.agri.repository.ProductRepository;
import com.ugly.agri.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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

    @Bean
    public Server h2TcpServer() throws SQLException {
        return Server.createTcpServer().start();
    }

    @Bean
    public void setTestData() {
        List<User> userList = userRepository.saveAll(getUserList());
        commentRepository.saveAll(getCommentList(userList));
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