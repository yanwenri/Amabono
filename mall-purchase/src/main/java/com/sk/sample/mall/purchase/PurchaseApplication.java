package com.sk.sample.mall.purchase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import com.sk.sample.mall.purchase.application.proxy.feign.dto.account.Address;
import com.sk.sample.mall.purchase.domain.model.CreditCard;
import com.sk.sample.mall.purchase.domain.model.Purchase;
import com.sk.sample.mall.purchase.domain.repository.PurchaseRepository;
import com.sk.sample.mall.purchase.domain.service.PurchaseService;

@SpringBootApplication
@EnableFeignClients
@EnableHypermediaSupport(type=EnableHypermediaSupport.HypermediaType.HAL)
public class PurchaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner createSampleData(PurchaseRepository purchaseRepository, PurchaseService purchaseService) {	
		return (args) -> {
			Purchase purchase = new Purchase(1L, 1L, 3);
			purchaseRepository.save(purchase);
			purchaseService.order(purchase.getId());
		
			purchase.setCreditCard(new CreditCard("12341234", "0921"));
			purchaseRepository.save(purchase);
			purchaseService.order(purchase.getId());
			
			purchase.setShippingAddress(new Address(12345, "부산"));
			purchaseRepository.save(purchase);
			purchaseService.order(purchase.getId());
		};
	}

}
