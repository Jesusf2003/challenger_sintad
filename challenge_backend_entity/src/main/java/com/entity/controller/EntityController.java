package com.entity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.entity.entity.dto.EntityDTO;
import com.entity.services.EntityService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@RequestMapping("/entity")
@RestController
@AllArgsConstructor
public class EntityController {

	private EntityService service;

	@GetMapping
	public ResponseEntity<?> findAll() {
		return this.service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
		return this.service.getById(id);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody EntityDTO data) {
		return this.service.save(data);
	}

	@PostMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody EntityDTO data) {
		return this.service.update(id, data);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id")Long id) {
		return this.service.setInactive(id);
	}
}