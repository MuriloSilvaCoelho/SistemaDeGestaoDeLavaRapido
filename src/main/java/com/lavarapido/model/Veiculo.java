package com.lavarapido.model;

/**
 * Representa um veículo pertencente a um cliente.
 * A placa fica nesta classe, permitindo vários veículos para o mesmo cliente.
 */
public class Veiculo {
    private final int id;
    private Cliente cliente;
    private String placaVeiculo;

    public Veiculo(int id, Cliente cliente, String placaVeiculo) {
        this.id = id;
        this.cliente = cliente;
        this.placaVeiculo = placaVeiculo;
    }

    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public String getPlacaVeiculo() { return placaVeiculo; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setPlacaVeiculo(String placaVeiculo) { this.placaVeiculo = placaVeiculo; }

    @Override
    public String toString() {
        return placaVeiculo + " - " + cliente.getNome();
    }
}
