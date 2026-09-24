import javax.swing.*;
import java.awt.*;

/**
 * Classe MainGUI con all'interno costruttore MainGUI e main di avvio con una semplice GUI
 * 
 * @author Cristian Dylan D'Amico
 * @version 1.0
 */
public class MainGUI extends JFrame{

    /** Costante per la dimensione dell'array */
    private final int dim = 10;

    /** Array di tipo SpazioFiera */
    private SpazioFiera[] array = new SpazioFiera[dim];

    /** Variabili temporanee */
    private SpazioFiera temp = new SpazioFiera(0, 0, 0, false);

    public MainGUI(){
        setSize(1200,700);
        setLayout(new GridLayout(0,1));
        setTitle("Elenco");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        array[0] = new SpazioFiera(1, 10, 500, false);
        array[1] = new SpazioFiera(2, 20, 1000, true);
        array[2] = new SpazioFiera(3, 30, 1500, false);
        array[3] = new SpazioFiera(4, 10, 500, false);
        array[4] = new SpazioFiera(5, 30, 1500, true);
        array[5] = new SpazioFiera(6, 20, 1000, true);
        array[6] = new SpazioFiera(7, 20, 1000, true);
        array[7] = new SpazioFiera(8, 10, 500, false);
        array[8] = new SpazioFiera(9, 30, 1500, true);
        array[9] = new SpazioFiera(10, 10, 500, false);

        for (int i = 0; i < dim - 1; i++) {
            for (int j = 0; j < dim - 1; j++) {
                if(array[j].getMetriQuadri() < array[j + 1].getMetriQuadri()){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < dim - 1; i++) {
            for (int j = 0; j < dim - 1; j++) {
                if(array[j].getMetriQuadri() == array[j + 1].getMetriQuadri()){
                    if(array[j].getCodiceUnivoco() > array[j +1].getCodiceUnivoco()){
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }

        JPanel menuPanel = new JPanel(new GridLayout(0,5));
        menuPanel.add(new JLabel(""));
        menuPanel.add(new JLabel("---"));
        menuPanel.add(new JLabel("MENU"));
        menuPanel.add(new JLabel("---"));
        menuPanel.add(new JLabel(""));

        JPanel elencoPanel = new JPanel(new GridLayout(0,5));
        for (int i = 0; i < dim; i++) {
            elencoPanel.add(new JLabel(""));
            elencoPanel.add(new JLabel(array[i].getCodiceUnivoco() + "."));
            elencoPanel.add(new JLabel(array[i].getMetriQuadri() + "mq"));
            elencoPanel.add(new JLabel(array[i].getCostoBase() + " euro"));
            elencoPanel.add(new JLabel(array[i].getIsPrenotato() + ""));
        }

        add(menuPanel);
        add(elencoPanel);

        setVisible(true);
    }

    /** Metodo per l'avvio */
    public static void main(String[] args) {
        new MainGUI();
    }
}
