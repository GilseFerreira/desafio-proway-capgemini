package com.capgemini.desafioproway.gerenciamentodeanuncios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourcesNotFoundException extends Exception {

	private static final long serialVersionUID = -2048383607426062946L;

	public ResourcesNotFoundException(String message) {
        super(message);
    }
}
