package com.document.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_tipo_documento")
public class TypeDocumentM {

	@Id
	@Column(name = "id_tipo_documento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "codigo")
	private String code;

	@Column(name = "nombre")
	private String name;

	@Column(name = "descripcion")
	private String description;

	@Column(name = "estado", columnDefinition = "BIT")
	private Boolean state;
}