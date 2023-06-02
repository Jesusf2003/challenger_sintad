package com.contributor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contributor.entity.TypeContributorM;
import com.contributor.services.TypeContributorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/contributor")
@AllArgsConstructor
public class TypeContributorController {

	private TypeContributorService service;

	@GetMapping
	public ResponseEntity<?> findAll() {
		return this.service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
		return this.service.getById(id);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody TypeContributorM data) {
		return this.service.save(data);
	}

	@PostMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody TypeContributorM data) {
		return this.service.update(id, data);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
		return this.service.setInactibe(id);
	}
}