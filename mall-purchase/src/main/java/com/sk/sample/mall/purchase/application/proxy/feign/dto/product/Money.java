package com.sk.sample.mall.purchase.application.proxy.feign.dto.product;

import lombok.Data;


@Data
public class Money {
	private Integer value;
	
	public Money(Integer value) {
		this.value = value;
	}
}

