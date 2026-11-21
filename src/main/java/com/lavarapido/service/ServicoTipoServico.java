package com.lavarapido.service;

import com.lavarapido.model.TipoServico;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Regras de negócio e armazenamento temporário dos tipos de serviço.
 */
public class ServicoTipoServico {
    private final List<TipoServico> servicos = new ArrayList<>();
    private int proximoId = 1;

    public List<TipoServico> listarTodos() {
        return Collections.unmodifiableList(new ArrayList<>(servicos));
    }

    public TipoServico buscarPorId(int id) {
        return servicos.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public TipoServico adicionar(String nome, String descricao, double preco) {
        validar(nome, descricao, preco);
        TipoServico servico = new TipoServico(proximoId++, nome.trim(),
                descricao.trim(), preco);
        servicos.add(servico);
        return servico;
    }

    public void atualizar(int id, String nome, String descricao, double preco) {
        TipoServico servico = buscarPorId(id);
        if (servico == null) {
            throw new IllegalArgumentException("Serviço não encontrado.");
        }
        validar(nome, descricao, preco);
        servico.setNome(nome.trim());
        servico.setDescricao(descricao.trim());
        servico.setPreco(preco);
    }

    public void excluir(int id) {
        TipoServico servico = buscarPorId(id);
        if (servico == null) {
            throw new IllegalArgumentException("Serviço não encontrado.");
        }
        servicos.remove(servico);
    }

    private void validar(String nome, String descricao, double preco) {
        if (nome == null || nome.trim().isEmpty()
                || descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe o nome e a descrição do serviço.");
        }
        if (!Double.isFinite(preco) || preco <= 0) {
            throw new IllegalArgumentException("O preço deve ser um número maior que zero.");
        }
    }
}
