package com.lavarapido.controller;

import com.lavarapido.model.Agendamento;
import com.lavarapido.model.TipoServico;
import com.lavarapido.model.Veiculo;
import com.lavarapido.service.ServicoAgendamento;
import com.lavarapido.service.ServicoTipoServico;
import com.lavarapido.service.ServicoVeiculo;
import com.lavarapido.view.TelaAgenda;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/** Controla os eventos de criação, edição, cancelamento e consulta da agenda. */
public class ControladorAgendamento {
    private final TelaAgenda view;
    private final ServicoAgendamento service;
    private final ServicoVeiculo veiculoService;
    private final ServicoTipoServico tipoServicoService;
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ControladorAgendamento(TelaAgenda view, ServicoAgendamento service,
                                 ServicoVeiculo veiculoService, ServicoTipoServico tipoServicoService) {
        this.view = view;
        this.service = service;
        this.veiculoService = veiculoService;
        this.tipoServicoService = tipoServicoService;

        view.getBtnAgendar().addActionListener(e -> agendar());
        view.getBtnAtualizar().addActionListener(e -> atualizar());
        view.getBtnCancelar().addActionListener(e -> cancelar());
        view.getBtnLimpar().addActionListener(e -> view.limparCampos());
        view.getBtnDia().addActionListener(e -> filtrarDia());
        view.getBtnSemana().addActionListener(e -> filtrarSemana());
        view.getBtnTodos().addActionListener(e -> atualizarTabela());
        view.getTabela().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) preencherCamposSelecionados();
        });
        atualizarCombos();
        atualizarTabela();
    }

    public void atualizarCombos() {
        view.definirVeiculos(veiculoService.listarTodos());
        view.definirServicos(tipoServicoService.listarTodos());
    }

    private void agendar() {
        try {
            Veiculo veiculo = view.getVeiculoSelecionado();
            TipoServico servico = view.getServicoSelecionado();
            service.agendar(veiculo, servico, view.getDataHoraSelecionada());
            atualizarTabela();
            view.limparCampos();
            mensagem("Agendamento realizado com sucesso.");
        } catch (IllegalArgumentException ex) { erro(ex.getMessage()); }
    }

    private void atualizar() {
        int id = view.getIdSelecionado();
        if (id == -1) { erro("Selecione um agendamento na tabela para atualizar."); return; }
        try {
            service.atualizar(id, view.getVeiculoSelecionado(),
                    view.getServicoSelecionado(), view.getDataHoraSelecionada());
            atualizarTabela();
            view.limparCampos();
            mensagem("Agendamento atualizado com sucesso.");
        } catch (IllegalArgumentException ex) { erro(ex.getMessage()); }
    }

    private void cancelar() {
        int id = view.getIdSelecionado();
        if (id == -1) { erro("Selecione um agendamento na tabela para cancelar."); return; }
        int resposta = JOptionPane.showConfirmDialog(view,
                "Deseja cancelar o agendamento selecionado?", "Confirmar cancelamento", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                service.cancelar(id);
                atualizarTabela();
                view.limparCampos();
                mensagem("Agendamento cancelado.");
            } catch (IllegalArgumentException ex) { erro(ex.getMessage()); }
        }
    }

    private void preencherCamposSelecionados() {
        int id = view.getIdSelecionado();
        if (id != -1) {
            Agendamento agendamento = service.buscarPorId(id);
            if (agendamento != null) view.preencherFormulario(agendamento);
        }
    }

    private LocalDate lerDataFiltro() {
        String texto = view.getDataFiltro();
        if (texto.isEmpty()) return LocalDate.now();
        try { return LocalDate.parse(texto, FORMATO_DATA); }
        catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Digite a data no formato dd/MM/aaaa.");
        }
    }

    private void filtrarDia() {
        try { view.exibirAgendamentos(service.listarPorDia(lerDataFiltro())); }
        catch (IllegalArgumentException ex) { erro(ex.getMessage()); }
    }

    private void filtrarSemana() {
        try { view.exibirAgendamentos(service.listarPorSemana(lerDataFiltro())); }
        catch (IllegalArgumentException ex) { erro(ex.getMessage()); }
    }

    private void atualizarTabela() { view.exibirAgendamentos(service.listarTodos()); }
    private void mensagem(String texto) { JOptionPane.showMessageDialog(view, texto); }
    private void erro(String texto) {
        JOptionPane.showMessageDialog(view, texto, "Atenção", JOptionPane.WARNING_MESSAGE);
    }
}
