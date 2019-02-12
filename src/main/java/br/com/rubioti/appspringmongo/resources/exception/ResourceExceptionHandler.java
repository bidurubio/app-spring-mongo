package br.com.rubioti.appspringmongo.resources.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.rubioti.appspringmongo.services.exception.BaseException;
import br.com.rubioti.appspringmongo.services.exception.NotFoundException;
import br.com.rubioti.appspringmongo.services.exception.UnprocessableEntityException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler({NotFoundException.class, UnprocessableEntityException.class})
	void handleBadRequests(HttpServletResponse response, BaseException ex) throws IOException {		
	    response.sendError(ex.getStatus().value(), ex.getMessage());
	}

}
