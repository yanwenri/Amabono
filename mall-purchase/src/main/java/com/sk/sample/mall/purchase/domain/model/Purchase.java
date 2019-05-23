package com.sk.sample.mall.purchase.domain.model;

import javax.persistence.Entity;

import com.sk.sample.mall.purchase.application.proxy.feign.dto.account.Address;
import com.sk.sample.mall.shared.domain.AbstractEntity;
import com.sk.sample.mall.shared.domain.AggregateRoot;

import lombok.Data;

@Data
@Entity
public class Purchase extends AbstractEntity implements AggregateRoot {
	private Long buyerAccountId;
	private Long productId;
	private Integer productCount;
		
	private CreditCard creditCard;
	private Address shippingAddress;
	
	private Integer totalPrice;
	private Boolean purchased = false;
	
	public Purchase(Long buyerAccountId, Long productId, Integer productCount) {
		this.buyerAccountId = buyerAccountId;
		this.productId = productId;
		this.productCount = productCount;
	}
}
