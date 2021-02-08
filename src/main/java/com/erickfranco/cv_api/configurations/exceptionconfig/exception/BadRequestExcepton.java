package com.erickfranco.cv_api.configurations.exceptionconfig.exception;

public class BadRequestExcepton extends RuntimeException {

   public  BadRequestExcepton(){

   }

   public BadRequestExcepton(String message){
       super(message);
   }
}
