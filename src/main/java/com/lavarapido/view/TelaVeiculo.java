package com.lavarapido.view;

import com.lavarapido.model.Cliente;
import com.lavarapido.model.Veiculo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/** Tela para cadastrar vários veículos vinculados a um mesmo cliente. */
public class TelaVeiculo extends JPanel {
    private final JComboBox<Cliente> cbCliente = new JComboBox<>();
    private final JTextField txtPlaca = new JTextField();
    private final JButton btnSalvar = new JButton("Cadastrar veículo");
    private final JButton btnAtualizar = new JButton("Atualizar");
    private final JButton btnExcluir = new JButton("Excluir");
    private final JButton btnLimpar = new JButton("Limpar");

    private final DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"ID", "Cliente", "Placa do veículo"}, 0) {
        @Override public boolean isCellEditable(int row, int column) { return false; }
    };
    private final JTable tabela = new JTable(modelo);

    public TelaVeiculo() {
        setLayout(new BorderLayout(10, 10));
        JPanel formulario = new JPanel(new GridLayout(2, 2, 8, 5));
        formulario.setBorder(BorderFactory.createTitledBorder("Cadastro de veículo"));
        formulario.add(new JLabel("Cliente proprietário"));
        formulario.add(new JLabel("Placa do veículo"));
        formulario.add(cbCliente);
        formulario.add(txtPlaca);

        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        botoes.add(btnSalvar);
        botoes.add(btnAtualizar);
        botoes.add(btnExcluir);
        botoes.add(btnLimpar);
        JPanel topo = new JPanel(new BorderLayout());
        topo.add(formulario, BorderLayout.CENTER);
        topo.add(botoes, BorderLayout.SOUTH);

        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }

    public Cliente getClienteSelecionado() { return (Cliente) cbCliente.getSelectedItem(); }
    public String getPlaca() { return txtPlaca.getText(); }
    public JButton getBtnSalvar() { return btnSalvar; }
    public JButton getBtnAtualizar() { return btnAtualizar; }
    public JButton getBtnExcluir() { return btnExcluir; }
    public JButton getBtnLimpar() { return btnLimpar; }
    public JTable getTabela() { return tabela; }

    public int getIdSelecionado() {
        int linha = tabela.getSelectedRow();
        return linha == -1 ? -1 : (int) modelo.getValueAt(linha, 0);
    }

    public void definirClientes(List<Cliente> clientes) {
        DefaultComboBoxModel<Cliente> combo = new DefaultComboBoxModel<>();
        for (Cliente cliente : clientes) combo.addElement(cliente);
        cbCliente.setModel(combo);
    }

    public void preencherFormulario(Veiculo veiculo) {
        cbCliente.setSelectedItem(veiculo.getCliente());
        txtPlaca.setText(veiculo.getPlacaVeiculo());
    }

    public void limparCampos() {
        txtPlaca.setText("");
        tabela.clearSelection();
        if (cbCliente.getItemCount() > 0) cbCliente.setSelectedIndex(0);
        txtPlaca.requestFocus();
    }

    public void exibirVeiculos(List<Veiculo> veiculos) {
        modelo.setRowCount(0);
        for (Veiculo veiculo : veiculos) {
            modelo.addRow(new Object[]{veiculo.getId(), veiculo.getCliente().getNome(),
                    veiculo.getPlacaVeiculo()});
        }
    }
}

