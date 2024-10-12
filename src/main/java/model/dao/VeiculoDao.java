package model.dao;

import model.Veiculo;

import java.util.List;

public interface VeiculoDao {

    public Veiculo encontrarVeiculoPorModelo(String modelo);
    public void deletarVeiculoPelaCor(String modelo);
    public void adicionarVeiculo(Veiculo veiculo);

    List<Veiculo> buscarTodosVeiculos();

    public void atualizarVeiculo(Veiculo veiculo);
}
