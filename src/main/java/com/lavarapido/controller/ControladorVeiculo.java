package com.lavarapido.controller;

import com.lavarapido.model.Veiculo;
import com.lavarapido.service.ServicoAgendamento;
import com.lavarapido.service.ServicoCliente;
import com.lavarapido.service.ServicoVeiculo;
import com.lavarapido.view.TelaVeiculo;
import javax.swing.JOptionPane;

/** Controla cadastro, edição e exclusão dos veículos dos clientes. */
public class ControladorVeiculo {
    private final TelaVeiculo view;
    private final ServicoVeiculo service;
    private final ServicoCliente clienteService;
    private final ServicoAgendamento agendamentoService;
    private final Runnable aoAlterarCadastro;

    public ControladorVeiculo(TelaVeiculo view, ServicoVeiculo service,
                             ServicoCliente clienteService, ServicoAgendamento agendamentoService,
                             Runnable aoAlterarCadastro) {
        this.view = view;
        this.service = service;
        this.clienteService = clienteService;
        this.agendamentoService = agendamentoService;
        this.aoAlterarCadastro = aoAlterarCadastro;

        view.getBtnSalvar().addActionListener(e -> cadastrar());
        view.getBtnAtualizar().addActionListener(e -> atualizar());
        view.getBtnExcluir().addActionListener(e -> excluir());
        view.getBtnLimpar().addActionListener(e -> view.limparCampos());
        view.getTabela().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) preencherCamposSelecionados();
        });
        atualizarClientes();
        atualizarTabela();
    }

    public void atualizarClientes() {
        view.definirClientes(clienteService.listarTodos());
    }

    private void cadastrar() {
        try {
            service.adicionar(view.getClienteSelecionado(), view.getPlaca());
            atualizarTabela();
            view.limparCampos();
            aoAlterarCadastro.run();
            mensagem("Veículo cadastrado com sucesso.");
        } catch (IllegalArgumentException ex) { erro(ex.getMessage()); }
    }

    private void atualizar() {
        int id = view.getIdSelecionado();
        if (id == -1) { erro("Selecione um veículo na tabela para atualizar."); return; }
        try {
            service.atualizar(id, view.getClienteSelecionado(), view.getPlaca());
            atualizarTabela();
            view.limparCampos();
            aoAlterarCadastro.run();
            mensagem("Veículo atualizado com sucesso.");
        } catch (IllegalArgumentException ex) { erro(ex.getMessage()); }
    }

    private void excluir() {
        int id = view.getIdSelecionado();
        if (id == -1) { erro("Selecione um veículo na tabela para excluir."); return; }
        if (agendamentoService.temAgendamentoAtivoParaVeiculo(id)) {
            erro("Não é possível excluir: o veículo possui agendamento ativo.");
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(view,
                "Deseja realmente excluir este veículo?", "Confirmar exclusão", JOptionPane.YES_NO_OPTION);
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
            Veiculo veiculo = service.buscarPorId(id);
            if (veiculo != null) view.preencherFormulario(veiculo);
        }
    }

    private void atualizarTabela() { view.exibirVeiculos(service.listarTodos()); }
    private void mensagem(String texto) { JOptionPane.showMessageDialog(view, texto); }
    private void erro(String texto) {
        JOptionPane.showMessageDialog(view, texto, "Atenção", JOptionPane.WARNING_MESSAGE);
    }
}
