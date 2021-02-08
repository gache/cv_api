package com.erickfranco.cv_api.configurations.exceptionconfig.configexception;


import com.erickfranco.cv_api.configurations.exceptionconfig.exception.BadRequestExcepton;
import com.erickfranco.cv_api.configurations.exceptionconfig.exception.NotFoundExcepton;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfiguration {

    @ExceptionHandler(NotFoundExcepton.class)
    public ResponseEntity<?> notFoundException(Exception e){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(BadRequestExcepton.class)
    public ResponseEntity<?> badRequestException(Exception e){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
