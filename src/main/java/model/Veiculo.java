package model;

public class Veiculo {
    private int ano;
    private String modelo;
    private String cor;
  // Novo atributo para preço

    public Veiculo() {}

    public Veiculo(int ano, String modelo, String cor) {
        this.ano = ano;
        this.modelo = modelo;
        this.cor = cor;

    }

    // Getters e Setters
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
