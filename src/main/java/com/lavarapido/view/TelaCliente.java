package com.lavarapido.view;

import com.lavarapido.model.Cliente;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/** Interface gráfica do cadastro de clientes. */
public class TelaCliente extends JPanel {
    private final JTextField txtNome = new JTextField();
    private final JTextField txtCpf = new JTextField();
    private final JTextField txtTelefone = new JTextField();
    private final JTextField txtEmail = new JTextField();

    private final JButton btnSalvar = new JButton("Cadastrar");
    private final JButton btnAtualizar = new JButton("Atualizar");
    private final JButton btnExcluir = new JButton("Excluir");
    private final JButton btnLimpar = new JButton("Limpar");

    private final DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"ID", "Nome", "CPF", "Telefone", "E-mail"}, 0) {
        @Override public boolean isCellEditable(int row, int column) { return false; }
    };
    private final JTable tabela = new JTable(modelo);

    public TelaCliente() {
        setLayout(new BorderLayout(10, 10));
        JPanel formulario = new JPanel(new GridLayout(2, 4, 8, 5));
        formulario.setBorder(BorderFactory.createTitledBorder("Dados do cliente"));
        formulario.add(new JLabel("Nome"));
        formulario.add(new JLabel("CPF (somente números)"));
        formulario.add(new JLabel("Telefone (com DDD)"));
        formulario.add(new JLabel("E-mail"));
        formulario.add(txtNome);
        formulario.add(txtCpf);
        formulario.add(txtTelefone);
        formulario.add(txtEmail);

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

    public String getNome() { return txtNome.getText(); }
    public String getCpf() { return txtCpf.getText(); }
    public String getTelefone() { return txtTelefone.getText(); }
    public String getEmail() { return txtEmail.getText(); }
    public JButton getBtnSalvar() { return btnSalvar; }
    public JButton getBtnAtualizar() { return btnAtualizar; }
    public JButton getBtnExcluir() { return btnExcluir; }
    public JButton getBtnLimpar() { return btnLimpar; }
    public JTable getTabela() { return tabela; }

    public int getIdSelecionado() {
        int linha = tabela.getSelectedRow();
        return linha == -1 ? -1 : (int) modelo.getValueAt(linha, 0);
    }

    public void preencherFormulario(Cliente c) {
        txtNome.setText(c.getNome());
        txtCpf.setText(c.getCpf());
        txtTelefone.setText(c.getTelefone());
        txtEmail.setText(c.getEmail());
    }

    public void limparCampos() {
        txtNome.setText("");
        txtCpf.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        tabela.clearSelection();
        txtNome.requestFocus();
    }

    public void exibirClientes(List<Cliente> clientes) {
        modelo.setRowCount(0);
        for (Cliente c : clientes) {
            modelo.addRow(new Object[]{c.getId(), c.getNome(), c.getCpf(), c.getTelefone(), c.getEmail()});
        }
    }
}
