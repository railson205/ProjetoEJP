package com.example.Backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import com.example.Design.HomeFrames;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

public class Avaliacao {

    public Avaliacao(Object idProfissional, String idDoc, Double rating) {
        avalia((String) idProfissional, idDoc, rating);
    }

    private void avalia(String idProfissional, String idDoc, Double rating) {
        Map<String, Object> params = new HashMap<String, Object>();
        ApiFuture<QuerySnapshot> queryPro = ConectaFirebase.bd.collection("profissionais").get();
        ApiFuture<QuerySnapshot> queryHist = ConectaFirebase.bd.collection("histórico").get();
        ArrayList aux;
        try {
            for (DocumentSnapshot doc : queryHist.get().getDocuments()) {
                if (doc.getId().equals(idDoc)){
                    aux = (ArrayList) doc.get("informações");
                    aux.set(11, true);
                    DocumentReference docRef = ConectaFirebase.bd.collection("histórico")
                            .document(idDoc);
                    docRef.update("informações", aux);
                }
            }

            for (DocumentSnapshot doc : queryPro.get().getDocuments()) {
                if (doc.getId().equals(idProfissional)) {
                    params = doc.getData();

                    if (doc.get("avaliação") == null) {
                        params.replace("avaliação", rating);
                        params.replace("qtd avaliações", 1);
                    } else {
                        Double avalAux = Double.parseDouble(params.get("avaliação").toString());
                        params.replace("avaliação", avalAux + rating);

                        Double qtdAux = Double.parseDouble(params.get("qtd avaliações").toString());
                        params.replace("qtd avaliações", qtdAux + 1);
                    }

                    DocumentReference docRef = ConectaFirebase.bd.collection("profissionais")
                            .document(idProfissional);
                    docRef.update(params);
                    JOptionPane.showMessageDialog(null, "Avaliação enviada");
                    new HomeFrames().setVisible(true);
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
