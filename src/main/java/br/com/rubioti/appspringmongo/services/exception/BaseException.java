package br.com.rubioti.appspringmongo.services.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus status;

	public BaseException(HttpStatus status, String msg) {
		super(msg);
		setStatus(status);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
}
