package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.TransDTO;

public interface ITransService {
	TransDTO save(TransDTO dto);
	List<TransDTO> findByWallet(String wallet);   
}
