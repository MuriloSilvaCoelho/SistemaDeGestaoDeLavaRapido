package com.lavarapido;

import com.lavarapido.controller.ControladorAgendamento;
import com.lavarapido.controller.ControladorCliente;
import com.lavarapido.controller.ControladorServico;
import com.lavarapido.controller.ControladorVeiculo;
import com.lavarapido.service.ServicoAgendamento;
import com.lavarapido.service.ServicoCliente;
import com.lavarapido.service.ServicoTipoServico;
import com.lavarapido.service.ServicoVeiculo;
import com.lavarapido.view.TelaAgenda;
import com.lavarapido.view.TelaCliente;
import com.lavarapido.view.TelaServico;
import com.lavarapido.view.TelaVeiculo;
import javax.swing.*;

/** Ponto de entrada da aplicação. */
public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                // Se não for possível aplicar o visual do sistema, usa o padrão do Swing.
            }

            // Os serviços são compartilhados entre as telas durante a execução.
            ServicoCliente clienteService = new ServicoCliente();
            ServicoVeiculo veiculoService = new ServicoVeiculo();
            ServicoTipoServico tipoServicoService = new ServicoTipoServico();
            ServicoAgendamento agendamentoService = new ServicoAgendamento();

            TelaCliente clienteView = new TelaCliente();
            TelaVeiculo veiculoView = new TelaVeiculo();
            TelaServico servicoView = new TelaServico();
            TelaAgenda agendaView = new TelaAgenda();

            ControladorAgendamento agendaController = new ControladorAgendamento(
                    agendaView, agendamentoService, veiculoService, tipoServicoService);
            ControladorVeiculo veiculoController = new ControladorVeiculo(
                    veiculoView, veiculoService, clienteService, agendamentoService,
                    agendaController::atualizarCombos);

            new ControladorCliente(clienteView, clienteService, veiculoService, () -> {
                veiculoController.atualizarClientes();
                agendaController.atualizarCombos();
            });
            new ControladorServico(servicoView, tipoServicoService, agendamentoService,
                    agendaController::atualizarCombos);

            JTabbedPane abas = new JTabbedPane();
            abas.addTab("Clientes", clienteView);
            abas.addTab("Veículos", veiculoView);
            abas.addTab("Tipos de serviço", servicoView);
            abas.addTab("Agenda", agendaView);

            JFrame janela = new JFrame("Sistema de Controle - Lava Rápido");
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janela.setContentPane(abas);
            janela.setSize(1100, 680);
            janela.setLocationRelativeTo(null);
            janela.setVisible(true);
        });
    }
}
