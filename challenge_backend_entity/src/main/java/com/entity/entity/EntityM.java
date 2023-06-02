package com.entity.entity;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@Column(name = "id_tipo_documento")
	public Long idTypeDocument;
	
	@Column(name = "nro_documento")
	public String nroDocument;
	
	@Column(name = "nombre_comercial")
	public String tradename;
	
	@Column(name = "id_tipo_contribuyente")
	public Long idTypeContributor;

	@Column(name = "direccion")
	public String address;

	@Column(name = "telefono")
	public String telephone;

	@Column(name = "estado", columnDefinition = "BIT")
	public Boolean state;
}