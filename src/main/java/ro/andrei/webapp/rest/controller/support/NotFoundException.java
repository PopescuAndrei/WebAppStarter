package ro.andrei.webapp.rest.controller.support;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by epopean on 10/4/2016.
 */

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}