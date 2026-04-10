package classi;

public class Coda {
    
    private Persona first;
    private Persona last;
    private double incasso;

    public Coda(){
        first = null;
        last = null;
        incasso = 0;
    }

    public String pop(){
        Persona p = new Persona(null, null, 0);
        String s = "";

        if (first == null) {
            s = "\n\nNon ci sono persone in coda!";
        } else {
            p = first;
            first = p.getNext();
            s = "\n\nIl prossimo in coda e' " + p.getCognome() + " " + p.getNome() + "\nCliente servito!\n\n";
            this.incasso = incasso + ((p.getImporto() * 100) / 100);
        }

        return s;
    }

    public void push(String nome, String cognome, double importo){
        Persona p = new Persona(nome, cognome, importo);

        if (first == null) {
            first = last = p;
        } else {
            last.setNext(p);
            last = p;
        }
    }

    public String toString(){
        String s = "\nPersone in coda:\n";
        Persona p = new Persona(null, null, 0);

        p = first;

        if(p == null){
            s = " ";
        } else {
            while (p != null) {
                s = s + "- " + p.getCognome() + " " + p.getNome() + "\n";
                p = p.getNext();
            }
        }
        
        return s;
    }

    public String stampaUltimo(){
        String s = "";

        if (last == null) {
            System.out.println("\nNon ci sono persone in coda!");
        } else {
            s = "\nUltimo in coda: " + last.getCognome() + " " + last.getNome();
        }

        return s;
    }

    public int numeroPersone(){
        int i = 0;
        Persona p = new Persona(null, null, 0);

        p = first;

        while (p != null) {
            i++;
            p = p.getNext();
        }

        return i;
    }

    public double getIncasso(){
        return incasso;
    }

    public void setIncasso(double incasso){
        this.incasso = incasso;
    }

}
