package com.laptrinhjavaweb.service.iml;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.github.slugify.Slugify;
import com.laptrinhjavaweb.config.CloudinaryConfig;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.IProductService;

@Service
public class ProductService implements IProductService  {
	@Value("${cloud.url}")
	private String cloudinaryURL;
	
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	private CloudinaryConfig cloundinary;
	
	private Slugify slg = new Slugify();
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDTO Save(String name, MultipartFile file, BigDecimal value, String wallet) throws IOException {
		// upload on cloundinary
		cloundinary.upload(file.getBytes(),
				ObjectUtils.asMap("public_id", FilenameUtils.removeExtension(file.getOriginalFilename()),
						"unique_filename", "false", "folder", "blogzcoder/"));
		// end upload
		
		ProductDTO productDTO = new ProductDTO(name, file.getOriginalFilename(), value, wallet);
		productDTO.setCode(slg.slugify(name));
		ProductEntity productEntity = modelMapper.map(productDTO, ProductEntity.class);
		productEntity = productRepository.save(productEntity);
		productDTO = modelMapper.map(productEntity, ProductDTO.class);
		return productDTO;
	}
	
	public void urlImage(ProductDTO dto) {
		String fileDownloadUri = cloudinaryURL + dto.getImg();
		String linkCloundinary = fileDownloadUri.replaceAll(" ", "%20");
		dto.setImg(linkCloundinary);

	}

	@Override
	public List<ProductDTO> findAll() {
		List<ProductEntity> listProductE = productRepository.findAll();
		List<ProductDTO> listProductD = new ArrayList<ProductDTO>();
		for(ProductEntity items : listProductE) {
			ProductDTO dto = modelMapper.map(items, ProductDTO.class);
			urlImage(dto);
			listProductD.add(dto);
		}
		return listProductD;
	}

	@Override
	public ProductDTO Update(Long id, String name, MultipartFile file, BigDecimal value, String wallet)
			throws IOException {
		ProductEntity oldEntity = productRepository.findOneById(id);
		ProductDTO productDTO;
		System.out.println("file"+file);
		if(file.isEmpty()) {
			productDTO = new ProductDTO(name, oldEntity.getImg(), value, wallet);
			System.out.println("file dell co");
		}
		else {
			productDTO = new ProductDTO(name, file.getOriginalFilename(), value, wallet);
			cloundinary.delete(
					"blogzcoder/" + FilenameUtils.removeExtension(oldEntity.getImg().replaceAll(" ", "%20")),
					ObjectUtils.asMap("invalidate", true));

			cloundinary.upload(file.getBytes(),
					ObjectUtils.asMap("public_id", FilenameUtils.removeExtension(file.getOriginalFilename()),
							"unique_filename", "false", "folder", "blogzcoder/"));
		}
//		ProductDTO productDTO = new ProductDTO(name, file.getOriginalFilename(), value, wallet);
		productDTO.setCode(slg.slugify(name));
		productDTO.setId(id);

		
		// upload on cloundinary
//		cloundinary.delete(
//				"blogzcoder/" + FilenameUtils.removeExtension(oldEntity.getImg().replaceAll(" ", "%20")),
//				ObjectUtils.asMap("invalidate", true));
//
//		cloundinary.upload(file.getBytes(),
//				ObjectUtils.asMap("public_id", FilenameUtils.removeExtension(file.getOriginalFilename()),
//						"unique_filename", "false", "folder", "blogzcoder/"));
		// end upload
		
		productDTO.setCreatedDate(oldEntity.getCreatedDate());
		oldEntity = modelMapper.map(productDTO, ProductEntity.class);
		oldEntity = productRepository.save(oldEntity);
		productDTO = modelMapper.map(oldEntity, ProductDTO.class);
		return productDTO;
	}

	@Override
	public String delete(Long id) {
		productRepository.deleteById(id);
		return "delete product " + id + " success";
	}

	@Override
	public List<ProductDTO> findByWallet(String wallet) {
		List<ProductEntity> listProductE = productRepository.findByWallet(wallet);
		List<ProductDTO> listProductD = new ArrayList<ProductDTO>();
		for(ProductEntity items : listProductE) {
			ProductDTO dto = modelMapper.map(items, ProductDTO.class);
			urlImage(dto);
			listProductD.add(dto);
		}
		return listProductD;
	}

	@Override
	public ProductDTO findOneById(Long id) {
		// TODO Auto-generated method stub
		ProductEntity productE = productRepository.findOneById(id);
		ProductDTO dto = modelMapper.map(productE, ProductDTO.class);
		urlImage(dto);
		return dto;
	}
	
	
}
