package com.example.demo.exception;

import org.springframework.core.NestedIOException;
import org.springframework.web.util.NestedServletException;

public class ResourceNotFoundException extends NestedServletException {
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
