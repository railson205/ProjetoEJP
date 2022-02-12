public class Profissional extends Pessoa{
	private String profissao,descricao;
	
    public Profissional() {
		super();
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Nome: "+getNome()+", profissão: "+getProfissao()+", descrição: "+getDescricao();
	}
    
    
    
	
}
