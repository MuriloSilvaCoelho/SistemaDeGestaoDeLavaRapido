package com.lavarapido.view;

import com.lavarapido.model.Agendamento;
import com.lavarapido.model.TipoServico;
import com.lavarapido.model.Veiculo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/** Interface gráfica da agenda de serviços. */
public class TelaAgenda extends JPanel {
    private final JComboBox<Veiculo> cbVeiculo = new JComboBox<>();
    private final JComboBox<TipoServico> cbServico = new JComboBox<>();
    private final JSpinner spDataHora = new JSpinner(
            new SpinnerDateModel(new Date(), null, null, java.util.Calendar.MINUTE));
    private final JTextField txtDataFiltro = new JTextField(10);
    private final JButton btnAgendar = new JButton("Agendar");
    private final JButton btnAtualizar = new JButton("Atualizar");
    private final JButton btnCancelar = new JButton("Cancelar agendamento");
    private final JButton btnLimpar = new JButton("Limpar");
    private final JButton btnDia = new JButton("Ver dia");
    private final JButton btnSemana = new JButton("Ver semana");
    private final JButton btnTodos = new JButton("Ver todos");

    private final DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"ID", "Cliente", "Placa", "Serviço", "Data e hora", "Status"}, 0) {
        @Override public boolean isCellEditable(int row, int column) { return false; }
    };
    private final JTable tabela = new JTable(modelo);
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public TelaAgenda() {
        setLayout(new BorderLayout(10, 10));
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spDataHora, "dd/MM/yyyy HH:mm");
        spDataHora.setEditor(editor);

        JPanel formulario = new JPanel(new GridLayout(2, 3, 8, 5));
        formulario.setBorder(BorderFactory.createTitledBorder("Novo agendamento ou edição"));
        formulario.add(new JLabel("Veículo (placa - cliente)"));
        formulario.add(new JLabel("Tipo de serviço"));
        formulario.add(new JLabel("Data e hora (dd/MM/aaaa HH:mm)"));
        formulario.add(cbVeiculo);
        formulario.add(cbServico);
        formulario.add(spDataHora);

        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        botoes.add(btnAgendar);
        botoes.add(btnAtualizar);
        botoes.add(btnCancelar);
        botoes.add(btnLimpar);

        JPanel filtros = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filtros.setBorder(BorderFactory.createTitledBorder("Consultar agenda"));
        filtros.add(new JLabel("Data (dd/MM/aaaa):"));
        filtros.add(txtDataFiltro);
        filtros.add(btnDia);
        filtros.add(btnSemana);
        filtros.add(btnTodos);

        JPanel topo = new JPanel(new BorderLayout());
        topo.add(formulario, BorderLayout.NORTH);
        topo.add(botoes, BorderLayout.CENTER);
        topo.add(filtros, BorderLayout.SOUTH);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }

    public Veiculo getVeiculoSelecionado() { return (Veiculo) cbVeiculo.getSelectedItem(); }
    public TipoServico getServicoSelecionado() { return (TipoServico) cbServico.getSelectedItem(); }
    public JButton getBtnAgendar() { return btnAgendar; }
    public JButton getBtnAtualizar() { return btnAtualizar; }
    public JButton getBtnCancelar() { return btnCancelar; }
    public JButton getBtnLimpar() { return btnLimpar; }
    public JButton getBtnDia() { return btnDia; }
    public JButton getBtnSemana() { return btnSemana; }
    public JButton getBtnTodos() { return btnTodos; }
    public JTable getTabela() { return tabela; }
    public String getDataFiltro() { return txtDataFiltro.getText().trim(); }

    public LocalDateTime getDataHoraSelecionada() {
        Date data = (Date) spDataHora.getValue();
        return LocalDateTime.ofInstant(data.toInstant(), ZoneId.systemDefault());
    }

    public int getIdSelecionado() {
        int linha = tabela.getSelectedRow();
        return linha == -1 ? -1 : (int) modelo.getValueAt(linha, 0);
    }

    public void definirVeiculos(List<Veiculo> veiculos) {
        DefaultComboBoxModel<Veiculo> combo = new DefaultComboBoxModel<>();
        for (Veiculo veiculo : veiculos) combo.addElement(veiculo);
        cbVeiculo.setModel(combo);
    }

    public void definirServicos(List<TipoServico> servicos) {
        DefaultComboBoxModel<TipoServico> combo = new DefaultComboBoxModel<>();
        for (TipoServico servico : servicos) combo.addElement(servico);
        cbServico.setModel(combo);
    }

    public void preencherFormulario(Agendamento agendamento) {
        cbVeiculo.setSelectedItem(agendamento.getVeiculo());
        cbServico.setSelectedItem(agendamento.getTipoServico());
        Date data = Date.from(agendamento.getDataHora().atZone(ZoneId.systemDefault()).toInstant());
        spDataHora.setValue(data);
    }

    public void limparCampos() {
        tabela.clearSelection();
        spDataHora.setValue(new Date());
        if (cbVeiculo.getItemCount() > 0) cbVeiculo.setSelectedIndex(0);
        if (cbServico.getItemCount() > 0) cbServico.setSelectedIndex(0);
    }

    public void exibirAgendamentos(List<Agendamento> agendamentos) {
        modelo.setRowCount(0);
        for (Agendamento a : agendamentos) {
            modelo.addRow(new Object[]{a.getId(), a.getVeiculo().getCliente().getNome(),
                    a.getVeiculo().getPlacaVeiculo(), a.getTipoServico().getNome(),
                    a.getDataHora().format(FORMATO), a.getStatus().getDescricao()});
        }
    }
}
