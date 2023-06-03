package com.entity.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_tipo_contribuyente")
public class TypeContributorM {

	@Id
	@Column(name = "id_tipo_contribuyente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Column(name = "nombre")
	public String name;

	@Column(name = "estado", columnDefinition = "BIT")
	public Boolean state;
}