package com.sk.sample.mall.purchase.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.sample.mall.purchase.application.proxy.feign.AccountProxy;
import com.sk.sample.mall.purchase.application.proxy.feign.ProductProxy;
import com.sk.sample.mall.purchase.application.proxy.feign.dto.account.Account;
import com.sk.sample.mall.purchase.application.proxy.feign.dto.product.Product;
import com.sk.sample.mall.purchase.domain.model.Purchase;
import com.sk.sample.mall.purchase.domain.repository.PurchaseRepository;

@Service
public class PurchaseLogic implements PurchaseService {
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private AccountProxy accountProxy;
	
	@Autowired
	private ProductProxy productProxy;
	
	public void order(Long purchaseId) {
		Purchase purchase = purchaseRepository.findOne(purchaseId);
		
		if(purchase == null) {
			System.err.println("no purchase");
			return;
		}
		
		System.out.println("Purchase: " + purchase.toString());
		
		if(purchase.getCreditCard() == null) {
			System.err.println("no credit card");
			return;
		}
		
		if(purchase.getShippingAddress() == null) {
			System.err.println("no shippig address");
			return;
		}
		
		Account account = accountProxy.findAccount(purchase.getBuyerAccountId());
		System.out.println("Buyer: " + account.toString());
			
		Product product = productProxy.findProduct(purchase.getProductId());
		System.out.println("Product: " + product.toString());
			
		purchase.setTotalPrice(purchase.getProductCount() * product.getPrice().getValue());
		purchase.setPurchased(true);
			
		purchaseRepository.save(purchase);
	}
}
