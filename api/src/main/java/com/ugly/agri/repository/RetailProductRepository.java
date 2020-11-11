package com.ugly.agri.repository;

import com.ugly.agri.domain.RetailProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailProductRepository extends CrudRepository<RetailProduct, Long> {
    RetailProduct findByName(String name);
}