package com.laptrinhjavaweb.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.laptrinhjavaweb.dto.ProductDTO;

public interface IProductService {
	ProductDTO Save(String name, MultipartFile file, BigDecimal value, String wallet) throws IOException ;
	List<ProductDTO> findAll();
	ProductDTO Update(Long id, String name, MultipartFile file, BigDecimal value, String wallet) throws IOException;
	String delete(Long id);
	List<ProductDTO> findByWallet(String wallet);
	ProductDTO findOneById(Long id);
}
