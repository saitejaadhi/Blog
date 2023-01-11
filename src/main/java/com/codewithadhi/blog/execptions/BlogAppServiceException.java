package com.codewithadhi.blog.execptions;

import org.springframework.http.HttpStatus;

public class BlogAppServiceException extends RuntimeException{
    private final HttpStatus httpStatus;
    public BlogAppServiceException(String message, Throwable throwable, HttpStatus httpStatus){
        super(message, throwable);
        this.httpStatus = httpStatus;
    }
    public BlogAppServiceException(String message, HttpStatus httpStatus, Throwable throwable) {
        super(message, throwable);
        this.httpStatus = httpStatus;
    }
    public BlogAppServiceException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
    public BlogAppServiceException(String message) {
        super (message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
