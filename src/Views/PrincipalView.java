/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcus.hmoraes
 */
public class PrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public PrincipalView() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClientes = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        btnPedidos = new javax.swing.JButton();
        Desktop = new javax.swing.JDesktopPane();
        btnRelatorio = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        SubMnCliente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        SubMnProduto = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        SubMnPedido = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        SubMnRelatorio = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        SubMnSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loja Gabenrick's H&C");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1123, 711));

        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnProduto.setText("Produto");
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });

        btnPedidos.setText("Pedido");
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });

        Desktop.setBackground(new java.awt.Color(240, 240, 240));
        Desktop.setForeground(new java.awt.Color(240, 240, 240));
        Desktop.setEnabled(false);
        Desktop.setPreferredSize(new java.awt.Dimension(939, 573));

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnRelatorio.setText("Relatório");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        jMenu1.setText("Clientes");

        SubMnCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        SubMnCliente.setText("Cadastrar");
        SubMnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMnClienteActionPerformed(evt);
            }
        });
        jMenu1.add(SubMnCliente);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Produtos");

        SubMnProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        SubMnProduto.setText("Cadastrar");
        SubMnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMnProdutoActionPerformed(evt);
            }
        });
        jMenu2.add(SubMnProduto);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Pedido");

        SubMnPedido.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        SubMnPedido.setText("Cadastrar");
        SubMnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMnPedidoActionPerformed(evt);
            }
        });
        jMenu3.add(SubMnPedido);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Relatório");

        SubMnRelatorio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        SubMnRelatorio.setText("Pedido");
        SubMnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMnRelatorioActionPerformed(evt);
            }
        });
        jMenu5.add(SubMnRelatorio);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("Ajuda");

        SubMnSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        SubMnSobre.setText("Sobre");
        SubMnSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMnSobreActionPerformed(evt);
            }
        });
        jMenu4.add(SubMnSobre);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(btnProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnClientes, btnPedidos, btnProduto});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProduto)
                .addGap(18, 18, 18)
                .addComponent(btnPedidos)
                .addGap(18, 18, 18)
                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
            .addComponent(Desktop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClientes, btnPedidos, btnProduto});

        getAccessibleContext().setAccessibleDescription("Tela Principal da Loja Gabenrick's H&C");

        setSize(new java.awt.Dimension(1123, 711));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        //JOptionPane.showMessageDialog(null, "teste!");
//        Desktop.removeAll();
        ClientesView Cadastro = new ClientesView();
        //((BasicInternalFrameUI) Cadastro.getUI()).setNorthPane(null);
        Cadastro.setVisible(true);
        Desktop.add(Cadastro);
        //comando para maximizar a tela JInternalFrame
        //Cadastro.setMaximum(true);
        // repaint para dar um refresh na tela
        this.repaint();

    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        //Cadastro.setVisible(false);
//        Desktop.removeAll();
        ProdutosView Produto = new ProdutosView();
        //((BasicInternalFrameUI) Produto.getUI()).setNorthPane(null);
        Produto.setVisible(true);
        Desktop.add(Produto);
        try {
            //comando para maximizar a tela JInternalFrame
            Produto.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
        // repaint para dar um refresh na tela
        this.repaint();

// TODO add your handling code here:
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        //Desktop.removeAll();
        PedidosView Pedido = new PedidosView();
        //((BasicInternalFrameUI) Pedido.getUI()).setNorthPane(null);
        Pedido.setVisible(true);
        Desktop.add(Pedido);
        try {
            //comando para maximizar a tela JInternalFrame
            Pedido.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
        // repaint para dar um refresh na tela
        this.repaint();
    }//GEN-LAST:event_btnPedidosActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        //Desktop.removeAll();
        RelatorioView relatorio = new RelatorioView();
        //((BasicInternalFrameUI) relatorio.getUI()).setNorthPane(null);
        relatorio.setVisible(true);
        Desktop.add(relatorio);
        try {
            //comando para maximizar a tela JInternalFrame
            relatorio.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
        // repaint para dar um refresh na tela
        this.repaint();
    }//GEN-LAST:event_btnRelatorioActionPerformed

    private void SubMnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMnClienteActionPerformed
//        Desktop.removeAll();
        ClientesView Cadastro = new ClientesView();
        Cadastro.setVisible(true);
        Desktop.add(Cadastro);
        try {
            //comando para maximizar a tela JInternalFrame
            Cadastro.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
        // repaint para dar um refresh na tela
        this.repaint();
    }//GEN-LAST:event_SubMnClienteActionPerformed

    private void SubMnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMnProdutoActionPerformed
//        Desktop.removeAll();
        ProdutosView Produto = new ProdutosView();
        //((BasicInternalFrameUI) Produto.getUI()).setNorthPane(null);
        Produto.setVisible(true);
        Desktop.add(Produto);
        try {
            //comando para maximizar a tela JInternalFrame
            Produto.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
        // repaint para dar um refresh na tela
        this.repaint();
    }//GEN-LAST:event_SubMnProdutoActionPerformed

    private void SubMnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMnPedidoActionPerformed
        //Desktop.removeAll();
        PedidosView Pedido = new PedidosView();
        //((BasicInternalFrameUI) Pedido.getUI()).setNorthPane(null);
        Pedido.setVisible(true);
        Desktop.add(Pedido);
        try {
            //comando para maximizar a tela JInternalFrame
            Pedido.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
        // repaint para dar um refresh na tela
        this.repaint();
    }//GEN-LAST:event_SubMnPedidoActionPerformed

    private void SubMnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMnRelatorioActionPerformed
        //Desktop.removeAll();
        RelatorioView relatorio = new RelatorioView();
        //((BasicInternalFrameUI) relatorio.getUI()).setNorthPane(null);
        relatorio.setVisible(true);
        Desktop.add(relatorio);
        try {
            //comando para maximizar a tela JInternalFrame
            relatorio.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
        // repaint para dar um refresh na tela
        this.repaint();
    }//GEN-LAST:event_SubMnRelatorioActionPerformed

    private void SubMnSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMnSobreActionPerformed
        SobreView sobre = new SobreView();
        sobre.setVisible(true);
        Desktop.add(sobre);
        this.repaint();
    }//GEN-LAST:event_SubMnSobreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuItem SubMnCliente;
    private javax.swing.JMenuItem SubMnPedido;
    private javax.swing.JMenuItem SubMnProduto;
    private javax.swing.JMenuItem SubMnRelatorio;
    private javax.swing.JMenuItem SubMnSobre;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
