package com.entity.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.entity.entity.TypeContributorM;

@FeignClient(
	name = "typecontributor-service",
	url = "http://localhost:8092/api",
	fallback = TypeContributorHystrixFallbackFactory.class
)
public interface TypeContributorClient {

	@GetMapping(value = "/contributor/{id}")
	TypeContributorM findItemById(@PathVariable(name = "id") Long id);
}