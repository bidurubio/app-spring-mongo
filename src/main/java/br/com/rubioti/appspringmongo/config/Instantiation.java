package br.com.rubioti.appspringmongo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.rubioti.appspringmongo.services.UserGroupService;
import br.com.rubioti.appspringmongo.services.UserService;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	UserService userService;
	
	@Autowired
	UserGroupService userGroupService;
	
	
	
	@Override
	public void run(String... args) throws Exception {

	}

}
