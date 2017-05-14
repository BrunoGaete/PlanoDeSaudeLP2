package lpii;

import java.util.ArrayList;

public class Ambulatorial extends Procedimento{
    private int qntDeTecnicos;
    private ArrayList<Clinica>clinicas = new ArrayList();

    public Ambulatorial(int qntDeTecnicos, String nome) {
        super(nome);
        this.qntDeTecnicos = qntDeTecnicos;
    }

    public ArrayList<Clinica> getClinicas() {
        return clinicas;
    }
    
    public void addClinica(Clinica clinicas) {
        this.clinicas.add(clinicas);
    }

    public void setClinicas(ArrayList<Clinica> clinicas) {
        this.clinicas = clinicas;
    }

    public int getQntDeTecnicos() {
        return qntDeTecnicos;
    }

    public void setQntDeTecnicos(int qntDeTecnicos) {
        this.qntDeTecnicos = qntDeTecnicos;
    }
}
