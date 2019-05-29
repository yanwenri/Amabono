package com.sk.sample.mall.purchase.application.proxy.feign.dto.account;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sk.sample.mall.shared.domain.AbstractEntity;
import com.sk.sample.mall.shared.domain.AggregateRoot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Account {
	private String userid;
	private String email;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private MemberType memberType;
	
	@Enumerated(EnumType.STRING)
	private MembershipLevelType membershipLevelType;
	
	private Address address;
	
	public Account(String userid, String email, String name, MemberType memberType) {
		this(userid, email, name, memberType, MembershipLevelType.SILVER);
	}
	
	public Account(String userid, String email, String name, MemberType memberType, MembershipLevelType membershipLevelType) {
		this.userid = userid;
		this.email = email;
		this.name = name;
		this.memberType = memberType;
		this.membershipLevelType = membershipLevelType;
	}
	
	
}

