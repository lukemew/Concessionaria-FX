package model;

public class Pessoa {
    private int idade;
    private String nome;
    private String telefone;
    private String email;

    public Pessoa() {
    }

    public Pessoa(int idade, String nome, String telefone, String email) {
        this.idade = idade;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
