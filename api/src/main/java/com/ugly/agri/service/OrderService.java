package com.ugly.agri.service;

import com.ugly.agri.domain.Order;
import com.ugly.agri.dto.RequestOrderDTO;
import com.ugly.agri.repository.OrderRepository;
import com.ugly.agri.repository.ProductRepository;
import com.ugly.agri.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order createOrder(RequestOrderDTO requestOrderDTO) {
        return orderRepository.save(requestOrderDTO.toEntity(userRepository.findById(requestOrderDTO.getUserId()).get(), productRepository.findById(requestOrderDTO.getProductId()).get()));
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id).get();
    }
}

