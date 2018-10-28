package pprs.Controllers.exception;

public class ConvocatoryNotFoundException extends Exception {
    public ConvocatoryNotFoundException(String id) {
        super("No se encontro la convocatoria con el id " + id);
    }
}
