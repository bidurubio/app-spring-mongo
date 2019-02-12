package br.com.rubioti.appspringmongo.resources;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rubioti.appspringmongo.domain.User;
import br.com.rubioti.appspringmongo.dto.UserDTO;

@RestController
@RequestMapping(value="/users")
public class UserResource extends BaseResource<String, User, UserDTO> {
	
}
