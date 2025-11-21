import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe che rappresenta l'interfaccia grafica per la gestione di un magazzino.
 * Permette di visualizzare informazioni sulle scorte tramite diversi pulsanti.
 */
public class MainGUI extends JFrame{
    
    /** Bottone per calcolare il totale delle scorte */
    private JButton totale;
    /** Bottone per trovare il prodotto con la quantità maggiore */
    private JButton maggiore;
    /** Bottone per trovare il prodotto con la quantità minore */
    private JButton minore;
    /** Bottone per contare i prodotti con meno di 5 pezzi */
    private JButton numProd;
    /** Label che mostra il risultato delle elaborazioni */
    private JLabel risultato;

    /**
     * Costruttore della classe MainGUI.
     * Inizializza la finestra, i prodotti, i pulsanti, e assegna i listener.
     */
    public MainGUI(){

        /** Numero di prodotti presenti nel magazzino */
        final int dim = 7;

        /** Array che contiene tutti i prodotti del magazzino */
        Prodotti[] magazzino = new Prodotti[dim];
        magazzino[0] = new Prodotti(12, "Pasta");
        magazzino[1] = new Prodotti(8, "Riso");
        magazzino[2] = new Prodotti(4, "Biscotti");
        magazzino[3] = new Prodotti(0, "Latte");
        magazzino[4] = new Prodotti(20, "Uova");
        magazzino[5] = new Prodotti(3, "Pane");
        magazzino[6] = new Prodotti(6, "Farina");

        // Formattazione finestra
        setTitle("Magazzino");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,720);
        setLayout(new GridLayout(0,3));

        // Creazione label del risultato
        risultato = new JLabel("--- RISULTATO ---");

        // Creazione bottoni
        totale = new JButton("Totale scorte");
        maggiore = new JButton("Prodotto con la quantità maggiore");
        minore = new JButton("Prodotto con la quantità minore");
        numProd = new JButton("Numero dei prodotti con meno di 5 pezzi");

        // Inserimento dei prodotti e delle scorte nella GUI
        add(new JLabel(""));
        JPanel prodottiJPanel = new JPanel(new GridLayout(0,3));
        prodottiJPanel.add(new JLabel("Indice:"));
        prodottiJPanel.add(new JLabel("Prodotto:"));
        prodottiJPanel.add(new JLabel("Scorte:"));
        for(int i = 0; i < dim; i++){
            prodottiJPanel.add(new JLabel((i+1) + " - "));
            prodottiJPanel.add(new JLabel(magazzino[i].getProdotto()));
            prodottiJPanel.add(new JLabel(String.valueOf(magazzino[i].getScorte())));
        }

        add(prodottiJPanel);

        // Aggiungo uno spazio vuoto
        add(Box.createVerticalStrut(20));

        // Inserimento bottoni e risultato
        add(new JLabel(""));
        JPanel buttonJPanel = new JPanel(new FlowLayout());
        buttonJPanel.add(totale);
        buttonJPanel.add(maggiore);
        buttonJPanel.add(minore);
        buttonJPanel.add(numProd);
        buttonJPanel.add(risultato);

        add(buttonJPanel);

        // Aggiungo i listener ai bottoni
        totale.addActionListener(new totaleListener());
        maggiore.addActionListener(new maggioreListener());
        minore.addActionListener(new minoreListener());
        numProd.addActionListener(new numProdListener());
        
        setVisible(true);
    }

    /**
     * Listener per il calcolo del totale delle scorte.
     */
    public class totaleListener implements ActionListener{
        /**
         * Calcola e mostra la somma delle scorte di tutti i prodotti.
         *
         * @param e evento generato dal clic del bottone
         */
        public void actionPerformed(ActionEvent e) {
            int tot = 0;
            final int dim = 7;

            Prodotti[] magazzino = new Prodotti[dim];
            magazzino[0] = new Prodotti(12, "Pasta");
            magazzino[1] = new Prodotti(8, "Riso");
            magazzino[2] = new Prodotti(4, "Biscotti");
            magazzino[3] = new Prodotti(0, "Latte");
            magazzino[4] = new Prodotti(20, "Uova");
            magazzino[5] = new Prodotti(3, "Pane");
            magazzino[6] = new Prodotti(6, "Farina");

            for(int i = 0; i < dim; i++) {
                tot = tot + magazzino[i].getScorte();
            }

            risultato.setText("--- Totale scorte: " + tot + " ---");
        }
    }

    /**
     * Listener per trovare il prodotto con più scorte.
     */
    public class maggioreListener implements ActionListener{
        /**
         * Trova e mostra il prodotto con la quantità di scorte maggiore.
         *
         * @param e evento clic
         */
        public void actionPerformed(ActionEvent e) {
            int mag = 0;

            final int dim = 7;

            Prodotti[] magazzino = new Prodotti[dim];
            magazzino[0] = new Prodotti(12, "Pasta");
            magazzino[1] = new Prodotti(8, "Riso");
            magazzino[2] = new Prodotti(4, "Biscotti");
            magazzino[3] = new Prodotti(0, "Latte");
            magazzino[4] = new Prodotti(20, "Uova");
            magazzino[5] = new Prodotti(3, "Pane");
            magazzino[6] = new Prodotti(6, "Farina");

            for(int i = 0; i < dim; i++){
                if(magazzino[i].getScorte() > mag){
                    mag = magazzino[i].getScorte();
                }
            }
            for(int i = 0; i < dim; i++){
                if(magazzino[i].getScorte() == mag){
                    risultato.setText("--- Prodotto con la quantità di scorte maggiore: " + magazzino[i].getProdotto() + " ---");
                }
            }
        }
    }

    /**
     * Listener per trovare il prodotto con meno scorte.
     */
    public class minoreListener implements ActionListener{
        /**
         * Determina il prodotto con la quantità minima di scorte.
         *
         * @param e evento clic
         */
        public void actionPerformed(ActionEvent e) {

            final int dim = 7;

            Prodotti[] magazzino = new Prodotti[dim];
            magazzino[0] = new Prodotti(12, "Pasta");
            magazzino[1] = new Prodotti(8, "Riso");
            magazzino[2] = new Prodotti(4, "Biscotti");
            magazzino[3] = new Prodotti(0, "Latte");
            magazzino[4] = new Prodotti(20, "Uova");
            magazzino[5] = new Prodotti(3, "Pane");
            magazzino[6] = new Prodotti(6, "Farina");

            int min = magazzino[0].getScorte();
            
            for(int i = 0; i < dim; i++){
                if(magazzino[i].getScorte() < min){
                    min = magazzino[i].getScorte();
                }
            }
            for(int i = 0; i < dim; i++){
                if(magazzino[i].getScorte() == min){
                    risultato.setText("--- Prodotto con la quantità di scorte minore: " + magazzino[i].getProdotto() + " ---");
                    if(min == 0){
                        risultato.setText("--- Prodotto con la quantità di scorte minore: " + magazzino[i].getProdotto() + " (esaurito) ---");
                    }
                }
            }
        }
    }

    /**
     * Listener per il conteggio dei prodotti con meno di 5 scorte.
     */
    public class numProdListener implements ActionListener{
        /**
         * Conta quanti prodotti hanno meno di 5 pezzi disponibili.
         *
         * @param e evento clic
         */
        public void actionPerformed(ActionEvent e) {

            final int dim = 7;

            Prodotti[] magazzino = new Prodotti[dim];
            magazzino[0] = new Prodotti(12, "Pasta");
            magazzino[1] = new Prodotti(8, "Riso");
            magazzino[2] = new Prodotti(4, "Biscotti");
            magazzino[3] = new Prodotti(0, "Latte");
            magazzino[4] = new Prodotti(20, "Uova");
            magazzino[5] = new Prodotti(3, "Pane");
            magazzino[6] = new Prodotti(6, "Farina");

            int nProd = 0;
            
            for(int i = 0; i < dim; i++){
                if(magazzino[i].getScorte() < 5){
                    nProd = nProd + 1;
                }
            }
            risultato.setText("--- Numero di prodotti con meno di 5 pezzi: " + nProd + " ---");
        }
    }

    /**
     * Metodo main: avvia la GUI del magazzino.
     *
     * @param args argomenti da linea di comando (non utilizzati)
     */
    public static void main(String[] args) {
        new MainGUI();
    }
}