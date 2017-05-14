package lpii;

import java.util.ArrayList;

public class Cirurgico extends Procedimento{
    private int qntMedicos;
    private ArrayList<Hospital>hopitais = new ArrayList();

    public Cirurgico(int qntMedicos, String nome) {
        super(nome);
        this.qntMedicos = qntMedicos;
    }

    public int getQntMedicos() {
        return qntMedicos;
    }

    public void setQntMedicos(int qntMedicos) {
        this.qntMedicos = qntMedicos;
    }

    public ArrayList<Hospital> getHopitais() {
        return hopitais;
    }

    public void setHopitais(ArrayList<Hospital> hopitais) {
        this.hopitais = hopitais;
    }   
}
