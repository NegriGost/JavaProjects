/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.CRUD;
import Modelo.Usuarios;
import static Visao.MenuPrincipal.lbUsuario;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigues
 */
public class MudancaSenhas extends javax.swing.JDialog{

    /**
     * Creates new form MudancaSenhas
     */
    CRUD obc=new CRUD();
    public MudancaSenhas() {
        super(new JFrame(),true);
        initComponents();
        String s=lbUsuario.getText();
        String[]nome=s.split(": ");
        jtUsuario.setText(""+nome[nome.length-1]);
        setLocationRelativeTo(null); 
        lbOk.setVisible(false); 
        lbOK2.setVisible(false); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelTodosComponentes = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btSair = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtConfirmarSenha = new javax.swing.JPasswordField();
        jtSenhaAnterior = new javax.swing.JPasswordField();
        lbOK2 = new javax.swing.JLabel();
        lbOk = new javax.swing.JLabel();
        jtNovaSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTodosComponentes.setBackground(new java.awt.Color(51, 141, 252));
        panelTodosComponentes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Atualizar Senhas");

        javax.swing.GroupLayout panelTodosComponentesLayout = new javax.swing.GroupLayout(panelTodosComponentes);
        panelTodosComponentes.setLayout(panelTodosComponentesLayout);
        panelTodosComponentesLayout.setHorizontalGroup(
            panelTodosComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTodosComponentesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTodosComponentesLayout.setVerticalGroup(
            panelTodosComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTodosComponentesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelTodosComponentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 70));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Confirmar Senha:");
        panelPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, 20));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Usuario:");
        panelPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        jtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtUsuario.setFocusable(false);
        panelPrincipal.add(jtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 240, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Senha Actual:");
        panelPrincipal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 20));

        btSair.setBackground(new java.awt.Color(0, 153, 255));
        btSair.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        panelPrincipal.add(btSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 110, 40));

        btSalvar.setBackground(new java.awt.Color(0, 153, 255));
        btSalvar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        btSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btSalvarKeyPressed(evt);
            }
        });
        panelPrincipal.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 110, 40));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Nova Senha:");
        panelPrincipal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 20));

        jtConfirmarSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtConfirmarSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtConfirmarSenhaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtConfirmarSenhaKeyReleased(evt);
            }
        });
        panelPrincipal.add(jtConfirmarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 240, 30));

        jtSenhaAnterior.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtSenhaAnterior.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtSenhaAnteriorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtSenhaAnteriorKeyReleased(evt);
            }
        });
        panelPrincipal.add(jtSenhaAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 240, 30));

        lbOK2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/iOK.png"))); // NOI18N
        panelPrincipal.add(lbOK2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, 50));

        lbOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/iOK.png"))); // NOI18N
        panelPrincipal.add(lbOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, 50));

        jtNovaSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtNovaSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtNovaSenhaKeyPressed(evt);
            }
        });
        panelPrincipal.add(jtNovaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 240, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
       salvarSenhas(obc.buscaUtilizador(),jtUsuario.getText());
       jtNovaSenha.setText("");
       jtConfirmarSenha.setText("");
       jtSenhaAnterior.setText(""); 
       lbOk.setVisible(false);
       lbOK2.setVisible(false); 
    }//GEN-LAST:event_btSalvarActionPerformed

    private void jtConfirmarSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtConfirmarSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btSalvar.grabFocus();
        }
    }//GEN-LAST:event_jtConfirmarSenhaKeyPressed

    private void jtConfirmarSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtConfirmarSenhaKeyReleased
         combinarSenhas2(jtNovaSenha.getText(),jtConfirmarSenha.getText());
    }//GEN-LAST:event_jtConfirmarSenhaKeyReleased

    private void jtSenhaAnteriorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtSenhaAnteriorKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtNovaSenha.grabFocus();
        }
    }//GEN-LAST:event_jtSenhaAnteriorKeyPressed

    private void jtSenhaAnteriorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtSenhaAnteriorKeyReleased
         combinarSenhas(jtSenhaAnterior.getText(),obc.buscaUtilizador());
    }//GEN-LAST:event_jtSenhaAnteriorKeyReleased

    private void jtNovaSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNovaSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtConfirmarSenha.grabFocus();
        }
    }//GEN-LAST:event_jtNovaSenhaKeyPressed

    private void btSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btSalvarKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            salvarSenhas(obc.buscaUtilizador(), jtUsuario.getText());
            jtNovaSenha.setText("");
            jtConfirmarSenha.setText("");
            jtSenhaAnterior.setText("");
            lbOk.setVisible(false);
            lbOK2.setVisible(false);
        }
    }//GEN-LAST:event_btSalvarKeyPressed

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
//            java.util.logging.Logger.getLogger(MudancaSenhas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MudancaSenhas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MudancaSenhas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MudancaSenhas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MudancaSenhas().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jtConfirmarSenha;
    private javax.swing.JPasswordField jtNovaSenha;
    private javax.swing.JPasswordField jtSenhaAnterior;
    public static javax.swing.JTextField jtUsuario;
    private javax.swing.JLabel lbOK2;
    private javax.swing.JLabel lbOk;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTodosComponentes;
    // End of variables declaration//GEN-END:variables

    private void combinarSenhas(String senha, List<Usuarios> utilizador) {
        boolean encontrou=false;
        for (int i = 0; i < utilizador.size(); i++) {
            Usuarios usu = utilizador.get(i);
            if ((usu.getSenha().equals(senha)) && (usu.getUtilizador().equals(jtUsuario.getText()))) {
                encontrou=true;
                break;
            }
        }
        encontrou(encontrou);
    }

    private void combinarSenhas2(String senhaNova, String senhaConfirmada) {
        if(senhaNova.equals(senhaConfirmada)){
            lbOK2.setVisible(true);
        }else{lbOK2.setVisible(false);}
    }

    private void salvarSenhas(List<Usuarios> utilizador,String usuario) {
        for (int i = 0; i < utilizador.size(); i++) {
            Usuarios usu = utilizador.get(i);
            if(usu.getUtilizador().equals(usuario))
            {
                usu.setSenha(jtNovaSenha.getText());
                obc.actualizar(usu);
                JOptionPane.showMessageDialog(null,"Senha atualizada com Sucesso!!","Messagem",1);
                break;
            }
        }
    }

    private void encontrou(boolean encontrou) {
        if (encontrou) {
            lbOk.setVisible(true);
        } else {
            lbOk.setVisible(false);
        }
    }

}
