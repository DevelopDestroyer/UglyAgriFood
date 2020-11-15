package com.ugly.agri.repository;

import com.ugly.agri.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByIsDeletedFalse();

    Optional<Product> findByIdAndIsDeletedFalse(Long id);
}