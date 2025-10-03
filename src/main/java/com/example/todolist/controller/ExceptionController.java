package com.example.todolist.controller;

import com.example.todolist.dto.ErrorDto;
import com.example.todolist.myException.NOTFOUNDEXCEPTION;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionController {

    private final MessageSourceAccessor messageSourceAccessor;

    public ExceptionController(MessageSourceAccessor messageSourceAccessor) {
        this.messageSourceAccessor = messageSourceAccessor;
    }

    @ExceptionHandler(NOTFOUNDEXCEPTION.class)
    public ResponseEntity<ErrorDto> handleNOTFOUNDEXCEPTiOn(NOTFOUNDEXCEPTION ex) {
        ErrorDto errorDto = new ErrorDto(ex.getMessage(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);


    }

@ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDto>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<ErrorDto> errorDtos = new ArrayList<>();
    for (int i = 0; i < fieldErrors.size(); i++) {
        ErrorDto errorDto= new ErrorDto(messageSourceAccessor.getMessage(fieldErrors.get(i).getDefaultMessage())
                , fieldErrors.get(i).getCode());
        errorDtos.add(errorDto);

    }
    return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDtos);

}
}