package com.document.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_tipo_documento")
public class TypeDocumentM {

	@Id
	@Column(name = "id_tipo_documento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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