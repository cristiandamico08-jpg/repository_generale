import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.ArrayList;
import java.util.Scanner;

import classi.*;
import eccezioni.*;

public class Main {

    private Scanner scanner = new Scanner(System.in);

    private ArrayList<Medico> listaMedici = new ArrayList<>();
    private ArrayList<Paziente> listaPazienti = new ArrayList<>();

    private Medico medico1 = new Medico("Matteo", "Perrotti", "10a", "specializzazione1");
    private Medico medico2 = new Medico("Alessandro", "Colombo", "10b", "specializzazione2");

    private Paziente paziente1 = new Paziente("Gianmarco", "Tocco", "codiceFiscale1");
    private Paziente paziente2 = new Paziente("Mirko", "Cisco", "codiceFiscale2");

    private DateTimeFormatter formattazioneData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private DateTimeFormatter formattazioneOra = DateTimeFormatter.ofPattern("HH:mm");

    private String codiceFiscale;
    private String matricola;
    private String dataString;
    private LocalDate data;
    private String oraString;
    private LocalTime ora;
    private String diagnosi;
    private Visita visita = new Visita(null, null, null, null, null);
    private Paziente pazienteVuoto = new Paziente(null, null, null);
    private Medico medicoVuoto = new Medico(null, null, null, null);

    private BufferedWriter bufferedWriter = null;
    private BufferedReader bufferedReader = null;
    private String percorso;
    private String linea;

    public Main(){
        listaMedici.add(medico1);
        listaMedici.add(medico2);

        listaPazienti.add(paziente1);
        listaPazienti.add(paziente2);

        try {
            System.out.print("\n\nInserisci il Codice Fiscale del PAZIENTE: ");
            codiceFiscale = scanner.nextLine();
            
            for (Paziente p : listaPazienti) {
                if (p.getCodiceFiscale().equals(codiceFiscale)) {
                    pazienteVuoto = p;
                    break;
                }
            }
            if (pazienteVuoto.getNome() == null) {
                throw new PersonaNonTrovata();
            }

            System.out.print("Inserisci la Matricola del MEDICO: ");
            matricola = scanner.nextLine();

            for (Medico m : listaMedici) {
                if (m.getMatricola().equals(matricola)) {
                    medicoVuoto = m;
                    break;
                }
            }
            if (medicoVuoto.getNome() == null) {
                throw new PersonaNonTrovata();
            }

            System.out.print("Inserisci la Data della visita (gg/mm/aaaa): ");
            dataString = scanner.nextLine();
            data = LocalDate.parse(dataString, formattazioneData);

            System.out.print("Inserisci l'Ora della visita (hh:mm): ");
            oraString = scanner.nextLine();
            ora = LocalTime.parse(oraString, formattazioneOra);

            System.out.print("Inserisci la Diagnosi: ");
            diagnosi = scanner.nextLine();

            visita = new Visita(medicoVuoto, pazienteVuoto, diagnosi, data, ora);

            try {
                percorso = ("file/" + codiceFiscale + ".txt");
                bufferedWriter = new BufferedWriter(new FileWriter(percorso, true));
                bufferedWriter.write("Data: " + visita.getData().format(formattazioneData) + " " + visita.getOra().format(formattazioneOra) + " | Medico: Dott. " + visita.getMedico().getCognome() + " | Diagnosi: " + visita.getDiagnosi());
                bufferedWriter.newLine();
            } catch (IOException ex) {
                System.err.println("Errore: " + ex.getMessage());
            } finally {
                try {
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                } catch (IOException exc) {
                    System.err.println("Errore: " + exc.getMessage());
                }
            }

        } catch (PersonaNonTrovata e) {
            System.err.println("Errore: " + e.getMessage());
        }

        try {
            System.out.print("\n\nInserisci il Codice Fiscale del PAZIENTE: ");
            codiceFiscale = scanner.nextLine();
            percorso = ("file/" + codiceFiscale + ".txt");
            bufferedReader = new BufferedReader(new FileReader(percorso));
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Errore: <!> La persona non ha mai fatto visite <!>");
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ex) {
                System.err.println("Errore: " + ex.getMessage());
            }
        }

        System.out.println("\n\n");
        scanner.close();
    }
    public static void main(String[] args){
        new Main();
    }
}
