package br.com.rubioti.appspringmongo.services.exception;

import org.springframework.http.HttpStatus;

public class ServiceException extends BaseException {

	private static final long serialVersionUID = 1L;

	public ServiceException(HttpStatus status, String msg) {
		super(status, msg);
	}

}
