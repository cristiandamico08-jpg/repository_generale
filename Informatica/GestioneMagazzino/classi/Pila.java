package classi;

public class Pila {
    private Pacco first;
    private double pesoSpedito;

    public Pila(){
        this.first = null;
        this.pesoSpedito = 0;
    }

    public void push(String codice, String descrizione, double peso){
        Pacco p = new Pacco(codice, descrizione, peso);
        if (first == null) {
            first = p;
        } else {
            p.setNext(first);
            first = p;
        }
    }

    public String pop(){
        Pacco p = new Pacco(null, null, 0);

        if (first == null) {
            System.out.println("\n\nNon ci sono pacchi");
        }

        p = first;
        this.pesoSpedito += p.getPeso();
        first = p.getNext();
        return "\n\nPacco rimosso!\n- Codice: " + p.getCodice() + "\n- Descrizione: " + p.getDescrizione() + "\n- Peso: " + p.getPeso() + "\n\n";
    }

    public String stampaTop(){
        if (first == null) {
            return "\n\nNon ci sono pacchi!";
        } else {
            return "\n\nInformazioni pacco:\n- Codice: " + first.getCodice() + "\n- Descrizione: " + first.getDescrizione() + "\n- Peso: " + first.getPeso() + "\n\n";
        }
    }

    public int contaPacchi(){
        Pacco p = new Pacco(null, null, 0);
        int i = 0;

        p = first;

        while (p != null) {
            i++;
            p = p.getNext();
        }

        return i;
    }

    public double getPesoTotale(){
        return pesoSpedito;
    }

    public String cercaPacco(String codice){
        Pacco p = first;

        if (first == null) {
            return "\nNon ci sono pacchi!";
        } else {
            while (p != null) {
                if (p.getCodice().equals(codice)) {
                    return "\nIl pacco e' presente nel magazzino";
                }
                p = p.getNext();
            }
        }
        return "\nIl pacco non esiste";
    }

    public String contaPacchiPesanti(double peso){
        int i = 0;
        Pacco p = first;
        if (first == null) {
            return "\nNon ci sono pacchi!";
        } else {
            while (p != null) {
                if (p.getPeso() > peso) {
                    i++;
                }
                p = p.getNext();
            }
        }
        return "\nNumero pacchi pesanti: " + i;
    }

}
