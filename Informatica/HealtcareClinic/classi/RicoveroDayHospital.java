package classi;

public class RicoveroDayHospital extends Paziente{

    public RicoveroDayHospital(String nome, int codiceCartella, double tariffaBase){
        super(nome, codiceCartella, tariffaBase);
    }

    @Override
    public void calcolaCostoRicovero(boolean pastoPersonalizzato, int numeroGiorni) {
        double tariffaBase = 100;
        super.setTariffaBase(tariffaBase);
        double arrotondamento = 0;
        if(pastoPersonalizzato == false){
            tariffaBase = tariffaBase * numeroGiorni;
            if(numeroGiorni > 5){
                tariffaBase = (tariffaBase * 20) / 100;
            }
        }

        arrotondamento = Math.round(tariffaBase * 100) / 100;
        
        System.out.println("\nIl costo finale e' di " + arrotondamento + " euro.");
    }

}
