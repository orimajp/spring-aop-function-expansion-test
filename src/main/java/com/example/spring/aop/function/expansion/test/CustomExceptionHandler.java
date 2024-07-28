package com.example.spring.aop.function.expansion.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  // Demonstration only
  @ExceptionHandler(ClassCastException.class)
  public ResponseEntity<Object> handleClassCastException(ClassCastException e) {
    log.error(e.getMessage());
    return ResponseEntity.ok("I don't known. (by CustomExceptionHandler)");
  }

}
