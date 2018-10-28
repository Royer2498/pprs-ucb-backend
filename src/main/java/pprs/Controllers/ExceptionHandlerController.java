package pprs.Controllers;

import pprs.Controllers.exception.*;
import pprs.Models.ErrorMessage;
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
    public ErrorMessage handleException(final ConvocatoryNotFoundException ex){
        return new ErrorMessage(ex.getMessage(), "/convocatoryNotFoundException");
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleException(final UserNotFoundException ex){
        return new ErrorMessage(ex.getMessage(), "/userNotFoundException");
    }

    @ExceptionHandler(ConvocatoriesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleException(final ConvocatoriesNotFoundException ex){
        return new ErrorMessage(ex.getMessage(), "/convocatoriesNotFoundException");
    }

    @ExceptionHandler(SubjectsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleException(final SubjectsNotFoundException ex){
        return new ErrorMessage(ex.getMessage(), "/subjectNotFoundException");
    }

    @ExceptionHandler(IncorrectUserNameException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED) //401
    public ErrorMessage handleException(final IncorrectUserNameException ex){
        return new ErrorMessage(ex.getMessage(), "/incorrectUserNameException");
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN) //403
    public ErrorMessage handleException(final IncorrectPasswordException ex){
        return new ErrorMessage(ex.getMessage(), "/incorrectPasswordException");
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.IM_USED) // 226
    public ErrorMessage handleException(final UserAlreadyExistsException ex){
        return new ErrorMessage(ex.getMessage(), "/userAlreadyExistsException");
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public ErrorMessage genericException(final Throwable ex){
        return new ErrorMessage(ex.getMessage(), "");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage genericException(final HttpMessageNotReadableException ex){
        return new ErrorMessage("Invalid JSON format", "/HttpMessageNotReadableException");
    }
}