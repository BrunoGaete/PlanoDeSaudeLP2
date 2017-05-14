package lpii;

import java.util.ArrayList;

public class Autorizacao {
    private String data;
    private ArrayList<ItemDeProcedimento>itenDeProcedimentos = new ArrayList();

    public Autorizacao() {
    }    

    public ArrayList<ItemDeProcedimento> getItenDeProcedimentos() {
        return itenDeProcedimentos;
    }

    public void setItenDeProcedimentos(ArrayList<ItemDeProcedimento> itenDeProcedimentos) {
        this.itenDeProcedimentos = itenDeProcedimentos;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
