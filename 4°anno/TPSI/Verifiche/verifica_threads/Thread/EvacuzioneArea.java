package Thread;

import java.util.concurrent.*;

public class EvacuzioneArea implements Runnable{

    private int i;

    public EvacuzioneArea(){
        this.i = 0;
    }

    @Override
    public void run(){
        try {
            for(i = 6; i != 0; i--){
                System.out.println("-T meno " + i + " secondi all'evacuazione");
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println("EVACUAZIONE COMPLETATA");
        } catch (InterruptedException e) {
            System.out.println("<!> Procedura di evacuazione compromessa <!>");
        }
    }
}
