import java.util.Random;

public class MioThreadRunnable implements Runnable {
        @Override
        public void run(){
            Random random = new Random();
            Campana campana = new Campana("Dong", random.nextInt(4) + 1);
        }
}
