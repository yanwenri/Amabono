package com.sk.sample.mall.purchase.domain.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Data
public class Receiver {
	private String recevierName;
	private String address;
	private int zipCode;
}
