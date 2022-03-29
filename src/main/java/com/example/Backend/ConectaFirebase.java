package com.example.Backend;

import java.io.FileInputStream;
import java.util.ArrayList;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.*;

public class ConectaFirebase {


    public static Firestore bd;
    public static ArrayList<ArrayList> lista = new ArrayList<ArrayList>();
    public static CurrentUser currentUser = new CurrentUser();

    public static void conectarDB() {
        try {

            FileInputStream serviceAccount = new FileInputStream("teste.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            bd = FirestoreClient.getFirestore();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public boolean inserirDadosProfissional(
            String nomeSobrenome, String email, String descricao, String senha,
            ArrayList<String> profissoes) throws Exception {
        ApiFuture<QuerySnapshot> query = bd.collection("profissionais").get();

        for (DocumentSnapshot doc : query.get().getDocuments()) {
            if (doc.get("email").equals(email))
                return false;
        }
        query = bd.collection("clientes").get();

        for (DocumentSnapshot doc : query.get().getDocuments()) {
            if (doc.get("email").equals(email))
                return false;
        }

        try {
            String uid = java.util.UUID.randomUUID().toString();
            DocumentReference docRef = bd.collection("profissionais").document(uid);
            docRef.set(new CrudProfissional().cadastroProfissional(nomeSobrenome, email, descricao, senha, profissoes));
            currentUser.setInfo(uid,nomeSobrenome, false);
            // ApiFuture<WriteResult> result =
            new ProfissionalManager().attListaProfissionais();
            return true;
        } catch (Exception e) {
        }
        new CurrentUser();
        return false;
    }

    public boolean inserirDadosCliente(
            String nomeSobrenome, String email, String senha) throws Exception {

        // Verifica no banco de dados se ja tem alguma conta com o email que será
        // adicionado
        ApiFuture<QuerySnapshot> query = bd.collection("clientes").get();

        for (DocumentSnapshot doc : query.get().getDocuments()) {
            if (doc.get("email").equals(email))
                return false;
        }
        query = bd.collection("profissionais").get();

        for (DocumentSnapshot doc : query.get().getDocuments()) {
            if (doc.get("email").equals(email))
                return false;
        }
        // tentativa de adicionar o cliente no banco de dados
        try {
            String uid = java.util.UUID.randomUUID().toString();
            DocumentReference docRef = bd.collection("clientes").document(uid);
            docRef.set(new CrudCliente().cadastroCliente(nomeSobrenome, email, senha));
            currentUser.setInfo(uid,nomeSobrenome, true);

            // ApiFuture<WriteResult> result =
            return true;
        } catch (Exception e) {
        }
        new CurrentUser();
        return false;
    }

    public boolean login(String email, String senha) throws Exception {
        ApiFuture<QuerySnapshot> query = bd.collection("profissionais").get();
        for (DocumentSnapshot doc : query.get().getDocuments()) {
            if (doc.get("email").equals(email) && doc.get("senha").equals(senha)) {
                currentUser.setInfo(doc, false);
                return true;
            }
        }

        query = bd.collection("clientes").get();
        for (DocumentSnapshot doc : query.get().getDocuments()) {
            if (doc.get("email").equals(email) && doc.get("senha").equals(senha)) {
                currentUser.setInfo(doc, true);
                return true;
            }
        }
        new CurrentUser();
        return false;
    }

    public static void logOut() {
        new CurrentUser();
    }

}
