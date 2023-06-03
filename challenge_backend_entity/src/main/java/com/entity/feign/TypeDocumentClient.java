package com.entity.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.entity.entity.TypeDocumentM;

@FeignClient(
	name = "typedocument-service",
	url = "http://localhost:8091/api",
	fallback = TypeDocumentHystrixFallbackFactory.class
)
public interface TypeDocumentClient {

	@GetMapping(value = "/document/{id}")
	TypeDocumentM findItemById(@PathVariable(name = "id") Long id);
}