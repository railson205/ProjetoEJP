package com.example.Backend;

import java.util.*;

public class CrudCliente {

    public CrudCliente() {
        super();
        this.data = new HashMap<String, Object>();
    }

    private String nomeSobrenome;
    private String email;
    private String senha;
    private Map<String, Object> data;

    public void setInfo(String nomeSobrenome, String email,String senha) {
        setNomeSobrenome(nomeSobrenome);
        setEmail(email);
        setSenha(senha);
    }

    public Map<String, Object> cadastroCliente(String nomeSobrenome, String email,String senha) {
        setInfo(nomeSobrenome, email,senha);
        data.put("nome", this.nomeSobrenome);
        data.put("email", this.email);
        data.put("senha",this.senha);
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

    public String getSenha(){
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
