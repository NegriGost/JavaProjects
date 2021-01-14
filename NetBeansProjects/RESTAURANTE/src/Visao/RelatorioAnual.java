/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.CRUD;
import Modelo.Itens_Produtos;
import Modelo.Categoria;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigues
 */
public class RelatorioAnual extends javax.swing.JPanel {

    String[] colunas = {"Descrição", "Quantidade", "Preco Total"};
    DefaultTableModel model = new DefaultTableModel(colunas, 0);
    CRUD crd = new CRUD();
    NumberFormat f = NumberFormat.getCurrencyInstance(new Locale("Portuguese", "MZ"));
    private SimpleDateFormat d = new SimpleDateFormat("yyyy");

    public RelatorioAnual() {
        initComponents();
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
            if (Integer.parseInt(d.format(it.getPedidos().getData())) == jtAno.getYear()&& it.getPedidos().getEstadoVenda().equalsIgnoreCase("Pago")) {
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
        produtoMaisVendido();
        produtoMenusVendido();
    }

    private void controlaLinhasPedido() {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    private void totalVendas() {
        double t = 0;
        for (int i = 0; i < tabela.getRowCount(); i++) {
            t += (double) tabela.getValueAt(i, 2);
        }
        jtTotal.setText(String.valueOf(f.format(t)));
    }

    private void produtoMaisVendido() {
        int maior = 0, posicao = 0;
        if (tabela.getRowCount() != 0) {
            for (int k = 0; k < tabela.getRowCount(); k++) {
                int pmv = (int) tabela.getValueAt(k, 1);
                if (maior < pmv) {
                    maior = pmv;
                    posicao = k;
                }
            }
            lbProdutoMaisVendido.setText(String.valueOf(tabela.getValueAt(posicao, 0)));
        } else {
            lbProdutoMaisVendido.setText("");
        }
    }

    private void produtoMenusVendido() {
        int menor = 10000000, linha = 0;
        if (tabela.getRowCount() != 0) {
            for (int k = 0; k < tabela.getRowCount(); k++) {
                int pmv = (int) tabela.getValueAt(k, 1);
                if (menor > pmv) {
                    menor = pmv;
                    linha = k;
                }
            }
            lbProdutoMenusVendido.setText(String.valueOf(tabela.getValueAt(linha, 0)));
        } else {
            lbProdutoMenusVendido.setText("");
        }
    }

    private void listarPorCategorias(String txt, List<Itens_Produtos> itens) {
        controlaLinhasPedido();
        para:
        for (int i = 0; i < itens.size(); i++) {
            Itens_Produtos it = itens.get(i);
            if (it.getProdutos().getCateg().getNomeCategoria().equals(txt) && it.getPedidos().getEstadoVenda().equalsIgnoreCase("Pago") && Integer.parseInt(d.format(it.getPedidos().getData())) == jtAno.getYear()) {
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
        produtoMaisVendido();
        produtoMenusVendido();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jtCategorias = new javax.swing.JComboBox<>();
        jtBuscar3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lbDescricao3 = new javax.swing.JLabel();
        lbDescricao2 = new javax.swing.JLabel();
        lbProdutoMaisVendido = new javax.swing.JLabel();
        lbProdutoMenusVendido = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jtTotal = new javax.swing.JTextField();
        lbCategorias = new javax.swing.JLabel();
        lbBlaBla = new javax.swing.JLabel();
        lbQuantidade = new javax.swing.JLabel();
        lbBla = new javax.swing.JLabel();
        jtAno = new com.toedter.calendar.JYearChooser();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelTitulo.setBackground(new java.awt.Color(51, 141, 252));
        panelTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbTitulo.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Relatório de Vendas Anuais");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTitulo)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24), new java.awt.Color(0, 153, 255))); // NOI18N

        jtCategorias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas Categorias" }));

        jtBuscar3.setBackground(new java.awt.Color(255, 255, 255));
        jtBuscar3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtBuscar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        jtBuscar3.setToolTipText("Pesquisar");
        jtBuscar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBuscar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jtCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jtBuscar3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtBuscar3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Vendas Efectuadas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24), new java.awt.Color(0, 153, 255))); // NOI18N

        tabela = new javax.swing.JTable(){
            public boolean isCellEditable(int a,int b){
                return false;
            }
        };
        tabela.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
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

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 153, 255));
        jLabel5.setText("Top Produtos:");

        lbDescricao3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbDescricao3.setText("1. Produto Mais Vendido:");

        lbDescricao2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbDescricao2.setText("2. Produto Menus Vendido:");

        lbProdutoMaisVendido.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbProdutoMaisVendido.setForeground(new java.awt.Color(0, 204, 0));
        lbProdutoMaisVendido.setText("Hamburguer Completo");

        lbProdutoMenusVendido.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbProdutoMenusVendido.setForeground(new java.awt.Color(255, 0, 51));
        lbProdutoMenusVendido.setText("Arroz de Camarão");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Ano:");

        lbTotal.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        lbTotal.setText("Total :");

        jtTotal.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jtTotal.setForeground(new java.awt.Color(0, 153, 255));
        jtTotal.setFocusable(false);

        lbCategorias.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbCategorias.setForeground(new java.awt.Color(0, 204, 0));
        lbCategorias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbBlaBla.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbBlaBla.setText("Quantidade total de");

        lbQuantidade.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbQuantidade.setForeground(new java.awt.Color(0, 204, 0));

        lbBla.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbBla.setText("é:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(983, 983, 983)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtAno, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(340, 340, 340)
                        .addComponent(lbBlaBla, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbBla, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbDescricao2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbProdutoMenusVendido, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbDescricao3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbProdutoMaisVendido, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(84, 84, 84)
                                .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbBlaBla)
                                    .addComponent(lbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbBla, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDescricao3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbProdutoMaisVendido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDescricao2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbProdutoMenusVendido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
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

    private void jtBuscar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBuscar3ActionPerformed
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
    }//GEN-LAST:event_jtBuscar3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JYearChooser jtAno;
    private javax.swing.JButton jtBuscar3;
    private javax.swing.JComboBox<String> jtCategorias;
    private javax.swing.JTextField jtTotal;
    private javax.swing.JLabel lbBla;
    private javax.swing.JLabel lbBlaBla;
    private javax.swing.JLabel lbCategorias;
    private javax.swing.JLabel lbDescricao2;
    private javax.swing.JLabel lbDescricao3;
    private javax.swing.JLabel lbProdutoMaisVendido;
    private javax.swing.JLabel lbProdutoMenusVendido;
    private javax.swing.JLabel lbQuantidade;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
