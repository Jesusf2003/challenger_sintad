package com.document.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.document.entity.TypeDocumentM;
import com.document.entity.TypeDocumentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TypeDocumentService {

	private TypeDocumentRepository repo;

	public ResponseEntity<List<TypeDocumentM>> getAll() {
		try {
			return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<TypeDocumentM> getById(Long id) {
		Optional<TypeDocumentM> opt = repo.findById(id);
		try {
			if (opt.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(opt.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<TypeDocumentM> save(TypeDocumentM data) {
		try {
			data.setState(true);
			return new ResponseEntity<>(repo.save(data), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<TypeDocumentM> update(Long id, TypeDocumentM data) {
		Optional<TypeDocumentM> opt = repo.findById(id);
		if (opt.isEmpty()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		TypeDocumentM _entity = opt.get();
		_entity.setCode(data.getCode());
		_entity.setName(data.getName());
		_entity.setDescription(data.getDescription());
		return new ResponseEntity<>(repo.save(_entity), HttpStatus.OK);
	}

	public ResponseEntity<TypeDocumentM> setInactive(Long id) {
		Optional<TypeDocumentM> opt = repo.findById(id);
		if (opt.isEmpty()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		TypeDocumentM _entity = opt.get();
		_entity.setState(false);
		return new ResponseEntity<>(repo.save(_entity), HttpStatus.OK);
	}
}