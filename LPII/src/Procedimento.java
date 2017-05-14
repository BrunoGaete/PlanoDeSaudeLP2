package lpii;

import java.util.ArrayList;

public class Procedimento {
    private ArrayList<PlanoDeSaude>planos = new ArrayList();
    private ArrayList<ItemDeProcedimento>itemDeProcedimentos = new ArrayList();
    private String nome;

    public Procedimento(String nome) {
        this.nome = nome;
    }

    public ArrayList<ItemDeProcedimento> getItemDeProcedimentos() {
        return itemDeProcedimentos;
    }

    public void setItemDeProcedimentos(ArrayList<ItemDeProcedimento> itemDeProcedimentos) {
        this.itemDeProcedimentos = itemDeProcedimentos;
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
