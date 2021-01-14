/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ImagemJar;
import Controle.CRUD;
import Modelo.Cargo;
import static Visao.MenuPrincipal.panelComponentes;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;

/**
 *
 * @author Rodrigues
 */
public class Perfil extends javax.swing.JDialog {

    CRUD obc = new CRUD();
    DefaultTableModel modelo = new DefaultTableModel(new String[]{"ID", "Perfil"}, 0);
    ImagemJar ij = new ImagemJar();

    public Perfil() {
        super(new JFrame(), true);
        initComponents();
        setLocationRelativeTo(null);
        tabelaCargo.setModel(modelo);
        tabelaCargo.getColumnModel().getColumn(1).setPreferredWidth(400);
        listarNaTabela(obc.buscaCargos());

        tabelaCargo.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int codigo = tabelaCargo.getSelectedRow();
                jtNome.setText(String.valueOf(tabelaCargo.getValueAt(codigo, 1)));
                lbErro.setText("");
            }
        });
    }

    private void controlaLinhasDaTabela() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public final void listarNaTabela(List<Cargo> cg) {
        controlaLinhasDaTabela();
        if (!cg.isEmpty()) {
            for (int i = 0; i < cg.size(); i++) {
                modelo.addRow(new Object[]{cg.get(i).getCodCargo(), cg.get(i).getNomeCargo()});
            }

        }

    }
//=========================================

    /**
     * Este metodo e responsavel por atualizar os dados na tabela do formulario
     */

//     private static Image createFaviIcon (String fileName){ 
//	URL url = ImageIcon.class.getResource(fileName);  
//	Image faviIcon = Toolkit.getDefaultToolkit().getImage(url);  
//	return faviIcon;
//    }
    public void atualizarNaTabela() {
        List<Cargo> cg = obc.buscaCargos();
        int codigo = tabelaCargo.getSelectedRow();
        if (codigo == -1) {
            lbErro.setText("Selecione o Usuario que deseja Atualizar!!!");
        } else {
            String nome = (String) tabelaCargo.getValueAt(codigo, 1);
            for (int i = 0; i < cg.size(); i++) {
                String nome2 = (String) tabelaCargo.getValueAt(i, 1);
                if (nome.equals(nome2)) {
                    cg.get(i).setNomeCargo(jtNome.getText());
                    obc.actualizar(cg.get(i));
                    JOptionPane.showMessageDialog(null, "Atualizado com Sucesso", "Messagem", 1, new ImageIcon(ij.getImageIcon("/Imagens/update2.png").getImage()));
                    break;
                }
            }
        }
    }

    //===========================================
    /**
     * Este metodo e responsavel por remover os dados na tabela do formulario
     */
    public void removerNaTabela() {
        List<Cargo> cg = obc.buscaCargos();
        int codigo = tabelaCargo.getSelectedRow();
        if (codigo == -1) {
            lbErro.setText("Selecione o Usuario que deseja remover!!!");
        } else {
            String nome = (String) tabelaCargo.getValueAt(codigo, 1);
            for (int i = 0; i < cg.size(); i++) {
                String nome2 = (String) tabelaCargo.getValueAt(i, 1);
                if (nome.equals(nome2)) {

                    int j = JOptionPane.showConfirmDialog(null, "Deseja realmente Remover Este Usuario", "Messagem", 2);
                    if (j == JOptionPane.OK_OPTION) {
                        obc.excluir(cg.get(i));
                        JOptionPane.showMessageDialog(null, "Removido com Sucesso!!!", "Messagem", 1, new ImageIcon(ij.getImageIcon("/Imagens/Delete.png").getImage()));
                        break;
                    }

                }
            }
        }

    }

    /**
     * Este metodo e responsavel por gravar os dados na base de dados e
     * imprimilos na tabela do formulario chamando o metodo listarNaTabela
     */
    private void gravar() {
        boolean achou = false;

        if (jtNome.getText().equals("")) {
            lbErro.setText("Os Campos na podem estar vazios!!!");
        } else {
            List<Cargo> cg = obc.buscaCargos();
            for (int i = 0; i < cg.size(); i++) {
                if (cg.get(i).getNomeCargo().equals(jtNome.getText())) {
                    achou = true;
                    break;
                }
            }

            if (achou) {
                lbErro.setText("Essa Categoria  ja foi Salva, Registe uma nova Categoria!!!");
            } else {
                Cargo tp = new Cargo(jtNome.getText());
                obc.salvar(tp);
                JOptionPane.showMessageDialog(null, "Salvado com Sucesso", "Messagem", 1, new ImageIcon(ij.getImageIcon("/Imagens/salvar.png").getImage()));
                lbErro.setText("");
            }
        }
    }//fim de gravar

    private void pesquisarCargosTrabalhadores(String n, List<Cargo> cp, ArrayList<Cargo> p) {
        for (int i = 0; i < cp.size(); i++) {
            Cargo cargo = cp.get(i);
            if (cargo.getNomeCargo().toLowerCase().startsWith(n) || String.valueOf(cargo.getCodCargo()).startsWith(n)) {
                p.add(cargo);
            }
        }
        listarCargosPesquisados(p);
    }

    private void listarCargosPesquisados(ArrayList<Cargo> cg) {
        controlaLinhas();
        for (int i = 0; i < cg.size(); i++) {
            Cargo cargo = cg.get(i);
            modelo.addRow(new Object[]{cargo.getCodCargo(), cargo.getNomeCargo()});
        }
    }

    private void controlaLinhas() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    private void corPesquisar() {
        jtPesquisar.setForeground(new Color(204, 204, 204));
    }

    private void cargos(List<Cargo> cargos) {
        for (int i = 0; i < cargos.size(); i++) {
            Cargo cg = cargos.get(i);
            for (int j = 0; j < PainelUsuario.jtPerfil.getItemCount(); j++) {
                if (!cg.getNomeCargo().equalsIgnoreCase(PainelUsuario.jtPerfil.getItemAt(j))) {
                    PainelUsuario.jtPerfil.addItem(cg.getNomeCargo());
                    PainelUsuario.jtPerfil.validate();
                }
            }
        }
    }

    private void categoriasRemover(List<Cargo> cargo) {
        for (int i = 0; i < cargo.size(); i++) {
            Cargo cg = cargo.get(i);
            for (int j = 0; j < PainelUsuario.jtPerfil.getItemCount(); j++) {
                if (cg.getNomeCargo().equalsIgnoreCase(PainelUsuario.jtPerfil.getItemAt(j))) {
                    PainelUsuario.jtPerfil.removeItemAt(j);
                }
            }
        }
    }

    private void atualizarPanelProdutos() {
        panelComponentes.removeAll();
        panelComponentes.add(new PainelUsuario());
        panelComponentes.validate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        panelDescricao = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        btUpdate = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        brSalvar = new javax.swing.JButton();
        panelTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCargo = new javax.swing.JTable();
        lbErro = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtPesquisar = new javax.swing.JTextField();
        panelTodosComponentes = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDescricao.setBackground(new java.awt.Color(255, 255, 255));
        panelDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 18))); // NOI18N
        panelDescricao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNome.setText("Nome:");
        panelDescricao.add(lbNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 30));

        jtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtNomeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNomeKeyTyped(evt);
            }
        });
        panelDescricao.add(jtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 370, 29));

        btUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/update2.png"))); // NOI18N
        btUpdate.setText("Atualizar");
        btUpdate.setBorderPainted(false);
        btUpdate.setContentAreaFilled(false);
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });
        panelDescricao.add(btUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 150, 40));

        btExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Delete.png"))); // NOI18N
        btExcluir.setText("Remover");
        btExcluir.setBorderPainted(false);
        btExcluir.setContentAreaFilled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        panelDescricao.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 160, 40));

        brSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        brSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.png"))); // NOI18N
        brSalvar.setText("Gravar");
        brSalvar.setBorderPainted(false);
        brSalvar.setContentAreaFilled(false);
        brSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brSalvarActionPerformed(evt);
            }
        });
        panelDescricao.add(brSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 150, 40));

        jPanel4.add(panelDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 480, 100));

        panelTabela.setBackground(new java.awt.Color(255, 255, 255));
        panelTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Cargos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24), new java.awt.Color(0, 153, 255))); // NOI18N
        panelTabela.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaCargo = new javax.swing.JTable(){
            public boolean isCellEditable(int a,int b){
                return false;
            }
        };
        tabelaCargo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tabelaCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaCargo);

        panelTabela.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 440, 200));

        lbErro.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lbErro.setForeground(new java.awt.Color(255, 0, 0));
        panelTabela.add(lbErro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 460, 20));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisa.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel6.add(jLabel3);
        jLabel3.setBounds(0, 0, 30, 26);

        jtPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtPesquisar.setForeground(new java.awt.Color(204, 204, 204));
        jtPesquisar.setText("Pesquisar Categoria por codigo ou nome");
        jtPesquisar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPesquisarActionPerformed(evt);
            }
        });
        jtPesquisar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtPesquisarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtPesquisarFocusLost(evt);
            }
        });
        jtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtPesquisarKeyReleased(evt);
            }
        });
        jPanel6.add(jtPesquisar);
        jtPesquisar.setBounds(30, 6, 320, 20);

        panelTabela.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 360, 30));

        jPanel4.add(panelTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 480, 320));

        panelTodosComponentes.setBackground(new java.awt.Color(51, 141, 252));
        panelTodosComponentes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Formulario de Cargos");

        javax.swing.GroupLayout panelTodosComponentesLayout = new javax.swing.GroupLayout(panelTodosComponentes);
        panelTodosComponentes.setLayout(panelTodosComponentesLayout);
        panelTodosComponentesLayout.setHorizontalGroup(
            panelTodosComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTodosComponentesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        panelTodosComponentesLayout.setVerticalGroup(
            panelTodosComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTodosComponentesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel4.add(panelTodosComponentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 70));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNomeKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            gravar();
            cargos(obc.buscaCargos());
            atualizarPanelProdutos();
            listarNaTabela(obc.buscaCargos());
        }
    }//GEN-LAST:event_jtNomeKeyPressed

    private void brSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brSalvarActionPerformed
        gravar();
        jtNome.setText("");
        atualizarPanelProdutos();
        listarNaTabela(obc.buscaCargos());
    }//GEN-LAST:event_brSalvarActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        atualizarNaTabela();
        atualizarPanelProdutos();
        listarNaTabela(obc.buscaCargos());
    }//GEN-LAST:event_btUpdateActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        removerNaTabela();
        atualizarPanelProdutos();
        listarNaTabela(obc.buscaCargos());
    }//GEN-LAST:event_btExcluirActionPerformed

    private void jtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPesquisarActionPerformed

    private void jtPesquisarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtPesquisarFocusGained
        jtPesquisar.setText("");
        jtPesquisar.setForeground(Color.BLACK);
    }//GEN-LAST:event_jtPesquisarFocusGained

    private void jtPesquisarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtPesquisarFocusLost
        jtPesquisar.setText("Pesquisar clientes por nome,apelido ou codigo");
        corPesquisar();
    }//GEN-LAST:event_jtPesquisarFocusLost

    private void jtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPesquisarKeyReleased
        pesquisarCargosTrabalhadores(jtPesquisar.getText(), obc.buscaCargos(), new ArrayList<Cargo>());
    }//GEN-LAST:event_jtPesquisarKeyReleased

    private void jtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNomeKeyTyped
//        char c = evt.getKeyChar();
//        if ((c < 'a' || c > 'z') && (c < 'A' | c > 'Z')&& (c > ' ')) {
//            evt.consume();
//        }
    }//GEN-LAST:event_jtNomeKeyTyped

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Perfil().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brSalvar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtPesquisar;
    private javax.swing.JLabel lbErro;
    private javax.swing.JLabel lbNome;
    private javax.swing.JPanel panelDescricao;
    private javax.swing.JPanel panelTabela;
    private javax.swing.JPanel panelTodosComponentes;
    private javax.swing.JTable tabelaCargo;
    // End of variables declaration//GEN-END:variables

}
