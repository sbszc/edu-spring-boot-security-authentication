package com.sbszc.eduspringbootsecurityauthentication.exception;

import com.sbszc.eduspringbootsecurityauthentication.dto.UserAuthenticationResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> messages = exception.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        UserAuthenticationResponse body = UserAuthenticationResponse.builder()
                .messages(messages)
                .build();

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<UserAuthenticationResponse> handle(UserExistsException exception) {

        UserAuthenticationResponse body = UserAuthenticationResponse.builder()
                .messages(exception.getMessage())
                .build();

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserAuthenticationResponse> handle(UserNotFoundException exception) {

        UserAuthenticationResponse body = UserAuthenticationResponse.builder()
                .messages(exception.getMessage())
                .build();

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<UserAuthenticationResponse> handle(RoleNotFoundException exception) {

        UserAuthenticationResponse body = UserAuthenticationResponse.builder()
                .messages(exception.getMessage())
                .build();

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

}
