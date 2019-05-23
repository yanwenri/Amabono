package com.sk.sample.mall.purchase.application.proxy.feign.dto.account;

import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Embeddable
public class Address {
	private Integer zipCode;
	private String homeAddress;
	
	public Address(Integer zipCode, String homeAddress) {
		this.zipCode = zipCode;
		this.homeAddress = homeAddress;
	}
}
