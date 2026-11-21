package com.lavarapido.service;

import com.lavarapido.model.Cliente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Regras de negócio e armazenamento temporário dos clientes. */
public class ServicoCliente {
    private final List<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;

    public List<Cliente> listarTodos() {
        return Collections.unmodifiableList(new ArrayList<>(clientes));
    }

    public Cliente buscarPorId(int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public Cliente adicionar(String nome, String cpf, String telefone, String email) {
        validarDados(nome, cpf, telefone, email);
        String cpfLimpo = somenteNumeros(cpf);
        boolean cpfExiste = clientes.stream().anyMatch(c -> c.getCpf().equals(cpfLimpo));
        if (cpfExiste) {
            throw new IllegalArgumentException("Já existe um cliente cadastrado com esse CPF.");
        }

        Cliente cliente = new Cliente(proximoId++, nome.trim(), cpfLimpo,
                somenteNumeros(telefone), email.trim());
        clientes.add(cliente);
        return cliente;
    }

    public void atualizar(int id, String nome, String cpf, String telefone, String email) {
        Cliente cliente = buscarPorId(id);
        if (cliente == null) throw new IllegalArgumentException("Cliente não encontrado.");

        validarDados(nome, cpf, telefone, email);
        String cpfLimpo = somenteNumeros(cpf);
        boolean cpfDeOutroCliente = clientes.stream()
                .anyMatch(c -> c.getCpf().equals(cpfLimpo) && c.getId() != id);
        if (cpfDeOutroCliente) {
            throw new IllegalArgumentException("Esse CPF já pertence a outro cliente.");
        }

        cliente.setNome(nome.trim());
        cliente.setCpf(cpfLimpo);
        cliente.setTelefone(somenteNumeros(telefone));
        cliente.setEmail(email.trim());
    }

    public void excluir(int id) {
        Cliente cliente = buscarPorId(id);
        if (cliente == null) throw new IllegalArgumentException("Cliente não encontrado.");
        clientes.remove(cliente);
    }

    private void validarDados(String nome, String cpf, String telefone, String email) {
        if (nome == null || nome.trim().isEmpty()
                || cpf == null || cpf.trim().isEmpty()
                || telefone == null || telefone.trim().isEmpty()
                || email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Preencha todos os campos do cliente.");
        }
        if (!somenteNumeros(cpf).matches("\\d{11}")) {
            throw new IllegalArgumentException("O CPF deve conter 11 números.");
        }
        if (!somenteNumeros(telefone).matches("\\d{10,11}")) {
            throw new IllegalArgumentException("O telefone deve conter DDD e 8 ou 9 dígitos.");
        }
        if (!email.trim().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Informe um e-mail válido.");
        }
    }

    private String somenteNumeros(String valor) {
        return valor == null ? "" : valor.replaceAll("\\D", "");
    }
}
