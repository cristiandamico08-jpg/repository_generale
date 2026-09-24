package eccezioni;

public class OspedalePienoException extends Exception{
    public OspedalePienoException(String message){
        super(message);
    }

    public OspedalePienoException(){
        super("\nSpiacenti, i posti letto sono tutti occupati");
    }
}
