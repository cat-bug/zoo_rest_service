package com.sample.zoorestservice.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public class BaseController {

    protected <T> T getEntityOrThrow(Optional<T> entity, String message) throws ResponseStatusException {
        if(entity.isPresent()){
            return entity.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }
    }
}
