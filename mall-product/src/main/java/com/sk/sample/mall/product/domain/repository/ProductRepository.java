package com.sk.sample.mall.product.domain.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sk.sample.mall.product.domain.model.Product;
import com.sk.sample.mall.product.domain.model.SizeType;

@RepositoryRestResource
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
	Product findByName(String name);
}