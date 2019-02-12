package br.com.rubioti.appspringmongo.services.exception;

import org.springframework.http.HttpStatus;

public class UnprocessableEntityException extends BaseException {

	private static final long serialVersionUID = 1L;

	public UnprocessableEntityException(String msg) {
		super(HttpStatus.UNPROCESSABLE_ENTITY, msg);
	}

}
