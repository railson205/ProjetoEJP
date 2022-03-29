package com.example.Design;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.example.Backend.HistDaoProfissional;

public class ListaHistProf extends AbstractTableModel {

    String[] colunas = { "Nome do cliente", "Descrição do problema", "Orçamento", "Dia", "Hora", "Endereço",
            "Terminou" };
    ArrayList<HistDaoProfissional> lista;

    public ListaHistProf(ArrayList<HistDaoProfissional> lista) {
        this.lista = lista;
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
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
    public Object getValueAt(int linha, int coluna) {
        // TODO Auto-generated method stub
        switch (coluna) {
            case 0:
                return lista.get(linha).getNomeCliente();
            case 1:
                return lista.get(linha).getDescProblema();
            case 2:
                return String.format("R$ %.2f", lista.get(linha).getOrcamento());
            case 3:
                return lista.get(linha).getDataHora().substring(0, 10);
            case 4:
                return lista.get(linha).getDataHora().substring(11);
            case 5:
                return lista.get(linha).getEndereco();
            case 6:
            if(lista.get(linha).isTerminado())
                return"Terminado";
                else return "Não terminou";

            default:
                return null;
        }
    }

    public boolean isTerminado(int index) {
        return lista.get(index).isTerminado();
    }

    public String getIdDoc(int index){
        return lista.get(index).getIdDoc();
    }

}
