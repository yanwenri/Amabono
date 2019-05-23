package com.sk.sample.mall.account.domain.model;

import javax.persistence.Embeddable;

import com.sk.sample.mall.shared.domain.ValueObject;

import lombok.Builder;
import lombok.Data;

@Data
@Embeddable
@Builder
public class Address implements ValueObject {
	private Integer zipCode;
	private String homeAddress;
	
	public Address(Integer zipCode, String homeAddress) {
		this.zipCode = zipCode;
		this.homeAddress = homeAddress;
	}
}
