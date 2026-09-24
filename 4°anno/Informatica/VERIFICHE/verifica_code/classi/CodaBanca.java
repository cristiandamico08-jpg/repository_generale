package classi;

public class CodaBanca {
    private Cliente first;
    private Cliente last;

    public CodaBanca(){
        this.first = null;
        this.last = null;
    }

    public void inserisci(String nome, String cognome, double importo){
        Cliente c = new Cliente(nome, cognome, importo);
        if (first == null) {
            first = last = c;
        } else {
            last.setNext(c);
            last = c;
        }
        System.out.println("\nCliente inserito con successo!");
    }

    public String serviProssimo(){
        Cliente c = new Cliente(null, null, 0);
        if (first == null) {
            this.last = null;
            return "\nNon ci sono persone in coda!\n\n";
        }
        c = first;
        first = c.getNext();
        if (first == null) {
            this.last = null;
        }
        return "\nCliente rimosso con successo!\n\n";
    }

    public String visualizza(){
        Cliente c = new Cliente(null, null, 0);
        String s = "\nClienti in attesa:\n";

        c = first;
        if (c == null) {
            s = "\nNon ci sono clienti in attesa!\n\n";
        } else {
            while (c != null) {
                s += " - Nome: " + c.getNome() + "\n - Cognome: " + c.getCognome() + "\n - Saldo: " + c.getSaldo() + " euro\n\n";
                c = c.getNext();
            }
        }
        return s;
    }

    public String stampaSaldoPrimo(){
        if (first == null) {
            return "Non ci sono clienti!";
        }
        return "Saldo cliente: " + first.getSaldo() + " euro";
    }

    public double versa(double importo){
        if (first == null) {
            return 0;
        }
        return first.getSaldo() + importo;
    }

    public double preleva(double importo){
        if (first == null) {
            return 0;
        }
        if ((first.getSaldo() - importo) < 0) {
            return 0;
        }
        return first.getSaldo() - importo;
    }

}
