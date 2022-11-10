package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.TransDTO;
import com.laptrinhjavaweb.service.iml.TransService;

@RestController
public class TransAPI {
	@Autowired
	TransService transService;
	
	@PostMapping("/trans")
	public TransDTO create(@RequestBody TransDTO dto) {
		return transService.save(dto);
	}
	
	@GetMapping("/trans/{wallet}")
	public List<TransDTO> showByWallet(@PathVariable("wallet") String wallet) {
		return transService.findByWallet(wallet);
	}
}
