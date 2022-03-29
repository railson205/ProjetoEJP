package com.example.Design;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.example.Backend.HistDaoCliente;

public class ListaHistCliente extends AbstractTableModel {

    String[] colunas = { "Nome do profissional", "Dia", "Hora", "Serviço terminado", "Avaliou" };
    ArrayList<HistDaoCliente> lista;

    public ListaHistCliente(ArrayList<HistDaoCliente> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return colunas.length;
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        // TODO Auto-generated method stub
        switch (coluna) {
            case 0:
                return lista.get(linha).getNomeProfissional();
            case 1:
                return lista.get(linha).getData();
            case 2:
                return lista.get(linha).getHora();
            case 3:
            if(lista.get(linha).isTerminouServico())
                return "Terminou";
                else return "Ainda não terminou";
            case 4:if(lista.get(linha).isAvaliou())
                return "Já foi avaliado";
                else return "Não foi avaliado";
        }
        return null;
    }

    public String getIdProfissional(int index){
        return lista.get(index).getIdProfissional();
    }

    public String getIdDoc(int index){
        return lista.get(index).getIdDoc();
    }
    public String getTeste(int index){
        return lista.get(index).getIdDoc();
    }

    public boolean isServicoTerminado(int index){
        return lista.get(index).isTerminouServico();
    }

    public boolean isAvaliou(int index){
        return lista.get(index).isAvaliou();
    }

}
