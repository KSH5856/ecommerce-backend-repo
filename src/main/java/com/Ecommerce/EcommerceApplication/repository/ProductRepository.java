package com.Ecommerce.EcommerceApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.EcommerceApplication.entity.ProductDetails;

@Repository
public interface ProductRepository extends JpaRepository<ProductDetails, Long> {

}
