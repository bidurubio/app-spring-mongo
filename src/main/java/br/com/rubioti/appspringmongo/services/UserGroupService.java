package br.com.rubioti.appspringmongo.services;

import org.springframework.stereotype.Service;

import br.com.rubioti.appspringmongo.domain.UserGroup;
import br.com.rubioti.appspringmongo.dto.UserGroupDTO;
import br.com.rubioti.appspringmongo.repository.BaseRepository;

@Service
public class UserGroupService extends BaseService<String, UserGroup, UserGroupDTO> {

	public UserGroupService(BaseRepository<String, UserGroup> repository) {
		super(repository);
	}
	
	@Override
	public UserGroupDTO toDto(UserGroup entity, boolean loadInternalLists) {
		UserGroupDTO dto = new UserGroupDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}

	@Override
	public UserGroup toEntity(UserGroupDTO dto) {
		UserGroup entity = new UserGroup();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}
}
