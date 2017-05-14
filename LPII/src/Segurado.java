
package lpii;

import java.util.ArrayList;

public class Segurado {
    
    private ArrayList<PlanoDeSaude>planos = new ArrayList();
    private ArrayList<Autorizacao>autorizacoes = new ArrayList();
    private String nome;
    private long cpf;

    public Segurado(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public ArrayList<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(ArrayList<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
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

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
}
