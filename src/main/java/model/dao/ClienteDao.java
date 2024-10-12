package model.dao;

import model.dao.entities.Cliente;

public interface ClienteDao {

    public void adicionarCliente(Cliente cliente);
    public void deletarClientePeloEmail(String email);
    public Cliente encontrarClientePorNome(String nome);
}
