package classi;

import java.time.*;

public class Visita {
    private Medico medico;
    private Paziente paziente;
    private String diagnosi;
    private LocalDate data;
    private LocalTime ora;

    public Visita(Medico medico, Paziente paziente, String diagnosi, LocalDate data, LocalTime ora){
        this.medico = medico;
        this.paziente = paziente;
        this.diagnosi = diagnosi;
        this.data = data;
        this.ora = ora;
    }

    public Medico getMedico(){
        return medico;
    }

    public Paziente getPaziente(){
        return paziente;
    }

    public String getDiagnosi() {
        return diagnosi;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setMedico(Medico medico){
        this.medico = medico;
    }

    public void setPaziente(Paziente paziente){
        this.paziente = paziente;
    }

    public void setDiagnosi(String diagnosi) {
        this.diagnosi = diagnosi;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }
}
