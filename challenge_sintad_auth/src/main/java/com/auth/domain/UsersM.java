package com.auth.domain;

import javax.persistence.*;

import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_usuarios")
public class UsersM {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuarios")
	private Long id;
	
	@Column(name = "nombre_usuario")
	private String username;

	@Column(name = "correo")
	private String email;
	
	@Column(name = "contrasena")
	private String password;
}