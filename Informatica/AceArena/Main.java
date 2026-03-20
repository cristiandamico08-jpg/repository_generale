import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import classi.*;
import eccezioni.*;

public class Main extends JFrame{
    
    private JTextField nomeInput;
    private JSpinner codiceIdentificativoInput;
    private JButton aggiungiGiocatore;
    private JLabel output;
    private ButtonGroup gruppoLezione;
    private JRadioButton affitto;
    private JRadioButton lezione;
    private JRadioButton racchettaSi;
    private JRadioButton racchettaNo;

    public Main(){
        setTitle("AceArena");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650,250);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLocationRelativeTo(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeInput = new JTextField();

        JLabel codiceIdentificativoLabel = new JLabel("Codice Identificativo:");
        codiceIdentificativoInput = new JSpinner();

        JLabel tipoLezione = new JLabel("Tipo lezione: ");
        affitto = new JRadioButton("Affitto Semplice");
        lezione = new JRadioButton("Lezione Perfezionamento");
        
        JLabel racchetta = new JLabel("Aggiungi racchetta professionale: ");
        racchettaSi = new JRadioButton("Si");
        racchettaNo = new JRadioButton("No");

        aggiungiGiocatore = new JButton("Aggiungi Giocatore");
        output = new JLabel("");
        affitto = new JRadioButton("Affitto Semplice");
        lezione = new JRadioButton("Lezione Perfezionamento");

        JPanel panel1 = new JPanel(new GridLayout(5, 3, 12, 12));
        panel1.add(nomeLabel);
        panel1.add(nomeInput);
        panel1.add(new JLabel(""));
        panel1.add(codiceIdentificativoLabel);
        panel1.add(codiceIdentificativoInput);
        panel1.add(new JLabel(""));
        
        panel1.add(tipoLezione);
        gruppoLezione = new ButtonGroup();
        gruppoLezione.add(affitto);
        gruppoLezione.add(lezione);
        panel1.add(affitto);
        panel1.add(lezione);

        panel1.add(racchetta);
        ButtonGroup gruppoRacchetta = new ButtonGroup();
        gruppoRacchetta.add(racchettaSi);
        gruppoRacchetta.add(racchettaNo);
        panel1.add(racchettaSi);
        panel1.add(racchettaNo);

        panel1.add(new JLabel(""));
        panel1.add(aggiungiGiocatore);
        panel1.add(output);

        add(panel1);

        setVisible(true);
    }

    public class aggiungiGiocatoreListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(affitto.isSelected()){
                if (racchettaSi.isSelected()) {
                    
                }
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}