package lpii;

import java.util.ArrayList;

public class PlanoDeSaude {

    private ArrayList<Segurado> segurados = new ArrayList();
    private ArrayList<Procedimento> procedimentos = new ArrayList();
    private String nome;
    private long numAut;

    public PlanoDeSaude(String nome, long numAut) {
        this.nome = nome;
        this.numAut = numAut;
    }

    public ArrayList<Segurado> getSegurados() {
        return segurados;
    }
    
    public void addSegurado(Segurado segurados) {
        this.segurados.add(segurados);
    }
    
    public void addProcedimento(Procedimento procedimentos) {
        this.procedimentos.add(procedimentos);
    }
    
    public void setSegurados(ArrayList<Segurado> segurados) {
        this.segurados = segurados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getNumAut() {
        return numAut;
    }

    public void setNumAut(long numAut) {
        this.numAut = numAut;
    }
}
