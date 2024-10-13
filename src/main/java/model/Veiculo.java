package model;

public class Veiculo {
    private int id;
    private int ano;
    private String modelo;
    private String cor;
    private double preco;


    public Veiculo() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Veiculo(int id, int ano, String modelo, String cor, double preco) {
        this.id = id;
        this.ano = ano;
        this.modelo = modelo;
        this.cor = cor;
        this.preco = preco;

    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

}
