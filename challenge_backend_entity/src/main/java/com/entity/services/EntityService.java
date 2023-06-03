package com.entity.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entity.entity.EntityM;
import com.entity.entity.EntityRepository;
import com.entity.entity.TypeContributorM;
import com.entity.entity.TypeDocumentM;
import com.entity.entity.dto.EntityDTO;
import com.entity.feign.TypeContributorClient;
import com.entity.feign.TypeDocumentClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EntityService {

	private EntityRepository repo;

	public ResponseEntity<List<EntityM>> getAll() {
		try {
			return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<EntityM> getById(Long id) {
		Optional<EntityM> opt = repo.findById(id);
		try {
			if (opt.isEmpty())
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(opt.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<EntityM> save(EntityDTO data) {
		TypeDocumentM doc = new TypeDocumentM();
		TypeContributorM cont = new TypeContributorM();
		try {
			doc.setId(data.getIdtypedoc());
			cont.setId(data.getIdtypecont());
			EntityM _entity = new EntityM();
			_entity.setIdtypedoc(doc);
			_entity.setNrodoc(data.getNrodoc());
			_entity.setSocialreason(data.getSocialreason());
			_entity.setTradename(data.getTradename());
			_entity.setIdtypecont(cont);
			_entity.setAddress(data.getAddress());
			_entity.setTelephone(data.getTelephone());
			_entity.setState(true);
			return new ResponseEntity<>(repo.save(_entity), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<EntityM> update(Long id, EntityDTO data) {
		Optional<EntityM> opt = repo.findById(id);
		TypeDocumentM doc = new TypeDocumentM();
		TypeContributorM cont = new TypeContributorM();
		try {
			doc.setId(data.getIdtypedoc());
			cont.setId(data.getIdtypecont());
			if (opt.isEmpty()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			EntityM _entity = opt.get();
			_entity.setIdtypedoc(doc);
			_entity.setNrodoc(data.getNrodoc());
			_entity.setSocialreason(data.getSocialreason());
			_entity.setTradename(data.getTradename());
			_entity.setIdtypecont(cont);
			_entity.setAddress(data.getAddress());
			_entity.setTelephone(data.getTelephone());
			return new ResponseEntity<>(repo.save(_entity), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<EntityM> setInactive(Long id) {
		Optional<EntityM> opt = repo.findById(id);
		try {
			if (opt.isEmpty()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			EntityM _entity = opt.get();
			_entity.setState(false);
			return new ResponseEntity<>(repo.save(_entity), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}