package classi;

public class Lista {

    private Prenotazione first;
    private Prenotazione last;
    private double incassoTotale;

    public Lista(){
        this.first = null;
        this.incassoTotale = 0;
    }

    public void push(String id, String paziente, String visita, double prezzo){
        Prenotazione p = new Prenotazione(id, paziente, visita, prezzo);

        if(first == null){
            first = last = p;
            System.out.println("\nPrenotazione inserita con successo!\n\n");
        } else {
            last.setNext(p);
            last = p;
            System.out.println("\nPrenotazione inserita con successo!\n\n");
        }
        
    }

    public String pop(String id){
        Prenotazione p1, p2 = new Prenotazione(null, null, null, 0);
        
        if (first == null) {
            return "\nNon ci sono prenotazioni!\n\n";
        }

        p1 = first;
        for(p2 = first; (!(p2.getId().equals(id))) && ((p2.getNext() != null)); p1 = p2, p2 = p2.getNext());
        if (p2.getId().equals(id)) {
            incassoTotale += p2.getPrezzo();
            if (p2 == first) {
                first = p2.getNext();
            } else {
                p1.setNext(p2.getNext());
            }
            return "\nPrenotazione eliminata con successo!\n\n";
        } else {
            return"\nLa prenotazione con ID \"" + id + "\" non esiste!\n\n";
        }
    }

    public void stampaProssima(){
        if (first == null) {
            System.out.println("\nNon ci sono prenotazioni!\n\n");
        } else {
            System.out.println("\nProssima prenotazione:\n - ID: " + first.getId() + "\n - Paziente: " + first.getPaziente() + "\n - Visita: " + first.getVisita() + "\n - Prezzo: " + first.getPrezzo() + "\n\n");
        }
    }

    public void contaPrenotazioni(){
        Prenotazione p1, p2 = new Prenotazione(null, null, null, 0);
        int i = 1;

        if (first == null) {
            System.out.println("\nNon ci sono prenotazioni!\n\n");
        } else {
            p1 = first;
            for (p2 = first; p2.getNext() != null; p1 = p2, p2 = p2.getNext()){
                i++;
            }
            System.out.println("\nAttualmente ci sono " + i + " prenotazioni\n\n");
        }
    }

    public double getIncassoTotale(){
        return incassoTotale;
    }

    public void cercaPaziente(String paziente){
        Prenotazione p1, p2 = new Prenotazione(null, null, null, 0);

        if (first == null) {
            System.out.println("\nNon ci sono prenotazioni!\n\n");
        } else {
            p1 = first;
            for (p2 = first; ((!(p2.getPaziente().equals(paziente))) && (p2.getNext() != null)); p1 = p2, p2 = p2.getNext());
            if (p2.getPaziente().equals(paziente)) {
                System.out.println("\nInformazioni prenotazione:\n - ID: " + p2.getId() + "\n - Paziente: " + p2.getPaziente() + "\n - Visita: " + p2.getVisita() + "\n - Prezzo: " + p2.getPrezzo() + "\n\n");
            } else {
                System.out.println("\nLa prenotazione di " + paziente + " non esiste!");
            }
        }
    }

    public void contaVisiteCostose(double prezzo){
        Prenotazione p1 = new Prenotazione(null, null, null, 0);
        int i = 0;

        if (first == null) {
            System.out.println("\nNon ci sono prenotazioni!\n\n");
        } else {
            p1 = first;
            while (p1 != null) {
                if (p1.getPrezzo() > prezzo) {
                    i++;
                }
                p1 = p1.getNext();
            }
            System.out.println("\nCi sono " + i + " prenotazioni che costano piu' di " + prezzo + " euro");
        }
    }

}