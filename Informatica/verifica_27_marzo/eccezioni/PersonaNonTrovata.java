package eccezioni;

public class PersonaNonTrovata extends Exception{
    public PersonaNonTrovata(String message){
        super(message);
    }

    public PersonaNonTrovata(){
        super("<!>Persona non trovata<!>");
    }
}
