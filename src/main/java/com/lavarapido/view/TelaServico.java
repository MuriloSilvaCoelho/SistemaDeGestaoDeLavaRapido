package com.lavarapido.view;

import com.lavarapido.model.TipoServico;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Interface gráfica do cadastro de tipos de serviço.
 */
public class TelaServico extends JPanel {
    private final JTextField txtNome = new JTextField();
    private final JTextField txtDescricao = new JTextField();
    private final JTextField txtPreco = new JTextField();

    private final JButton btnSalvar = new JButton("Cadastrar");
    private final JButton btnAtualizar = new JButton("Atualizar");
    private final JButton btnExcluir = new JButton("Excluir");
    private final JButton btnLimpar = new JButton("Limpar");

    private final DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"ID", "Nome", "Descrição", "Preço (R$)"}, 0) {
        @Override public boolean isCellEditable(int row, int column) { return false; }
    };
    private final JTable tabela = new JTable(modelo);

    public TelaServico() {
        setLayout(new BorderLayout(10, 10));

        JPanel formulario = new JPanel(new GridLayout(2, 3, 8, 5));
        formulario.setBorder(BorderFactory.createTitledBorder("Dados do serviço"));
        formulario.add(new JLabel("Nome"));
        formulario.add(new JLabel("Descrição"));
        formulario.add(new JLabel("Preço"));
        formulario.add(txtNome);
        formulario.add(txtDescricao);
        formulario.add(txtPreco);

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
    public String getDescricao() { return txtDescricao.getText(); }
    public String getPreco() { return txtPreco.getText(); }

    public JButton getBtnSalvar() { return btnSalvar; }
    public JButton getBtnAtualizar() { return btnAtualizar; }
    public JButton getBtnExcluir() { return btnExcluir; }
    public JButton getBtnLimpar() { return btnLimpar; }
    public JTable getTabela() { return tabela; }

    public int getIdSelecionado() {
        int linha = tabela.getSelectedRow();
        return linha == -1 ? -1 : (int) modelo.getValueAt(linha, 0);
    }

    public void preencherFormulario(TipoServico s) {
        txtNome.setText(s.getNome());
        txtDescricao.setText(s.getDescricao());
        txtPreco.setText(String.valueOf(s.getPreco()));
    }

    public void limparCampos() {
        txtNome.setText("");
        txtDescricao.setText("");
        txtPreco.setText("");
        tabela.clearSelection();
        txtNome.requestFocus();
    }

    public void exibirServicos(List<TipoServico> servicos) {
        modelo.setRowCount(0);
        for (TipoServico s : servicos) {
            modelo.addRow(new Object[]{s.getId(), s.getNome(), s.getDescricao(),
                    String.format("%.2f", s.getPreco())});
        }
    }
}
