package com.ugly.agri.service;

import com.google.common.collect.Lists;
import com.ugly.agri.domain.Review;
import com.ugly.agri.dto.RequestReviewDTO;
import com.ugly.agri.dto.ReviewDTO;
import com.ugly.agri.repository.ProductRepository;
import com.ugly.agri.repository.ReviewRepository;
import com.ugly.agri.repository.ReviewRepositorySupport;
import com.ugly.agri.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewRepositorySupport reviewRepositorySupport;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public List<ReviewDTO> getReviews(Long userId, Long productId) {
        List<Review> reviews = reviewRepositorySupport.findByCondition(userId, productId);
        List<ReviewDTO> reviewDTOList = Lists.newArrayList();
        reviews.forEach(review -> reviewDTOList.add(ReviewDTO.of(review)));
        return reviewDTOList;
    }

    public ReviewDTO createReview(RequestReviewDTO requestReviewDTO) {
        return ReviewDTO.of(
                reviewRepository.save(
                        requestReviewDTO.toEntity(
                                userRepository.findById(requestReviewDTO.getUserId()).get(),
                                productRepository.findById(requestReviewDTO.getProductId()).get())));
    }

    public ReviewDTO getReview(Long id) {
        return ReviewDTO.of(reviewRepository.findById(id).get());
    }
}
