public class Campana {
    public Campana(String suonoCamapana, int numeroRintocchi){
        System.out.println(suonoCamapana + " " + numeroRintocchi + " rintocchi");
    }

    public static void main(String[] args) {
        MioThreadRunnable thread1Runnable = new MioThreadRunnable();
        MioThreadRunnable thread2Runnable = new MioThreadRunnable();
        MioThreadRunnable thread3Runnable = new MioThreadRunnable();
        
        Thread thread1 = new Thread(thread1Runnable);
        thread1.start();
        Thread thread2 = new Thread(thread2Runnable);
        thread2.start();
        Thread thread3 = new Thread(thread3Runnable);
        thread3.start();
    }
}
