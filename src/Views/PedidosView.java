/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.PedidoController;
import Models.Pedido;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marcus.hmoraes & Patrick Chagas
 */
public class PedidosView extends javax.swing.JInternalFrame {

    /**
     * Creates new form Pedidos
     */
    public PedidosView() {
        initComponents();
        //ocultar campo onde será armazenado o Código do cliente
        txt_Id_Cli.setVisible(false);
        OcultarColunas_TblCliente();
        OcultarColunas_TblProduto();
        habilitarCliente();
    }
/**
 * Método auxiliar que habilita os campos para cadastro
 */
    private void habilitarCliente() {
        Rb_Nome_Cli.setEnabled(true);
        Rb_CPF_Cli.setEnabled(true);
        txt_Nome_Cli.setEnabled(true);
        txt_CPF_Cli.setEnabled(true);
        tbl_Cliente.setEnabled(true);
        txt_Id_Cli.setText("Vazio");
        //desabilitar Produto
        rb_Nome_Prod.setEnabled(false);
        rb_Cod_Prod.setEnabled(false);
        txt_Nome_Prod.setEnabled(false);
        txt_Cod_Prod.setEnabled(false);
        tbl_Produto.setEnabled(false);
        btn_Detalhar_Prod.setEnabled(false);
        btn_Incluir_Prod.setEnabled(false);
        tbl_Pedido.setEnabled(false);

    }
/**
 * Método auxiliar que habilita os campos para cadastro
 */
    private void habilitarProduto_Pedido() {
        Rb_Nome_Cli.setEnabled(false);
        Rb_CPF_Cli.setEnabled(false);
        txt_Nome_Cli.setEnabled(false);
        txt_CPF_Cli.setEnabled(false);
        tbl_Cliente.setEnabled(false);
        //Habilitar campos de produto
        rb_Nome_Prod.setEnabled(true);
        rb_Cod_Prod.setEnabled(true);
        txt_Nome_Prod.setEnabled(true);
        txt_Cod_Prod.setEnabled(true);
        tbl_Produto.setEnabled(true);
        btn_Detalhar_Prod.setEnabled(true);
        btn_Incluir_Prod.setEnabled(true);
        txt_Nome_Prod.setEditable(true);
        tbl_Pedido.setEnabled(true);
    }
 /**
  * Método auxiliar que oculta as colunas da tabela referente ao Id do Cliente
  */
    private void OcultarColunas_TblCliente() {
        //Oculta colunas da tabela referente ao Id do cliente
        if (tbl_Cliente.getColumnName(0).equalsIgnoreCase("id")) {
            tbl_Cliente.getColumnModel().getColumn(0).setMinWidth(0);
            tbl_Cliente.getColumnModel().getColumn(0).setMaxWidth(0);
        }
    }
/** @author Patrick
  * Método auxiliar que oculta as colunas da tabela referente ao valor e quantidade em estoque
  */
    private void OcultarColunas_TblProduto() {
        if (tbl_Produto.getColumnName(2).equalsIgnoreCase("Valor (R$)") && tbl_Produto.getColumnName(3).equalsIgnoreCase("Qtd. Estoque")) {
            //Oculta coluna referente ao valor
            tbl_Produto.getColumnModel().getColumn(2).setMinWidth(0);
            tbl_Produto.getColumnModel().getColumn(2).setMaxWidth(0);
            //Oculta coluna referente a Quantidade em estoque
            tbl_Produto.getColumnModel().getColumn(3).setMinWidth(0);
            tbl_Produto.getColumnModel().getColumn(3).setMaxWidth(0);
        }
    }
/**
 * @author Patrick
 * Método auxiliar que mostra valor e quantidade em estoque
 */
    private void Mostrar_Detalhes_TblProduto() {
        if (tbl_Produto.getColumnName(2).equalsIgnoreCase("Valor (R$)") && tbl_Produto.getColumnName(3).equalsIgnoreCase("Qtd. Estoque")) {
            //Oculta coluna referente ao valor
            tbl_Produto.getColumnModel().getColumn(2).setMinWidth(70);
            tbl_Produto.getColumnModel().getColumn(2).setMaxWidth(70);
            //Oculta coluna referente a Quantidade em estoque
            tbl_Produto.getColumnModel().getColumn(3).setMinWidth(90);
            tbl_Produto.getColumnModel().getColumn(3).setMaxWidth(90);
        }
    }
/**
 * Método para consultar produtos
 * @see Controllers.PedidoController
 * @param tipo
 * @throws ClassNotFoundException 
 */
    private void consultarProduto(byte tipo) throws ClassNotFoundException {
        //Peço ao controller resgatar os Produtos do banco de dados
        if (tipo == 1) {
            ArrayList<Pedido> linhasProdutos = PedidoController.getConsultaProduto(txt_Nome_Prod.getText(), tipo);
            ArrayList<String[]> adicionarATabela = PedidoController.getProduto(txt_Nome_Prod.getText(), tipo);
            DefaultTableModel tmpedido = (DefaultTableModel) this.tbl_Produto.getModel();
            //Limpo a tabela, excluindo todas as linhas
            tmpedido.setRowCount(0);
            //Para cada Produtos resgatado do banco de dados, atualizo a tabela
            for (int i = 0; i < linhasProdutos.size(); i++) {
                tmpedido.addRow(adicionarATabela.get(i));
            }
        } else if (tipo == 2) {
            ArrayList<Pedido> linhasProdutos = PedidoController.getConsultaProduto(txt_Cod_Prod.getText(), tipo);
            ArrayList<String[]> adicionarATabela = PedidoController.getProduto(txt_Cod_Prod.getText(), tipo);
            DefaultTableModel tmPedidos = (DefaultTableModel) this.tbl_Produto.getModel();
            //Limpo a tabela, excluindo todas as linhas
            tmPedidos.setRowCount(0);
            //Para cada cliente resgatado do banco de dados, atualizo a tabela
            for (int i = 0; i < linhasProdutos.size(); i++) {
                tmPedidos.addRow(adicionarATabela.get(i));
            }
        }

        if (tbl_Produto.getColumnName(2).equalsIgnoreCase("Valor (R$)") && tbl_Produto.getColumnName(3).equalsIgnoreCase("Qtd. Estoque")) {
            //Oculta coluna referente ao valor
            tbl_Produto.getColumnModel().getColumn(2).setMinWidth(0);
            tbl_Produto.getColumnModel().getColumn(2).setMaxWidth(0);
            //Oculta coluna referente a Quantidade em estoque
            tbl_Produto.getColumnModel().getColumn(3).setMinWidth(0);
            tbl_Produto.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        //table.removeColumn(table.getColumnModel().getColumn(4));
    }
    /** Método para consultar os clientes
     * @see Controllers.PedidoController
     * @param tipo
     * @throws ClassNotFoundException 
     */
    
    private void consultarCliente(byte tipo) throws ClassNotFoundException {
        //Peço ao controller resgatar os clientes do banco de dados
        if (tipo == 1) {
            ArrayList<Pedido> linhasClientes = PedidoController.getConsultaCliente(txt_Nome_Cli.getText(), tipo);
            ArrayList<String[]> adicionarATabela = PedidoController.getCliente(txt_Nome_Cli.getText(), tipo);
            DefaultTableModel tmPedidos = (DefaultTableModel) this.tbl_Cliente.getModel();
            //Limpo a tabela, excluindo todas as linhas
            tmPedidos.setRowCount(0);
            //Para cada cliente resgatado do banco de dados, atualizo a tabela
            for (int i = 0; i < linhasClientes.size(); i++) {
                tmPedidos.addRow(adicionarATabela.get(i));
            }
        } else if (tipo == 2) {
            ArrayList<Pedido> linhasClientes = PedidoController.getConsultaCliente(txt_CPF_Cli.getText(), tipo);
            ArrayList<String[]> adicionarATabela = PedidoController.getCliente(txt_CPF_Cli.getText(), tipo);
            DefaultTableModel tmPedidos = (DefaultTableModel) this.tbl_Cliente.getModel();
            //Limpo a tabela, excluindo todas as linhas
            tmPedidos.setRowCount(0);
            //Para cada cliente resgatado do banco de dados, atualizo a tabela
            for (int i = 0; i < linhasClientes.size(); i++) {
                tmPedidos.addRow(adicionarATabela.get(i));
            }
        }

        //Oculta colunas da tabela referente ao Id do cliente
        OcultarColunas_TblCliente();

    }
    /**
     * Método para adicionar item na tabela
     * @param linha 
     */
    private void adicionarItem(int linha) {
        //Instanciando tabelas de Pedido e produto
        DefaultTableModel tmPedido = (DefaultTableModel) this.tbl_Pedido.getModel();
        DefaultTableModel tmItemPedido = (DefaultTableModel) this.tbl_Produto.getModel();

        boolean itemExistente = false;
        int somaLinhas = tbl_Pedido.getRowCount();
        for (int i = 0; i < somaLinhas; i++) {
            if (tmPedido.getValueAt(i, 0).equals(tmItemPedido.getValueAt(linha, 0))) {
                itemExistente = true;
            }
        }
        if (itemExistente == false) {
            //adiciona dados selecionados a tabela de pedidos
            tmPedido.addRow(new String[]{String.valueOf(tmItemPedido.getValueAt(linha, 0)),
                String.valueOf(tmItemPedido.getValueAt(linha, 1)),
                String.valueOf(tmItemPedido.getValueAt(linha, 2)),
                String.valueOf(1),
                String.valueOf(tmItemPedido.getValueAt(linha, 3)),
                String.valueOf(tmItemPedido.getValueAt(linha, 2)),});
            //limpar campos da tabela de Pedido
            tmItemPedido.setNumRows(0);
        }

    }
    /**
     * Totais de itens em $
     */
    private void totaisItens() {
        double valor = 0;
        int somaLinhas = tbl_Pedido.getRowCount();
        //formula para formatar dados 
        DecimalFormat formato = new DecimalFormat("#0.00");
        for (int i = 0; i < somaLinhas; i++) {
            //replaceall para converter "," para "." 
            valor = valor + Double.parseDouble(String.valueOf(tbl_Pedido.getModel().getValueAt(i, 5)).replaceAll("\\,", "."));
        }
        txt_TotalPedido.setText(String.valueOf(formato.format(valor)).replaceAll("\\.", ","));
    }
    /** @see Controllers.PedidoController
     * Método para salvar o pedido
     */
    private void salvar() {
        int itensPedido = tbl_Pedido.getRowCount();
        if (itensPedido <= 0 || txt_Id_Cli.getText().equalsIgnoreCase("Vazio") || txt_TotalPedido.getText().equalsIgnoreCase("0,00")) {
            JOptionPane.showMessageDialog(null, "Operação não pode ser concluida, pelos seguintes motivos: \n"
                    + "1- Cliente não foi selecionado. e/ou\n"
                    + "2- não foi selecionado nenhum Produto.\n"
                    + "\n"
                    + "preencha esses campos e tente novamente.");
        } else {
            //inserção no banco de dados e retorna valor do IDPedido
            int IdPedido = PedidoController.salvarPedido(Integer.parseInt(txt_Id_Cli.getText()),
                    Double.parseDouble(txt_TotalPedido.getText().replaceAll("\\,", ".")),
                    String.valueOf(cbForPagamento.getSelectedItem()));

            if (IdPedido > 0) {
                //me tras o valor do id do pedido para poder ser usado mais tarde

                for (int i = 0; i <= itensPedido; i++) {
                    if (PedidoController.SalvarItemPedido(Integer.parseInt(String.valueOf(tbl_Pedido.getModel().getValueAt(i, 0))),
                            IdPedido,
                            Integer.parseInt(String.valueOf(tbl_Pedido.getModel().getValueAt(i, 3))),
                            Double.parseDouble(String.valueOf(tbl_Pedido.getModel().getValueAt(i, 5)).replaceAll("\\,", ".")))) {

                    } else if (i == itensPedido) {
                        limparCampos();
                        JOptionPane.showMessageDialog(null, "Pedido Realizado com sucesso");
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha ao cadastrar iten ou itens");
                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "Falha ao cadastrar Pedido!");
            }
        }
    }

    private void limparCampos() {
        DefaultTableModel tmCliente = (DefaultTableModel) this.tbl_Cliente.getModel();
        DefaultTableModel tmItemPedido = (DefaultTableModel) this.tbl_Produto.getModel();
        DefaultTableModel tmPedido = (DefaultTableModel) this.tbl_Pedido.getModel();

        tmCliente.setNumRows(0);
        tmItemPedido.setNumRows(0);
        tmPedido.setNumRows(0);
        txt_Nome_Prod.setText(null);
        txt_Cod_Prod.setText(null);
        txt_TotalPedido.setText("0,00");
        
        habilitarCliente();
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RN_Pesquisa_Cliente = new javax.swing.ButtonGroup();
        rn_Pesquisa_Produto = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txt_Nome_Cli = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Rb_Nome_Cli = new javax.swing.JRadioButton();
        Rb_CPF_Cli = new javax.swing.JRadioButton();
        txt_CPF_Cli = new javax.swing.JFormattedTextField();
        btnSelecionarCli = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Cliente = new javax.swing.JTable();
        txt_Id_Cli = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        rb_Nome_Prod = new javax.swing.JRadioButton();
        rb_Cod_Prod = new javax.swing.JRadioButton();
        txt_Nome_Prod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Cod_Prod = new javax.swing.JFormattedTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_Produto = new javax.swing.JTable();
        btn_Detalhar_Prod = new javax.swing.JButton();
        btn_Incluir_Prod = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_Cadastrar_Ped = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Pedido = new javax.swing.JTable();
        btn_Delete_ItemPed = new javax.swing.JButton();
        lbl_formPagamento = new javax.swing.JLabel();
        cbForPagamento = new javax.swing.JComboBox<>();
        txt_TotalPedido = new javax.swing.JFormattedTextField();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setMinimumSize(new java.awt.Dimension(939, 573));
        setNormalBounds(new java.awt.Rectangle(0, 0, 852, 0));
        setPreferredSize(new java.awt.Dimension(939, 573));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Pedido"));
        jPanel5.setForeground(new java.awt.Color(240, 240, 240));
        jPanel5.setToolTipText("");
        jPanel5.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        txt_Nome_Cli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Nome_CliKeyReleased(evt);
            }
        });

        jLabel1.setText("Nome do cliente");

        jLabel3.setText("CPF");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar por")));

        RN_Pesquisa_Cliente.add(Rb_Nome_Cli);
        Rb_Nome_Cli.setSelected(true);
        Rb_Nome_Cli.setText("Nome");
        Rb_Nome_Cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rb_Nome_CliActionPerformed(evt);
            }
        });

        RN_Pesquisa_Cliente.add(Rb_CPF_Cli);
        Rb_CPF_Cli.setText("CPF");
        Rb_CPF_Cli.setToolTipText("");
        Rb_CPF_Cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rb_CPF_CliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Rb_CPF_Cli)
                    .addComponent(Rb_Nome_Cli))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Rb_Nome_Cli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Rb_CPF_Cli)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_CPF_Cli.setEditable(false);
        txt_CPF_Cli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CPF_CliKeyReleased(evt);
            }
        });

        btnSelecionarCli.setText("Selecionar");
        btnSelecionarCli.setActionCommand("");
        btnSelecionarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarCliActionPerformed(evt);
            }
        });

        tbl_Cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Nome completo", "CPF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_Cliente);

        txt_Id_Cli.setText("Vazio");

        btnCancelar.setText("Alterar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(txt_Nome_Cli, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                            .addComponent(txt_CPF_Cli))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_Id_Cli, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSelecionarCli)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Nome_Cli, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_CPF_Cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSelecionarCli)
                        .addComponent(btnCancelar))
                    .addComponent(txt_Id_Cli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_CPF_Cli, txt_Nome_Cli});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Produto"));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar por")));

        rn_Pesquisa_Produto.add(rb_Nome_Prod);
        rb_Nome_Prod.setSelected(true);
        rb_Nome_Prod.setText("Nome");
        rb_Nome_Prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_Nome_ProdActionPerformed(evt);
            }
        });

        rn_Pesquisa_Produto.add(rb_Cod_Prod);
        rb_Cod_Prod.setText("Código");
        rb_Cod_Prod.setToolTipText("");
        rb_Cod_Prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_Cod_ProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_Cod_Prod)
                    .addComponent(rb_Nome_Prod))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rb_Nome_Prod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_Cod_Prod)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_Nome_Prod.setEditable(false);
        txt_Nome_Prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Nome_ProdKeyReleased(evt);
            }
        });

        jLabel2.setText("Nome do produto");

        jLabel4.setText("Código do produto");

        txt_Cod_Prod.setEditable(false);
        txt_Cod_Prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Cod_ProdKeyReleased(evt);
            }
        });

        tbl_Produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Produto", "Valor (R$)", "Qtd. Estoque"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbl_Produto);

        btn_Detalhar_Prod.setText("Detalhar");
        btn_Detalhar_Prod.setActionCommand("");
        btn_Detalhar_Prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Detalhar_ProdActionPerformed(evt);
            }
        });

        btn_Incluir_Prod.setText("Incluir");
        btn_Incluir_Prod.setActionCommand("");
        btn_Incluir_Prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Incluir_ProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(txt_Nome_Prod)
                            .addComponent(txt_Cod_Prod, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_Detalhar_Prod)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Incluir_Prod)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Nome_Prod, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Cod_Prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Detalhar_Prod)
                    .addComponent(btn_Incluir_Prod)))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_Cod_Prod, txt_Nome_Prod});

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedido"));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Total do pedido");

        btn_Cadastrar_Ped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icon_add_32.png"))); // NOI18N
        btn_Cadastrar_Ped.setToolTipText("Cadastrar Cliente");
        btn_Cadastrar_Ped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cadastrar_PedActionPerformed(evt);
            }
        });

        tbl_Pedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Valor (R$)", "Qntd. Pedido", "Qntd. Estoque", "Subtotal (R$)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Pedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_PedidoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Pedido);

        btn_Delete_ItemPed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icon_delete_32.png"))); // NOI18N
        btn_Delete_ItemPed.setToolTipText("Excluir Cliente");
        btn_Delete_ItemPed.setMaximumSize(new java.awt.Dimension(48, 48));
        btn_Delete_ItemPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Delete_ItemPedActionPerformed(evt);
            }
        });

        lbl_formPagamento.setText("Forma de Pagamento");

        cbForPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Cartão de Débito", "Cartão de Crédito" }));

        txt_TotalPedido.setEditable(false);
        txt_TotalPedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_TotalPedido.setText("0,00");
        txt_TotalPedido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_formPagamento)
                            .addComponent(cbForPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btn_Delete_ItemPed, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Cadastrar_Ped, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_TotalPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_TotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Delete_ItemPed, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Cadastrar_Ped, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_formPagamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbForPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 888, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Cadastro de Pedido");
        getAccessibleContext().setAccessibleDescription("");

        setBounds(0, 0, 939, 573);
    }// </editor-fold>//GEN-END:initComponents

    private void Rb_Nome_CliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rb_Nome_CliActionPerformed
        //comandos para ocultar de CPF e liberar campo de nome
        txt_CPF_Cli.setText(null);
        txt_CPF_Cli.setEditable(false);
        txt_Nome_Cli.setEditable(true);
    }//GEN-LAST:event_Rb_Nome_CliActionPerformed

    private void Rb_CPF_CliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rb_CPF_CliActionPerformed
        //comandos para ocultar de nome e liberar campo de CPF
        txt_Nome_Cli.setText(null);
        txt_Nome_Cli.setEditable(false);
        txt_CPF_Cli.setEditable(true);
    }//GEN-LAST:event_Rb_CPF_CliActionPerformed

    private void btnSelecionarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarCliActionPerformed
        int setar = tbl_Cliente.getSelectedRow();
        if (setar >= 0) {
            txt_Id_Cli.setText(tbl_Cliente.getModel().getValueAt(setar, 0).toString());
            txt_Nome_Cli.setText(null);
            txt_CPF_Cli.setText(null);
            habilitarProduto_Pedido();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um cliente, para começar o pedido.");
        }
    }//GEN-LAST:event_btnSelecionarCliActionPerformed

    private void rb_Nome_ProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_Nome_ProdActionPerformed
        txt_Cod_Prod.setText(null);
        txt_Cod_Prod.setEditable(false);
        txt_Nome_Prod.setEditable(true);
    }//GEN-LAST:event_rb_Nome_ProdActionPerformed

    private void rb_Cod_ProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_Cod_ProdActionPerformed
        txt_Nome_Prod.setText(null);
        txt_Nome_Prod.setEditable(false);
        txt_Cod_Prod.setEditable(true);
    }//GEN-LAST:event_rb_Cod_ProdActionPerformed

    private void txt_Nome_CliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Nome_CliKeyReleased
        if (txt_Nome_Cli.getText().equalsIgnoreCase("")) {
            tbl_Cliente.setCellEditor(null);
        } else {
            try {
                byte tipo = 1;
                consultarCliente(tipo);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PedidosView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txt_Nome_CliKeyReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txt_Id_Cli.setText(null);
        habilitarCliente();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txt_CPF_CliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CPF_CliKeyReleased
        if (txt_CPF_Cli.getText().equalsIgnoreCase("")) {
            tbl_Cliente.setCellEditor(null);
        } else {
            try {
                byte tipo = 2;
                consultarCliente(tipo);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PedidosView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txt_CPF_CliKeyReleased

    private void txt_Nome_ProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Nome_ProdKeyReleased
        if (txt_Nome_Prod.getText().equalsIgnoreCase("")) {
            tbl_Produto.setCellEditor(null);
        } else {
            try {
                byte tipo = 1;
                consultarProduto(tipo);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PedidosView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txt_Nome_ProdKeyReleased

    private void txt_Cod_ProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Cod_ProdKeyReleased
        if (txt_Cod_Prod.getText().equalsIgnoreCase("")) {
            tbl_Produto.setCellEditor(null);
        } else {
            try {
                byte tipo = 2;
                consultarProduto(tipo);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PedidosView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txt_Cod_ProdKeyReleased

    private void btn_Detalhar_ProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Detalhar_ProdActionPerformed
        Mostrar_Detalhes_TblProduto();
    }//GEN-LAST:event_btn_Detalhar_ProdActionPerformed

    private void btn_Incluir_ProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Incluir_ProdActionPerformed
        int setar = tbl_Produto.getSelectedRow();
        if (setar >= 0) {
            txt_Nome_Prod.setText(null);
            txt_Cod_Prod.setText(null);
            adicionarItem(setar);
            totaisItens();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Produto.");
        }
    }//GEN-LAST:event_btn_Incluir_ProdActionPerformed

    private void tbl_PedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_PedidoKeyReleased
        //realiza o calculo do subTotal
        int linha = tbl_Pedido.getSelectedRow();
        if (linha >= 0) {
            //armazena soma dos dados da soma do pedido
            if (Integer.parseInt(tbl_Pedido.getModel().getValueAt(linha, 3).toString()) <= Integer.parseInt(tbl_Pedido.getModel().getValueAt(linha, 4).toString())) {
                tbl_Pedido.getModel().setValueAt(String.valueOf(Double.parseDouble(String.valueOf(tbl_Pedido.getModel().getValueAt(linha, 2)).replaceAll("\\,", "."))
                        * Integer.parseInt(tbl_Pedido.getModel().getValueAt(linha, 3).toString())).replaceAll("\\.", ","), linha, 5);
            } else {
                JOptionPane.showMessageDialog(null, "Quantidade informada não se encontra em estoque.\n"
                        + "Quantidade total em estoque foi adicionado ao invés do informado!");
                tbl_Pedido.getModel().setValueAt(tbl_Pedido.getModel().getValueAt(linha, 4), linha, 3);
            }

        }
        totaisItens();
        //replaceAll(",", ".");

    }//GEN-LAST:event_tbl_PedidoKeyReleased

    private void btn_Delete_ItemPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Delete_ItemPedActionPerformed
        int linha = tbl_Pedido.getSelectedRow();
        if (linha >= 0) {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o item selecionado?");
            switch (opcao) {
                case 0:
                    //comando para exclui os dados selecionados
                    ((DefaultTableModel) tbl_Pedido.getModel()).removeRow(linha);
                    totaisItens();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Operação cancelada, pelo usuario!");
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Item para ser removido!");
        }
    }//GEN-LAST:event_btn_Delete_ItemPedActionPerformed

    private void btn_Cadastrar_PedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Cadastrar_PedActionPerformed
        salvar();
    }//GEN-LAST:event_btn_Cadastrar_PedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup RN_Pesquisa_Cliente;
    private javax.swing.JRadioButton Rb_CPF_Cli;
    private javax.swing.JRadioButton Rb_Nome_Cli;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSelecionarCli;
    private javax.swing.JButton btn_Cadastrar_Ped;
    private javax.swing.JButton btn_Delete_ItemPed;
    private javax.swing.JButton btn_Detalhar_Prod;
    private javax.swing.JButton btn_Incluir_Prod;
    private javax.swing.JComboBox<String> cbForPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_formPagamento;
    private javax.swing.JRadioButton rb_Cod_Prod;
    private javax.swing.JRadioButton rb_Nome_Prod;
    private javax.swing.ButtonGroup rn_Pesquisa_Produto;
    private javax.swing.JTable tbl_Cliente;
    private javax.swing.JTable tbl_Pedido;
    private javax.swing.JTable tbl_Produto;
    private javax.swing.JFormattedTextField txt_CPF_Cli;
    private javax.swing.JFormattedTextField txt_Cod_Prod;
    private javax.swing.JTextField txt_Id_Cli;
    private javax.swing.JTextField txt_Nome_Cli;
    private javax.swing.JTextField txt_Nome_Prod;
    private javax.swing.JFormattedTextField txt_TotalPedido;
    // End of variables declaration//GEN-END:variables
}
