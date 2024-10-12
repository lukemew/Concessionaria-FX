package model.dao.entities;

import model.Veiculo;

public class Carro extends Veiculo {
    private double valor;

    public Carro() {
    }

    public Carro(int ano, String modelo, String cor, double valor) {
        super(ano, modelo, cor);
        this.valor = valor;
    }
}
