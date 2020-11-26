package com.ugly.agri.repository;

import com.ugly.agri.domain.RetailProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RetailProductRepository extends JpaRepository<RetailProduct, Long> {
    RetailProduct findByName(String name);

    Optional<RetailProduct> findByIdAndIsDeletedFalse(Long id);
}