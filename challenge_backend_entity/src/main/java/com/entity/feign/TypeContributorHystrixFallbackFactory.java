package com.entity.feign;

import org.springframework.stereotype.Component;

import com.entity.entity.TypeContributorM;

@Component
public class TypeContributorHystrixFallbackFactory implements TypeContributorClient {

	@Override
	public TypeContributorM findItemById(Long id) {
		TypeContributorM cont = new TypeContributorM();
		return cont.builder().id(id).name(cont.getName()).state(cont.getState()).build();
	}
}