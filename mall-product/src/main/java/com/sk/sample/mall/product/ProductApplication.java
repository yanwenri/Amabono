package com.sk.sample.mall.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import com.sk.sample.mall.product.domain.model.ColorType;
import com.sk.sample.mall.product.domain.model.Money;
import com.sk.sample.mall.product.domain.model.Product;
import com.sk.sample.mall.product.domain.model.ProductDescription;
import com.sk.sample.mall.product.domain.model.SizeType;
import com.sk.sample.mall.product.domain.repository.ProductRepository;

@SpringBootApplication
@EnableHypermediaSupport(type=EnableHypermediaSupport.HypermediaType.HAL)
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner createSampleData(ProductRepository productRepository) {	
		return (args) -> {
			Product product1 = new Product("Iron Man", new Money(30000), new ProductDescription(ColorType.RED, SizeType.L));
			productRepository.save(product1);
			
			Product product2 = new Product("Captain America", new Money(20000), new ProductDescription(ColorType.BLUE, SizeType.M));
			productRepository.save(product2);
			
			Iterable<Product> productList = productRepository.findAll();
			for(Product product : productList) {
				System.out.println(product.toString());	
			}
			
			System.out.println("-------------------------------------------------------");
			
			Product product = productRepository.findByName("Captain America");
			
			if(product != null) {
				System.out.println("Name: " + product.getName());
				System.out.println("Price: " + product.getPrice());
				System.out.println("Color: " + product.getProductDescription().getColorType());
				System.out.println("Size: " + product.getProductDescription().getSizeType());
				
				if(product.getProductDescription().getColorType() == ColorType.BLUE) {
					System.out.println("Good Color!");
				}
			}
		};
	}
}
