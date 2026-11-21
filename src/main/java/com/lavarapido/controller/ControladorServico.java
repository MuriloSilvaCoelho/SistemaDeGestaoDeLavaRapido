package com.lavarapido.controller;

import com.lavarapido.model.TipoServico;
import com.lavarapido.service.ServicoAgendamento;
import com.lavarapido.service.ServicoTipoServico;
import com.lavarapido.view.TelaServico;
import javax.swing.JOptionPane;

/**
 * Controla os eventos da tela de tipos de serviço.
 */
public class ControladorServico {
    private final TelaServico view;
    private final ServicoTipoServico service;
    private final ServicoAgendamento agendamentoService;
    private final Runnable aoAlterarCadastro;

    public ControladorServico(TelaServico view, ServicoTipoServico service,
                             ServicoAgendamento agendamentoService,
                             Runnable aoAlterarCadastro) {
        this.view = view;
        this.service = service;
        this.agendamentoService = agendamentoService;
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

    private double lerPreco() {
        try {
            return Double.parseDouble(view.getPreco().trim().replace(",", "."));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Informe um preço válido. Exemplo: 35,00.");
        }
    }

    private void cadastrar() {
        try {
            service.adicionar(view.getNome(), view.getDescricao(), lerPreco());
            atualizarTabela();
            view.limparCampos();
            aoAlterarCadastro.run();
            mensagem("Serviço cadastrado com sucesso.");
        } catch (IllegalArgumentException ex) {
            erro(ex.getMessage());
        }
    }

    private void atualizar() {
        int id = view.getIdSelecionado();
        if (id == -1) {
            erro("Selecione um serviço na tabela para atualizar.");
            return;
        }
        try {
            service.atualizar(id, view.getNome(), view.getDescricao(), lerPreco());
            atualizarTabela();
            view.limparCampos();
            aoAlterarCadastro.run();
            mensagem("Serviço atualizado com sucesso.");
        } catch (IllegalArgumentException ex) {
            erro(ex.getMessage());
        }
    }

    private void excluir() {
        int id = view.getIdSelecionado();
        if (id == -1) {
            erro("Selecione um serviço na tabela para excluir.");
            return;
        }
        if (agendamentoService.temAgendamentoAtivoParaServico(id)) {
            erro("Não é possível excluir: esse serviço possui agendamento ativo.");
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(view,
                "Deseja realmente excluir este serviço?", "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION);
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
            TipoServico servico = service.buscarPorId(id);
            if (servico != null) view.preencherFormulario(servico);
        }
    }

    private void atualizarTabela() {
        view.exibirServicos(service.listarTodos());
    }

    private void mensagem(String texto) {
        JOptionPane.showMessageDialog(view, texto);
    }

    private void erro(String texto) {
        JOptionPane.showMessageDialog(view, texto, "Atenção", JOptionPane.WARNING_MESSAGE);
    }
}
