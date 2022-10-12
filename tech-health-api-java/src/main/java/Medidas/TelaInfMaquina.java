/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Medidas;


import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.util.Conversor;
import java.awt.Color;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author rmsouza
 */
public class TelaInfMaquina extends javax.swing.JFrame {
//CONEXAO BANCO
       Medidas.ConexaoTechHealth connection = new Medidas.ConexaoTechHealth();
       JdbcTemplate banco = connection.getConexao(); 
        
       //CRIANDO O LOOCA + INSTANCIANDO OUTRAS CLASSES DAS MEDIDAS
       Looca looca = new Looca();
       Computador comp = new Computador();
       Processador processador = new Processador();
       Sistema sistema = new Sistema();
       Memoria memoria = new Memoria();
       Conversor conversor = new Conversor();
       
       //CRIANDO VARIAVES DAS MEDIDAS
        
        String nome_Processador = processador.getNome();
        Integer numero_CPU_fisica = processador.getNumeroCpusFisicas();
        //Long capacidade_Total_Memoria = Conversor.formatarBytes(memoria.getTotal());   -------- PS: essa foi direto no insert
        String sistema_Operacional = sistema.getSistemaOperacional();
        String fabricante = sistema.getFabricante();
        
    /**
     * Creates new form TelaInfMaquina
     */
    public TelaInfMaquina() {
        initComponents();
        
        //MAQUINA 1
        Computador comp1 = new Computador();
        List<Computador> listaMaquina01 = banco.query("select idMaquina, Hospital.nome_Hospital, ala_Hospitalar, sistema_Operacional, fabricante, nome_Processador, "
                + "frequencia_Processador, capacidade_Total_Memoria, tamanho_Disco, numero_CPU_fisica from maquina\n" +
        "right join hospital on maquina.fkHospital = hospital.idHospital where idMaquina = 1;", new BeanPropertyRowMapper(Computador.class));
        
        lblIdMaq01.setText(listaMaquina01.get(0).getIdMaquina().toString());
        lblAlaMaq01.setText(listaMaquina01.get(0).getAla_Hospitalar());
        lblSist_OperMaq01.setText(listaMaquina01.get(0).getSistema_Operacional());
        lblFabricanMaq01.setText(listaMaquina01.get(0).getFabricante());
        lblNomProcessMaq01.setText(listaMaquina01.get(0).getNome_Processador());
        lblFreqProcessMaq01.setText(listaMaquina01.get(0).getFrequencia_Processador());
        lblTotMemoMaq01.setText(listaMaquina01.get(0).getCapacidade_Total_Memoria());
        lblTotDiscoMaq01.setText(listaMaquina01.get(0).getTamanho_Disco());
        lblNumCpuFisMaq01.setText(listaMaquina01.get(0).getNumero_CPU_fisica().toString());
        
        //MAQUINA 2
        Computador comp2 = new Computador();
        List<Computador> listaMaquina02 = banco.query("select idMaquina, Hospital.nome_Hospital, ala_Hospitalar, sistema_Operacional, fabricante, nome_Processador,"
                + "frequencia_Processador, capacidade_Total_Memoria, tamanho_Disco, numero_CPU_fisica from maquina\n" +
        "right join hospital on maquina.fkHospital = hospital.idHospital where idMaquina = 2;", new BeanPropertyRowMapper(Computador.class));
        
        lblIdMaq2.setText(listaMaquina02.get(0).getIdMaquina().toString());
        lblAlaMaq2.setText(listaMaquina02.get(0).getAla_Hospitalar());
        lblSist_OperMaq2.setText(listaMaquina02.get(0).getSistema_Operacional());
        lblFabricanMaq2.setText(listaMaquina02.get(0).getFabricante());
        lblNomProcessMaq2.setText(listaMaquina02.get(0).getNome_Processador());
        lblFreqProcessMaq2.setText(listaMaquina02.get(0).getFrequencia_Processador());
        lblTotMemoMaq2.setText(listaMaquina02.get(0).getCapacidade_Total_Memoria());
        lblTotDiscoMaq2.setText(listaMaquina02.get(0).getTamanho_Disco());
        lblNumCpuFisMaq2.setText(listaMaquina02.get(0).getNumero_CPU_fisica().toString());
        
        //MAQUINA 3
        Computador comp3 = new Computador();
        List<Computador> listaMaquina03 = banco.query("select idMaquina, Hospital.nome_Hospital, ala_Hospitalar, sistema_Operacional, fabricante, nome_Processador,"
                + "frequencia_Processador, capacidade_Total_Memoria, tamanho_Disco, numero_CPU_fisica from maquina\n" +
        "right join hospital on maquina.fkHospital = hospital.idHospital where idMaquina = 3;", new BeanPropertyRowMapper(Computador.class));
        
        lblIdMaq3.setText(listaMaquina03.get(0).getIdMaquina().toString());
        lblAlaMaq3.setText(listaMaquina03.get(0).getAla_Hospitalar());
        lblSist_OperMaq3.setText(listaMaquina03.get(0).getSistema_Operacional());
        lblFabricanMaq3.setText(listaMaquina03.get(0).getFabricante());
        lblNomProcessMaq3.setText(listaMaquina03.get(0).getNome_Processador());
        lblFreqProcessMaq3.setText(listaMaquina03.get(0).getFrequencia_Processador());
        lblTotMemoMaq3.setText(listaMaquina03.get(0).getCapacidade_Total_Memoria());
        lblTotDiscoMaq3.setText(listaMaquina03.get(0).getTamanho_Disco());
        lblNumCpuFisMaq3.setText(listaMaquina03.get(0).getNumero_CPU_fisica().toString());
        
        //MAQUINA 4
        Computador comp4 = new Computador();
        List<Computador> listaMaquina04 = banco.query("select idMaquina, Hospital.nome_Hospital, ala_Hospitalar, sistema_Operacional, fabricante, nome_Processador,"
                + "frequencia_Processador, capacidade_Total_Memoria, tamanho_Disco, numero_CPU_fisica from maquina\n" +
        "right join hospital on maquina.fkHospital = hospital.idHospital where idMaquina = 4;", new BeanPropertyRowMapper(Computador.class));
        
        lblIdMaq4.setText(listaMaquina04.get(0).getIdMaquina().toString());
        lblAlaMaq4.setText(listaMaquina04.get(0).getAla_Hospitalar());
        lblSist_OperMaq4.setText(listaMaquina04.get(0).getSistema_Operacional());
        lblFabricanMaq4.setText(listaMaquina04.get(0).getFabricante());
        lblNomProcessMaq4.setText(listaMaquina04.get(0).getNome_Processador());
        lblFreqProcessMaq4.setText(listaMaquina04.get(0).getFrequencia_Processador());
        lblTotMemoMaq4.setText(listaMaquina04.get(0).getCapacidade_Total_Memoria());
        lblTotDiscoMaq4.setText(listaMaquina04.get(0).getTamanho_Disco());
        lblNumCpuFisMaq4.setText(listaMaquina04.get(0).getNumero_CPU_fisica().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnVerMaq01 = new javax.swing.JButton();
        btnVerMaq03 = new javax.swing.JButton();
        btnVerMaq02 = new javax.swing.JButton();
        btnVerMaq04 = new javax.swing.JButton();
        lblHospital01 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblAlaMaq01 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblSist_OperMaq01 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblFabricanMaq01 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblNomProcessMaq01 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCapacidade = new javax.swing.JLabel();
        lblTotMemMaq2 = new javax.swing.JLabel();
        lblTotMemoMaq01 = new javax.swing.JLabel();
        lblTotDiscoMaq01 = new javax.swing.JLabel();
        lblTotMemMaq3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblIdMaq01 = new javax.swing.JLabel();
        lblNumCpuFisMaq01 = new javax.swing.JLabel();
        lblIdMaq2 = new javax.swing.JLabel();
        lblNomProcessMaq2 = new javax.swing.JLabel();
        lblAlaMaq2 = new javax.swing.JLabel();
        lblSist_OperMaq2 = new javax.swing.JLabel();
        lblFabricanMaq2 = new javax.swing.JLabel();
        lblFreqProcessMaq2 = new javax.swing.JLabel();
        lblTotMemoMaq2 = new javax.swing.JLabel();
        lblTotDiscoMaq2 = new javax.swing.JLabel();
        lblNumCpuFisMaq2 = new javax.swing.JLabel();
        lblIdMaq3 = new javax.swing.JLabel();
        lblAlaMaq3 = new javax.swing.JLabel();
        lblSist_OperMaq3 = new javax.swing.JLabel();
        lblFabricanMaq3 = new javax.swing.JLabel();
        lblNomProcessMaq3 = new javax.swing.JLabel();
        lblNomProcessMaq4 = new javax.swing.JLabel();
        lblIdMaq4 = new javax.swing.JLabel();
        lblAlaMaq4 = new javax.swing.JLabel();
        lblSist_OperMaq4 = new javax.swing.JLabel();
        lblFabricanMaq4 = new javax.swing.JLabel();
        lblFreqProcessMaq3 = new javax.swing.JLabel();
        lblFreqProcessMaq4 = new javax.swing.JLabel();
        lblTotMemoMaq3 = new javax.swing.JLabel();
        lblTotMemoMaq4 = new javax.swing.JLabel();
        lblTotDiscoMaq3 = new javax.swing.JLabel();
        lblNumCpuFisMaq3 = new javax.swing.JLabel();
        lblTotDiscoMaq4 = new javax.swing.JLabel();
        lblNumCpuFisMaq4 = new javax.swing.JLabel();
        btnVerMedidas = new javax.swing.JButton();
        lblFreqProcessMaq01 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Informações das Máquinas");

        btnVerMaq01.setText("Maquina 1");
        btnVerMaq01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMaq01ActionPerformed(evt);
            }
        });

        btnVerMaq03.setText("Máquina 3");
        btnVerMaq03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMaq03ActionPerformed(evt);
            }
        });

        btnVerMaq02.setText("Maquina 2");
        btnVerMaq02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMaq02ActionPerformed(evt);
            }
        });

        btnVerMaq04.setText("Maquina 4");
        btnVerMaq04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMaq04ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Ala Hospitalar:");

        lblAlaMaq01.setText("---------");

        lblSist_OperMaq01.setText("--------");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Sistema Operacional:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Fabricante:");

        lblFabricanMaq01.setText("--------");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Processador:");

        lblNomProcessMaq01.setText("--------");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Frequencia do Processador:");

        txtCapacidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCapacidade.setText("Capacidade Total da Memória:");

        lblTotMemMaq2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTotMemMaq2.setText("Tamanho do Disco:");

        lblTotMemoMaq01.setText("--------");

        lblTotDiscoMaq01.setText("--------");

        lblTotMemMaq3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTotMemMaq3.setText("Numero de CPUs Fisicas:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("ID da máquina:");

        lblIdMaq01.setText("-------");

        lblNumCpuFisMaq01.setText("--------");

        lblIdMaq2.setText("-------");

        lblNomProcessMaq2.setText("--------");

        lblAlaMaq2.setText("---------");

        lblSist_OperMaq2.setText("--------");

        lblFabricanMaq2.setText("--------");

        lblFreqProcessMaq2.setText("--------");

        lblTotMemoMaq2.setText("--------");

        lblTotDiscoMaq2.setText("--------");

        lblNumCpuFisMaq2.setText("--------");

        lblIdMaq3.setText("-------");

        lblAlaMaq3.setText("---------");

        lblSist_OperMaq3.setText("--------");

        lblFabricanMaq3.setText("--------");

        lblNomProcessMaq3.setText("--------");

        lblNomProcessMaq4.setText("--------");

        lblIdMaq4.setText("-------");

        lblAlaMaq4.setText("---------");

        lblSist_OperMaq4.setText("--------");

        lblFabricanMaq4.setText("--------");

        lblFreqProcessMaq3.setText("--------");

        lblFreqProcessMaq4.setText("--------");

        lblTotMemoMaq3.setText("--------");

        lblTotMemoMaq4.setText("--------");

        lblTotDiscoMaq3.setText("--------");

        lblNumCpuFisMaq3.setText("--------");

        lblTotDiscoMaq4.setText("--------");

        lblNumCpuFisMaq4.setText("--------");

        btnVerMedidas.setText("Ver medidas");
        btnVerMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMedidasActionPerformed(evt);
            }
        });

        lblFreqProcessMaq01.setText("--------");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(btnVerMaq01)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerMaq04)
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(lblHospital01, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(309, 309, 309)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblAlaMaq2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblAlaMaq3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnVerMaq02)
                                                .addGap(293, 293, 293)
                                                .addComponent(btnVerMaq03)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblAlaMaq4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(lblFabricanMaq2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblFabricanMaq3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(lblSist_OperMaq2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(318, 318, 318)
                                                .addComponent(lblSist_OperMaq3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblSist_OperMaq4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblFabricanMaq4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(16, 16, 16))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblFreqProcessMaq01)
                                .addGap(261, 261, 261)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblTotMemoMaq3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblFreqProcessMaq2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(339, 339, 339)
                                            .addComponent(lblFreqProcessMaq3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(388, 388, 388)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblNumCpuFisMaq3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblTotDiscoMaq3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblFreqProcessMaq4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblTotMemoMaq4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblTotDiscoMaq4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNumCpuFisMaq4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(582, 582, 582))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSist_OperMaq01, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAlaMaq01, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCapacidade)
                                    .addComponent(lblTotMemMaq2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotMemoMaq01, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTotDiscoMaq01, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNumCpuFisMaq01, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblTotMemMaq3))
                        .addGap(195, 195, 195)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotDiscoMaq2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotMemoMaq2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNumCpuFisMaq2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(79, 79, 79)
                        .addComponent(lblFabricanMaq01, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(32, 32, 32)
                        .addComponent(lblNomProcessMaq01, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(lblNomProcessMaq2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(lblNomProcessMaq3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(lblNomProcessMaq4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(88, 88, 88)
                .addComponent(lblIdMaq01)
                .addGap(288, 288, 288)
                .addComponent(lblIdMaq2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIdMaq3)
                .addGap(296, 296, 296)
                .addComponent(lblIdMaq4)
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addGap(613, 613, 613)
                .addComponent(btnVerMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerMaq01)
                    .addComponent(btnVerMaq02)
                    .addComponent(btnVerMaq03)
                    .addComponent(btnVerMaq04))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblIdMaq01)
                    .addComponent(lblIdMaq2)
                    .addComponent(lblIdMaq3)
                    .addComponent(lblIdMaq4))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHospital01)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAlaMaq01)
                            .addComponent(lblAlaMaq2))
                        .addGap(63, 63, 63))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblSist_OperMaq01)
                            .addComponent(lblSist_OperMaq2)
                            .addComponent(lblSist_OperMaq3)
                            .addComponent(lblSist_OperMaq4))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAlaMaq3)
                            .addComponent(lblAlaMaq4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblFabricanMaq01)
                    .addComponent(lblFabricanMaq2)
                    .addComponent(lblFabricanMaq3)
                    .addComponent(lblFabricanMaq4))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblNomProcessMaq01)
                    .addComponent(lblNomProcessMaq2)
                    .addComponent(lblNomProcessMaq3)
                    .addComponent(lblNomProcessMaq4))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblFreqProcessMaq2)
                    .addComponent(lblFreqProcessMaq3)
                    .addComponent(lblFreqProcessMaq4)
                    .addComponent(lblFreqProcessMaq01))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCapacidade)
                    .addComponent(lblTotMemoMaq01)
                    .addComponent(lblTotMemoMaq2)
                    .addComponent(lblTotMemoMaq3)
                    .addComponent(lblTotMemoMaq4))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotMemMaq2)
                    .addComponent(lblTotDiscoMaq01)
                    .addComponent(lblTotDiscoMaq2)
                    .addComponent(lblTotDiscoMaq3)
                    .addComponent(lblTotDiscoMaq4))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotMemMaq3)
                    .addComponent(lblNumCpuFisMaq01)
                    .addComponent(lblNumCpuFisMaq2)
                    .addComponent(lblNumCpuFisMaq3)
                    .addComponent(lblNumCpuFisMaq4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnVerMedidas)
                .addGap(78, 78, 78))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //BOTAO PRA VER MAQUINA 1
    private void btnVerMaq01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMaq01ActionPerformed
       
//        Computador comp1 = new Computador();
//        List<Computador> listaMaquina01 = banco.query("select idMaquina, Hospital.nome_Hospital, ala_Hospitalar, sistema_Operacional, fabricante, nome_Processador,"
//                + "frequencia_Processador, capacidade_Total_Memoria, tamanho_Disco, numero_CPU_fisica from maquina\n" +
//        "right join hospital on maquina.fkHospital = hospital.idHospital where idMaquina = 1;", new BeanPropertyRowMapper(Computador.class));
//        
//        lblIdMaq01.setText(listaMaquina01.get(0).getIdMaquina().toString());
//        lblAlaMaq01.setText(listaMaquina01.get(0).getAla_Hospitalar());
//        lblSist_OperMaq01.setText(listaMaquina01.get(0).getSistema_Operacional());
//        lblFabricanMaq01.setText(listaMaquina01.get(0).getFabricante());
//        lblNomProcessMaq01.setText(listaMaquina01.get(0).getNome_Processador());
//        lblFreqProcessMaq01.setText(listaMaquina01.get(0).getFrequencia_Processador());
//        lblTotMemoMaq01.setText(listaMaquina01.get(0).getCapacidade_Total_Memoria());
//        lblTotDiscoMaq01.setText(listaMaquina01.get(0).getTamanho_Disco());
//        lblNumCpuFisMaq01.setText(listaMaquina01.get(0).getNumero_CPU_fisica().toString());
        
    }//GEN-LAST:event_btnVerMaq01ActionPerformed
        //BOTAO PRA VER MAQUINA 2
    private void btnVerMaq02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMaq02ActionPerformed
//        Computador comp2 = new Computador();
//        List<Computador> listaMaquina02 = banco.query("select idMaquina, Hospital.nome_Hospital, ala_Hospitalar, sistema_Operacional, fabricante, nome_Processador,"
//                + "frequencia_Processador, capacidade_Total_Memoria, tamanho_Disco, numero_CPU_fisica from maquina\n" +
//        "right join hospital on maquina.fkHospital = hospital.idHospital where idMaquina = 2;", new BeanPropertyRowMapper(Computador.class));
//        
//        lblIdMaq2.setText(listaMaquina02.get(0).getIdMaquina().toString());
//        lblAlaMaq2.setText(listaMaquina02.get(0).getAla_Hospitalar());
//        lblSist_OperMaq2.setText(listaMaquina02.get(0).getSistema_Operacional());
//        lblFabricanMaq2.setText(listaMaquina02.get(0).getFabricante());
//        lblNomProcessMaq2.setText(listaMaquina02.get(0).getNome_Processador());
//        lblFreqProcessMaq2.setText(listaMaquina02.get(0).getFrequencia_Processador());
//        lblTotMemoMaq2.setText(listaMaquina02.get(0).getCapacidade_Total_Memoria());
//        lblTotDiscoMaq2.setText(listaMaquina02.get(0).getTamanho_Disco());
//        lblNumCpuFisMaq2.setText(listaMaquina02.get(0).getNumero_CPU_fisica().toString());
        
    }//GEN-LAST:event_btnVerMaq02ActionPerformed
        //BOTAO PRA VER MAQUINA 3
    private void btnVerMaq03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMaq03ActionPerformed
//        Computador comp3 = new Computador();
//        List<Computador> listaMaquina03 = banco.query("select idMaquina, Hospital.nome_Hospital, ala_Hospitalar, sistema_Operacional, fabricante, nome_Processador,"
//                + "frequencia_Processador, capacidade_Total_Memoria, tamanho_Disco, numero_CPU_fisica from maquina\n" +
//        "right join hospital on maquina.fkHospital = hospital.idHospital where idMaquina = 3;", new BeanPropertyRowMapper(Computador.class));
//        
//        lblIdMaq3.setText(listaMaquina03.get(0).getIdMaquina().toString());
//        lblAlaMaq3.setText(listaMaquina03.get(0).getAla_Hospitalar());
//        lblSist_OperMaq3.setText(listaMaquina03.get(0).getSistema_Operacional());
//        lblFabricanMaq3.setText(listaMaquina03.get(0).getFabricante());
//        lblNomProcessMaq3.setText(listaMaquina03.get(0).getNome_Processador());
//        lblFreqProcessMaq3.setText(listaMaquina03.get(0).getFrequencia_Processador());
//        lblTotMemoMaq3.setText(listaMaquina03.get(0).getCapacidade_Total_Memoria());
//        lblTotDiscoMaq3.setText(listaMaquina03.get(0).getTamanho_Disco());
//        lblNumCpuFisMaq3.setText(listaMaquina03.get(0).getNumero_CPU_fisica().toString());
    }//GEN-LAST:event_btnVerMaq03ActionPerformed
        //BOTAO PRA VER MAQUINA 4
    private void btnVerMaq04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMaq04ActionPerformed
//        Computador comp4 = new Computador();
//        List<Computador> listaMaquina04 = banco.query("select idMaquina, Hospital.nome_Hospital, ala_Hospitalar, sistema_Operacional, fabricante, nome_Processador,"
//                + "frequencia_Processador, capacidade_Total_Memoria, tamanho_Disco, numero_CPU_fisica from maquina\n" +
//        "right join hospital on maquina.fkHospital = hospital.idHospital where idMaquina = 4;", new BeanPropertyRowMapper(Computador.class));
//        
//        lblIdMaq4.setText(listaMaquina04.get(0).getIdMaquina().toString());
//        lblAlaMaq4.setText(listaMaquina04.get(0).getAla_Hospitalar());
//        lblSist_OperMaq4.setText(listaMaquina04.get(0).getSistema_Operacional());
//        lblFabricanMaq4.setText(listaMaquina04.get(0).getFabricante());
//        lblNomProcessMaq4.setText(listaMaquina04.get(0).getNome_Processador());
//        lblFreqProcessMaq4.setText(listaMaquina04.get(0).getFrequencia_Processador());
//        lblTotMemoMaq4.setText(listaMaquina04.get(0).getCapacidade_Total_Memoria());
//        lblTotDiscoMaq4.setText(listaMaquina04.get(0).getTamanho_Disco());
//        lblNumCpuFisMaq4.setText(listaMaquina04.get(0).getNumero_CPU_fisica().toString());
    }//GEN-LAST:event_btnVerMaq04ActionPerformed

    private void btnVerMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMedidasActionPerformed
        TelaMedidasMaquina telaMedidas = new TelaMedidasMaquina();
        telaMedidas.setVisible(true);
                
    }//GEN-LAST:event_btnVerMedidasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInfMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInfMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInfMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInfMaquina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInfMaquina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerMaq01;
    private javax.swing.JButton btnVerMaq02;
    private javax.swing.JButton btnVerMaq03;
    private javax.swing.JButton btnVerMaq04;
    private javax.swing.JButton btnVerMedidas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblAlaMaq01;
    private javax.swing.JLabel lblAlaMaq2;
    private javax.swing.JLabel lblAlaMaq3;
    private javax.swing.JLabel lblAlaMaq4;
    private javax.swing.JLabel lblFabricanMaq01;
    private javax.swing.JLabel lblFabricanMaq2;
    private javax.swing.JLabel lblFabricanMaq3;
    private javax.swing.JLabel lblFabricanMaq4;
    private javax.swing.JLabel lblFreqProcessMaq01;
    private javax.swing.JLabel lblFreqProcessMaq2;
    private javax.swing.JLabel lblFreqProcessMaq3;
    private javax.swing.JLabel lblFreqProcessMaq4;
    private javax.swing.JLabel lblHospital01;
    private javax.swing.JLabel lblIdMaq01;
    private javax.swing.JLabel lblIdMaq2;
    private javax.swing.JLabel lblIdMaq3;
    private javax.swing.JLabel lblIdMaq4;
    private javax.swing.JLabel lblNomProcessMaq01;
    private javax.swing.JLabel lblNomProcessMaq2;
    private javax.swing.JLabel lblNomProcessMaq3;
    private javax.swing.JLabel lblNomProcessMaq4;
    private javax.swing.JLabel lblNumCpuFisMaq01;
    private javax.swing.JLabel lblNumCpuFisMaq2;
    private javax.swing.JLabel lblNumCpuFisMaq3;
    private javax.swing.JLabel lblNumCpuFisMaq4;
    private javax.swing.JLabel lblSist_OperMaq01;
    private javax.swing.JLabel lblSist_OperMaq2;
    private javax.swing.JLabel lblSist_OperMaq3;
    private javax.swing.JLabel lblSist_OperMaq4;
    private javax.swing.JLabel lblTotDiscoMaq01;
    private javax.swing.JLabel lblTotDiscoMaq2;
    private javax.swing.JLabel lblTotDiscoMaq3;
    private javax.swing.JLabel lblTotDiscoMaq4;
    private javax.swing.JLabel lblTotMemMaq2;
    private javax.swing.JLabel lblTotMemMaq3;
    private javax.swing.JLabel lblTotMemoMaq01;
    private javax.swing.JLabel lblTotMemoMaq2;
    private javax.swing.JLabel lblTotMemoMaq3;
    private javax.swing.JLabel lblTotMemoMaq4;
    private javax.swing.JLabel txtCapacidade;
    // End of variables declaration//GEN-END:variables
}
