package com.entity.feign;

import org.springframework.stereotype.Component;

import com.entity.entity.TypeDocumentM;

@Component
public class TypeDocumentHystrixFallbackFactory implements TypeDocumentClient {

	@Override
	public TypeDocumentM findItemById(Long id) {
		TypeDocumentM doc = new TypeDocumentM();
		return doc.builder().id(id).code(doc.getCode()).name(doc.getName()).description(doc.getDescription()).state(doc.getState()).build();
	}
}