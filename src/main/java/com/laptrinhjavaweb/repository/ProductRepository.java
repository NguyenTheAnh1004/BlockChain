package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	ProductEntity findOneById(Long id);

	List<ProductEntity> findByWallet(String wallet);

}
