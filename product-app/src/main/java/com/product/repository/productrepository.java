package com.product.repository;

import com.product.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productrepository extends JpaRepository<product, Integer> {
}

