package com.laptrinhjavaweb.dto;

import java.math.BigDecimal;

import javax.persistence.Column;

public class TransDTO extends AbtractDTO {
	
	private String walletFrom;
	private String walletTo;
	private BigDecimal value;
	private BigDecimal gas;
	private BigDecimal gasPrice;
	private String transId;
	public String getWalletFrom() {
		return walletFrom;
	}
	public void setWalletFrom(String walletFrom) {
		this.walletFrom = walletFrom;
	}
	public String getWalletTo() {
		return walletTo;
	}
	public void setWalletTo(String walletTo) {
		this.walletTo = walletTo;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public BigDecimal getGas() {
		return gas;
	}
	public void setGas(BigDecimal gas) {
		this.gas = gas;
	}
	public BigDecimal getGasPrice() {
		return gasPrice;
	}
	public void setGasPrice(BigDecimal gasPrice) {
		this.gasPrice = gasPrice;
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	
}
