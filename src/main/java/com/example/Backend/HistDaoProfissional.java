package com.example.Backend;

public class HistDaoProfissional {


	public HistDaoProfissional(String nomeCliente, String descProblema, Double orcamento, String dataHora,
			String endereco, String idDoc, boolean terminado) {
		super();
		this.nomeCliente = nomeCliente;
		this.descProblema = descProblema;
		this.orcamento = orcamento;
		this.dataHora = dataHora;
		this.endereco = endereco;
		this.idDoc = idDoc;
		this.terminado = terminado;
	}

	private String nomeCliente,descProblema,dataHora,endereco,idDoc;
	private Double orcamento;
	private boolean terminado;

	//id do documento e se o serviço foi terminado

	public String getIdDoc() {
		return idDoc;
	}

	public boolean isTerminado() {
		return terminado;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getDescProblema() {
		return descProblema;
	}

	public void setDescProblema(String descProblema) {
		this.descProblema = descProblema;
	}

	public Double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Double orcamento) {
		this.orcamento = orcamento;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
    
}
