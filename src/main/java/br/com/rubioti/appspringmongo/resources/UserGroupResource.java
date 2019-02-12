package br.com.rubioti.appspringmongo.resources;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rubioti.appspringmongo.domain.UserGroup;
import br.com.rubioti.appspringmongo.dto.UserGroupDTO;

@RestController
@RequestMapping(value="/usergroups")
public class UserGroupResource extends BaseResource<String, UserGroup, UserGroupDTO> {
	
}
