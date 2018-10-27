package pprs.Controllers;

import pprs.Controllers.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ConvocatoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleException(final ConvocatoryNotFoundException ex){
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleException(final UserNotFoundException ex){
    }

    @ExceptionHandler(ConvocatoriesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleException(final ConvocatoriesNotFoundException ex){
    }

    @ExceptionHandler(SubjectsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleException(final SubjectsNotFoundException ex){
    }

    @ExceptionHandler(IncorrectUserNameException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED) //401
    public void handleException(final IncorrectUserNameException ex){
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN) //403
    public void handleException(final IncorrectPasswordException ex){
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.IM_USED) // 226
    public void handleException(final UserAlreadyExistsException ex){
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public void genericException(final Throwable ex){
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public void genericException(final HttpMessageNotReadableException ex){
    }
}