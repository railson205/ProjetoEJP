package com.example.Backend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

import com.example.Backend.CurrentUser;
import com.example.Backend.Historico;
import com.example.Design.ClienteDataFrame;
import com.example.Design.HomeFrames;
import com.example.Design.ProfissionalDataFrame;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

public class Notificacao {

    public Notificacao() {
        this.lista = new ArrayList<ArrayList>();
        this.listaInt = new ArrayList<Integer>();
    }

    /*
     * TODO: problem[0]=Id do cliente
     * problem[1]=Nome do cliente
     * problem[2]=Descrição sobre o problema
     * problem[3]=Id do profissional
     * problem[4]=Nome do profissional
     * problem[5]=Orçamento-c
     * problem[6]=Endereço do cliente-p
     * problem[7]=data inicial de disponibilidade-p
     * problem[8]=data final de disponibilidade do cliente-p
     * problem[9]=Confirmação de ida do profissional-c
     * problem[10]=Id do documento
     * problem[11]=se foi lido pelo cliente
     * problem[12]=se o cliente aceitou
     */
    private String idCliente;
    private ArrayList<ArrayList> lista;
    ArrayList<Integer> listaInt;
    JComboBox jcb;

    public void verificaMensagem(boolean cliente) throws Exception {
        this.idCliente = CurrentUser.uid;
        int op;
        Object objectAux;
        listaInt.clear();

        if (cliente) {

            do {
                attLista(cliente);

                if (lista.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Você tem " + lista.size() + " notificação(ões)");
                    op = 0;
                } else {
                    objectAux = JOptionPane.showInputDialog(null, "Você tem " + lista.size() + " notificação(ões)",
                            null,
                            JOptionPane.PLAIN_MESSAGE, null, listaInt.toArray(), null);
                    if (objectAux == null)
                        op = 0;
                    else
                        op = Integer.parseInt(String.valueOf(objectAux));
                }
                if (op <= lista.size() && op > 0) {
                    ArrayList<Object> mensagem = lista.get(op - 1);
                    if (mensagem.get(9) != null) {

                        confirmaDataIdaProfissional(mensagem);
                    } else if (mensagem.get(5) != null) {
                        // tem o orçamento
                        // JOptionPane.showMessageDialog(null, "Fornece data");

                        op = clienteForneceData(mensagem);
                    }
                }

            } while (op != 0 && op != -1);
        } else {
            do {
                attLista(cliente);

                // op=1;
                if (lista.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Você tem " + lista.size() + " notificação(ões)");
                    op = 0;
                } else {
                    objectAux = JOptionPane.showInputDialog(null, "Você tem " + lista.size() + " notificação(ões)",
                            null,
                            JOptionPane.PLAIN_MESSAGE, null, listaInt.toArray(), null);
                    if (objectAux == null)
                        op = 0;
                    else
                        op = Integer.parseInt(String.valueOf(objectAux));
                }

                if (op <= lista.size() && op > 0) {
                    ArrayList<Object> mensagem = lista.get(op - 1);
                    if (mensagem.get(8) != null && mensagem.get(9) == null) {
                        // tem a data para escolher de ir
                        // JOptionPane.showMessageDialog(null, "Escolhe data");
                        new ProfissionalDataFrame(mensagem).setVisible(true);
                        op = -1;
                    } else if (mensagem.get(5) == null) {
                        // tem q fornecer o orçamento

                        orcamento(mensagem);
                    }
                }

            } while (op != 0 && op != -1);

        }
        if (op == 0)
            new HomeFrames().setVisible(true);
    }

    private void attLista(boolean cliente) throws Exception {
        lista.clear();
        listaInt.clear();
        ApiFuture<QuerySnapshot> query = ConectaFirebase.bd.collection("contratação").get();

        if (cliente) {
            for (DocumentSnapshot doc : query.get().getDocuments()) {
                ArrayList<Object> aux = (ArrayList<Object>) doc.get("informações");
                if (aux.get(0).equals(idCliente) && aux.get(9) != null && !(boolean) aux.get(11)
                        && (boolean) aux.get(12)) {
                    // tem a confirmação da ida do profissional
                    lista.add(aux);
                } else if (aux.get(0).equals(idCliente) && aux.get(5) != null && aux.get(8) == null
                        && (boolean) aux.get(12)) {
                    // tem o orçamento
                    lista.add(aux);
                }
            }
        } else {
            for (DocumentSnapshot doc : query.get().getDocuments()) {
                ArrayList<Object> aux = (ArrayList<Object>) doc.get("informações");
                if (aux.get(3).equals(idCliente) && aux.get(8) != null && aux.get(9) == null && (boolean) aux.get(12)) {
                    // tem a data para escolher de ir
                    lista.add(aux);
                } else if (aux.get(3).equals(idCliente) && aux.get(5) == null) {
                    // tem q fornecer o orçamento
                    lista.add(aux);
                }
            }
        }
        for (int i = 1; i <= lista.size(); i++)
            listaInt.add(i);
    }

    private void confirmaDataIdaProfissional(ArrayList<Object> mensagem) {
        String dia = String.valueOf(mensagem.get(9)).substring(0, 10),
                hora = String.valueOf(mensagem.get(9)).substring(11);
        JOptionPane.showMessageDialog(null, "O profissional indicou que virá às " + hora + " do dia " + dia);
        mensagem.set(11, true);
        DocumentReference doc = ConectaFirebase.bd.collection("contratação").document((String) mensagem.get(10));
        doc.update("informações", mensagem);
        JOptionPane.showMessageDialog(null, "Mensagem atualizada");

    }

    // TODO: calendar
    private int clienteForneceData(ArrayList<Object> mensagem) {
        int op;

        op = JOptionPane.showConfirmDialog(null,
                String.format("O orçamento será de: R$ %.2f\nVocê aceitará esse serviço: ",
                        Double.parseDouble(String.valueOf(mensagem.get(5)))));
        /*
         * 0=sim
         * 1=não
         * 2=cancelar
         * -1=fechou
         */
        if (op == 0)// aceitou
        {
            new ClienteDataFrame(mensagem).setVisible(true);
            return -1;
        } else {
            mensagem.set(12, false);
            DocumentReference doc = ConectaFirebase.bd.collection("contratação").document((String) mensagem.get(10));
            doc.update("informações", mensagem);

            ArrayList<Object> aux = new ArrayList<Object>();
            aux.add(mensagem.get(0));
            aux.add(mensagem.get(1));
            aux.add(mensagem.get(3));
            aux.add(mensagem.get(4));
            new Historico().addHistorico((String) mensagem.get(0), false, aux);
            return 1;
        }

    }

    private void orcamento(ArrayList<Object> mensagem) {
        String s, message = "Forneça um orçamento para esse problema: " + (String) mensagem.get(2);
        Double orcamento = 0.0;
        do {
            s = JOptionPane.showInputDialog(null, message);
            if (s.matches("[0-9]+"))
                orcamento = Double.parseDouble(s);
            else
                message = "<html>Forneça um orçamento para esse problema: " + (String) mensagem.get(2)
                        + "<font color=#FF0000><br>Digite um valor válido ou retire a vírgula ou o ponto</font></html>";
        } while (!s.matches("[0-9]+"));
        // Double orcamento = sc.nextDouble();

        mensagem.set(5, orcamento * 1.1);
        DocumentReference doc = ConectaFirebase.bd.collection("contratação").document((String) mensagem.get(10));
        doc.update("informações", mensagem);
        JOptionPane.showMessageDialog(null, "Mensagem atualizada");

    }

}
