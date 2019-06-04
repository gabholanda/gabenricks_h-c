/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.ClienteController;
import Models.Cliente;
import java.awt.Dimension;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Locale;
import javax.swing.JInternalFrame;
=======
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marcus.hmoraes
 */
public class ClientesView extends javax.swing.JInternalFrame {

    /**
     * Creates new form Cliente_Cadastro
     */
    private String modoTela; //   "Criar/Editar/Consultar"

    public ClientesView() {

        initComponents();

        Dimension size = txtDataCli.getCalendarPreferredSize();
        size.width += 90;
        txtDataCli.setCalendarPreferredSize(size);
        DesabilitarFormulario();
        LoadTable();
    }

    public void LimparFormulario() {
        txtNomeCli.setText("");
        txtCPFCli.setText("");
<<<<<<< HEAD
        txtFoneCli.setText("");
        txtEmailCli.setText("");
        txtEnderecoCli.setText("");
        txtNumeroCli.setText("0");
=======
        txtEmailCli.setText("");
        txtEnderecoCli.setText("");
        txtNumeroCli.setText("");
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1
        txtCEPCli.setText("");
        txtComplementoCli.setText("");
        txtCidadeCli.setText("");

    }

    private boolean ValidarFormulario() {
<<<<<<< HEAD
        if (modoTela.equals("Consultar")) {
            return true;
        }
=======

>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1
        if (this.txtNomeCli.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Defina um nome para o cliente!");
            return false;
        }

        if (this.txtCPFCli.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Defina um CPF para cliente!");
            return false;
        }
        return true;

    }

    /**
     * Método auxiliar para desabilitar campos do formulário
     */
    public void DesabilitarFormulario() {
        txtNomeCli.setEditable(false);
        txtCPFCli.setEditable(false);
        txtEmailCli.setEditable(false);
        txtEnderecoCli.setEditable(false);
        txtNumeroCli.setEditable(false);
        txtCEPCli.setEditable(false);
        txtComplementoCli.setEditable(false);
        txtCidadeCli.setEditable(false);
        CboEstadoCli.setEditable(false);
        CboEnderecoCli.setEditable(false);

        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }

    /**
     * Método auxiliar para habilitar campos do formulário
     */
    public void HabilitarFormulario() {
        txtNomeCli.setEditable(true);
        txtCPFCli.setEditable(true);
        txtEmailCli.setEditable(true);
        txtEnderecoCli.setEditable(true);
        txtNumeroCli.setEditable(true);
        txtCEPCli.setEditable(true);
        txtComplementoCli.setEditable(true);
        txtCidadeCli.setEditable(true);
        CboEstadoCli.setEditable(true);
        CboEnderecoCli.setEditable(true);

        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }

    public void HabilitarFormularioParaConsulta() {
        txtNomeCli.setEditable(true);
        txtCPFCli.setEditable(true);

        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }

    public void LoadTable() {

        //Peço ao controller resgatar os clientes do banco de dados
        ArrayList<String[]> linhasClientes = ClienteController.getClientes();

        DefaultTableModel tmClientes = (DefaultTableModel) this.tblClientes.getModel();
        //Limpo a tabela, excluindo todas as linhas
        tmClientes.setRowCount(0);

        //Para cada cliente resgatado do banco de dados, atualizo a tabela
<<<<<<< HEAD
        linhasClientes.forEach((c) -> {
            tmClientes.addRow(c);
        });

        //Defino o tamanho para cada coluna
        tblClientes.getColumnModel().getColumn(0).setPreferredWidth(50); //ID
        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(250); // Nome
        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(200); // Data Nascimento
        tblClientes.getColumnModel().getColumn(3).setPreferredWidth(300); // CPF
        tblClientes.getColumnModel().getColumn(4).setPreferredWidth(200); // Telefone
        tblClientes.getColumnModel().getColumn(5).setPreferredWidth(250); // Email
        tblClientes.getColumnModel().getColumn(6).setPreferredWidth(100); // Rua
        tblClientes.getColumnModel().getColumn(7).setPreferredWidth(400);  // Endereco
        tblClientes.getColumnModel().getColumn(8).setPreferredWidth(100);  // Numero
        tblClientes.getColumnModel().getColumn(9).setPreferredWidth(150); // CEP
        tblClientes.getColumnModel().getColumn(10).setPreferredWidth(150); // Complemento
        tblClientes.getColumnModel().getColumn(11).setPreferredWidth(200); // Cidade
        tblClientes.getColumnModel().getColumn(12).setPreferredWidth(100);// Estado
    }

    public void ConsultaLoadTable() {

        //Peço ao controller resgatar os clientes do banco de dados
        ArrayList<String[]> linhasClientes = ClienteController.getConsultaClientes(txtNomeCli.getText());
        DefaultTableModel tmClientes = (DefaultTableModel) this.tblClientes.getModel();
        //Limpo a tabela, excluindo todas as linhas
        tmClientes.setRowCount(0);
        //Para cada cliente resgatado do banco de dados, atualizo a tabela
        linhasClientes.forEach((c) -> {
            tmClientes.addRow(c);
        });
=======
        for (String[] c : linhasClientes) {
            tmClientes.addRow(c);
        }
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1

        //Defino o tamanho para cada coluna
        tblClientes.getColumnModel().getColumn(0).setPreferredWidth(50); //ID
        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(150);
<<<<<<< HEAD
        tblClientes.getColumnModel().getColumn(3).setPreferredWidth(300);
        tblClientes.getColumnModel().getColumn(4).setPreferredWidth(200);
        tblClientes.getColumnModel().getColumn(5).setPreferredWidth(400);
        tblClientes.getColumnModel().getColumn(6).setPreferredWidth(100);
        tblClientes.getColumnModel().getColumn(7).setPreferredWidth(400);
        tblClientes.getColumnModel().getColumn(8).setPreferredWidth(50);
        tblClientes.getColumnModel().getColumn(9).setPreferredWidth(150);
        tblClientes.getColumnModel().getColumn(10).setPreferredWidth(150);
        tblClientes.getColumnModel().getColumn(11).setPreferredWidth(200);
        tblClientes.getColumnModel().getColumn(12).setPreferredWidth(50);

=======
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

<<<<<<< HEAD
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnCadastrar = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        panelCadastro = new javax.swing.JPanel();
=======
        DesktopMain = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1
        txtNomeCli = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtDataCli = new datechooser.beans.DateChooserCombo();
        lblDataNacimento = new javax.swing.JLabel();
        txtCPFCli = new javax.swing.JFormattedTextField();
        lblCPF = new javax.swing.JLabel();
        txtFoneCli = new javax.swing.JFormattedTextField();
        lblFone = new javax.swing.JLabel();
        txtEmailCli = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        CboEnderecoCli = new javax.swing.JComboBox<>();
        lblEndereco = new javax.swing.JLabel();
        txtEnderecoCli = new javax.swing.JTextField();
        txtNumeroCli = new javax.swing.JFormattedTextField();
        lblNumero = new javax.swing.JLabel();
        txtCEPCli = new javax.swing.JFormattedTextField();
        lblCEP = new javax.swing.JLabel();
        txtComplementoCli = new javax.swing.JTextField();
        lblComplemento = new javax.swing.JLabel();
        txtCidadeCli = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        CboEstadoCli = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
<<<<<<< HEAD
        lblTijolos = new javax.swing.JLabel();
=======
        btnCadastrar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1

        setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro Cliente"));
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setForeground(java.awt.Color.white);
        setTitle("Cadastro de Cliente");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setEnabled(false);
        setFrameIcon(null);
        setMinimumSize(new java.awt.Dimension(852, 852));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVerifyInputWhenFocusTarget(false);
        setVisible(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tabela", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

<<<<<<< HEAD
            },
            new String [] {
                "ID", "Nome", "Data de Nascimento", "CPF", "Telefone", "Email", "Rua", "Endereço", "Numero", "CEP", "Complemento", "Cidade", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
=======
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tabela", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Data de Nascimento", "CPF", "Email", "Rua", "Endereço", "Numero", "CEP", "Complemento", "Cidade", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
<<<<<<< HEAD
=======
        });
        jScrollPane1.setViewportView(tblClientes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 285, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblClientes);

<<<<<<< HEAD
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icon_add_32.png"))); // NOI18N
        btnCadastrar.setToolTipText("Novo Cliente");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icon_delete_32.png"))); // NOI18N
        btnDelete.setToolTipText("Excluir Cliente");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
=======
        lblNome.setText("Nome");

        txtDataCli.setFormat(2);

        lblDataNacimento.setText("Data de nascimento");

        try {
            txtCPFCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPFCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFCliActionPerformed(evt);
            }
        });

        lblCPF.setText("CPF");

        try {
            txtFoneCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFoneCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFoneCliActionPerformed(evt);
            }
        });

        lblFone.setText("Telefone");

        txtEmailCli.setToolTipText("Ex.: Senac@senac.edu.br");
        txtEmailCli.addActionListener(new java.awt.event.ActionListener() {
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icon_edit_32.png"))); // NOI18N
        btnAlterar.setToolTipText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icon_search_32.png"))); // NOI18N
        btnConsultar.setToolTipText("Consultar Clientes");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(1174, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(89, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(23, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE)))
        );

        panelCadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtNomeCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeCliActionPerformed(evt);
            }
        });

        lblNome.setText("Nome");

        lblDataNacimento.setText("Data de nascimento");
=======
        CboEnderecoCli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rua", "Avenida", "Travessa", "Aeroporto" }));
        CboEnderecoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CboEnderecoCliActionPerformed(evt);
            }
        });

        lblEndereco.setText("Endereço");

        txtEnderecoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoCliActionPerformed(evt);
            }
        });

        txtNumeroCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        lblNumero.setText("Número");
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1

        try {
            txtCPFCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPFCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFCliActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        lblCPF.setText("CPF");

        try {
            txtFoneCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFoneCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFoneCliActionPerformed(evt);
            }
        });

        lblFone.setText("Telefone");
=======
        lblCEP.setText("CEP");

        txtComplementoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplementoCliActionPerformed(evt);
            }
        });

        lblComplemento.setText("Complemento");

        txtCidadeCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeCliActionPerformed(evt);
            }
        });

        lblCidade.setText("Cidade");
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1

        txtEmailCli.setToolTipText("Ex.: Senac@senac.edu.br");
        txtEmailCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailCliActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        lblEmail.setText("E-mail");

        CboEnderecoCli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rua", "Avenida", "Travessa", "Aeroporto" }));
        CboEnderecoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CboEnderecoCliActionPerformed(evt);
            }
        });

        lblEndereco.setText("Endereço");

        txtEnderecoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoCliActionPerformed(evt);
            }
        });

        txtNumeroCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        lblNumero.setText("Número");

        try {
            txtCEPCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblCEP.setText("CEP");

        txtComplementoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplementoCliActionPerformed(evt);
            }
        });

        lblComplemento.setText("Complemento");

        txtCidadeCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeCliActionPerformed(evt);
            }
        });

        lblCidade.setText("Cidade");

        CboEstadoCli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        CboEstadoCli.setToolTipText("Selecione seu Estado.");
        CboEstadoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CboEstadoCliActionPerformed(evt);
            }
        });

        lblEstado.setText("Estado");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblTijolos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/brick.jpg"))); // NOI18N

        javax.swing.GroupLayout panelCadastroLayout = new javax.swing.GroupLayout(panelCadastro);
        panelCadastro.setLayout(panelCadastroLayout);
        panelCadastroLayout.setHorizontalGroup(
            panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastroLayout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCadastroLayout.createSequentialGroup()
                        .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCadastroLayout.createSequentialGroup()
                                .addComponent(CboEnderecoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEnderecoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtComplementoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblComplemento))
                        .addGap(23, 23, 23)
                        .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCidadeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNumeroCli, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CboEstadoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCEPCli, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblEndereco)
                    .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtEmailCli)
                        .addComponent(lblNome, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNomeCli, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
                            .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblEmail)
                                .addComponent(lblDataNacimento, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDataCli, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(52, 52, 52)
                            .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCPFCli, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(66, 66, 66)
                            .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtFoneCli, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                .addComponent(lblFone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTijolos, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelCadastroLayout.setVerticalGroup(
            panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
=======
        lblEstado.setText("Estado");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtEmailCli)
                    .addComponent(lblEndereco, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeCli, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(CboEnderecoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtEnderecoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblEmail)
                                        .addComponent(lblDataNacimento, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDataCli, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(52, 52, 52)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(83, 83, 83))
                                        .addComponent(txtCPFCli, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtComplementoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblComplemento))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFoneCli)
                            .addComponent(lblFone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCidadeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNumeroCli, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCEPCli, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CboEstadoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(35, 35, 35))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1
                .addComponent(lblNome)
                .addGap(9, 9, 9)
                .addComponent(txtNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
<<<<<<< HEAD
                .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
=======
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1
                    .addComponent(lblDataNacimento)
                    .addComponent(lblCPF)
                    .addComponent(lblFone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
<<<<<<< HEAD
                .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
=======
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1
                        .addComponent(txtCPFCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFoneCli, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDataCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmailCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
<<<<<<< HEAD
                .addGap(7, 7, 7)
                .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
=======
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1
                    .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
<<<<<<< HEAD
                .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
=======
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1
                    .addComponent(CboEnderecoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEnderecoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCEPCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
<<<<<<< HEAD
                .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtComplementoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidadeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CboEstadoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(85, 85, 85))
            .addGroup(panelCadastroLayout.createSequentialGroup()
                .addComponent(lblTijolos, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelCadastroLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CboEnderecoCli, CboEstadoCli, txtCEPCli, txtCPFCli, txtCidadeCli, txtComplementoCli, txtEmailCli, txtEnderecoCli, txtFoneCli, txtNomeCli, txtNumeroCli});

        panelCadastroLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblCEP, lblCPF, lblCidade, lblComplemento, lblDataNacimento, lblEmail, lblEndereco, lblEstado, lblFone, lblNome, lblNumero});
=======
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtComplementoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidadeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CboEstadoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CboEnderecoCli, CboEstadoCli, txtCEPCli, txtCPFCli, txtCidadeCli, txtComplementoCli, txtEmailCli, txtEnderecoCli, txtFoneCli, txtNomeCli, txtNumeroCli});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblCEP, lblCPF, lblCidade, lblComplemento, lblDataNacimento, lblEmail, lblEndereco, lblEstado, lblFone, lblNome, lblNumero});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 239, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(384, Short.MAX_VALUE))
        );

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/create.png"))); // NOI18N
        btnCadastrar.setToolTipText("Novo Cliente");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/read.png"))); // NOI18N
        btnConsultar.setToolTipText("Consultar Clientes");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/update.png"))); // NOI18N
        btnAlterar.setToolTipText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/delete.png"))); // NOI18N
        btnDelete.setToolTipText("Excluir Cliente");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        DesktopMain.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopMain.setLayer(btnCadastrar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopMain.setLayer(btnConsultar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopMain.setLayer(btnAlterar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopMain.setLayer(btnDelete, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopMainLayout = new javax.swing.GroupLayout(DesktopMain);
        DesktopMain.setLayout(DesktopMainLayout);
        DesktopMainLayout.setHorizontalGroup(
            DesktopMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopMainLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DesktopMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        DesktopMainLayout.setVerticalGroup(
            DesktopMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopMainLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(DesktopMainLayout.createSequentialGroup()
                .addGap(441, 441, 441)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(463, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(panelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1739, 967);
=======
            .addComponent(DesktopMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1140, 929);
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1
    }// </editor-fold>//GEN-END:initComponents


    private void dateChooserCombo1OnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserCombo1OnCommit
        // TODO add your handling code here:
    }//GEN-LAST:event_dateChooserCombo1OnCommit

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (modoTela.equals("Consultar")) {
            if (!txtNomeCli.getText().equalsIgnoreCase("") && !txtCPFCli.getText().equalsIgnoreCase("")) {
                ClienteController.consultar(txtNomeCli.getText());
                this.ConsultaLoadTable();
            } else if (!txtNomeCli.getText().equalsIgnoreCase("")) {
                ClienteController.consultar(txtNomeCli.getText());
                this.ConsultaLoadTable();
            } else if (!txtCPFCli.getText().equalsIgnoreCase("")) {
                ClienteController.consultar(txtCPFCli.getText());
                this.ConsultaLoadTable();
            }
            LimparFormulario();
            DesabilitarFormulario();
        }
        if (ValidarFormulario()) {
            if (modoTela.equals("Criar")) {
                //Passo ao controller a entrada do usuário e peço para salvar no banco de dados
                if (ClienteController.salvar(
                        txtNomeCli.getText(),
                        txtDataCli.getText(),
                        txtCPFCli.getText(),
                        txtFoneCli.getText(),
                        txtEmailCli.getText(),
                        CboEnderecoCli.getSelectedItem().toString(),
                        txtEnderecoCli.getText(),
                        Integer.parseInt(txtNumeroCli.getText()),
                        txtCEPCli.getText(),
                        txtComplementoCli.getText(),
                        txtCidadeCli.getText(),
                        CboEstadoCli.getSelectedItem().toString())) {

                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                    //Recarrego a tabela com os dados resgatados do banco de dados
                    this.LoadTable();
                    LimparFormulario();
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao cadastrar cliente!");
                }

            } else if (modoTela.equals("Editar")) {

                //Passo ao controller a entrada do usuário e peço para atualizar o banco de dados
                if (ClienteController.atualizar(
                        txtNomeCli.getText(),
                        txtDataCli.getText(),
                        txtCPFCli.getText(),
                        txtFoneCli.getText(),
                        txtEmailCli.getText(),
                        CboEnderecoCli.getSelectedItem().toString(),
                        txtEnderecoCli.getText(),
                        Integer.parseInt(txtNumeroCli.getText()),
                        txtCEPCli.getText(),
                        txtComplementoCli.getText(),
                        txtCidadeCli.getText(),
                        CboEstadoCli.getSelectedItem().toString())) {
                    //Recarrego a tabela com os dados resgatados do banco de dados
                    this.LoadTable();
                    JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Falha ao atualizar cliente!");
                }

            }

            LimparFormulario();
            DesabilitarFormulario();

        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        DesabilitarFormulario();
        LimparFormulario();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void CboEstadoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CboEstadoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CboEstadoCliActionPerformed

    private void txtCidadeCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeCliActionPerformed

    private void txtComplementoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplementoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplementoCliActionPerformed

    private void txtEnderecoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoCliActionPerformed

    private void CboEnderecoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CboEnderecoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CboEnderecoCliActionPerformed

    private void txtEmailCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailCliActionPerformed

    private void txtFoneCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFoneCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFoneCliActionPerformed

    private void txtCPFCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFCliActionPerformed

    private void txtNomeCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeCliActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        btnSalvar.setText("Consultar");
        HabilitarFormularioParaConsulta();
        modoTela = "Consultar";
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        //Verifico se há linhas para poder editar
        btnSalvar.setText("Alterar");
        if (tblClientes.getRowCount() > 0) {
            //Verifico se o usuário selecionou alguma linha (Primeira linha = 0)
            if (tblClientes.getSelectedRow() >= 0) {

                HabilitarFormulario();

                //Variável acessória para identifcar se o formulário está em modo de edição ou alteração
                modoTela = "Editar";
                //Atribuo os valores que estão na linha selecionada para a tabela
                txtNomeCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 1).toString());
                txtDataCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 2).toString());
                txtCPFCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 3).toString());
                txtFoneCli.setName(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 4).toString());
                txtEmailCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 5).toString());
                CboEnderecoCli.setName(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 6).toString());
                txtEnderecoCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 7).toString());
                txtNumeroCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 8).toString());
                txtCEPCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 9).toString());
                txtComplementoCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 10).toString());
                txtCidadeCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 11).toString());
                CboEstadoCli.setName(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 12).toString());

            } else {
                JOptionPane.showMessageDialog(this, "Selecione um cliente para editar!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não há clientes para editar!");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (tblClientes.getRowCount() > 0) {
            int numeroLinha = tblClientes.getSelectedRow();
            if (ClienteController.excluir(Integer.parseInt(tblClientes.getValueAt(numeroLinha, 0).toString()))) {
                this.LoadTable();
                JOptionPane.showMessageDialog(this, "Cliente excluído da base de dados");
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao excluir o cliente!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não há clientes para excluir!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
<<<<<<< HEAD
        btnSalvar.setText("Salvar");
=======
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1
        modoTela = "Criar";
        HabilitarFormulario();
        LimparFormulario();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (tblClientes.getRowCount() > 0) {
            int numeroLinha = tblClientes.getSelectedRow();
            if (ClienteController.excluir(Integer.parseInt(tblClientes.getValueAt(numeroLinha, 0).toString()))) {
                this.LoadTable();
                JOptionPane.showMessageDialog(this, "Cliente excluído da base de dados");
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao excluir o cliente!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não há clientes para excluir!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        //Verifico se há linhas para poder editar
        if (tblClientes.getRowCount() > 0) {
            //Verifico se o usuário selecionou alguma linha (Primeira linha = 0)
            if (tblClientes.getSelectedRow() >= 0) {

                HabilitarFormulario();

                //Variável acessória para identifcar se o formulário está em modo de edição ou alteração
                modoTela = "Editar";
                //Atribuo os valores que estão na linha selecionada para a tabela
                txtNomeCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 0).toString());
                txtCPFCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 1).toString());
                txtDataCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 2).toString());
                txtEmailCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 3).toString());
                CboEnderecoCli.setName(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 4).toString());
                txtEnderecoCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 5).toString());
                txtNumeroCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 6).toString());
                txtCEPCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 7).toString());
                txtComplementoCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 8).toString());
                txtCidadeCli.setText(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 9).toString());
                CboEstadoCli.setName(tblClientes.getModel().getValueAt(tblClientes.getSelectedRow(), 10).toString());

            } else {
                JOptionPane.showMessageDialog(this, "Selecione um cliente para editar!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não há clientes para editar!");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void CboEnderecoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CboEnderecoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CboEnderecoCliActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (ValidarFormulario()) {
            if (modoTela.equals("Criar")) {
                //Passo ao controller a entrada do usuário e peço para salvar no banco de dados
                if (ClienteController.salvar(
                        txtNomeCli.getText(),
                        txtDataCli.getText(),
                        txtCPFCli.getText(),
                        txtFoneCli.getText(),
                        txtEmailCli.getText(),
                        CboEnderecoCli.getName(),
                        txtEnderecoCli.getText(),
                        Integer.parseInt(txtNumeroCli.getText()),
                        txtCEPCli.getText(),
                        txtComplementoCli.getText(),
                        txtCidadeCli.getText(),
                        CboEstadoCli.getName())) {
                    //Recarrego a tabela com os dados resgatados do banco de dados
                    this.LoadTable();

                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                    LimparFormulario();
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao cadastrar cliente!");
                }

            } else if (modoTela.equals("Editar")) {

                //Passo ao controller a entrada do usuário e peço para atualizar o banco de dados
                if (ClienteController.atualizar(
                        txtNomeCli.getText(),
                        txtDataCli.getText(),
                        txtCPFCli.getText(),
                        txtFoneCli.getText(),
                        txtEmailCli.getText(),
                        CboEnderecoCli.getName(),
                        txtEnderecoCli.getText(),
                        Integer.parseInt(txtNumeroCli.getText()),
                        txtCEPCli.getText(),
                        txtComplementoCli.getText(),
                        txtCidadeCli.getText(),
                        CboEstadoCli.getName())) {
                    //Recarrego a tabela com os dados resgatados do banco de dados
                    this.LoadTable();
                    JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Falha ao atualizar cliente!");
                }

            }

            LimparFormulario();
            DesabilitarFormulario();

        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        DesabilitarFormulario();
        LimparFormulario();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtFoneCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFoneCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFoneCliActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        HabilitarFormularioParaConsulta();
        if (!txtNomeCli.getText().equalsIgnoreCase("") && !txtCPFCli.getText().equalsIgnoreCase("")) {
            ClienteController.consultar(txtNomeCli.getText());
            this.LoadTable();
        } else if (!txtNomeCli.getText().equalsIgnoreCase("")) {
            ClienteController.consultar(txtNomeCli.getText());
            this.LoadTable();
        } else if (!txtCPFCli.getText().equalsIgnoreCase("")) {
            ClienteController.consultar(txtCPFCli.getText());
            this.LoadTable();
        }
        LimparFormulario();
        DesabilitarFormulario();

    }//GEN-LAST:event_btnConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CboEnderecoCli;
    private javax.swing.JComboBox<String> CboEstadoCli;
    private javax.swing.JButton btnAlterar;
    private static javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSalvar;
<<<<<<< HEAD
    private javax.swing.JPanel jPanel2;
=======
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblDataNacimento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFone;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
<<<<<<< HEAD
    private javax.swing.JLabel lblTijolos;
    private javax.swing.JPanel panelCadastro;
=======
>>>>>>> e2bc75177a649262b2770b09e8e48b674b74f0d1
    private javax.swing.JTable tblClientes;
    private javax.swing.JFormattedTextField txtCEPCli;
    private javax.swing.JFormattedTextField txtCPFCli;
    private javax.swing.JTextField txtCidadeCli;
    private javax.swing.JTextField txtComplementoCli;
    private datechooser.beans.DateChooserCombo txtDataCli;
    private javax.swing.JTextField txtEmailCli;
    private javax.swing.JTextField txtEnderecoCli;
    private javax.swing.JFormattedTextField txtFoneCli;
    private javax.swing.JTextField txtNomeCli;
    private javax.swing.JFormattedTextField txtNumeroCli;
    // End of variables declaration//GEN-END:variables
}
