package lpii;

import java.util.ArrayList;

public class Hospital extends Local{
    private ArrayList<Cirurgico>cirurgicos = new ArrayList();
    private int qntDeMedicos;

    public Hospital(int qntDeMedicos, long cep) {
        super(cep);
        this.qntDeMedicos = qntDeMedicos;
    }

    public ArrayList<Cirurgico> getCirurgicos() {
        return cirurgicos;
    }

    public void setCirurgicos(ArrayList<Cirurgico> cirurgicos) {
        this.cirurgicos = cirurgicos;
    }

    public int getQntDeMedicos() {
        return qntDeMedicos;
    }

    public void setQntDeMedicos(int qntDeMedicos) {
        this.qntDeMedicos = qntDeMedicos;
    }    
}
