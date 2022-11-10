package com.laptrinhjavaweb.api;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.iml.ProductService;


@RestController

public class ProductAPI {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public List<ProductDTO> showProduct() {
		return productService.findAll();
	}
	
	@PostMapping("/product")
	public ProductDTO createProduct(@RequestParam("name") String name, @RequestParam("file") MultipartFile file, @RequestParam("value") BigDecimal value, @RequestParam("wallet") String wallet) throws IOException {
		return productService.Save(name, file, value, wallet);
//		return new ProductDTO(name, file.getOriginalFilename(), value, wallet);
	}
	
	@PutMapping("/product")
	public ProductDTO updateProduct(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("file") MultipartFile file, @RequestParam("value") BigDecimal value, @RequestParam("wallet") String wallet) throws IOException {
		return productService.Update(id, name, file, value, wallet);
//		return new ProductDTO(name, file.getOriginalFilename(), value, wallet);
	}
	 
	@DeleteMapping("/product/{id}")
	public String delete(@PathVariable("id") Long id) {
		return productService.delete(id);		
	}

}
