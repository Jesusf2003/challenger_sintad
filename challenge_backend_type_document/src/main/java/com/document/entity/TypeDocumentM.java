package com.document.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tipo_documento")
public class TypeDocumentM {

	@Id
	@Column(name = "tb_tipo_documento")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Column(name = "codigo")
	public String code;

	@Column(name = "nombre")
	public String name;

	@Column(name = "descripcion")
	public String description;

	@Column(name = "estado", columnDefinition = "BIT")
	public Boolean state;
}