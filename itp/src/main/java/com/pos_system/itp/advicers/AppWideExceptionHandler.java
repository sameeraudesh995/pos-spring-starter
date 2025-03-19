package com.pos_system.itp.advicers;


import com.pos_system.itp.exception.EntryNotFoundException;
import com.pos_system.itp.util.StandardResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandardResponseDto> handleEntryNotFoundException(EntryNotFoundException e){
        return new ResponseEntity<>(
                new StandardResponseDto(404,e.getMessage(),e)
                , HttpStatus.NOT_FOUND
        );
    }
}
