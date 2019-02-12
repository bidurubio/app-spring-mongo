package br.com.rubioti.appspringmongo.services.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {
	
	private static final long serialVersionUID = 1L;

	public NotFoundException(String msg) {
		super(HttpStatus.NOT_FOUND, msg);
	}
}
