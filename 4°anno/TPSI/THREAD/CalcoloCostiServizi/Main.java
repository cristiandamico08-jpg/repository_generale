public class Main {

    public static void main(String[] args) {
        calcoloCosti calcoloCostoVolo = new calcoloCosti("Volo");
        calcoloCosti calcoloCostoHotel = new calcoloCosti("Hotel");
        calcoloCosti calcoloCostoAssicurazione = new calcoloCosti("Assicurazione");
        
        Thread threadVolo = new Thread(calcoloCostoVolo, "Volo");
        Thread threadHotel = new Thread(calcoloCostoHotel, "Hotel");
        Thread threadAssicurazione = new Thread(calcoloCostoAssicurazione, "Assicurazione");
        
        threadVolo.start();
        threadHotel.start();
        threadAssicurazione.start();

        try {
            threadVolo.join();
            threadHotel.join();
            threadAssicurazione.join();
            
            double totale = Math.round((calcoloCostoVolo.getCosto() + calcoloCostoHotel.getCosto() + calcoloCostoAssicurazione.getCosto()) * 100) / 100;
            System.out.println("Costo totale: " + totale + " euro");
        } catch (InterruptedException e) {
            System.out.println("<!>" + e.getMessage() + "<!>");
        }
    }
}
