/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

/**
 *
 * @author Rodrigues
 */
   

import Controle.CRUD;
import Controle.ImagemJar;
import Modelo.Compras;
import com.mysql.jdbc.Connection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class PedidosPendentes extends javax.swing.JPanel {

    /**
     * Creates new form PedidosPendentes
     */
     CRUD obc = new CRUD();
    ImagemJar ij = new ImagemJar();
    DefaultTableModel modelo = new DefaultTableModel(new String[]{"Nº do Pedido", "Cliente", "Mesa", "Estado", "Data", "Total","Vendedor"}, 0);
    NumberFormat f = NumberFormat.getCurrencyInstance(new Locale("Portuguese", "MZ"));
    private SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
    public PedidosPendentes() {
        initComponents();
         tabela();
        jtDate.setDateFormat(d);
        try {
            listarPedidoPorData(obc.buscaPedidos(), jtDate.getText());
        } catch (ParseException ex) {
            Logger.getLogger(Recibos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private void listarPedidoPorData(List<Compras> pedidos, String text) throws ParseException {
        controlaLinhasPedido();
        for (Compras pedido : pedidos) {
            if (d.format(pedido.getData()).equals(text) && (pedido.getEstadoVenda().equalsIgnoreCase("Pendente"))) {
                modelo.addRow(new Object[]{pedido.getCodigoVenda(), pedido.getClientes().getNomeCli(), pedido.getMesa(), pedido.getEstadoVenda(), pedido.getData(), pedido.getTotalPedido(),pedido.getFunc().getNome()+" "+pedido.getFunc().getApelido()});
            }
        }
        totalFacturas();
    }
     
       
    
    private void tabela() {
        tabela.setModel(modelo);
        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int codigo = tabela.getSelectedRow();
                jtNFatura.setText(String.valueOf(tabela.getValueAt(codigo, 0)));
            }

        });

    }//fim de tabela

    private void buscarFatura(String text, int codigo) {
        if (tabela.getValueAt(codigo, 2) != null && tabela.getValueAt(codigo, 0).equals(text)) {
            facturaComMesa(text);
        } else {
            facturaSemMesa(text);
        }
    }//fim de Buscar Fatura

    private void facturaSemMesa(String text) {
        String url = "jdbc:mysql://localhost:3306/restaurante?zeroDateTimeBehavior=convertToNull";
        InputStream icon =ij.getArquivo("/Imagens/images.jpg");       
        try {
            Connection c = (Connection) DriverManager.getConnection(url, "root", "");
            String caminho = "/Faturas/ICMFaturaSemCliente.jasper";
            Map mapa = new HashMap();
            mapa.put("codVenda", text);
            mapa.put("IMAGEM",icon);
            JasperPrint inf = JasperFillManager.fillReport(ij.getArquivo(caminho), mapa, c);
            JasperViewer visor = new JasperViewer(inf, false);
            visor.setTitle("Fatura");
            visor.setBounds(0, 0, 1365, 800);
            visor.setVisible(true);
        } catch (SQLException | JRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar a Fatura");
        }
    }

    private void facturaComMesa(String text) {
        String url = "jdbc:mysql://localhost:3306/restaurante?zeroDateTimeBehavior=convertToNull";
        InputStream icon =ij.getArquivo("/Imagens/images.jpg");       
        try {
            Connection c = (Connection) DriverManager.getConnection(url, "root", "");
            String caminho = "/Faturas/ICMFatura.jasper";
            Map mapa = new HashMap();
            mapa.put("codVenda", text);
            mapa.put("IMAGEM",icon);
            JasperPrint inf = JasperFillManager.fillReport(ij.getArquivo(caminho), mapa, c);
            JasperViewer visor = new JasperViewer(inf, false);
            visor.setTitle("Fatura");
            visor.setBounds(0, 0, 1365, 800);
            visor.setVisible(true);

        } catch (SQLException | JRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar a Fatura");
        }
    }

    private void totalFacturas() throws ParseException {
        double t = 0;
        for (int i = 0; i < tabela.getRowCount(); i++) {
            t += f.parse((String) tabela.getValueAt(i, 5)).doubleValue();
        }
        jtTotal.setText(String.valueOf(f.format(t)));
    }

    private void controlaLinhasPedido() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }
      

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        painelTitulo = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jtNFatura = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        panelTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        lbTotal = new javax.swing.JLabel();
        jtTotal = new javax.swing.JTextField();
        jtBuscar = new javax.swing.JButton();
        jtDate = new datechooser.beans.DateChooserCombo();

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        painelTitulo.setBackground(new java.awt.Color(51, 141, 252));
        painelTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbTitulo.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Pedidos Pendentes");

        javax.swing.GroupLayout painelTituloLayout = new javax.swing.GroupLayout(painelTitulo);
        painelTitulo.setLayout(painelTituloLayout);
        painelTituloLayout.setHorizontalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(381, 381, 381))
        );
        painelTituloLayout.setVerticalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nº do Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24), new java.awt.Color(0, 153, 255))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtNFatura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtNFatura.setFocusable(false);
        jPanel2.add(jtNFatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 1000, 30));

        Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Print.png"))); // NOI18N
        Buscar.setToolTipText("Importar uma Fatura");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        jPanel2.add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 120, 70));

        panelTabela.setBackground(new java.awt.Color(255, 255, 255));
        panelTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Pedidos Pendentes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24), new java.awt.Color(0, 153, 255))); // NOI18N
        panelTabela.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabela = new javax.swing.JTable(){
            public boolean isCellEditable(int a,int b){
                return false;
            }
        };
        tabela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabela);

        panelTabela.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 78, 1110, 300));

        lbTotal.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lbTotal.setText("Total:");
        panelTabela.add(lbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(722, 380, 100, 50));

        jtTotal.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jtTotal.setForeground(new java.awt.Color(0, 153, 255));
        jtTotal.setFocusable(false);
        panelTabela.add(jtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 390, 270, 40));

        jtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        jtBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        jtBuscar.setToolTipText("Pesquisar Pedidos");
        jtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBuscarActionPerformed(evt);
            }
        });
        panelTabela.add(jtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 40, 40, 30));

        jtDate.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));
        panelTabela.add(jtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 40, 220, 30));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1172, Short.MAX_VALUE)
                    .addComponent(panelTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
            .addComponent(painelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(painelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        int cod = tabela.getSelectedRow();
        if (cod == -1) {
            JOptionPane.showMessageDialog(null, "Por favor! selecione a linha que deseja verificar a fatura.", "Messagem", 0);
        } else {
            buscarFatura(jtNFatura.getText(), tabela.getSelectedRow());
        }
    }//GEN-LAST:event_BuscarActionPerformed

    private void jtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBuscarActionPerformed
        try {
            listarPedidoPorData(obc.buscaPedidos(), jtDate.getText());
        } catch (ParseException ex) {
            Logger.getLogger(Recibos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jtBuscar;
    private datechooser.beans.DateChooserCombo jtDate;
    private javax.swing.JTextField jtNFatura;
    private javax.swing.JTextField jtTotal;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTabela;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
