import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**

* La classe {@code es_5bottoni} estende {@link JFrame} e crea una finestra con cinque bottoni e cinque campi di testo.
* Ogni bottone esegue un'operazione specifica sul testo o sul numero inserito:
* <ul>
* ```
  <li>Trasformare un numero decimale in binario.</li>
  ```
* ```
  <li>Rendere maiuscola la prima lettera di un testo.</li>
  ```
* ```
  <li>Trasformare tutto il testo in maiuscolo.</li>
  ```
* ```
  <li>Trasformare tutto il testo in minuscolo.</li>
  ```
* ```
  <li>Rendere maiuscola la prima lettera e minuscole tutte le altre lettere.</li>
  ```
* </ul>

*/
public class es_5bottoni extends JFrame {


/** Bottone per trasformare un numero decimale in binario */
private JButton bin;

/** Bottone per rendere maiuscola la prima lettera del testo */
private JButton maiusc;

/** Bottone per trasformare tutto il testo in maiuscolo */
private JButton testoMaiuscolo;

/** Bottone per trasformare tutto il testo in minuscolo */
private JButton testoMinuscolo;

/** Bottone per rendere maiuscola la prima lettera e minuscole tutte le altre lettere */
private JButton primaMaiuscola;

/** Label per mostrare il risultato dell'operazione */
private JLabel risultato;

/** Campo di testo per inserire un numero decimale */
private JTextField input1;

/** Campo di testo per inserire un testo da trasformare con prima lettera maiuscola */
private JTextField input2;

/** Campo di testo per inserire un testo da trasformare tutto in maiuscolo */
private JTextField input3;

/** Campo di testo per inserire un testo da trasformare tutto in minuscolo */
private JTextField input4;

/** Campo di testo per inserire un testo da trasformare con prima lettera maiuscola e resto minuscolo */
private JTextField input5;

/**
 * Costruttore della classe {@code es_5bottoni}.
 * Inizializza la finestra, crea i campi di testo, i bottoni, aggiunge i listener e rende visibile la GUI.
 */
public es_5bottoni() {
    setTitle("5 Bottoni");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(1000, 600);
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

    input1 = new JTextField(10);
    input2 = new JTextField(10);
    input3 = new JTextField(10);
    input4 = new JTextField(10);
    input5 = new JTextField(10);
    risultato = new JLabel("--- RISULTATO ---");

    bin = new JButton("Trasforma il numero decimale in binario");
    maiusc = new JButton("Prima lettera maiuscola");
    testoMaiuscolo = new JButton("Testo maiuscolo");
    testoMinuscolo = new JButton("Testo minuscolo");
    primaMaiuscola = new JButton("Prima lettera maiuscola e tutto minuscolo");

    add(new JLabel("--- INSERISCI ---"));

    JPanel inputPanel = new JPanel(new FlowLayout());
    inputPanel.add(new JLabel("Numero decimale: "));
    inputPanel.add(input1);
    inputPanel.add(new JLabel("Testo per lettera maiuscola: "));
    inputPanel.add(input2);
    inputPanel.add(new JLabel("Testo per trasformare tutto in maiuscolo: "));
    inputPanel.add(input3);
    inputPanel.add(new JLabel("Testo per trasformare tutto in minuscolo: "));
    inputPanel.add(input4);
    inputPanel.add(new JLabel("Testo per trasformare la prima lettera maiuscola e tutto minuscolo: "));
    inputPanel.add(input5);

    JPanel buttonPanelNum = new JPanel(new FlowLayout());
    buttonPanelNum.add(bin);
    buttonPanelNum.add(maiusc);
    buttonPanelNum.add(testoMaiuscolo);
    buttonPanelNum.add(testoMinuscolo);
    buttonPanelNum.add(primaMaiuscola);

    add(inputPanel);
    add(buttonPanelNum);
    add(risultato);

    bin.addActionListener(new binListener());
    maiusc.addActionListener(new maiuscListener());
    testoMaiuscolo.addActionListener(new testoMaiuscoloListener());
    testoMinuscolo.addActionListener(new testoMinuscoloListener());
    primaMaiuscola.addActionListener(new primaMaiuscolaListener());

    setVisible(true);
}

/**
 * Listener per il bottone "Trasforma il numero decimale in binario".
 * Converte il numero decimale inserito in {@link #input1} in binario e mostra il risultato.
 */
public class binListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int dec = Integer.parseInt(input1.getText());
        String bin1 = "";
        int temp;
        do {
            temp = dec % 2;
            bin1 = temp + bin1;
            dec = dec / 2;
        } while (dec > 0);
        risultato.setText("--- RISULTATO BINARIO: " + bin1 + " ---");
    }
}

/**
 * Listener per il bottone "Prima lettera maiuscola".
 * Trasforma la prima lettera del testo in {@link #input2} in maiuscolo.
 */
public class maiuscListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String Maiuscola = input2.getText().substring(0, 1).toUpperCase();
        String testo = input2.getText().substring(1);
        risultato.setText("--- PRIMA LETTERA MAIUSCOLA: " + Maiuscola + testo + " ---");
    }
}

/**
 * Listener per il bottone "Testo maiuscolo".
 * Trasforma tutto il testo in {@link #input3} in maiuscolo.
 */
public class testoMaiuscoloListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        risultato.setText("--- TESTO MAIUSCOLO: " + input3.getText().toUpperCase() + " ---");
    }
}

/**
 * Listener per il bottone "Testo minuscolo".
 * Trasforma tutto il testo in {@link #input4} in minuscolo.
 */
public class testoMinuscoloListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        risultato.setText("--- TESTO MINUSCOLO: " + input4.getText().toLowerCase() + " ---");
    }
}

/**
 * Listener per il bottone "Prima lettera maiuscola e tutto minuscolo".
 * Trasforma la prima lettera in maiuscolo e tutte le altre lettere in minuscolo nel testo di {@link #input5}.
 */
public class primaMaiuscolaListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String testo = input5.getText();
        String risultatoTesto = testo.substring(0, 1).toUpperCase() + testo.substring(1).toLowerCase();
        risultato.setText("--- TESTO PRIMA MAIUSCOLA E TUTTO MINUSCOLA: " + risultatoTesto + " ---");
    }
}

/**
 * Metodo principale che avvia l'applicazione creando un'istanza di {@code es_5bottoni}.
 *
 * @param args Parametri della linea di comando (non utilizzati)
 */
public static void main(String[] args) {
    new es_5bottoni();
}


}
