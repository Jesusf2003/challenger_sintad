package com.contributor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.contributor.entity.TypeContributorM;
import com.contributor.entity.TypeContributorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TypeContributorService {

	private TypeContributorRepository repo;

	public ResponseEntity<List<TypeContributorM>> getAll() {
		try {
			return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<TypeContributorM> getById(Long id) {
		Optional<TypeContributorM> opt = repo.findById(id);
		try {
			if (opt.isEmpty()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(opt.get(), HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<TypeContributorM> save(TypeContributorM data) {
		try {
			data.setState(true);
			return new ResponseEntity<>(repo.save(data), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<TypeContributorM> update(Long id, TypeContributorM data) {
		Optional<TypeContributorM> opt = repo.findById(id);
		if (opt.isEmpty()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		TypeContributorM _entity = opt.get();
		_entity.setName(data.getName());
		return new ResponseEntity<>(repo.save(_entity), HttpStatus.OK);
	}

	public ResponseEntity<TypeContributorM> setInactibe(Long id) {
		Optional<TypeContributorM> opt = repo.findById(id);
		if (opt.isEmpty()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		TypeContributorM _entity = opt.get();
		_entity.setState(false);
		return new ResponseEntity<>(repo.save(_entity), HttpStatus.OK);
	}
}