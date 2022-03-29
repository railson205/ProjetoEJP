/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Design;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import com.example.Backend.ConectaFirebase;
import com.example.Backend.ProfissionalManager;

/**
 *
 * @author Rason
 */
public class ListaTableModel extends AbstractTableModel {

    private ArrayList<ArrayList> lista = new ArrayList<ArrayList>();
    private String[] colunas = { "Nome", "Profissões", "Descrição", "Avaliação", "Id" };

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    @Override
    public int getRowCount() {
        lista = ConectaFirebase.lista;
        return lista.size();

    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch (coluna) {
            case 0:
                return lista.get(linha).get(1);
            case 1:

                return String.join(", ", (ArrayList<String>) lista.get(linha).get(3));
            case 2:
                return lista.get(linha).get(2);
            case 3:
                if (lista.get(linha).get(4) == null) {
                    return "-";
                } else {
                    Double value = Double.parseDouble(lista.get(linha).get(4).toString())
                            / Double.parseDouble(lista.get(linha).get(5).toString());
                    return String.format("%.2f", value);
                }
            case 4:
                return lista.get(linha).get(0);
        }

        /*
         * switch(coluna){
         * case 0: return dados[linha][coluna];
         * case 1: return dados[linha][coluna];
         * case 2: return dados[linha][coluna];
         * case 3: return dados[linha][coluna];
         * case 4: return dados[linha][coluna];
         * }
         */

        return null;
    }

}
