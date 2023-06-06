package com.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.auth.domain.*;
import com.auth.domain.dto.*;
import com.auth.services.UsersService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UsersController {

	@Autowired
	private RestTemplate restTemplate;

	private UsersService service;

	@GetMapping("/users")
	public List<UsersM> findAll() {
		return service.getAll();
	}

	@GetMapping("/document")
	public List<TypeDocumentDTO> getAllDocuments() {
		ResponseEntity<List<TypeDocumentDTO>> res = restTemplate.exchange(
				"http://localhost:8091/document", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<TypeDocumentDTO>>() {
				});
		return res.getBody();
	}

	@PostMapping(value = "/document", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TypeDocumentDTO> saveDocument(@RequestBody TypeDocumentDTO data) {
		return restTemplate.postForEntity("http://localhost:8091/document", data, TypeDocumentDTO.class);
	}

	@PutMapping(value = "/document/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TypeDocumentDTO> updateDocument(@PathVariable(name = "id") Long id,
			@RequestBody TypeDocumentDTO data) {
		return restTemplate.postForEntity("http://localhost:8091/document" + "/" + id, data, TypeDocumentDTO.class);
	}

	@DeleteMapping(value = "/document/{id}")
	public TypeDocumentDTO deleteDocument(@PathVariable(name = "id") Long id) {
		ResponseEntity<TypeDocumentDTO> res = restTemplate.exchange("http://localhost:8091/document" + "/" + id, HttpMethod.DELETE,
				null, new ParameterizedTypeReference<TypeDocumentDTO>() {
				});
		return res.getBody();
	}

	@GetMapping("/contributor")
	public List<TypeContributorDTO> getAllContributors() {
		ResponseEntity<List<TypeContributorDTO>> res = restTemplate.exchange("http://localhost:8092/contributor", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<TypeContributorDTO>>() {
				});
		return res.getBody();
	}

	@PostMapping(value = "/contributor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TypeContributorDTO> saveContributor(@RequestBody TypeContributorDTO data) {
		return restTemplate.postForEntity("http://localhost:8092/contributor", data, TypeContributorDTO.class);
	}

	@PostMapping(value = "/contributor/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TypeContributorDTO> updateContributor(@PathVariable(name = "id") Long id,
			@RequestBody TypeContributorDTO data) {
		return restTemplate.postForEntity("http://localhost:8092/contributor" + "/" + id, data, TypeContributorDTO.class);
	}

	@DeleteMapping(value = "/contributor/{id}")
	public TypeContributorDTO deleteContributor(@PathVariable(name = "id") Long id) {
		ResponseEntity<TypeContributorDTO> res = restTemplate.exchange("http://localhost:8092/contributor" + "/" + id,
				HttpMethod.DELETE, null, new ParameterizedTypeReference<TypeContributorDTO>() {
				});
		return res.getBody();
	}

	@PostMapping("/register")
	public UsersM save(@RequestBody UsersM data) {
		return service.save(data);
	}

	@PostMapping("/login")
	public UsersDTO login(@RequestParam("user") String user, @RequestParam("pswd") String pswd) {
		return service.login(user, pswd);
	}
}