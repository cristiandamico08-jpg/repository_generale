import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe principale che rappresenta una semplice interfaccia grafica ATM.
 * Permette di effettuare operazioni di deposito, prelievo e visualizzazione del saldo.
 */
public class Main extends JFrame{
    
    /** Campo di input per l'importo da depositare o prelevare. */
    private JTextField input;
    /** Bottone per effettuare un deposito. */
    private JButton deposita;
    /** Bottone per effettuare un prelievo. */
    private JButton preleva;
    /** Bottone per visualizzare il saldo corrente. */
    private JButton mostraSaldo;
    /** Etichetta che mostra informazioni all'utente. */
    private JLabel info;

    /** Oggetto ContoCorrente associato all'utente. */
    private ContoCorrente utente;

    /**
     * Costruttore della classe Main: inizializza la finestra e i componenti grafici.
     */
    public Main(){

        //formattazione finestra
        setTitle("ATM");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,250);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        //dichiaro gli oggetti
        input = new JTextField(20);
        deposita = new JButton("Deposita");
        preleva = new JButton("Preleva");
        mostraSaldo = new JButton("Mostra saldo");
        info = new JLabel("");
        
        //dichiaro le variabili
        utente = new ContoCorrente("Cippo Cioppo", 125634.69);

        //inserisco gli oggetti nella schermata

        //TextField
        add(new JLabel(""));
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Inserisci una quantità di denaro: "));
        inputPanel.add(input);
        inputPanel.add(new JLabel("€"));

        //Bottoni
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(deposita);
        buttonPanel.add(preleva);
        buttonPanel.add(mostraSaldo);

        //informazioni
        JPanel infoPanel = new JPanel(new FlowLayout());
        infoPanel.add(info);

        //li visualizzo a schermo
        add(inputPanel);
        add(buttonPanel);
        add(infoPanel);

        //assegno le azioni ai 3 pulsanti
        deposita.addActionListener(new depositaListener());
        preleva.addActionListener(new prelevaListener());
        mostraSaldo.addActionListener(new mostraSaldoListener());

        setVisible(true);
    }

    /**
     * Listener che gestisce l'operazione di deposito.
     * Legge l'importo inserito, lo converte in double e lo deposita sul conto.
     */
    public class depositaListener implements ActionListener{
        /**
         * Esegue la logica collegata al click del pulsante "Deposita".
         *
         * @param e evento generato dal pulsante
         */
        public void actionPerformed(ActionEvent e){
            String temp = input.getText();
            double valore = Double.parseDouble(temp);
            utente.deposita(valore);
            info.setText("- Nome: " + utente.getNome() + "  - Saldo: " + utente.getSaldo() + " €");
        }
    }

    /**
     * Listener che gestisce l'operazione di prelievo.
     * Legge l'importo inserito, lo converte in double e lo preleva dal conto.
     */
    public class prelevaListener implements ActionListener{
        /**
         * Esegue la logica collegata al click del pulsante "Preleva".
         *
         * @param e evento generato dal pulsante
         */
        public void actionPerformed(ActionEvent e){
            String temp = input.getText();
            double valore = Double.parseDouble(temp);
            utente.preleva(valore);
            info.setText("- Nome: " + utente.getNome() + "  - Saldo: " + utente.getSaldo() + " €");
        }
    }

    /**
     * Listener che mostra le informazioni del conto corrente.
     */
    public class mostraSaldoListener implements ActionListener{
        /**
         * Esegue la logica collegata al click del pulsante "Mostra saldo".
         *
         * @param e evento generato dal pulsante
         */
        public void actionPerformed(ActionEvent e){
            info.setText("- Nome: " + utente.getNome() + "  - Saldo: " + utente.getSaldo() + " €");
        }
    }

    /**
     * Metodo principale che avvia l'applicazione ATM.
     *
     * @param args argomenti passati da linea di comando (non utilizzati)
     */
    public static void main(String[] args){
        new Main();
    }
}
