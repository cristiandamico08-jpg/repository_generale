package thread;

import java.util.Random;

public class PrezzoComponente implements Runnable {
    private String nome;
    private double costo;
    private Random random;

    public PrezzoComponente(String nome){
        this.nome = nome;
        this.costo = 0;
        this.random = new Random();
    }
    
    @Override
    public void run(){
        try {
            Thread.sleep(1000);
            this.costo = Math.round((random.nextDouble(2101) + 100) * 100) / 100;
            System.out.println("Prezzo " + nome + ": " + costo + " euro");
        } catch (InterruptedException e) {
            System.out.println("<!> " + e.getMessage() + " <!>");
        }
    }

    public double getCosto(){
        return costo;
    }

}
