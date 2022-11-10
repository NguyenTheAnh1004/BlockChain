package com.laptrinhjavaweb.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trans")
public class TransEntity extends BaseEntity {

	@Column
	private String walletFrom;

	@Column
	private String walletTo;

	@Column
	private BigDecimal value;

	@Column
	private BigDecimal gas;

	@Column
	private BigDecimal gasPrice;
	
	@Column
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
