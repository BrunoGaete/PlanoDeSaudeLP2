package lpii;

import java.util.ArrayList;

public class Local {
    private long cep;
    private ArrayList<Autorizacao>autorizacoes = new ArrayList();

    public Local(long cep) {
        this.cep = cep;
    }

    public long getCep() {
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public ArrayList<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(ArrayList<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }   
}
