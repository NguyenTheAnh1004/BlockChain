package com.laptrinhjavaweb.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	@Bean
	public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
////		commentDTO.setUserName(commentEntity.getUser().getUserName());
//		modelMapper.addMappings(CommentEntity::getUser, UserEntity::getUserName);
        return modelMapper;
	}
}
