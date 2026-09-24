import thread.PrezzoComponente;

public class Main {

    private PrezzoComponente cpu = new PrezzoComponente("CPU");
    private PrezzoComponente gpu = new PrezzoComponente("GPU");
    private PrezzoComponente ram = new PrezzoComponente("RAM");

    private Thread T_1 = new Thread(cpu);
    private Thread T_2 = new Thread(gpu);
    private Thread T_3 = new Thread(ram);

    private double totale = 0;

    public Main(){
        
        System.out.println("\n\nAvvio calcolo prezzi...\n\n");

        T_1.start();
        T_2.start();
        T_3.start();

        try {
            T_1.join();
            T_2.join();
            T_3.join();
        } catch (InterruptedException e) {
            System.out.println("\n\n\n<!> Interruzione <!>\n\n\n");
        }

        totale = Math.round((cpu.getCosto() + gpu.getCosto() + ram.getCosto()) * 100) / 100;
        System.out.println("\n\nRisultati finali:");
        System.out.println("CPU: " + cpu.getCosto() + " euro");
        System.out.println("GPU: " + gpu.getCosto() + " euro");
        System.out.println("RAM: " + ram.getCosto() + " euro");
        System.out.println("Totale: " + totale + " euro\n");

    }

    public static void main(String[] args) {
        new Main();
    }
}