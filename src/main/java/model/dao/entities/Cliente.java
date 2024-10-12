package model.dao.entities;

import model.Pessoa;

public class Cliente extends Pessoa {
    private String idCliente;

    public Cliente() {
    }

    public Cliente(int idade, String nome, String telefone, String email) {
        super(idade, nome, telefone, email);
    }

}
