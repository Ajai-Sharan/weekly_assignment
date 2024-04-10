package com.example.productservicesst.Exception;


import com.example.productservicesst.dtos.Exceptiondtos;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Exceptiondtos> handleArithmeticException(){
        Exceptiondtos exceptiondtos = new Exceptiondtos();
        exceptiondtos.setMessage("Something went wrong");
        exceptiondtos.setResolution("If you run the code, it will provide undefined solution");
        ResponseEntity<Exceptiondtos> response =  new ResponseEntity<>(exceptiondtos, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<Exceptiondtos> handleArrayIndexOutOfBoundsException(){
        Exceptiondtos exceptiondtos = new Exceptiondtos();
        exceptiondtos.setMessage("Don't ask me to do that I can not do");
        exceptiondtos.setResolution("ArrayIndexOutOfBounds");
        ResponseEntity<Exceptiondtos> response =  new ResponseEntity<>(exceptiondtos, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Exceptiondtos> handleGeneralException(){
        Exceptiondtos exceptiondtos = new Exceptiondtos();
        exceptiondtos.setMessage("I did not write code for this error. Please figure it out by yourself");
        exceptiondtos.setResolution("please visit other website");
        ResponseEntity<Exceptiondtos> response =  new ResponseEntity<>(exceptiondtos, HttpStatus.BAD_REQUEST);
        return response;
    }







}
