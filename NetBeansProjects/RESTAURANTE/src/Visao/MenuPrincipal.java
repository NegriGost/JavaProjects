package Visao;

import Controle.ImagemJar;
import Controle.ArquivoMenu;
import Controle.ImagemFundo;
import static Controle.ImagemJar.redimensionarFrameTotal;
import com.mysql.jdbc.Connection;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Rodrigues
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de imagens", "jpg");
    private String caminho = "";
    ArquivoMenu am = new ArquivoMenu();
    ImagemJar ij = new ImagemJar();

    /**
     * Creates new form MenuPrincipal
     */
   
    public MenuPrincipal() {

        initComponents();
        this.setIconImage(ij.getImageIcon("/Imagens/Hamburger.png").getImage());
        this.setSize(redimensionarFrameTotal()); 
        panelStatus.setSize(redimensionarFrameTotal());
        fecharMenuPrincipal();
        dataHora();
        btUsuario.setBounds(07, 10, 95, 90);
        btUsuario.setVerticalTextPosition(SwingConstants.BOTTOM);
        btUsuario.setHorizontalTextPosition(SwingConstants.CENTER);

        btClientes.setBounds(07, 110, 95, 90);
        btClientes.setVerticalTextPosition(SwingConstants.BOTTOM);
        btClientes.setHorizontalTextPosition(SwingConstants.CENTER);

        btProdutos.setBounds(07, 210, 95, 90);
        btProdutos.setVerticalTextPosition(SwingConstants.BOTTOM);
        btProdutos.setHorizontalTextPosition(SwingConstants.CENTER);

        btVendas.setBounds(07, 310, 95, 90);//10,410,90,90
        btVendas.setVerticalTextPosition(SwingConstants.BOTTOM);
        btVendas.setHorizontalTextPosition(SwingConstants.CENTER);

        btMesas.setBounds(07, 410, 95, 90);
        btMesas.setVerticalTextPosition(SwingConstants.BOTTOM);
        btMesas.setHorizontalTextPosition(SwingConstants.CENTER);

        btCardapio.setVerticalTextPosition(SwingConstants.BOTTOM);
        btCardapio.setHorizontalTextPosition(SwingConstants.CENTER);
        btCardapio.setBounds(07, 610, 95, 90);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBoasVindas = new javax.swing.JPanel();
        panelButton = new javax.swing.JPanel();
        btUsuario = new javax.swing.JButton();
        btClientes = new javax.swing.JButton();
        btProdutos = new javax.swing.JButton();
        btMesas = new javax.swing.JButton();
        btVendas = new javax.swing.JButton();
        btCardapio = new javax.swing.JButton();
        panelStatus = new javax.swing.JPanel();
        lbHora = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        lbDescricao = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        lbCargo = new javax.swing.JLabel();
        lbHora1 = new javax.swing.JLabel();
        panelComponentes = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        itemVendedor = new javax.swing.JMenu();
        itemFatura = new javax.swing.JMenuItem();
        vendasDiarias = new javax.swing.JMenuItem();
        vendasMensais = new javax.swing.JMenuItem();
        vendasMensais1 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mesas = new javax.swing.JMenuItem();
        clientes = new javax.swing.JMenuItem();
        menuConsulta = new javax.swing.JMenu();
        jtPCancelados = new javax.swing.JMenuItem();
        itemPedidosPendentes = new javax.swing.JMenuItem();
        senhas = new javax.swing.JMenu();
        menuPersonalizar = new javax.swing.JMenu();
        Noire = new javax.swing.JMenuItem();
        Acryl = new javax.swing.JMenuItem();
        Smart = new javax.swing.JMenuItem();
        McWindows = new javax.swing.JMenuItem();
        Graphit = new javax.swing.JMenuItem();
        Aluminium = new javax.swing.JMenuItem();
        Texture = new javax.swing.JMenuItem();
        nimbus = new javax.swing.JMenuItem();
        nimbus1 = new javax.swing.JMenuItem();
        itemBlocoNotas = new javax.swing.JMenuItem();
        Calculadora = new javax.swing.JMenuItem();
        Senhas = new javax.swing.JMenuItem();
        menuWeb = new javax.swing.JMenu();
        Google = new javax.swing.JMenuItem();
        Gmail = new javax.swing.JMenuItem();
        youtube = new javax.swing.JMenuItem();
        Ajuda = new javax.swing.JMenu();
        itemManual = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();
        itemSair = new javax.swing.JMenuItem();
        itemRestarte = new javax.swing.JMenuItem();
        itemInicial = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sitema de  Restaurante e Vendas do ICM 2016 @ criado por Rodrigues Mafumo : Contacto-849231169,EMAIL-mafumorodrigues@gmail.com");
        setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        setName("Menu Principal"); // NOI18N

        panelBoasVindas.setLayout(new java.awt.BorderLayout());

        panelButton.setBackground(new java.awt.Color(51, 141, 252));
        panelButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Under Computer.png"))); // NOI18N
        btUsuario.setText("Usuarios");
        btUsuario.setDefaultCapable(false);
        btUsuario.setMaximumSize(new java.awt.Dimension(95, 90));
        btUsuario.setMinimumSize(new java.awt.Dimension(95, 90));
        btUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUsuarioActionPerformed(evt);
            }
        });

        btClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/User Group Man Woman.png"))); // NOI18N
        btClientes.setText("Clientes");
        btClientes.setMaximumSize(new java.awt.Dimension(95, 90));
        btClientes.setMinimumSize(new java.awt.Dimension(95, 90));
        btClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClientesActionPerformed(evt);
            }
        });

        btProdutos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Ingredients.png"))); // NOI18N
        btProdutos.setText("Produtos");
        btProdutos.setMaximumSize(new java.awt.Dimension(95, 90));
        btProdutos.setMinimumSize(new java.awt.Dimension(95, 90));
        btProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProdutosActionPerformed(evt);
            }
        });

        btMesas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btMesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/meza.png"))); // NOI18N
        btMesas.setText("Mesas");
        btMesas.setMaximumSize(new java.awt.Dimension(95, 90));
        btMesas.setMinimumSize(new java.awt.Dimension(95, 90));
        btMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMesasActionPerformed(evt);
            }
        });

        btVendas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Meal.png"))); // NOI18N
        btVendas.setText("Vendas");
        btVendas.setMaximumSize(new java.awt.Dimension(95, 90));
        btVendas.setMinimumSize(new java.awt.Dimension(95, 90));
        btVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVendasActionPerformed(evt);
            }
        });

        btCardapio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btCardapio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cad.jpg"))); // NOI18N
        btCardapio.setText("Cardapio");
        btCardapio.setMaximumSize(new java.awt.Dimension(95, 90));
        btCardapio.setMinimumSize(new java.awt.Dimension(95, 90));
        btCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCardapioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btMesas, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(btCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(btProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelBoasVindas.add(panelButton, java.awt.BorderLayout.LINE_START);

        panelStatus.setBackground(new java.awt.Color(51, 141, 252));
        panelStatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbHora.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lbHora.setForeground(new java.awt.Color(255, 255, 255));
        lbHora.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lbData.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lbData.setForeground(new java.awt.Color(255, 255, 255));
        lbData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbDescricao.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lbDescricao.setForeground(new java.awt.Color(255, 255, 255));
        lbDescricao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDescricao.setText("Sistema de Restaurante Versao 1.2");

        lbUsuario.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbUsuario.setText("Usuario: Root");

        lbCargo.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lbCargo.setForeground(new java.awt.Color(255, 255, 255));
        lbCargo.setText("Cargo: Livre");

        lbHora1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lbHora1.setForeground(new java.awt.Color(255, 255, 255));
        lbHora1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHora1.setText("Horas:");

        javax.swing.GroupLayout panelStatusLayout = new javax.swing.GroupLayout(panelStatus);
        panelStatus.setLayout(panelStatusLayout);
        panelStatusLayout.setHorizontalGroup(
            panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStatusLayout.createSequentialGroup()
                .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbHora1)
                .addGap(18, 18, 18)
                .addComponent(lbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbData, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(lbDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelStatusLayout.setVerticalGroup(
            panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbDescricao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbHora1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBoasVindas.add(panelStatus, java.awt.BorderLayout.PAGE_END);

        panelComponentes.setBackground(new java.awt.Color(255, 255, 255));
        panelComponentes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelComponentes.setLayout(new java.awt.CardLayout());
        panelComponentes.setBorder(caminho("/Imagens/mes.jpg"));
        panelBoasVindas.add(panelComponentes, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelBoasVindas, java.awt.BorderLayout.CENTER);

        itemVendedor.setText("Relatórios");
        itemVendedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        itemFatura.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemFatura.setText("Faturas");
        itemFatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFaturaActionPerformed(evt);
            }
        });
        itemVendedor.add(itemFatura);

        vendasDiarias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        vendasDiarias.setText("Vendas Diárias");
        vendasDiarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendasDiariasActionPerformed(evt);
            }
        });
        itemVendedor.add(vendasDiarias);

        vendasMensais.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        vendasMensais.setText("Vendas Mensais");
        vendasMensais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendasMensaisActionPerformed(evt);
            }
        });
        itemVendedor.add(vendasMensais);

        vendasMensais1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        vendasMensais1.setText("Vendas Anuais");
        vendasMensais1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendasMensais1ActionPerformed(evt);
            }
        });
        itemVendedor.add(vendasMensais1);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem1.setText("Vendas por Vendedor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        itemVendedor.add(jMenuItem1);

        mesas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mesas.setText("Mesas");
        mesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesasActionPerformed(evt);
            }
        });
        itemVendedor.add(mesas);

        clientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clientes.setText("Clientes");
        clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesActionPerformed(evt);
            }
        });
        itemVendedor.add(clientes);

        menuBar.add(itemVendedor);

        menuConsulta.setText("Consultas");
        menuConsulta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtPCancelados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtPCancelados.setText("Pedidos Cancelados");
        jtPCancelados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPCanceladosActionPerformed(evt);
            }
        });
        menuConsulta.add(jtPCancelados);

        itemPedidosPendentes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemPedidosPendentes.setText("Pedidos Pendentes");
        itemPedidosPendentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPedidosPendentesActionPerformed(evt);
            }
        });
        menuConsulta.add(itemPedidosPendentes);

        menuBar.add(menuConsulta);

        senhas.setText("Ferramentas");
        senhas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        menuPersonalizar.setText("Estilo");
        menuPersonalizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Noire.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Noire.setText("Noire");
        Noire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoireActionPerformed(evt);
            }
        });
        menuPersonalizar.add(Noire);

        Acryl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Acryl.setText("Acryl");
        Acryl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcrylActionPerformed(evt);
            }
        });
        menuPersonalizar.add(Acryl);

        Smart.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Smart.setText("Smart");
        Smart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SmartActionPerformed(evt);
            }
        });
        menuPersonalizar.add(Smart);

        McWindows.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        McWindows.setText("McWindows");
        McWindows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                McWindowsActionPerformed(evt);
            }
        });
        menuPersonalizar.add(McWindows);

        Graphit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Graphit.setText("Graphit");
        Graphit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphitActionPerformed(evt);
            }
        });
        menuPersonalizar.add(Graphit);

        Aluminium.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Aluminium.setText("Aluminium");
        Aluminium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AluminiumActionPerformed(evt);
            }
        });
        menuPersonalizar.add(Aluminium);

        Texture.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Texture.setText("Texture");
        Texture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextureActionPerformed(evt);
            }
        });
        menuPersonalizar.add(Texture);

        nimbus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nimbus.setText("Nimbus");
        nimbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nimbusActionPerformed(evt);
            }
        });
        menuPersonalizar.add(nimbus);

        nimbus1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nimbus1.setText("Metal");
        nimbus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nimbus1ActionPerformed(evt);
            }
        });
        menuPersonalizar.add(nimbus1);

        senhas.add(menuPersonalizar);

        itemBlocoNotas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemBlocoNotas.setText("Bloco de Notas");
        itemBlocoNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBlocoNotasActionPerformed(evt);
            }
        });
        senhas.add(itemBlocoNotas);

        Calculadora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Calculadora.setText("Maquina Calculadora");
        Calculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculadoraActionPerformed(evt);
            }
        });
        senhas.add(Calculadora);

        Senhas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Senhas.setText("Mudar Senha");
        Senhas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SenhasActionPerformed(evt);
            }
        });
        senhas.add(Senhas);

        menuBar.add(senhas);

        menuWeb.setText("IR PARA WEB");
        menuWeb.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        Google.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Google.setText("Google");
        Google.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoogleActionPerformed(evt);
            }
        });
        menuWeb.add(Google);

        Gmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Gmail.setText("Gmail");
        Gmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GmailActionPerformed(evt);
            }
        });
        menuWeb.add(Gmail);

        youtube.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        youtube.setText("Youtube");
        youtube.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                youtubeActionPerformed(evt);
            }
        });
        menuWeb.add(youtube);

        menuBar.add(menuWeb);

        Ajuda.setText("Ajuda");
        Ajuda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemManual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemManual.setText("Manual de Utilizador");
        itemManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemManualActionPerformed(evt);
            }
        });
        Ajuda.add(itemManual);

        menuBar.add(Ajuda);

        menuSair.setText("Sair");
        menuSair.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        itemSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemSair.setText("Sair");
        itemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSairActionPerformed(evt);
            }
        });
        menuSair.add(itemSair);

        itemRestarte.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemRestarte.setText("Restart");
        itemRestarte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRestarteActionPerformed(evt);
            }
        });
        menuSair.add(itemRestarte);

        itemInicial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemInicial.setText("Menu Inicial");
        itemInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemInicialActionPerformed(evt);
            }
        });
        menuSair.add(itemInicial);

        menuBar.add(menuSair);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUsuarioActionPerformed
        panelComponentes.removeAll();
        panelComponentes.add(new PainelUsuario());
        panelComponentes.validate();
    }//GEN-LAST:event_btUsuarioActionPerformed

    private void btClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClientesActionPerformed
        panelComponentes.removeAll();
        panelComponentes.add(new PainelClientes());
        panelComponentes.validate();
    }//GEN-LAST:event_btClientesActionPerformed

    private void btMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMesasActionPerformed
        panelComponentes.removeAll();
        panelComponentes.add(new PainelMesa());
        panelComponentes.validate();
    }//GEN-LAST:event_btMesasActionPerformed

    private void btProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProdutosActionPerformed
        panelComponentes.removeAll();
        panelComponentes.add(new PainelProdutos());
    }//GEN-LAST:event_btProdutosActionPerformed

    private void btVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVendasActionPerformed
        panelComponentes.removeAll();
        panelComponentes.add(new PainelVenda());
        panelComponentes.validate();
        PainelVenda.lbMesa.setVisible(false);
        PainelVenda.jtMesa.setVisible(false);
        PainelVenda.btGravarPedido.setText("Cobrar");

    }//GEN-LAST:event_btVendasActionPerformed

    private void itemFaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFaturaActionPerformed
        panelComponentes.removeAll();
        panelComponentes.add(new Recibos());
        panelComponentes.validate();
    }//GEN-LAST:event_itemFaturaActionPerformed

    private void itemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Deseja Realmente sair", "Messagem", JOptionPane.OK_CANCEL_OPTION);
        if (i == JOptionPane.OK_OPTION) {
            System.exit(0);
        } else {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_itemSairActionPerformed

    private void btCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCardapioActionPerformed
        carregarCardapio();
    }//GEN-LAST:event_btCardapioActionPerformed

    private void itemInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemInicialActionPerformed
        panelComponentes.removeAll();
        panelComponentes.updateUI();
    }//GEN-LAST:event_itemInicialActionPerformed

    private void NoireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoireActionPerformed
        try {
            MenuPrincipal.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_NoireActionPerformed

    private void AcrylActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcrylActionPerformed
        try {
            MenuPrincipal.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_AcrylActionPerformed

    private void SmartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SmartActionPerformed
        try {
            MenuPrincipal.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_SmartActionPerformed

    private void McWindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_McWindowsActionPerformed
        try {
            MenuPrincipal.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_McWindowsActionPerformed

    private void GraphitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphitActionPerformed
        try {
            MenuPrincipal.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_GraphitActionPerformed

    private void AluminiumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AluminiumActionPerformed
        try {
            MenuPrincipal.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_AluminiumActionPerformed

    private void TextureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextureActionPerformed
        try {
            MenuPrincipal.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_TextureActionPerformed

    private void vendasDiariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendasDiariasActionPerformed
        panelComponentes.removeAll();
        panelComponentes.add(new RelatorioDiario());
        panelComponentes.validate();
     

    }//GEN-LAST:event_vendasDiariasActionPerformed

    private void vendasMensaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendasMensaisActionPerformed
        panelComponentes.removeAll();
        panelComponentes.add(new RelatorioMensal());
        panelComponentes.validate();
    }//GEN-LAST:event_vendasMensaisActionPerformed

    private void itemBlocoNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBlocoNotasActionPerformed
        try {
            Runtime.getRuntime().exec("NotePad");
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemBlocoNotasActionPerformed

    private void GoogleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoogleActionPerformed
        try {
            URI google = new URI("www.goole.com");
            Desktop.getDesktop().browse(google);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GoogleActionPerformed

    private void GmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GmailActionPerformed
        try {
            URI google = new URI("www.gmail.com");
            Desktop.getDesktop().browse(google);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GmailActionPerformed

    private void youtubeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_youtubeActionPerformed
        try {
            URI google = new URI("www.youtube.com");
            Desktop.getDesktop().browse(google);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_youtubeActionPerformed

    private void CalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculadoraActionPerformed
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CalculadoraActionPerformed

    private void vendasMensais1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendasMensais1ActionPerformed
        panelComponentes.removeAll();
        panelComponentes.add(new RelatorioAnual());
        panelComponentes.validate();
    }//GEN-LAST:event_vendasMensais1ActionPerformed

    private void mesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesasActionPerformed
        String url = "jdbc:mysql://localhost:3306/restaurante?zeroDateTimeBehavior=convertToNull";
        InputStream icon =ij.getArquivo("/Imagens/images.jpg");       

        try {
            Connection c = (Connection) DriverManager.getConnection(url, "root", "");
            String caminho = "/Faturas/Mesas.jasper";
            Map mapa = new HashMap();
            mapa.put("IMAGEM",icon);
            JasperPrint inf = JasperFillManager.fillReport(ij.getArquivo(caminho), mapa, c);
            JasperViewer visor = new JasperViewer(inf, false);
            visor.setTitle("Relatorio de Mesas");
            visor.setLocationRelativeTo(null);
            visor.setVisible(true);
            visor.setBounds(0, 0, 1365, 800);
            visor.toFront();
        } catch (SQLException | JRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar a Fatura");
        }
    }//GEN-LAST:event_mesasActionPerformed

    private void clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesActionPerformed
        String url = "jdbc:mysql://localhost:3306/restaurante?zeroDateTimeBehavior=convertToNull";
        InputStream icon =ij.getArquivo("/Imagens/images.jpg");       

        try {
            Connection c = (Connection) DriverManager.getConnection(url, "root", "");
            String caminho = "/Faturas/Clientes.jasper";
            Map mapa = new HashMap();
            mapa.put("IMAGEM",icon);
            JasperPrint inf = JasperFillManager.fillReport(ij.getArquivo(caminho), mapa, c);
            JasperViewer visor = new JasperViewer(inf, false);
            visor.setTitle("Relatorio de Clientes");
            visor.setLocationRelativeTo(null);
            visor.setVisible(true);
            visor.setBounds(0, 0, 1365, 800);
            visor.toFront();
        } catch (SQLException | JRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar a Fatura");
        }
    }//GEN-LAST:event_clientesActionPerformed

    private void SenhasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SenhasActionPerformed
        new MudancaSenhas().setVisible(true);
    }//GEN-LAST:event_SenhasActionPerformed

    private void itemRestarteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRestarteActionPerformed
        dispose();
        new BarraProgresso().setVisible(true); 
    }//GEN-LAST:event_itemRestarteActionPerformed

    private void itemManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemManualActionPerformed
       JOptionPane.showMessageDialog(null,"ups! o Manual ainda esta sendo produzido","Messagem",1);
    }//GEN-LAST:event_itemManualActionPerformed

    private void nimbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nimbusActionPerformed
          try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    SwingUtilities.updateComponentTreeUI(this);
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarraProgresso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nimbusActionPerformed

    private void nimbus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nimbus1ActionPerformed
            try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    SwingUtilities.updateComponentTreeUI(this);
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarraProgresso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nimbus1ActionPerformed

    private void jtPCanceladosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPCanceladosActionPerformed
        panelComponentes.removeAll();
        panelComponentes.add(new PedidosCancelados());
        panelComponentes.validate();
     
    }//GEN-LAST:event_jtPCanceladosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        panelComponentes.removeAll();
        panelComponentes.add(new RelatorioProdutoVendedor());
        panelComponentes.validate();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void itemPedidosPendentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPedidosPendentesActionPerformed
        panelComponentes.removeAll();
        panelComponentes.add(new PedidosPendentes());
        panelComponentes.validate();
    }//GEN-LAST:event_itemPedidosPendentesActionPerformed

    private void buscarFoto() {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(filter);
        int opcao = jfc.showOpenDialog(this);
        if (opcao == JFileChooser.APPROVE_OPTION) {
            caminho = jfc.getSelectedFile().getAbsolutePath();
            JOptionPane.showMessageDialog(null, caminho);
            panelComponentes.setBorder(caminho(caminho));
            SwingUtilities.updateComponentTreeUI(this);
        }
    }

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
//                if ("".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MenuPrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenuItem Acryl;
    private javax.swing.JMenu Ajuda;
    public static javax.swing.JMenuItem Aluminium;
    public static javax.swing.JMenuItem Calculadora;
    private javax.swing.JMenuItem Gmail;
    private javax.swing.JMenuItem Google;
    public static javax.swing.JMenuItem Graphit;
    public static javax.swing.JMenuItem McWindows;
    public static javax.swing.JMenuItem Noire;
    public static javax.swing.JMenuItem Senhas;
    public static javax.swing.JMenuItem Smart;
    public static javax.swing.JMenuItem Texture;
    private javax.swing.JButton btCardapio;
    public static javax.swing.JButton btClientes;
    public static javax.swing.JButton btMesas;
    public static javax.swing.JButton btProdutos;
    public static javax.swing.JButton btUsuario;
    public static javax.swing.JButton btVendas;
    public static javax.swing.JMenuItem clientes;
    public static javax.swing.JMenuItem itemBlocoNotas;
    public static javax.swing.JMenuItem itemFatura;
    private javax.swing.JMenuItem itemInicial;
    private javax.swing.JMenuItem itemManual;
    private javax.swing.JMenuItem itemPedidosPendentes;
    private javax.swing.JMenuItem itemRestarte;
    private javax.swing.JMenuItem itemSair;
    public static javax.swing.JMenu itemVendedor;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jtPCancelados;
    public static javax.swing.JLabel lbCargo;
    public static javax.swing.JLabel lbData;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbHora1;
    public static javax.swing.JLabel lbUsuario;
    private javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenu menuConsulta;
    public static javax.swing.JMenu menuPersonalizar;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenu menuWeb;
    public static javax.swing.JMenuItem mesas;
    public static javax.swing.JMenuItem nimbus;
    public static javax.swing.JMenuItem nimbus1;
    private javax.swing.JPanel panelBoasVindas;
    private javax.swing.JPanel panelButton;
    public static javax.swing.JPanel panelComponentes;
    private javax.swing.JPanel panelStatus;
    public static javax.swing.JMenu senhas;
    public static javax.swing.JMenuItem vendasDiarias;
    public static javax.swing.JMenuItem vendasMensais;
    public static javax.swing.JMenuItem vendasMensais1;
    private javax.swing.JMenuItem youtube;
    // End of variables declaration//GEN-END:variables
 class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar c = Calendar.getInstance();
            lbHora.setText(String.format("%1$tH:%1$tM:%1$tS", c));
        }
    }

    public final void dataHora() {
        Date data = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        lbData.setText("Data: " + df.format(data));
        Timer time = new Timer(1000, new hora());
        time.start();
    }

    private void fecharMenuPrincipal() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "Deseja Realmente sair", "Messagem", JOptionPane.OK_CANCEL_OPTION);
                if (i == JOptionPane.OK_OPTION) {
                    System.exit(0);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }

        });
    }

    public void carregarCardapio() {
        String url = "jdbc:mysql://localhost:3306/restaurante?zeroDateTimeBehavior=convertToNull";
        InputStream icon =ij.getArquivo("/Imagens/images.jpg");       
        try {
            Connection c = (Connection) DriverManager.getConnection(url, "root", "");
            Statement stm = c.createStatement();
            ResultSet set = stm.executeQuery("SELECT\n" +
                    "     produtos.`Foto` AS produtos_Foto,\n" +
                    "     produtos.`Preco` AS produtos_Preco,\n" +
                    "     produtos.`nomeProd` AS produtos_nomeProd,\n" +
                    "     produtoscategoria.`nomeCategoria` AS produtoscategoria_nomeCategoria,\n" +
                    "     produtos.`codProd` AS produtos_codProd\n" +
                    "FROM\n" +
                    "     `produtoscategoria` produtoscategoria INNER JOIN `produtos` produtos ON produtoscategoria.`codCateg` = produtos.`produtoCategoria`");
            String caminho = "/Faturas/RelatorioCardapio.jasper";
            JRResultSetDataSource result = new JRResultSetDataSource(set);
            Map mapa = new HashMap();
            mapa.put("IMAGEM",icon);
            JasperPrint inf = JasperFillManager.fillReport(ij.getArquivo(caminho),mapa, result);
            JasperViewer visor = new JasperViewer(inf, false);
            visor.setTitle("Cardapio");
            visor.setVisible(true);
            visor.setBounds(0, 0, 1365, 800);
        } catch (SQLException | JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar a Fatura");
        }
    }

    private ImagemFundo caminho(String caminho) {
        ImagemFundo iF = new ImagemFundo(caminho);
        return iF;
    }
}
