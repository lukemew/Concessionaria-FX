package model.dao.entities;

import model.Veiculo;

public class Carro extends Veiculo {

    public Carro() {
    }

    public Carro( int ano, String modelo, String cor, double preco) {
        super( ano, modelo, cor, preco);
    }
}
