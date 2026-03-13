package eccezioni;

public class CampiEsauritiException extends Exception{
    public CampiEsauritiException(String message){
        super(message);
    }

    public CampiEsauritiException(){
        super("Limite giocatori raggiunto!");
    }
}
