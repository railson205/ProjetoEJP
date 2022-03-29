package com.example.Backend;

import java.util.*;

import javax.swing.JOptionPane;

import com.example.Design.HistClienteFrame;
import com.example.Design.HistProfissionalFrame;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

public class Historico {

    public Historico() {
        this.data = new HashMap<String, Object>();
    }

    private Map<String, Object> data;

    /*
     * 0=id cliente
     * 1=nome do cliente
     * 2=id profissional
     * 3=nome do profissional
     * 4=data e horário da ida do profissional
     * 5=endereço do cliente
     * 6=Descrição do problema
     * 7=Orçamento
     * 
     * 8=se aceitou
     * 9=se o profissional terminou o trabalho
     * 10=se foi lido
     * 11=entregou a avaliação
     * 12=id do documento
     */
    public void addHistorico(String id, boolean aceita, ArrayList<Object> aux) {

        if (id.equals(aux.get(0)) || id.equals(aux.get(1))) {
            String uid = java.util.UUID.randomUUID().toString();
            ArrayList<Object> listaHistorico = aux;
            if (aceita) {
                listaHistorico.add(true);
                listaHistorico.add(false);
                listaHistorico.add(false);
                listaHistorico.add(false);
                listaHistorico.add(uid);
            } else {
                listaHistorico.add(null);
                listaHistorico.add(null);
                listaHistorico.add(null);
                listaHistorico.add(false);
                listaHistorico.add(null);
                listaHistorico.add(false);
                listaHistorico.add(null);
                listaHistorico.add(uid);

                // System.out.println("Sim");
            }
            data.clear();
            data.put("informações", listaHistorico);
            DocumentReference doc = ConectaFirebase.bd.collection("histórico").document(uid);
            doc.set(data);
        }

    }

    public void mostaHistorico(String id, boolean cliente) throws Exception {
        ApiFuture<QuerySnapshot> query = ConectaFirebase.bd.collection("histórico").get();
        boolean aceita;
        ArrayList<Object> lista = new ArrayList<Object>();
        ArrayList<HistDaoCliente> histCliente = new ArrayList<HistDaoCliente>();
        ArrayList<HistDaoProfissional> histProfissional = new ArrayList<HistDaoProfissional>();

        for (DocumentSnapshot doc : query.get().getDocuments()) {
            // se id fornecido for igual ao id que está na lista e se o trabalho for aceito
            lista = (ArrayList<Object>) doc.get("informações");
            aceita = (boolean) (lista).get(8);
            if (id.equals((lista).get(0)) && aceita) {
                histCliente.add(new HistDaoCliente(String.valueOf(lista.get(3)),String.valueOf(lista.get(5)),String.valueOf(lista.get(2)),String.valueOf(lista.get(12)),(boolean)lista.get(9),(boolean)lista.get(11)));
                System.out.println("Nome do profissional: " + (lista).get(3));
                System.out.println(
                        "Data e horário de ida do profissional: " + (lista).get(5));
                System.out.println(
                        ((boolean) (lista).get(9))
                                ? "O profissional já terminou o trabalho"
                                : "O profissional ainda não terminou o trabalho");
                // aba de avaliação
                if (!(boolean) (lista).get(11) && (boolean) (lista).get(9)) {
                    lista.set(11, true);
                    lista.set(10, false);
                    ConectaFirebase.bd.collection("histórico").document((String) lista.get(12)).update("informações",
                            lista);
                    //new Avaliacao(lista.get(2),String.valueOf(lista.get(12)));
                }

            } else if (id.equals((lista).get(2))) {
                if ((boolean) lista.get(8)) {
                    if (!(boolean) lista.get(9)) {
                        int op = JOptionPane.showConfirmDialog(null,
                                "Informe se você já terminou o trabalho do dia " + lista.get(5) + " no endereço "
                                        + lista.get(4));
                        // se tiver terminado o trabalho
                        // TODO: selecionar true ou false
                        if (op == 0) {
                            lista.set(9, true);
                            lista.set(10, false);
                            ConectaFirebase.bd.collection("histórico").document((String) lista.get(12))
                                    .update("informações", lista);
                        }
                    } else {
                        histProfissional.add(new HistDaoProfissional(String.valueOf(lista.get(1)),
                                String.valueOf(lista.get(6)), String.valueOf(lista.get(7)),
                                String.valueOf(lista.get(5)), String.valueOf(lista.get(4)),String.valueOf(lista.get(12)),(boolean)lista.get(9)));

                    }
                } else
                    System.out.println(
                            "O cliente " + (lista).get(1) + " não quis o trabalho");
            }

            // se não tiver sido lido, altera para lido
            if (lista.get(10).equals(false)) {
                lista.set(10, true);
                ConectaFirebase.bd.collection("histórico").document((String) lista.get(12)).update("informações",
                        lista);
            }

        }

    }

}
