package Thread;

import java.util.ArrayList;

public class RicercaDispersi implements Runnable{

    private ArrayList<Integer> zone = new ArrayList<>();
    private int zoneEsplorate;

    public RicercaDispersi(ArrayList<Integer> zone){
        this.zone = zone;
        this.zoneEsplorate = 0;
    }

    public int getZoneEsplorate(){
        return zoneEsplorate;
    }

    @Override
    public void run(){
        try {
            for (Integer zona : zone) {
                this.zoneEsplorate++;
                Thread.sleep(400);
            }
        } catch (InterruptedException e) {
            System.out.println("Ricerca Terminata. Zone controllate: " + zoneEsplorate);
        }
    }
}
