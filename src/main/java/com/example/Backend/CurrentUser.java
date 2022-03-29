package com.example.Backend;

import com.google.cloud.firestore.DocumentSnapshot;

public class CurrentUser {

	public CurrentUser() {
		setUid(null);
		setNome(null);
	}


	public static String uid;
	public static boolean cliente;
	public static String nome;


	public void setUid(String uid) {
		this.uid = uid;
	}

	public boolean getCliente() {
		return this.cliente;
	}

	public void setCliente(boolean cliente) {
		this.cliente= cliente;
	}

	public void setInfo(DocumentSnapshot doc,boolean cliente){
		setUid(doc.getId());
		setNome(doc.getString("nome"));
		setCliente(cliente);
	}

	public void setInfo(String id,String nome,boolean cliente){
		setUid(id);
		setNome(nome);
		setCliente(cliente);
	}

	public void setNome(String nome){
		this.nome= nome;
	}

}
