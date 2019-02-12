package br.com.rubioti.appspringmongo.resources;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.rubioti.appspringmongo.domain.BaseEntity;
import br.com.rubioti.appspringmongo.dto.BaseDTO;
import br.com.rubioti.appspringmongo.services.BaseService;

public abstract class BaseResource<ID extends Serializable, Entity extends BaseEntity<ID>, DTO extends BaseDTO<ID>> {

	@Autowired
	BaseService<ID, Entity, DTO> service;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public ResponseEntity<List<DTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@RequestMapping(value = { "/", "" }, method = RequestMethod.POST)
	public ResponseEntity<DTO> insert(@RequestBody DTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<DTO> findById(@PathVariable(name="id") ID id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable(name="id") ID id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.PUT)
	public ResponseEntity<DTO> save(@RequestBody DTO dto, @PathVariable(name="id") ID id) {
		dto = service.save(dto, id);
		return ResponseEntity.ok(dto);
	}
}
