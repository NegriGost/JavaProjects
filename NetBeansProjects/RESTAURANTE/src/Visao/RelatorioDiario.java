/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;
import Controle.CRUD;
import Controle.ImagemJar;
import Modelo.Itens_Produtos;
import Modelo.Categoria;
import com.mysql.jdbc.Connection;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Rodrigues
 */
public final class RelatorioDiario extends javax.swing.JPanel {

    String[] colunas = {"Descrição", "Quantidade", "Preco Total"};
    String[] colunasMaisConsumida = {"Descrição", "Quantidade", "Preco Total"};
    String[] colunasMenusConsumida = {"Descrição", "Quantidade", "Preco Total"};
    DefaultTableModel model = new DefaultTableModel(colunas, 0);
    DefaultTableModel modelMaisConsumida = new DefaultTableModel(colunasMaisConsumida, 0);
    DefaultTableModel modelMenusConsumida = new DefaultTableModel(colunasMenusConsumida, 0);
    List<Integer> imc=new ArrayList<>();
    List<Integer> kmc=new ArrayList<>();
    CRUD crd = new CRUD();
    NumberFormat f = NumberFormat.getCurrencyInstance(new Locale("Portuguese", "MZ"));
    private SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");

    public RelatorioDiario() {

        initComponents();
        jtDate.setDateFormat(d);
        lbBla.setVisible(false);
        lbBlaBla.setVisible(false);
        tabela.setModel(model);
        listarCategoria(crd.buscaTipoProdutos());
        listarVendas(crd.buscaItens());
        tabela.getColumnModel().getColumn(0).setPreferredWidth(900);

    }

    public void listarCategoria(List<Categoria> pc) {
        for (Categoria produtoCategoria : pc) {
            jtCategorias.addItem(produtoCategoria.getNomeCategoria());
        }
    }

    private void listarVendas(List<Itens_Produtos> itens) {
        controlaLinhasPedido();
        para:
        for (int i = 0; i < itens.size(); i++) {
            Itens_Produtos it = itens.get(i);
            if (d.format(it.getPedidos().getData()).equals(jtDate.getText())&&it.getPedidos().getEstadoVenda().equalsIgnoreCase("Pago")) {
                if (tabela.getRowCount() >= 0) {
                    for (int k = 0; k < tabela.getRowCount(); k++) {
                        String nome = (String) tabela.getValueAt(k, 0);
                        if (nome.equals(it.getProdutos().getNomeProd())) {
                            tabela.setValueAt((int) tabela.getValueAt(k, 1) + it.getQuantidade(), k, 1);
                            tabela.setValueAt((double) tabela.getValueAt(k, 2) + it.getPrecoTotal(), k, 2);
                            continue para;
                        }
                    }
                  model.addRow(new Object[]{it.getProdutos().getNomeProd(), it.getQuantidade(), it.getPrecoTotal()});
                }
            }
        }
        totalVendas();
        boolean verdade=false;
        for (int i = 0; i < tabela.getRowCount(); i++) {
            for (int j = 0; j < tabela.getRowCount(); j++) {
                if ((int) tabela.getValueAt(i, 1) != (int) tabela.getValueAt(j, 1)) {
                    verdade=true;
                }
            }

        }
        if (verdade) {
            produtoMaisVendido();
            produtoMenusVendido();
        }
    }

    private void controlaLinhasPedido() {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }
     private void controlaLinhasPedidoMais() {
        while (modelMaisConsumida.getRowCount() > 0) {
            modelMaisConsumida.removeRow(0);
        }
    }

      private void controlaLinhasPedidoMenus() {
        while (modelMenusConsumida.getRowCount() > 0) {
            modelMenusConsumida.removeRow(0);
        }
    }


    private void totalVendas() {
        double t = 0;
        for (int i = 0; i < tabela.getRowCount(); i++) {
            t += (double) tabela.getValueAt(i, 2);
        }
        jtTotal.setText(String.valueOf(f.format(t)));
    }
   ImagemJar ij = new ImagemJar();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jtCategorias = new javax.swing.JComboBox<>();
        jtDate = new datechooser.beans.DateChooserCombo();
        jtBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        lbTotal = new javax.swing.JLabel();
        jtTotal = new javax.swing.JTextField();
        lbCategorias = new javax.swing.JLabel();
        lbBlaBla = new javax.swing.JLabel();
        lbQuantidade = new javax.swing.JLabel();
        lbBla = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelTitulo.setBackground(new java.awt.Color(51, 141, 252));
        panelTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbTitulo.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Relatório de Vendas Diárias");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(352, 352, 352)
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTitulo)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24), new java.awt.Color(0, 153, 255))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtCategorias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas Categorias" }));
        jPanel2.add(jtCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 880, 30));

        jtDate.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));
        jPanel2.add(jtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 210, 30));

        jtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        jtBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        jtBuscar.setToolTipText("Pesquisar");
        jtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(jtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 40, 40, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Produtos Vendidos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24), new java.awt.Color(0, 153, 255))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabela = new javax.swing.JTable(){
            public boolean isCellEditable(int a,int b){
                return false;
            }
        };
        tabela.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1140, 240));

        lbTotal.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        lbTotal.setText("Total:");
        jPanel3.add(lbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 370, 80, 70));

        jtTotal.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jtTotal.setForeground(new java.awt.Color(0, 153, 255));
        jtTotal.setFocusable(false);
        jPanel3.add(jtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 390, 290, 40));

        lbCategorias.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbCategorias.setForeground(new java.awt.Color(0, 204, 0));
        lbCategorias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lbCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 220, 30));

        lbBlaBla.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbBlaBla.setText("Quantidade total de");
        jPanel3.add(lbBlaBla, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 200, -1));

        lbQuantidade.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbQuantidade.setForeground(new java.awt.Color(0, 204, 0));
        jPanel3.add(lbQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, 70, 30));

        lbBla.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbBla.setText("Consumidos(as) é:");
        jPanel3.add(lbBla, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 180, 30));

        Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Print.png"))); // NOI18N
        Buscar.setToolTipText("Importar um Relatorio\n");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        jPanel3.add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, -1, 70));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBuscarActionPerformed
        imc=new ArrayList<>();
        kmc=new ArrayList<>();
        if (!(jtCategorias.getSelectedItem() == null)) {
            if (jtCategorias.getSelectedItem().equals("Todas Categorias")) {
                listarVendas(crd.buscaItens());
                lbBla.setVisible(false);
                lbBlaBla.setVisible(false);
                lbCategorias.setText("");
                lbQuantidade.setText("");
            } else {
                listarPorCategorias(jtCategorias.getSelectedItem().toString(), crd.buscaItens());
                lbBla.setVisible(true);
                lbBlaBla.setVisible(true);
            }
        }
        
    }//GEN-LAST:event_jtBuscarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        String url = "jdbc:mysql://localhost:3306/restaurante?zeroDateTimeBehavior=convertToNull";
        try {
            InputStream icon =ij.getArquivo("/Imagens/images.jpg");       
            Connection c = (Connection) DriverManager.getConnection(url, "root", "");
            String caminho = "/Faturas/RProd.jasper";
            Map mapa = new HashMap();
            mapa.put("data",jtDate.getText());
            mapa.put("Image",icon);
            JasperPrint inf = JasperFillManager.fillReport(ij.getArquivo(caminho), mapa, c);
            JasperViewer visor = new JasperViewer(inf, false);
            visor.setTitle("Relatorio de Produtos");
            visor.setLocationRelativeTo(null);
            visor.setVisible(true);
            visor.setBounds(0, 0, 1365, 800);
            visor.toFront();
        } catch (SQLException | JRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar a Fatura");
        }
    }//GEN-LAST:event_BuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jtBuscar;
    private javax.swing.JComboBox<String> jtCategorias;
    private datechooser.beans.DateChooserCombo jtDate;
    private javax.swing.JTextField jtTotal;
    private javax.swing.JLabel lbBla;
    private javax.swing.JLabel lbBlaBla;
    private javax.swing.JLabel lbCategorias;
    private javax.swing.JLabel lbQuantidade;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

//       private void cancelarPedidos() {
//        for (int i = tabelaMaisConsumida.getRowCount() - 1; i >= 0; i--) {
//            modelMaisConsumida.removeRow(i);
//        }
//       }
//    
//       private void cancelarPedidos2() {
//        for (int i = tabelaMenusConsumida.getRowCount() - 1; i >= 0; i--) {
//            modelMenusConsumida.removeRow(i);
//        }
//       }
    private void produtoMaisVendido() {
        int maior = 0, posicao = 0;
        if (tabela.getRowCount() != 0) {
            for (int k = 0; k < tabela.getRowCount(); k++) {
                int pmv = (int) tabela.getValueAt(k, 1);
                if (maior < pmv) {
                    maior = pmv;
                    posicao = k;
                }else if(maior==pmv){imc.add(k);}
            }
            imc.add(posicao);
            controlaLinhasPedidoMais();
            for (int i = 0; i < imc.size(); i++) {
                Integer get = imc.get(i);
                modelMaisConsumida.addRow(new Object[]{String.valueOf(tabela.getValueAt(get, 0)), String.valueOf(tabela.getValueAt(get, 1)), String.valueOf(tabela.getValueAt(get, 2))});
            }

        }
    }

    private void produtoMenusVendido() {
        int menor = 1000000000, linha = 0;
        boolean encontrou = false;int pos=0;
        if (tabela.getRowCount() != 0 && tabela.getRowCount() != 1) {
            for (int k = 0; k < tabela.getRowCount(); k++) {
                int pmv = (int) tabela.getValueAt(k, 1);
                if (menor > pmv) {
                    menor = pmv;
                    linha = k;
                    encontrou = true;
                } else if(menor>pmv) {
                    kmc.add(k);
                }
            }

            if (encontrou) {
                kmc.add(linha);
            }
            
            controlaLinhasPedidoMenus();
            for (int i = 0; i < kmc.size(); i++) {
                Integer get = kmc.get(i);
                modelMenusConsumida.addRow(new Object[]{String.valueOf(tabela.getValueAt(get, 0)), String.valueOf(tabela.getValueAt(get, 1)), String.valueOf(tabela.getValueAt(get, 2))});
            }
        }
    }

    private void listarPorCategorias(String txt, List<Itens_Produtos> itens) {
        controlaLinhasPedido();
        para:
        for (int i = 0; i < itens.size(); i++) {
            Itens_Produtos it = itens.get(i);
            if (it.getProdutos().getCateg().getNomeCategoria().equals(txt) && it.getPedidos().getEstadoVenda().equalsIgnoreCase("Pago")&& d.format(it.getPedidos().getData()).equals(jtDate.getText())) {
                if (tabela.getRowCount() >= 0) {
                    for (int k = 0; k < tabela.getRowCount(); k++) {
                        String nome = (String) tabela.getValueAt(k, 0);
                        if (nome.equals(it.getProdutos().getNomeProd())) {
                            tabela.setValueAt((int) tabela.getValueAt(k, 1) + it.getQuantidade(), k, 1);
                            tabela.setValueAt((double) tabela.getValueAt(k, 2) + it.getPrecoTotal(), k, 2);
                            continue para;
                        }
                    }
                }
                model.addRow(new Object[]{it.getProdutos().getNomeProd(), it.getQuantidade(), it.getPrecoTotal()});
            }
    }

        totalVendas();
        boolean verdade=false;
        for (int i = 0; i < tabela.getRowCount(); i++) {
            for (int j = 0; j < tabela.getRowCount(); j++) {
                if ((int) tabela.getValueAt(i, 1) != (int) tabela.getValueAt(j, 1)) {
                    verdade=true;
                }
            }

        }
        if (verdade) {
            produtoMaisVendido();
            produtoMenusVendido();
        }
        quantidadeTotalProdutosPorCategoria(jtCategorias.getSelectedItem().toString());
    }

    private void quantidadeTotalProdutosPorCategoria(String txt) {
        lbCategorias.setText(txt);
        int qtdTotal = 0;
        for (int i = 0; i < tabela.getRowCount(); i++) {
            qtdTotal += (int) tabela.getValueAt(i, 1);

        }
        lbQuantidade.setText(String.valueOf(qtdTotal));
    }
}