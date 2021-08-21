package com.example.cadastro.model;

public class Formulario {
    private String nome;
    private String telefone;
    private String email;
    private boolean listaEmails;
    private String sexo;
    private String cidade;
    private String uf;

    public Formulario(String nome, String telefone, String email, boolean listaEmails, String sexo, String cidade, String uf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.listaEmails = listaEmails;
        this.sexo = sexo;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isListaEmails() {
        return listaEmails;
    }

    public void setListaEmails(boolean listaEmails) {
        this.listaEmails = listaEmails;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Formulario{\n" +
                "nome=" + nome + '\n' +
                "telefone=" + telefone + '\n' +
                "email=" + email + '\n' +
                "listaEmails=" + listaEmails + '\n' +
                "sexo=" + sexo + '\n' +
                "cidade=" + cidade + '\n' +
                "uf=" + uf + '\n' +
                '}';
    }
}
