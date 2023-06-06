package com.document.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.document.entity.TypeDocumentM;
import com.document.services.TypeDocumentService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/document")
@AllArgsConstructor
public class TypeDocumentController {

	private TypeDocumentService service;

	@GetMapping
	public ResponseEntity<?> findAll() {
		return this.service.getAll();
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody TypeDocumentM data) {
		return this.service.save(data);
	}

	@PostMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody TypeDocumentM data) {
		return this.service.update(id, data);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
		return this.service.setInactive(id);
	}
}