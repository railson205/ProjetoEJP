package com.example.Backend;

public class HistDaoCliente {

public HistDaoCliente(String nomeProfissional, String dataHora, String idProfissional, String idDoc,
			boolean terminouServico, boolean avaliou) {
		super();
		this.nomeProfissional = nomeProfissional;
		this.dataHora = dataHora;
		this.idProfissional = idProfissional;
		this.idDoc = idDoc;
		this.terminouServico = terminouServico;
		this.avaliou = avaliou;
	}
private String nomeProfissional, dataHora,idProfissional,idDoc;
private boolean terminouServico,avaliou;


public String getIdProfissional() {
	return idProfissional;
}
public String getIdDoc() {
	return idDoc;
}


public String getNomeProfissional() {
	return nomeProfissional;
}
public void setNomeProfissional(String nomeProfissional) {
	this.nomeProfissional = nomeProfissional;
}
public String getDataHora() {
	return dataHora;
}

public String getData(){
return dataHora.substring(0,10);
}

public String getHora(){
return dataHora.substring(11);
}

public void setDataHora(String dataHora) {
	this.dataHora = dataHora;
}
public boolean isTerminouServico() {
	return terminouServico;
}
public void setTerminouServico(boolean terminouServico) {
	this.terminouServico = terminouServico;
}
public boolean isAvaliou() {
	return avaliou;
}
public void setAvaliou(boolean avaliou) {
	this.avaliou = avaliou;
}


}
