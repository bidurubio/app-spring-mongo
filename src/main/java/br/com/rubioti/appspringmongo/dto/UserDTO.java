package br.com.rubioti.appspringmongo.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class UserDTO extends BaseDTO<String> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<UserGroupDTO> groups;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<UserGroupDTO> getGroups() {
		return groups;
	}

	public void setGroups(List<UserGroupDTO> groups) {
		this.groups = groups;
	}
	
}
