package com.lavarapido.controller;

import com.lavarapido.model.Cliente;
import com.lavarapido.service.ServicoCliente;
import com.lavarapido.service.ServicoVeiculo;
import com.lavarapido.view.TelaCliente;
import javax.swing.JOptionPane;

/** Recebe os eventos da tela de clientes e aciona as regras de negócio. */
public class ControladorCliente {
    private final TelaCliente view;
    private final ServicoCliente service;
    private final ServicoVeiculo veiculoService;
    private final Runnable aoAlterarCadastro;

    public ControladorCliente(TelaCliente view, ServicoCliente service,
                             ServicoVeiculo veiculoService, Runnable aoAlterarCadastro) {
        this.view = view;
        this.service = service;
        this.veiculoService = veiculoService;
        this.aoAlterarCadastro = aoAlterarCadastro;

        view.getBtnSalvar().addActionListener(e -> cadastrar());
        view.getBtnAtualizar().addActionListener(e -> atualizar());
        view.getBtnExcluir().addActionListener(e -> excluir());
        view.getBtnLimpar().addActionListener(e -> view.limparCampos());
        view.getTabela().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) preencherCamposSelecionados();
        });
        atualizarTabela();
    }

    private void cadastrar() {
        try {
            service.adicionar(view.getNome(), view.getCpf(), view.getTelefone(), view.getEmail());
            atualizarTabela();
            view.limparCampos();
            aoAlterarCadastro.run();
            mensagem("Cliente cadastrado com sucesso.");
        } catch (IllegalArgumentException ex) { erro(ex.getMessage()); }
    }

    private void atualizar() {
        int id = view.getIdSelecionado();
        if (id == -1) { erro("Selecione um cliente na tabela para atualizar."); return; }
        try {
            service.atualizar(id, view.getNome(), view.getCpf(), view.getTelefone(), view.getEmail());
            atualizarTabela();
            view.limparCampos();
            aoAlterarCadastro.run();
            mensagem("Cliente atualizado com sucesso.");
        } catch (IllegalArgumentException ex) { erro(ex.getMessage()); }
    }

    private void excluir() {
        int id = view.getIdSelecionado();
        if (id == -1) { erro("Selecione um cliente na tabela para excluir."); return; }
        if (veiculoService.temVeiculosParaCliente(id)) {
            erro("Não é possível excluir este cliente enquanto houver veículos vinculados. Exclua os veículos primeiro.");
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(view,
                "Deseja realmente excluir este cliente?", "Confirmar exclusão", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            service.excluir(id);
            atualizarTabela();
            view.limparCampos();
            aoAlterarCadastro.run();
        }
    }

    private void preencherCamposSelecionados() {
        int id = view.getIdSelecionado();
        if (id != -1) {
            Cliente cliente = service.buscarPorId(id);
            if (cliente != null) view.preencherFormulario(cliente);
        }
    }

    private void atualizarTabela() { view.exibirClientes(service.listarTodos()); }
    private void mensagem(String texto) { JOptionPane.showMessageDialog(view, texto); }
    private void erro(String texto) {
        JOptionPane.showMessageDialog(view, texto, "Atenção", JOptionPane.WARNING_MESSAGE);
    }
}
