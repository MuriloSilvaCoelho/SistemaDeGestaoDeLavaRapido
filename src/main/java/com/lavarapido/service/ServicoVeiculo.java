package com.lavarapido.service;

import com.lavarapido.model.Cliente;
import com.lavarapido.model.Veiculo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Regras de negócio e armazenamento temporário dos veículos. */
public class ServicoVeiculo {
    private final List<Veiculo> veiculos = new ArrayList<>();
    private int proximoId = 1;

    public List<Veiculo> listarTodos() {
        return Collections.unmodifiableList(new ArrayList<>(veiculos));
    }

    public List<Veiculo> listarPorCliente(int clienteId) {
        List<Veiculo> resultado = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getCliente().getId() == clienteId) resultado.add(veiculo);
        }
        return resultado;
    }

    public Veiculo buscarPorId(int id) {
        return veiculos.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
    }

    public Veiculo adicionar(Cliente cliente, String placaVeiculo) {
        validar(cliente, placaVeiculo);
        String placa = normalizarPlaca(placaVeiculo);
        verificarPlacaDisponivel(placa, -1);
        Veiculo veiculo = new Veiculo(proximoId++, cliente, placa);
        veiculos.add(veiculo);
        return veiculo;
    }

    public void atualizar(int id, Cliente cliente, String placaVeiculo) {
        Veiculo veiculo = buscarPorId(id);
        if (veiculo == null) throw new IllegalArgumentException("Veículo não encontrado.");
        validar(cliente, placaVeiculo);
        String placa = normalizarPlaca(placaVeiculo);
        verificarPlacaDisponivel(placa, id);
        veiculo.setCliente(cliente);
        veiculo.setPlacaVeiculo(placa);
    }

    public void excluir(int id) {
        Veiculo veiculo = buscarPorId(id);
        if (veiculo == null) throw new IllegalArgumentException("Veículo não encontrado.");
        veiculos.remove(veiculo);
    }

    public boolean temVeiculosParaCliente(int clienteId) {
        return veiculos.stream().anyMatch(v -> v.getCliente().getId() == clienteId);
    }

    private void validar(Cliente cliente, String placaVeiculo) {
        if (cliente == null) {
            throw new IllegalArgumentException("Selecione o cliente proprietário do veículo.");
        }
        if (placaVeiculo == null || placaVeiculo.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe a placa do veículo.");
        }
        String placa = normalizarPlaca(placaVeiculo);
        boolean placaAntiga = placa.matches("[A-Z]{3}[0-9]{4}");
        boolean placaMercosul = placa.matches("[A-Z]{3}[0-9][A-Z0-9][0-9]{2}");
        if (!placaAntiga && !placaMercosul) {
            throw new IllegalArgumentException("Informe uma placa válida (ex.: ABC1234 ou ABC1D23).");
        }
    }

    private void verificarPlacaDisponivel(String placa, int idIgnorado) {
        boolean duplicada = veiculos.stream().anyMatch(v ->
                v.getId() != idIgnorado && v.getPlacaVeiculo().equals(placa));
        if (duplicada) throw new IllegalArgumentException("Essa placa já está cadastrada.");
    }

    private String normalizarPlaca(String placa) {
        return placa == null ? "" : placa.trim().replaceAll("\\s", "").toUpperCase();
    }
}
