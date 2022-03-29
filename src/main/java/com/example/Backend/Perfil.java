package com.example.Backend;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

public class Perfil {

    public Perfil() {

    }

    private String id;

    // ambos
    public boolean trocaNome() throws Exception {
        Scanner sc = new Scanner(System.in);
        this.id = CurrentUser.uid;

        // procura na base de dados dod cliente
        ApiFuture<QuerySnapshot> query = ConectaFirebase.bd.collection("clientes").get();
        for (DocumentSnapshot doc : query.get().getDocuments()) {
            if (doc.getId().equals(id)) {
                Map<String, Object> params = doc.getData();
                System.out.println("Novo nome:");
                //String novoNome = sc.nextLine();
                String novoNome = "Juca Nonato";
                params.replace("nome", novoNome);
                DocumentReference docRef = ConectaFirebase.bd.collection("clientes").document(doc.getId());
                docRef.update(params);
                sc.close();
                return true;
            }

        }

        query = ConectaFirebase.bd.collection("profissionais").get();
        for (DocumentSnapshot doc : query.get().getDocuments()) {
            if (doc.getId().equals(id)) {
                Map<String, Object> params = doc.getData();
                System.out.println("Novo nome:");
                // String novoNome = sc.nextLine();
                String novoNome = "João Railson Costa";
                params.replace("nome", novoNome);
                DocumentReference docRef = ConectaFirebase.bd.collection("profissionais").document(doc.getId());
                docRef.update(params);
                sc.close();
                return true;
            }
        }
        sc.close();
        return false;
    }

    // ambos

    public boolean trocaSenha() throws Exception {
        Scanner sc = new Scanner(System.in);
        this.id = CurrentUser.uid;

        ApiFuture<QuerySnapshot> query = ConectaFirebase.bd.collection("clientes").get();
        for (DocumentSnapshot doc : query.get().getDocuments()) {
            if (doc.getId().equals(id)) {
                Map<String, Object> params = doc.getData();
                System.out.println("Senha antiga:");
                String senhaAntiga = "123456";//sc.nextLine();
                System.out.println("Nova senha:");
                String novaSenha = "1234567";//sc.nextLine();
                System.out.println("Confirmar nova senha:");
                String confirmaNovaSenha ="1234567";// sc.nextLine();

                if (senhaAntiga.equals(params.get("senha"))&&novaSenha.equals(confirmaNovaSenha)) {
                    params.replace("senha", novaSenha);
                    DocumentReference docRef = ConectaFirebase.bd.collection("clientes").document(doc.getId());
                    docRef.update(params);
                    sc.close();
                    return true;
                } else {
                    sc.close();
                    return false;
                }
            }

        }

        query = ConectaFirebase.bd.collection("profissionais").get();
        for (DocumentSnapshot doc : query.get().getDocuments()) {
            if (doc.getId().equals(id)) {
                Map<String, Object> params = doc.getData();
                System.out.println("Senha antiga:");
                String senhaAntiga = "132456";//sc.nextLine();
                System.out.println("Nova senha:");
                String novaSenha ="1234567"; //sc.nextLine();
                System.out.println("Confirmar nova senha:");
                String confirmaNovaSenha ="1234567";// sc.nextLine();
                // String novaSenha = "João Railson Costa";
                if (senhaAntiga.equals(params.get("senha"))&&novaSenha.equals(confirmaNovaSenha)) {
                    params.replace("senha", novaSenha);
                    DocumentReference docRef = ConectaFirebase.bd.collection("profissionais").document(doc.getId());
                    docRef.update(params);
                    sc.close();
                    return true;
                } else {
                    sc.close();
                    return false;
                }

            }
        }
        sc.close();
        return false;

    }

    // somente profissionais
    public void mostraAvaliacao() {

        this.id = CurrentUser.uid;
        ApiFuture<QuerySnapshot> query = ConectaFirebase.bd.collection("profissionais").get();

        try {
            for (DocumentSnapshot doc : query.get().getDocuments()) {
                if (doc.getId().equals(id)) {
                    System.out.println(doc.getLong("qtd avaliações") != null
                            ? String.format("Sua nota é de %.2f e conta com %d avaliações",
                                    doc.getDouble("avaliação") / doc.getLong("qtd avaliações"),
                                    doc.getLong("qtd avaliações"))
                            : "Você ainda não recebeu nenhuma avaliação");
                }

            }
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // somente profissionais
    public void faturamento() {
        this.id = CurrentUser.uid;
        ApiFuture<QuerySnapshot> query = ConectaFirebase.bd.collection("contratação").get();
        try {
            Double valor = 0.0;
            for (DocumentSnapshot doc : query.get().getDocuments()) {
                ArrayList<Object> result = (ArrayList<Object>) doc.get("informações");
                if (result.get(3).equals(id)) {
                    Double aux = ((Long) result.get(5)).doubleValue();
                    valor += aux;
                }

            }
            System.out.println(String.format("Seu faturamento foi de: R$%.2f", (valor * 0.909095)));
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private String getNome(boolean cliente, String id) throws Exception {
        String nome = "";
        if (cliente) {
            ApiFuture<QuerySnapshot> query = ConectaFirebase.bd.collection("clientes").get();

            for (DocumentSnapshot doc : query.get().getDocuments()) {
                if (doc.getId().equals(id))
                    return (String) doc.get("nome");
            }
        } else {
            ApiFuture<QuerySnapshot> query = ConectaFirebase.bd.collection("profissionais").get();

            for (DocumentSnapshot doc : query.get().getDocuments()) {
                if (doc.getId().equals(id))
                    return (String) doc.get("nome");
            }
        }
        return nome;
    }
}
