package com.auth.domain.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeDocumentDTO {

	private Long id;
	private String code;
	private String name;
	private String description;
	private Boolean state;
}