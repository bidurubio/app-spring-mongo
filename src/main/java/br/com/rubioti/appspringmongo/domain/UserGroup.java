package br.com.rubioti.appspringmongo.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="usergroups")
public class UserGroup extends BaseEntity<String> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public UserGroup() { 
		
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
