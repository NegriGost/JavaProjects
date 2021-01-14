package Visao;

import Controle.ImagemJar;
import Controle.CRUD;
import Controle.GeradorPasswordUser;
import Modelo.Cargo;
import Modelo.Funcionarios;
import Modelo.Usuarios;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigues
 */
public class PainelUsuario extends javax.swing.JPanel {

    CRUD obc = new CRUD();
    String[] colunas = {"ID", "Nome", "Apelido", "Cargo", "Morada", "Contacto", "Email", "Estado"};
    DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
    ImagemJar ij = new ImagemJar();

    /**
     * Creates new form PainelUsuario
     */
    public PainelUsuario() {
        initComponents();
        inicializaTabela();
        listarCargos(obc.buscaCargos());
        ButtonGroup g = new ButtonGroup();
        g.add(btAtivar);
        g.add(btDesativar);
    }

    private void listarCargos(List<Cargo> buscaCargos) {
        for (Cargo buscaCargo : buscaCargos) {
            jtPerfil.addItem(buscaCargo.getNomeCargo());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        panelPrincipal = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        painelComponentes = new javax.swing.JPanel();
        jtMorada = new javax.swing.JTextField();
        lbApelido = new javax.swing.JLabel();
        lbPerfil = new javax.swing.JLabel();
        jtPerfil = new javax.swing.JComboBox<>();
        lbNome = new javax.swing.JLabel();
        lbMOrada = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        jtApelido = new javax.swing.JTextField();
        jtNome = new javax.swing.JTextField();
        jtEmail = new javax.swing.JTextField();
        lbContacto = new javax.swing.JLabel();
        jtContacto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        painelBotoes = new javax.swing.JPanel();
        btGravar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btRemover1 = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        painelTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuario = new javax.swing.JTable();
        lbErro = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtPesquisar = new javax.swing.JTextField();
        btDesativar = new javax.swing.JRadioButton();
        btAtivar = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jtUtilizador = new javax.swing.JTextField();
        lbSenha = new javax.swing.JLabel();
        jtSenha = new javax.swing.JPasswordField();
        lbUsuario1 = new javax.swing.JLabel();
        btGerar = new javax.swing.JButton();

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelTitulo.setBackground(new java.awt.Color(51, 141, 252));
        panelTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbTitulo.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Formulário de Usuarios");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lbTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelComponentes.setBackground(new java.awt.Color(255, 255, 255));
        painelComponentes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24), new java.awt.Color(0, 153, 255))); // NOI18N

        jtMorada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtMorada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtMoradaActionPerformed(evt);
            }
        });
        jtMorada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtMoradaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtMoradaKeyTyped(evt);
            }
        });

        lbApelido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbApelido.setText("Apelido:");

        lbPerfil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbPerfil.setText("Perfil:");

        jtPerfil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtPerfil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtPerfilKeyPressed(evt);
            }
        });

        lbNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNome.setText("Nomes:");

        lbMOrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbMOrada.setText("Morada:");

        lbEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbEmail.setText("Email:");

        jtApelido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtApelido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtApelidoActionPerformed(evt);
            }
        });
        jtApelido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtApelidoFocusGained(evt);
            }
        });
        jtApelido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtApelidoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtApelidoKeyTyped(evt);
            }
        });

        jtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNomeActionPerformed(evt);
            }
        });
        jtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtNomeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNomeKeyTyped(evt);
            }
        });

        jtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEmailActionPerformed(evt);
            }
        });
        jtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtEmailKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtEmailKeyTyped(evt);
            }
        });

        lbContacto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbContacto.setText("Contacto: ");

        jtContacto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtContactoActionPerformed(evt);
            }
        });
        jtContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtContactoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtContactoKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");

        javax.swing.GroupLayout painelComponentesLayout = new javax.swing.GroupLayout(painelComponentes);
        painelComponentes.setLayout(painelComponentesLayout);
        painelComponentesLayout.setHorizontalGroup(
            painelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelComponentesLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(painelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelComponentesLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addComponent(lbApelido)
                        .addGap(2, 2, 2)
                        .addComponent(jtApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelComponentesLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(lbPerfil)
                        .addGap(17, 17, 17)
                        .addComponent(jtPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(painelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelComponentesLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(lbNome)
                        .addGap(3, 3, 3))
                    .addGroup(painelComponentesLayout.createSequentialGroup()
                        .addComponent(lbMOrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(painelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtMorada, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(jtNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelComponentesLayout.createSequentialGroup()
                        .addComponent(lbEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(painelComponentesLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbContacto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );
        painelComponentesLayout.setVerticalGroup(
            painelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelComponentesLayout.createSequentialGroup()
                .addGroup(painelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelComponentesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelComponentesLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbApelido))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelComponentesLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbNome))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelComponentesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(painelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelComponentesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jtApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelComponentesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(painelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelComponentesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(painelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelComponentesLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lbPerfil))
                            .addGroup(painelComponentesLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lbMOrada, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painelComponentesLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(painelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEmail)))
                    .addGroup(painelComponentesLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jtMorada, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelComponentesLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jtPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        painelBotoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btGravar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.png"))); // NOI18N
        btGravar.setText("Gravar");
        btGravar.setBorderPainted(false);
        btGravar.setContentAreaFilled(false);
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        btLimpar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Broom.png"))); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.setBorderPainted(false);
        btLimpar.setContentAreaFilled(false);
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btAtualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/update2.png"))); // NOI18N
        btAtualizar.setText("Atualizar");
        btAtualizar.setBorderPainted(false);
        btAtualizar.setContentAreaFilled(false);
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btRemover1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btRemover1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/user.png"))); // NOI18N
        btRemover1.setText("Cargos");
        btRemover1.setBorderPainted(false);
        btRemover1.setContentAreaFilled(false);
        btRemover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemover1ActionPerformed(evt);
            }
        });

        btRemover.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Delete.png"))); // NOI18N
        btRemover.setText("Remover");
        btRemover.setBorderPainted(false);
        btRemover.setContentAreaFilled(false);
        btRemover.setEnabled(false);
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelBotoesLayout = new javax.swing.GroupLayout(painelBotoes);
        painelBotoes.setLayout(painelBotoesLayout);
        painelBotoesLayout.setHorizontalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btRemover1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelBotoesLayout.setVerticalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btAtualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelBotoesLayout.createSequentialGroup()
                .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btRemover1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btGravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        painelTabela.setBackground(new java.awt.Color(255, 255, 255));
        painelTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Usuários", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24), new java.awt.Color(0, 153, 255))); // NOI18N

        tabelaUsuario = new javax.swing.JTable(){
            public boolean isCellEditable(int a,int b){
                return false;
            }
        };
        tabelaUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabelaUsuario.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tabelaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaUsuario);

        lbErro.setBackground(new java.awt.Color(255, 255, 255));
        lbErro.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lbErro.setForeground(new java.awt.Color(255, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisa.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 30, 26);

        jtPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtPesquisar.setForeground(new java.awt.Color(204, 204, 204));
        jtPesquisar.setText("Pesquisar Usuario pelo nome,apelido ou codigo");
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
        jPanel1.add(jtPesquisar);
        jtPesquisar.setBounds(30, 6, 440, 20);

        btDesativar.setBackground(new java.awt.Color(255, 255, 255));
        btDesativar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btDesativar.setText("Desativar Usuario");
        btDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesativarActionPerformed(evt);
            }
        });

        btAtivar.setBackground(new java.awt.Color(255, 255, 255));
        btAtivar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btAtivar.setText("Ativar Usuario");
        btAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelTabelaLayout = new javax.swing.GroupLayout(painelTabela);
        painelTabela.setLayout(painelTabelaLayout);
        painelTabelaLayout.setHorizontalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaLayout.createSequentialGroup()
                .addGroup(painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelTabelaLayout.createSequentialGroup()
                        .addGap(374, 374, 374)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelTabelaLayout.createSequentialGroup()
                        .addGap(504, 504, 504)
                        .addComponent(btAtivar)
                        .addGap(11, 11, 11)
                        .addComponent(btDesativar))
                    .addGroup(painelTabelaLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelTabelaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbErro, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelTabelaLayout.setVerticalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAtivar)
                    .addComponent(btDesativar))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lbErro, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtUtilizador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtUtilizador.setFocusable(false);
        jtUtilizador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtUtilizadorActionPerformed(evt);
            }
        });
        jtUtilizador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtUtilizadorKeyPressed(evt);
            }
        });

        lbSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSenha.setText("Senha:");

        jtSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtSenha.setFocusable(false);
        jtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtSenhaKeyPressed(evt);
            }
        });

        lbUsuario1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbUsuario1.setText("Utilizador:");

        btGerar.setBackground(new java.awt.Color(51, 153, 255));
        btGerar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btGerar.setText("Gerar User e Senha");
        btGerar.setToolTipText("Gerar Username e Password");
        btGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lbUsuario1)
                        .addGap(1, 1, 1)
                        .addComponent(jtUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbSenha)
                        .addGap(7, 7, 7)
                        .addComponent(jtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jtUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbSenha))
                    .addComponent(jtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(btGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrincipalLayout.createSequentialGroup()
                            .addComponent(painelComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painelComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(painelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtMoradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtMoradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtMoradaActionPerformed

    private void jtUtilizadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtUtilizadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtUtilizadorActionPerformed

    private void jtApelidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtApelidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtApelidoActionPerformed

    private void jtApelidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtApelidoFocusGained
//        lbErro.setText("");
    }//GEN-LAST:event_jtApelidoFocusGained

    private void jtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNomeActionPerformed

    private void jtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEmailActionPerformed

    private void jtContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtContactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtContactoActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        if (jtUtilizador.getText().equals("") || jtSenha.getText().equals("")) {
            lbErro.setText("Os Campos[ Utilizador e Senha] nao podem estar Vazios");
        } else {
            gravar();
        }

    }//GEN-LAST:event_btGravarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        jtApelido.setText("");
        jtNome.setText("");
        jtEmail.setText("");
        jtUtilizador.setText("");
        jtSenha.setText("");
        jtMorada.setText("");
        jtContacto.setText("");
    }//GEN-LAST:event_btLimparActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        atualizarNaTabela();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btRemover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemover1ActionPerformed
        new Perfil().setVisible(true);
    }//GEN-LAST:event_btRemover1ActionPerformed

    private void jtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPesquisarActionPerformed

    private void jtPesquisarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtPesquisarFocusGained
        jtPesquisar.setText("");
        jtPesquisar.setForeground(Color.BLACK);
    }//GEN-LAST:event_jtPesquisarFocusGained

    private void jtPesquisarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtPesquisarFocusLost
        jtPesquisar.setText("Pesquisar Usuario pelo nome,apelido ou codigo");
        corPesquisar();
    }//GEN-LAST:event_jtPesquisarFocusLost

    private void jtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPesquisarKeyReleased
        pesquisarFuncionarios(jtPesquisar.getText(), obc.buscaFunc(), new ArrayList<Funcionarios>());
    }//GEN-LAST:event_jtPesquisarKeyReleased

    private void jtApelidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtApelidoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtNome.grabFocus();
        }
    }//GEN-LAST:event_jtApelidoKeyPressed

    private void jtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtContacto.grabFocus();
        }

    }//GEN-LAST:event_jtNomeKeyPressed

    private void jtUtilizadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtUtilizadorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtPerfil.grabFocus();
        }
    }//GEN-LAST:event_jtUtilizadorKeyPressed

    private void jtPerfilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPerfilKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtMorada.grabFocus();
        }
    }//GEN-LAST:event_jtPerfilKeyPressed

    private void jtMoradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtMoradaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtEmail.grabFocus();
        }
    }//GEN-LAST:event_jtMoradaKeyPressed

    private void jtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEmailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtSenha.grabFocus();
        }
    }//GEN-LAST:event_jtEmailKeyPressed

    private void jtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            gravar();
            listarNaTabela(obc.buscaFunc());
        }
    }//GEN-LAST:event_jtSenhaKeyPressed

    private void jtContactoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtContactoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtUtilizador.grabFocus();
        }
    }//GEN-LAST:event_jtContactoKeyPressed

    private void jtContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtContactoKeyTyped
        char c = evt.getKeyChar();
        if(c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jtContactoKeyTyped

    private void btGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerarActionPerformed
        if (jtNome.getText().equals("") || jtApelido.getText().equals("") || jtContacto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Os Campos [Nome, Apelido e Contacto] nao podem esar vazios!!", "Messagem", 2);
        } else {
            geradorUser(jtNome.getText(), jtApelido.getText());
            geradorPassword(jtApelido.getText(), jtContacto.getText());
        }
    }//GEN-LAST:event_btGerarActionPerformed

    private void btDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesativarActionPerformed
        int idx = tabelaUsuario.getSelectedRow();
        if (idx != -1) {
            desativarUsuario(obc.buscaFunc(), (int) tabelaUsuario.getValueAt(tabelaUsuario.getSelectedRow(), 0));
        } else {
            JOptionPane.showMessageDialog(null, "Por favor!!!Selecione o Usuario que Desaja Desativar.", "Messagem", 2);
        }
    }//GEN-LAST:event_btDesativarActionPerformed

    private void btAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtivarActionPerformed
        int idx = tabelaUsuario.getSelectedRow();
        if (idx != -1) {
            ativarUsuario(obc.buscaFunc(), (int) tabelaUsuario.getValueAt(tabelaUsuario.getSelectedRow(), 0));
        } else {
            JOptionPane.showMessageDialog(null, "Por favor!!!Selecione o Usuario que Desaja Ativar.", "Messagem", 2);
        }
    }//GEN-LAST:event_btAtivarActionPerformed

    private void jtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNomeKeyTyped
//        char c = evt.getKeyChar();
//        if ((c < 'a' || c > 'z') && (c < 'A' | c > 'Z')&& (c > ' ')) {
//            evt.consume();
//        }
    }//GEN-LAST:event_jtNomeKeyTyped

    private void jtApelidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtApelidoKeyTyped
//        char c = evt.getKeyChar();
//        if ((c < 'a' || c > 'z') && (c < 'A' | c > 'Z')&& (c > ' ')) {
//            evt.consume();
//        }
    }//GEN-LAST:event_jtApelidoKeyTyped

    private void jtMoradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtMoradaKeyTyped
//        char c = evt.getKeyChar();
//        if ((c < 'a' || c > 'z')&&(c < 'A' || c > 'Z')&&(c < '0' || c > '9')&& (c < 'º'||c > 'º')&& (c < '.'||c > '.')&& (c < '-'||c > '-')&& (c < '/'||c > '/')) {
//            evt.consume();
//        }
    }//GEN-LAST:event_jtMoradaKeyTyped

    private void jtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEmailKeyTyped
//        char c = evt.getKeyChar();
//        if ((c < 'a' || c > 'z')&&(c < '0' || c > '9')&& (c < '@'||c > '@')&& (c < '.'||c > '.')) {
//            evt.consume();
//        }
    }//GEN-LAST:event_jtEmailKeyTyped

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        removerNaTabela();
    }//GEN-LAST:event_btRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btAtivar;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JRadioButton btDesativar;
    private javax.swing.JButton btGerar;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btRemover1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtApelido;
    private javax.swing.JTextField jtContacto;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtMorada;
    private javax.swing.JTextField jtNome;
    public static javax.swing.JComboBox<String> jtPerfil;
    private javax.swing.JTextField jtPesquisar;
    private javax.swing.JPasswordField jtSenha;
    private javax.swing.JTextField jtUtilizador;
    private javax.swing.JLabel lbApelido;
    private javax.swing.JLabel lbContacto;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbErro;
    private javax.swing.JLabel lbMOrada;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPerfil;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbUsuario1;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelComponentes;
    private javax.swing.JPanel painelTabela;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tabelaUsuario;
    // End of variables declaration//GEN-END:variables

    private final void inicializaTabela() {
        tabelaUsuario.setModel(modelo);
        listarNaTabela(obc.buscaFunc());

        tabelaUsuario.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                int codigo = tabelaUsuario.getSelectedRow();
                jtNome.setText(String.valueOf(tabelaUsuario.getValueAt(codigo, 1)));
                jtApelido.setText(String.valueOf(tabelaUsuario.getValueAt(codigo, 2)));
                jtPerfil.setSelectedItem((String) tabelaUsuario.getValueAt(codigo, 3));
                jtMorada.setText(String.valueOf(tabelaUsuario.getValueAt(codigo, 4)));
                jtContacto.setText(String.valueOf(tabelaUsuario.getValueAt(codigo, 5)));
                jtEmail.setText(String.valueOf(tabelaUsuario.getValueAt(codigo, 6)));
                lbErro.setText("");
            }

        });

    }

    public final void listarNaTabela(List<Funcionarios> func) {
        controlaLinhas();
        if (!func.isEmpty()) {
            for (int i = 0; i < func.size(); i++) {
                Funcionarios u = func.get(i);
                modelo.addRow(new Object[]{u.getId(), u.getNome(), u.getApelido(), u.getCargo().getNomeCargo(), u.getMorada(), u.getContacto(), u.getEmail(), u.getEstado()});
            }
        }
    }
///=========================================

    public void atualizarNaTabela() {
        List<Funcionarios> ut = obc.buscaFunc();
        int codigo = tabelaUsuario.getSelectedRow();
        if (codigo == -1) {
            lbErro.setText("Selecione o Usuario que deseja Atualizar!!!");
        } else {
            String nome = (String) tabelaUsuario.getValueAt(codigo, 1);
            for (int i = 0; i < ut.size(); i++) {
                Funcionarios func = ut.get(i);
                String nome2 = (String) tabelaUsuario.getValueAt(i, 1);
                if (nome.equals(nome2)) {
                    func.setApelido(jtApelido.getText());
                    func.setNome(jtNome.getText());
                    func.setEmail(jtEmail.getText());
                    func.setCargo(cargo(jtPerfil.getSelectedItem().toString(), obc.buscaCargos()));
                    func.setMorada(jtMorada.getText());
                    func.setContacto(jtContacto.getText());
                    obc.actualizar(func);
                    JOptionPane.showMessageDialog(null, "Atualizado com Sucesso", "Messagem", 1, new ImageIcon(ij.getImageIcon("/Imagens/update2.png").getImage()));
                    listarNaTabela(obc.buscaFunc());
                    break;
                }
            }
        }
    }

    //===========================================
    public void removerNaTabela() {
        List<Funcionarios> ut = obc.buscaFunc();
        int codigo = tabelaUsuario.getSelectedRow();
        if (codigo == -1) {
            lbErro.setText("Selecione o Usuario que deseja remover!!!");
        } else {
            String nome = (String) tabelaUsuario.getValueAt(codigo, 1);
            for (int i = 0; i < ut.size(); i++) {
                String nome2 = (String) tabelaUsuario.getValueAt(i, 1);
                if (nome.equals(nome2)) {

                    int j = JOptionPane.showConfirmDialog(null, "Deseja realmente Remover Este Usuario", "Messagem", 2);
                    if (j == JOptionPane.OK_OPTION) {
                        obc.excluir(ut.get(i));
                        JOptionPane.showMessageDialog(null, "Removido com Sucesso!!!", "Messagem", 1, new ImageIcon(ij.getImageIcon("/Imagens/Delete.png").getImage()));
                    }
                    listarNaTabela(obc.buscaFunc());
                    break;
                }
            }
        }

    }

    private void gravar() {
        boolean achou = false;
        if (jtNome.getText().equals("") || jtApelido.getText().equals("") || jtContacto.getText().equals("")) {
            lbErro.setText("Os Campos na podem estar vazios!!!");
        } else {
            List<Funcionarios> ut = obc.buscaFunc();
            for (int i = 0; i < ut.size(); i++) {
                if (ut.get(i).getNome().equals(jtNome.getText())) {
                    achou = true;
                    break;
                }
            }

            if (achou) {

                lbErro.setText("Esse usuario ja foi Salvo, Registe um novo Usuario!!!");
            } else {
                try{
                Funcionarios func = new Funcionarios(jtNome.getText(), jtApelido.getText(), jtMorada.getText(), jtContacto.getText(), jtEmail.getText(), cargo(jtPerfil.getSelectedItem().toString(), obc.buscaCargos()), "Ativo");
                Usuarios usu = new Usuarios(jtUtilizador.getText(), jtSenha.getText(), func);
                obc.salvar(usu);
                JOptionPane.showMessageDialog(null, "Salvado com Sucesso", "Messagem", 1, new ImageIcon(ij.getImageIcon("/Imagens/salvar.png").getImage()));
                lbErro.setText("");
                listarNaTabela(obc.buscaFunc());
                }catch(NullPointerException npe){
                    JOptionPane.showMessageDialog(null,"Erro,Cadastre Perfis Por Favor!!");
                }
            }
        }
    }//fim de gravar

    private void pesquisarFuncionarios(String n, List<Funcionarios> func, ArrayList<Funcionarios> f) {
        for (int i = 0; i < func.size(); i++) {
            Funcionarios u = func.get(i);
            if (u.getNome().toLowerCase().startsWith(n) || String.valueOf(u.getId()).startsWith(n) || String.valueOf(u.getApelido()).toLowerCase().startsWith(n)) {
                f.add(u);
            }
        }
        listarFuncionariosPesquisados(f);
    }

    private void controlaLinhas() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    private void listarFuncionariosPesquisados(ArrayList<Funcionarios> usu) {
        controlaLinhas();
        for (int i = 0; i < usu.size(); i++) {
            Funcionarios func = usu.get(i);
            modelo.addRow(new Object[]{func.getId(), func.getNome(), func.getApelido(), func.getCargo(), func.getMorada(), func.getContacto(), func.getEmail(), func.getEstado()});
        }
    }

    private void corPesquisar() {
        jtPesquisar.setForeground(new Color(204, 204, 204));
    }

    private Cargo cargo(String cargo, List<Cargo> buscaCargos) {
        Cargo cg = null;
        for (int i = 0; i < buscaCargos.size(); i++) {
            Cargo get = buscaCargos.get(i);
            if (cargo.equals(get.getNomeCargo())) {
                cg = get;
                break;
            }
        }
        return cg;
    }

    private void geradorUser(String nome, String apelido) {
        GeradorPasswordUser gpu = new GeradorPasswordUser();
        jtUtilizador.setText(gpu.gerarUsername(nome, apelido));
    }

    private void geradorPassword(String apelido, String contacto) {
        GeradorPasswordUser gpu = new GeradorPasswordUser();
        jtSenha.setText(gpu.gerarPassword(apelido, contacto));
    }

    private void desativarUsuario(List<Funcionarios> func, int id) {
        for (int i = 0; i < func.size(); i++) {
            Funcionarios buscaFunc = func.get(i);
            if (buscaFunc.getCodFunc() == id) {
                buscaFunc.setEstado("Inativo");
                obc.actualizar(buscaFunc);
                JOptionPane.showMessageDialog(null, "Usuario Desativado com Sucesso", "Messagem", 1);
                listarNaTabela(obc.buscaFunc());
                break;
            }
        }
    }

    private void ativarUsuario(List<Funcionarios> func, int id) {
        for (int i = 0; i < func.size(); i++) {
            Funcionarios buscaFunc = func.get(i);
            if (buscaFunc.getCodFunc() == id) {
                buscaFunc.setEstado("Ativo");
                obc.actualizar(buscaFunc);
                JOptionPane.showMessageDialog(null,"Usuario Ativado com Sucesso","Messagem", 1);
                listarNaTabela(obc.buscaFunc());
                break;
            }
        }
    }

}
