package Informatica.FitFlow.it.fitflow.exception;

public class CapienzaMassimaException extends Exception {
    public CapienzaMassimaException(String message) {
        super(message);
    }

    public CapienzaMassimaException() {
        super("Capienza massima della palestra raggiunta.");
    }
    
}
