package Thread;

public class SegnaleRadio implements Runnable{
    public SegnaleRadio(){

    }

    @Override
    public void run(){
        try {
            while(!Thread.interrupted()){
                System.out.println("Ping radio in corso...");
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println("<!> Trasmissione radio interrotta dal comando centrale <!>");
        }
    }
}
