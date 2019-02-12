package br.com.rubioti.appspringmongo.services;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.rubioti.appspringmongo.domain.BaseEntity;
import br.com.rubioti.appspringmongo.dto.BaseDTO;
import br.com.rubioti.appspringmongo.repository.BaseRepository;
import br.com.rubioti.appspringmongo.services.exception.NotFoundException;
import br.com.rubioti.appspringmongo.services.exception.ServiceException;
import br.com.rubioti.appspringmongo.services.exception.UnprocessableEntityException;

@Service
public abstract class BaseService<ID extends Serializable, Entity extends BaseEntity<ID>, DTO extends BaseDTO<ID>> {

	private final BaseRepository<ID, Entity> repository;

	public BaseService(BaseRepository<ID, Entity> repository) {
		this.repository = repository;
	}

	public List<DTO> findAll() {
		return repository.findAll().stream().map(entity -> toDto(entity, false)).collect(Collectors.toList());
	}

	public DTO insert(DTO dto) {
		if (dto.getId() != null && repository.existsById(dto.getId())) {
			throw new UnprocessableEntityException(String
					.format("Identifier '%s' already exists! Leave null to generate automatically.", dto.getId()));
		}
		dto = toDto(repository.insert(toEntity(dto)), true);
		return toDto(repository.findById(dto.getId())
				.orElseThrow(() -> new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, "Entity has not been inserted!")),true);
	}

	public DTO findById(ID id) {
		return toDto(repository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Entity with identifier '%s' not found!", id))), true);
	}

	public void delete(ID id) {
		repository.delete(toEntity(findById(id)));
	}

	public DTO save(DTO dto, ID id) {
		dto.setId(id);
		if (repository.existsById(id)) {			
			dto = toDto(repository.save(toEntity(dto)),true);
			return toDto(repository.findById(dto.getId())
					.orElseThrow(() -> new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, String.format("Entity with identifier '%s' was not saved!", id))),true);
		} else {
			throw new NotFoundException(String.format("Entity with identifier '%s' not found!", id));
		}
	}
	
	public abstract DTO toDto(Entity entity, boolean loadInternalLists);
	
	public List<DTO> toDto(List<Entity> list) {		
		return list.stream().map(entity -> toDto(entity, false)).collect(Collectors.toList());
	}
	
	public abstract Entity toEntity(DTO dto);
	
	public List<Entity> toEntity(List<DTO> list) {		
		return list.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}
}
