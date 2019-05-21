package com.example.demotest.controlleur;

import com.example.demotest.modele.exception.MessagePayload;
import com.example.demotest.modele.validation.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MessagePayload erreurMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        var messagePayload = new MessagePayload();

        for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
            var error = objectError.getDefaultMessage().split(":");

            messagePayload.setCode(error[0]);
            messagePayload.setMessage(error[1]);

        }

        return messagePayload;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public MessagePayload erreurErrorException (Exception ex) {
        var messagePayload = new MessagePayload();

        messagePayload.setCode("9999");
        messagePayload.setMessage(ex.getMessage());

        return messagePayload;
    }
}
