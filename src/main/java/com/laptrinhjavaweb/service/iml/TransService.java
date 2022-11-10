package com.laptrinhjavaweb.service.iml;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.github.slugify.Slugify;
import com.laptrinhjavaweb.config.CloudinaryConfig;
import com.laptrinhjavaweb.dto.TransDTO;
import com.laptrinhjavaweb.entity.TransEntity;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.repository.TransRepository;
import com.laptrinhjavaweb.service.ITransService;

@Service
public class TransService implements ITransService{
	@Autowired
	ModelMapper modelMapper;

	private Slugify slg = new Slugify();
	
	@Autowired
	private TransRepository transRepository;
	
	@Override
	public TransDTO save(TransDTO dto) {
		TransEntity entity = modelMapper.map(dto, TransEntity.class);
		entity = transRepository.save(entity);
		dto = modelMapper.map(entity, TransDTO.class);
		return dto;
	}

	@Override
	public List<TransDTO> findByWallet(String wallet) {
		List<TransEntity> listEntitty = transRepository.findByWalletFrom(wallet);
		List<TransDTO> rs = new ArrayList<TransDTO>();
		for(TransEntity items : listEntitty) {
			TransDTO dto = modelMapper.map(items, TransDTO.class);
			rs.add(dto);
		}
		return rs;
	}

}
