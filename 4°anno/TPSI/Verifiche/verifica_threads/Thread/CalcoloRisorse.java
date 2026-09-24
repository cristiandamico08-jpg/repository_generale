package Thread;

import java.util.ArrayList;

public class CalcoloRisorse implements Runnable{

    private ArrayList<Integer> arrayList = new ArrayList<>();
    private int totaleFondi; 
    
    public CalcoloRisorse(ArrayList<Integer> arrayList){
        this.arrayList = arrayList;
        this.totaleFondi = 0;
    }

    public int getTotaleFondi(){
        return totaleFondi;
    }

    @Override
    public void run(){
        try {
            for (Integer fondo : arrayList) {
                this.totaleFondi += fondo;
            }
            Thread.sleep(150);
            System.out.println("\nCalcolo risorse completato");
        } catch (InterruptedException e) {
            System.out.println("<!> Calcolo interrotto <!>");
        }
    }
}
