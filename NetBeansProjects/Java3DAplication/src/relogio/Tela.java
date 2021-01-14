
package relogio;

import java.awt.event.KeyEvent;

/**
 *
 * @author Rodrigues Mafumo e Dionisio Macamo
 */
public class Tela extends javax.swing.JFrame {

    public Tela() {
        initComponents();
        this.setSize(1366,760);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgCor = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        paFigs1 = new relogio.PanelRelogio();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        cuboEmRotacao = new javax.swing.JMenu();
        menuRotacaoFaceaFace = new javax.swing.JMenu();
        menuMovimentoRotativo = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(new java.awt.GridLayout(1, 3));

        jPanel5.setLayout(new java.awt.BorderLayout());

        paFigs1.setBackground(new java.awt.Color(255, 255, 255));
        paFigs1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                paFigs1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout paFigs1Layout = new javax.swing.GroupLayout(paFigs1);
        paFigs1.setLayout(paFigs1Layout);
        paFigs1Layout.setHorizontalGroup(
            paFigs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 844, Short.MAX_VALUE)
        );
        paFigs1Layout.setVerticalGroup(
            paFigs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
        );

        jPanel5.add(paFigs1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel3.add(jPanel7, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        cuboEmRotacao.setText("Cubo_Em_Rotação");
        cuboEmRotacao.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                cuboEmRotacaoMenuSelected(evt);
            }
        });
        jMenuBar1.add(cuboEmRotacao);

        menuRotacaoFaceaFace.setText("Rotação_Face_A_Face");
        menuRotacaoFaceaFace.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                menuRotacaoFaceaFaceMenuSelected(evt);
            }
        });
        jMenuBar1.add(menuRotacaoFaceaFace);

        menuMovimentoRotativo.setText("Cubos_Em_Movimento_Rotativo");
        menuMovimentoRotativo.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                menuMovimentoRotativoMenuSelected(evt);
            }
        });
        jMenuBar1.add(menuMovimentoRotativo);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        switch(evt.getKeyCode()){
            case KeyEvent.VK_SPACE:System.exit(0);break;
            case KeyEvent.VK_H:
                if(paFigs1.h!=255){paFigs1.h+=5;}else{paFigs1.h=255;};
                
            
                break;
            case KeyEvent.VK_M: if(paFigs1.m!=255){paFigs1.m+=5;}else{paFigs1.m=255;};break;
            case KeyEvent.VK_S:if(paFigs1.s!=255){paFigs1.s+=5;}else{paFigs1.s=255;};break;
            case KeyEvent.VK_1:paFigs1.h-=5;break;
            case KeyEvent.VK_2:paFigs1.m-=5;break;
            case KeyEvent.VK_3:paFigs1.s-=5;break;
        }
    }//GEN-LAST:event_formKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:
        switch(evt.getKeyCode()){
            case KeyEvent.VK_SPACE:System.out.println("relogio.Tela1.jPanel1KeyPressed()");;break;
        }
    }//GEN-LAST:event_jPanel1KeyPressed

    private void paFigs1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paFigs1KeyPressed
        switch(evt.getKeyCode()){
            case KeyEvent.VK_SPACE:System.exit(0);break;
        }
    }//GEN-LAST:event_paFigs1KeyPressed

    private void cuboEmRotacaoMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_cuboEmRotacaoMenuSelected
        Cubo_Em_Rotacao app=new Cubo_Em_Rotacao();
        app.start();
    }//GEN-LAST:event_cuboEmRotacaoMenuSelected

    private void menuRotacaoFaceaFaceMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_menuRotacaoFaceaFaceMenuSelected
        Cubos_Rodando_Face_A_Face app=new Cubos_Rodando_Face_A_Face();
        app.start();
    }//GEN-LAST:event_menuRotacaoFaceaFaceMenuSelected

    private void menuMovimentoRotativoMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_menuMovimentoRotativoMenuSelected
       Cubos_Em_Movimento_Rotativo app=new Cubos_Em_Movimento_Rotativo();
       app.start();
    }//GEN-LAST:event_menuMovimentoRotativoMenuSelected
    
    public void oi(){
//        paFigs1.desenha(0, 0, slAltura.getValue());
        paFigs1.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgCor;
    private javax.swing.JMenu cuboEmRotacao;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JMenu menuMovimentoRotativo;
    private javax.swing.JMenu menuRotacaoFaceaFace;
    private relogio.PanelRelogio paFigs1;
    // End of variables declaration//GEN-END:variables
}
