package com.example.Backend;

import java.util.*;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

public class Contrata {



    // TODO: problem[0]=Id do cliente
    // TODO: problem[1]=Nome do cliente
    // TODO: problem[2]=Descrição sobre o problema
    // TODO: problem[3]=Id do profissional
    // TODO: problem[4]=Nome do profissional
    // TODO: problem[5]=Orçamento
    // TODO: problem[6]=Endereço do cliente
    // TODO: problem[7]=Tempo disponível para o cliente
    // TODO: problem[8][1-3]=hora,data inicial e data
    // TODO: problem[9]=Confirmação de ida do profissional
    // TODO: problem[10]=Dia final de disponibilidade do cliente


    public void pedido(String idCliente,String idProfissional,String descDoProblema) {
        try {
            ArrayList<Object> list = new ArrayList<Object>();
            Map<String, Object> data = new HashMap<String, Object>();


            String uid = java.util.UUID.randomUUID().toString();
            DocumentReference docRef = ConectaFirebase.bd.collection("contratação").document(uid);
            String nomeCliente = getNome(true,idCliente);
            String nomeProfissional = getNome(false,idProfissional);

            list.add(idCliente);
            list.add(nomeCliente);
            list.add(descDoProblema);
            list.add(idProfissional);
            list.add(nomeProfissional);
            list.add(null);
            list.add(null);
            list.add(null);
            list.add(null);
            list.add(null);
            list.add(uid);
            list.add(false);
            list.add(true);
            
            data.put("informações", list);
            docRef.set(data);

        } catch (Exception e) {
        }
    }

    private String getNome(boolean cliente,String id) throws Exception {
        String nome = "";
        if(cliente){
            ApiFuture<QuerySnapshot> query = ConectaFirebase.bd.collection("clientes").get();

            for (DocumentSnapshot doc : query.get().getDocuments()) {
                if (doc.getId().equals(id))
                return (String) doc.get("nome");
            }
        }else{
            ApiFuture<QuerySnapshot> query = ConectaFirebase.bd.collection("profissionais").get();

        for (DocumentSnapshot doc : query.get().getDocuments()) {
            if (doc.getId().equals(id))
                return (String) doc.get("nome");
        }
        }
        return nome;
    }

}
