package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.TransEntity;


public interface TransRepository extends JpaRepository<TransEntity, Long> {

	List<TransEntity> findByWalletFrom(String wallet);

}
