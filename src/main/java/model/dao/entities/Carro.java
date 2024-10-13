package model.dao.entities;

import model.Veiculo;

public class Carro extends Veiculo {

    public Carro() {
    }

    public Carro(int id, int ano, String modelo, String cor, double preco) {
        super(id, ano, modelo, cor, preco);
    }
}
