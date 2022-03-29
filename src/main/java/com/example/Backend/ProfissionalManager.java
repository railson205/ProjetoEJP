package com.example.Backend;

import java.util.ArrayList;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

public class ProfissionalManager {
    public ArrayList<ArrayList> attListaProfissionais() {
        ConectaFirebase.lista.clear();
        ApiFuture<QuerySnapshot> query = ConectaFirebase.bd.collection("profissionais").get();

        try {
            for (DocumentSnapshot doc : query.get().getDocuments()) {
                ArrayList<Object> aux = new ArrayList<Object>();
                aux.add(doc.getId());
                aux.add(doc.get("nome"));
                aux.add(doc.get("descrição"));
                aux.add(doc.get("profissões"));
                aux.add(doc.get("avaliação"));
                aux.add(doc.get("qtd avaliações"));
                ConectaFirebase.lista.add(aux);
            }
            return ConectaFirebase.lista;
        } catch (Exception e) {
            System.out.println("Erro em pegar os documentos da query");
            //TODO: handle exception
        }
        return null;
    }

    public void mostraProfissionais(){
        attListaProfissionais();
        ConectaFirebase.lista.forEach((n) -> System.out.println(n.toString()));
    }

    public void procuraProfissional(String nomeProcura) {
        try {
            attListaProfissionais();
        } catch (Exception e) {
            System.out.println("Erro atualizar a lista de profissionais");
            //TODO: handle exception
        }
        //verifica se a lista está vazia
        if (!ConectaFirebase.lista.isEmpty()) {
            //lista para guardar os índeces dos profissionais que tenham a profissão de procura
            ArrayList<Integer> b = new ArrayList<Integer>();
            for (int i = 0; i < ConectaFirebase.lista.size(); i++) {
                ArrayList<ArrayList> aux = ConectaFirebase.lista.get(i);
                for (int j = 0; j < aux.get(3).size(); j++) {
                    if (((String) aux.get(3).get(j)).toLowerCase().contains(nomeProcura)) 
                        b.add(i);
                    
                }
            }

            ArrayList<ArrayList> aux = new ArrayList<ArrayList>();
            b.forEach((n) -> aux.add(ConectaFirebase.lista.get(n)));

            ConectaFirebase.lista = aux;
        }
    }

    public void procuraProfissional(ArrayList<String> lista) {
        try {
            attListaProfissionais();
        } catch (Exception e) {
            System.out.println("Erro atualizar a lista de profissionais");
            //TODO: handle exception
        }
        if (!ConectaFirebase.lista.isEmpty()&&!lista.isEmpty()) {
            ArrayList<Integer> b = new ArrayList<Integer>();
        //pega tds os documentos
            for (int i = 0; i < ConectaFirebase.lista.size(); i++) {
                ArrayList<ArrayList> aux = ConectaFirebase.lista.get(i);
                //pega as listas dos profissionais
                for (int j = 0; j < aux.get(3).size(); j++) {
                    for(String s : lista){
                        if (((String) aux.get(3).get(j)).contains(s)&&!b.contains(i)) 
                            b.add(i);
                        
                    }
                }
            }
            ArrayList<ArrayList> aux = new ArrayList<ArrayList>();
            b.forEach((n) -> aux.add(ConectaFirebase.lista.get(n)));

            ConectaFirebase.lista = aux;
        }
    }
}
