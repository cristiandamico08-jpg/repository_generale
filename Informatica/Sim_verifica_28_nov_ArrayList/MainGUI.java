package repository_generale.Informatica.Sim_verifica_28_nov_ArrayList;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame{
    
    private ArrayList<Articolo> panini = new ArrayList<Articolo>();
    private ArrayList<Articolo> bibite = new ArrayList<Articolo>();
    private final int dim = 3;
    private Articolo temp = new Articolo(null, 0);

    public MainGUI() {
        setTitle("Lista panini e bibite");
        setSize(1000,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,1));

        panini.add(0, new Articolo("Cotoletta e patatine", 2.50));
        panini.add(1, new Articolo("Cotoletta", 2.00));
        panini.add(2, new Articolo("Piadina wurstel e patatine", 3.00));

        for (int i = 0; i > dim - 1; i++) {
            for (int j = 0; j > dim - 1; j++) {
                if(panini.get(j).getPrezzo() < panini.get(j + 1).getPrezzo()) {
                    temp = panini.get(j);
                    panini.set(j, panini.get(j + 1));
                    panini.set(j + 1, temp);
                }
            }
        }

        bibite.add(0, new Articolo("Coca-Cola", 1.50));
        bibite.add(1, new Articolo("Acqua naturale", 0.80));
        bibite.add(2, new Articolo("Caffe'", 1.20));

        for (int i = 0; i > dim - 1; i++) {
            for (int j = 0; j > dim - 1; j++) {
                if(bibite.get(j).getPrezzo() < bibite.get(j + 1).getPrezzo()) {
                    temp = bibite.get(j);
                    bibite.set(j, bibite.get(j + 1));
                    bibite.set(j + 1, temp);
                }
            }
        }
        
        JPanel paniniPanel = new JPanel(new GridLayout(0,4));
        paniniPanel.add(new JLabel(""));
        paniniPanel.add(new JLabel("---"));
        paniniPanel.add(new JLabel("PANINI"));
        paniniPanel.add(new JLabel("---"));
        for (int i = 0; i < dim; i++) {
            paniniPanel.add(new JLabel(""));
            paniniPanel.add(new JLabel((i + 1) + "."));
            paniniPanel.add(new JLabel(panini.get(i).getNome()));
            paniniPanel.add(new JLabel(panini.get(i).getPrezzo() + " euro"));
        }
        add(paniniPanel);

        add(new JLabel(""));

        JPanel bibitePanel = new JPanel(new GridLayout(0,4));
        bibitePanel.add(new JLabel(""));
        bibitePanel.add(new JLabel("---"));
        bibitePanel.add(new JLabel("BIBITE"));
        bibitePanel.add(new JLabel("---"));
        for (int i = 0; i < dim; i++) {
            bibitePanel.add(new JLabel(""));
            bibitePanel.add(new JLabel((i + 1) + "."));
            bibitePanel.add(new JLabel(bibite.get(i).getNome()));
            bibitePanel.add(new JLabel(bibite.get(i).getPrezzo() + " euro"));
        }
        add(bibitePanel);

        add(new JLabel(""));

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}
