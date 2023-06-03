package com.entity.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_entidad")
public class EntityM {

	@Id
	@Column(name = "id_entidad")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(targetEntity = TypeDocumentM.class)
	@JoinColumn(name = "id_tipo_documento")
	private TypeDocumentM idtypedoc;

	@Column(name = "nro_documento")
	private String nrodoc;

	@Column(name = "razon_social")
	private String socialreason;

	@Column(name = "nombre_comercial")
	private String tradename;

	@OneToOne(targetEntity = TypeContributorM.class)
	@JoinColumn(name = "id_tipo_contribuyente")
	private TypeContributorM idtypecont;

	@Column(name = "direccion")
	private String address;

	@Column(name = "telefono")
	private String telephone;

	@Column(name = "estado", columnDefinition = "BIT")
	private Boolean state;
}