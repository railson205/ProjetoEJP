package com.example.Backend;

import java.util.*;

public class CrudProfissional {

    public CrudProfissional() {
        super();
        this.data = new HashMap<String, Object>();
    }

    private String nomeSobrenome;
    private String email;
    private String descricao;
    private String senha;
    private ArrayList<String> profissoes;
    private Map<String, Object> data;

    public void setInfo(ArrayList<Object>dados) {
        setNomeSobrenome(nomeSobrenome);
        setEmail(email);
        setDescricao(descricao);
        setProfissoes(profissoes);
        setSenha(senha);
    }

    public Map<String, Object> cadastroProfissional(String nomeSobrenome, String email, String descricao, String senha,
            ArrayList<String> profissoes) {
        //setInfo(nomeSobrenome, email, descricao, senha, profissoes);
        data.put("nome", nomeSobrenome);
        data.put("email",email);
        data.put("descrição",descricao);
        data.put("senha",senha);
        data.put("profissões",profissoes);
        data.put("avaliação",null);
        data.put("qtd avaliações",null);
        return data;
    }

    public String getNomeSobrenome() {
        return nomeSobrenome;
    }

    public void setNomeSobrenome(String nomeSobrenome) {
        this.nomeSobrenome = nomeSobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<String> getProfissoes() {
        return profissoes;
    }

    public void setProfissoes(ArrayList<String> profissoes) {
        this.profissoes = profissoes;
    }

    public String getSenha(){
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
