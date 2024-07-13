package com.server.chucked.api.product.domain.persistence;

import com.server.chucked.api.product.domain.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByOrderByIdDesc(Pageable pageable);
    List<Product> findAllByOrderByIdDesc();
}
