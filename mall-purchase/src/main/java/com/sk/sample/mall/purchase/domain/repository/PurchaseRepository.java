package com.sk.sample.mall.purchase.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sk.sample.mall.purchase.domain.model.Purchase;

@RepositoryRestResource
public interface PurchaseRepository extends PagingAndSortingRepository<Purchase, Long> {
	Purchase findOne(Long id);
}
