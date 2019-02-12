package br.com.rubioti.appspringmongo.dto;

public class UserGroupDTO extends BaseDTO<String> {

	private static final long serialVersionUID = 1L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
