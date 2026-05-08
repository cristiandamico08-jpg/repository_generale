import java.util.ArrayList;

import Thread.*;

public class CentraleOperativa {

    private ArrayList<Integer> fondi = new ArrayList<>();
    private ArrayList<Integer> mappaZone = new ArrayList<>();

    private SegnaleRadio segnaleRadio = new SegnaleRadio();
    private RicercaDispersi ricercaDispersi = new RicercaDispersi(mappaZone);
    private EvacuzioneArea evacuzioneArea = new EvacuzioneArea();
    private CalcoloRisorse calcoloRisorse = new CalcoloRisorse(fondi);

    private Thread tSegnaleRadio = new Thread(segnaleRadio);
    private Thread tRicercaDispersi = new Thread(ricercaDispersi);
    private Thread tEvacuzioneArea = new Thread(evacuzioneArea);
    private Thread tCalcoloRisorse = new Thread(calcoloRisorse);

    public CentraleOperativa(){

        fondi.add(1000);
        fondi.add(2500);
        fondi.add(3000);
        fondi.add(1500);

        mappaZone.add(1);
        mappaZone.add(2);
        mappaZone.add(3);
        mappaZone.add(4);
        mappaZone.add(5);
        mappaZone.add(6);
        mappaZone.add(7);
        mappaZone.add(8);

        try {
            tSegnaleRadio.start();
            tRicercaDispersi.start();
            tEvacuzioneArea.start();
            tCalcoloRisorse.start();

            System.out.println("\nDati tRicerca:\nID: " + tRicercaDispersi.getId() + "\nStato: " + tRicercaDispersi.getState() + "\nPriorità: " + tRicercaDispersi.getPriority() + "\nisAlive(): " + tRicercaDispersi.isAlive());

            Thread.sleep(1000);

            tRicercaDispersi.interrupt();
            tSegnaleRadio.interrupt();

            tSegnaleRadio.join();
            tRicercaDispersi.join();
            tEvacuzioneArea.join();
            tCalcoloRisorse.join();

            System.out.println("\n\nReport Finale:\nTotale fondi calcolati: " + calcoloRisorse.getTotaleFondi() + "\nNumero totale di zone esplorate prima dello stop: " + ricercaDispersi.getZoneEsplorate());

        } catch (Exception e) {
            System.out.println("<!> Thread main interrotto <!>");
        }
    }

    public static void main(String[] args) {
        new CentraleOperativa();
    }
}