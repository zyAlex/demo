package com.example.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value=Exception.class)
    public ModelAndView exceptionHangler(Exception e, HttpServletRequest req){
       ModelAndView model = new ModelAndView();
       model.addObject("exception",e);
       model.addObject("url",req.getRequestURI());
       model.setViewName("error");

        return model;
    }
}
