package com.wondersgroup.center.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by wxk on 2019/6/4.
 */
@ControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String handleException(){
          return "error";
    }
}
