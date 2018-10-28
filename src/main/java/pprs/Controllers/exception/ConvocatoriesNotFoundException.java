package pprs.Controllers.exception;

public class ConvocatoriesNotFoundException extends Exception {
    public ConvocatoriesNotFoundException() {
        super("Error al encontrar convocatorias");
    }
}
