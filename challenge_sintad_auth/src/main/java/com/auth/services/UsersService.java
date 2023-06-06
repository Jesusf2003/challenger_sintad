package com.auth.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.domain.UsersM;
import com.auth.domain.UsersRepository;
import com.auth.domain.dto.UsersDTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsersService implements UserDetailsService {

	private UsersRepository repo;

	public List<UsersM> getAll() {
		return repo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersM user = repo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("No se encontró el usuario: " + username);
		}
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}

	public UsersDTO login(String user, String pswd) {
		String token = getJWTToken(pswd);
		UsersM _entity = repo.findByUsername(user);
		UsersDTO dto = new UsersDTO();
		if (_entity == null) {
			dto.setUser("Usuario no encontrado");
			return dto;
		}
		dto.setUser(_entity.getUsername());
		dto.setToken(token);
		return dto;
	}

	public UsersM save(UsersM data) {
		return repo.save(data);
	}

	public String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

	public UsersM update(Long id, UsersM data) {
		return repo.save(data);
	}
}