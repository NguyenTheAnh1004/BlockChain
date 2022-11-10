package com.laptrinhjavaweb.dto;

import java.math.BigDecimal;

public class ProductDTO extends AbtractDTO {
	
	private String name;
	private String img;
	private BigDecimal value;
	private String wallet;
	
	
	public ProductDTO() {
		super();
	}
	
	public ProductDTO(String name, String img, BigDecimal value, String wallet) {
		super();
		this.name = name;
		this.img = img;
		this.value = value;
		this.wallet = wallet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public String getWallet() {
		return wallet;
	}
	public void setWallet(String wallet) {
		this.wallet = wallet;
	}
	
}
