package pprs.Controllers.exception;

public class IncorrectUserNameException extends Exception {
    public IncorrectUserNameException(String message) {
        super(message);
    }
}