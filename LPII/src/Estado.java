package lpii;

import java.util.ArrayList;

public class Estado {
    private ArrayList<Autorizacao> autorizacoes = new ArrayList();

    public Estado() {
    }

    public ArrayList<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(ArrayList<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }
    
    public void addAutorizacao(Autorizacao autorizacoes){
        this.autorizacoes.add(autorizacoes);
    }
    
    public enum EstadoEnum{
        PENDENTE("PENDENTE"), AUTORIZADO("AUTORIZADO"), NEGADO("NEGADO");
        public String estado = "PENDENTE";
        
        EstadoEnum(String estado){
            this.estado = estado;
        }        
    }
}
