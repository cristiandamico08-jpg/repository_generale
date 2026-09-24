package Exceptions;

public class ValoreScontoException extends Exception{
    public ValoreScontoException(String message){
        super(message);
    }

    public ValoreScontoException(){
        super("Valore sconto non valido! [0-100]");
    }
}
