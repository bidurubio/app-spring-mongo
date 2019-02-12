package br.com.rubioti.appspringmongo.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rubioti.appspringmongo.domain.User;
import br.com.rubioti.appspringmongo.dto.UserDTO;
import br.com.rubioti.appspringmongo.repository.BaseRepository;

@Service
public class UserService extends BaseService<String, User, UserDTO> {

	@Autowired
	UserGroupService userGroupService;
	
	public UserService(BaseRepository<String, User> repository) {
		super(repository);
	}

	@Override
	public UserDTO toDto(User user, boolean loadInternalLists) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		if(loadInternalLists) {
			dto.setGroups(user.getGroups().stream().map(group -> userGroupService.toDto(group, loadInternalLists)).collect(Collectors.toList()));
		}
		return dto;
	}

	@Override
	public User toEntity(UserDTO dto) {
		User entity = new User();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setGroups(dto.getGroups().stream().map(group -> userGroupService.toEntity(group)).collect(Collectors.toList()));
		return entity;
	}
	
}
