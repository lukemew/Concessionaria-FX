package model.dao.entities;

public class Venda {

    private Carro carroId;
    private Cliente clienteId;
    private Vendedor vendedorId;
    private double valorTotal;

    public Venda(){
    }

    public Venda(Integer idVenda, Carro carroId, Cliente clienteId, Vendedor vendedorId, double valorTotal) {
        this.carroId = carroId;
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
    }


    public Carro getCarroId() {
        return carroId;
    }

    public void setCarroId(Carro carroId) {
        this.carroId = carroId;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }
}
