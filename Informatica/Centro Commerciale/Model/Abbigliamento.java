package Model;

import Exceptions.ValoreScontoException;

public class Abbigliamento extends Negozio {
    public Abbigliamento(String nome, Prodotto... p){
        super(nome, p);
    }

    public void applicaSaldi(int percentuale) throws ValoreScontoException{
        if (percentuale < 0 || percentuale > 100) {
            throw new ValoreScontoException();
        }

        for (Prodotto prodotto : super.getProdotti()) {
            double prezzo = prodotto.getPrezzo() - ((percentuale * prodotto.getPrezzo()) / 100);
            double arrotondamento = Math.round(prezzo * 100) / 100;
            prodotto.setPrezzo(arrotondamento);
        }
    }

    @Override
    public void stampaDettagli(){
        //
    }
}
