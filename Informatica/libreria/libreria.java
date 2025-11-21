import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe {@code libreria} rappresenta un'interfaccia grafica per visualizzare informazioni su diversi libri.
 * Estende {@link JFrame} e utilizza componenti Swing per l'interazione con l'utente.
 */
public class libreria extends JFrame {

    /**
     * Bottone per mostrare le informazioni del libro selezionato.
     */
    private JButton info;

    /**
     * Campo di testo in cui l'utente inserisce il titolo del libro.
     */
    private JTextField input;

    /**
     * Etichetta che mostra le informazioni del libro o messaggi di errore.
     */
    private JLabel testo;

    /**
     * Primo libro della libreria.
     */
    private Libro libro1;

    /**
     * Secondo libro della libreria.
     */
    private Libro libro2;

    /**
     * Terzo libro della libreria.
     */
    private Libro libro3;

    /**
     * Costruttore della classe {@code libreria}.
     * Inizializza la finestra, i componenti grafici e i libri disponibili.
     */
    public libreria() {

        setTitle("Libreria");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 200);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        info = new JButton("Mostra informazioni sul libro");
        input = new JTextField(15);
        testo = new JLabel("");

        libro1 = new Libro("10 motivi per andare ad Amsterdam", "Simon Neapolitans", 2025, 12.50, true);
        libro2 = new Libro("Bicipiti Enormi", "Adrian Cirauds", 2020, 35.67, true);
        libro3 = new Libro("La mia biografia", "Louise Maloney", 2016, 20.69, false);

        add(new JLabel("--- INSERISCI TITOLO LIBRO ---"));
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(input);

        JPanel buttonInputPanel = new JPanel(new FlowLayout());
        buttonInputPanel.add(info);

        add(inputPanel);
        add(buttonInputPanel);
        add(testo);

        mostraInfo();

        setVisible(true);
    }

    /**
     * Aggiunge l'action listener al bottone {@link #info} per mostrare le informazioni del libro.
     * Utilizza una classe interna {@link infoListener}.
     */
    public void mostraInfo() {
        info.addActionListener(new infoListener());
    }

    /**
     * Classe interna che implementa {@link ActionListener} per gestire l'evento del bottone.
     * Quando il bottone viene premuto, cerca il libro corrispondente al titolo inserito
     * e aggiorna l'etichetta {@link #testo} con le informazioni del libro o un messaggio di errore.
     */
    public class infoListener implements ActionListener {

        /**
         * Metodo invocato quando il bottone viene premuto.
         *
         * @param e l'evento generato dall'azione del bottone
         */
        public void actionPerformed(ActionEvent e) {
            String vf;
            int t = 0;

            if (input.getText().equals(libro1.titolo)) {
                if (libro1.disponibile == true) {
                    vf = "SI";
                } else {
                    vf = "NO";
                }
                testo.setText("-Titolo: " + libro1.titolo + "    -Autore: " + libro1.autore + "   -Anno di produzione: " + libro1.anno + "     -Prezzo: " + libro1.prezzo + "€     -Disponibilita': " + vf);
                t = 1;
            }

            if (input.getText().equals(libro2.titolo)) {
                if (libro2.disponibile == true) {
                    vf = "SI";
                } else {
                    vf = "NO";
                }
                testo.setText("-Titolo: " + libro2.titolo + "    -Autore: " + libro2.autore + "   -Anno di produzione: " + libro2.anno + "     -Prezzo: " + libro2.prezzo + "€     -Disponibilita': " + vf);
                t = 1;
            }

            if (input.getText().equals(libro3.titolo)) {
                if (libro3.disponibile == true) {
                    vf = "SI";
                } else {
                    vf = "NO";
                }
                testo.setText("-Titolo: " + libro3.titolo + "    -Autore: " + libro3.autore + "   -Anno di produzione: " + libro3.anno + "     -Prezzo: " + libro3.prezzo + "€     -Disponibilita': " + vf);
                t = 1;
            }

            if (t != 1) {
                testo.setText("Libro non trovato");
            }
        }
    }
}
