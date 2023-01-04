package com.sbszc.eduspringbootsecurityauthentication.exception;

public class UserExistsException extends RuntimeException {

    public UserExistsException() {
        super();
    }

    public UserExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UserExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistsException(String message) {
        super(message);
    }

    public UserExistsException(Throwable cause) {
        super(cause);
    }
}
