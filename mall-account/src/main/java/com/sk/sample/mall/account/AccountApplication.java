package com.sk.sample.mall.account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import com.sk.sample.mall.account.domain.model.Account;
import com.sk.sample.mall.account.domain.model.Address;
import com.sk.sample.mall.account.domain.model.MemberType;
import com.sk.sample.mall.account.domain.model.MembershipLevelType;
import com.sk.sample.mall.account.domain.repository.AccountRepository;

@SpringBootApplication
@EnableHypermediaSupport(type=EnableHypermediaSupport.HypermediaType.HAL)
public class AccountApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	public CommandLineRunner createSampleData(AccountRepository accountRepository) {	
		return (args) -> {
			Account account1 = new Account("hong@sk.com", "홍길동", MemberType.BUYER);
			accountRepository.save(account1);
			
			Account account2 = new Account("kang@sk.com", "강호동", MemberType.BUYER, MembershipLevelType.VIP);
			account2.setAddress(new Address(12345, "서울시 강남구"));
			accountRepository.save(account2);
			
			Account account3 = new Account("yu@gmail.com", "유재석", MemberType.SELLER);
			account3.setAddress(new Address(10000, "경기도 성남시"));
			accountRepository.save(account3);
			
			Iterable<Account> beforeAccountList = accountRepository.findAll();
			for(Account beforeAccount : beforeAccountList) {
				System.out.println(beforeAccount.toString());	
			}
			
			Account account = accountRepository.findByEmail("hong@sk.com");
			account.setAddress(Address.builder().zipCode(10000).homeAddress("경기도 성남시").build());
			accountRepository.save(account);
			
			System.out.println("-------------------------------------------------------");
			
			Iterable<Account> afterAccountList = accountRepository.findAll();
			for(Account afterAccount : afterAccountList) {
				System.out.println(afterAccount.toString());	
			}
		};
	}
}
