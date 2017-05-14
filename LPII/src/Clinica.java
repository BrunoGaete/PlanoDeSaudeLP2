package lpii;

import java.util.ArrayList;

public class Clinica extends Local{
    private String medicoResponsavel;
    private ArrayList<Ambulatorial>ambulatoria = new ArrayList();

    public Clinica(String medicoResponsavel, long cep) {
        super(cep);
        this.medicoResponsavel = medicoResponsavel;
    }

    public String getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(String medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    public ArrayList<Ambulatorial> getAmbulatoria() {
        return ambulatoria;
    }

    public void setAmbulatoria(ArrayList<Ambulatorial> ambulatoria) {
        this.ambulatoria = ambulatoria;
    }    
}
