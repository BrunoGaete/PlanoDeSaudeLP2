package lpii;

import java.util.ArrayList;

public class Operadora {
    
    private ArrayList<PlanoDeSaude>planos = new ArrayList();
    private String nome;

    public Operadora(String nome) {
        this.nome = nome;
    }
    
    public void addPlano(PlanoDeSaude planos) {
        this.planos.add(planos);
    }

    public ArrayList<PlanoDeSaude> getPlanos() {
        return planos;
    }

    public void setPlanos(ArrayList<PlanoDeSaude> planos) {
        this.planos = planos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
