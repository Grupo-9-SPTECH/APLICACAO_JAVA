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
        btnVerMedidas = new javax.swing.JButton();
        lblFreqProcessMaq01 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Informações da Máquina");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Ala Hospitalar:");

        lblAlaMaq01.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAlaMaq01.setText("---------");

        lblSist_OperMaq01.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSist_OperMaq01.setText("--------");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 204));
        jLabel6.setText("Sistema Operacional:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Fabricante:");

        lblFabricanMaq01.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFabricanMaq01.setText("--------");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setText("Processador:");

        lblNomProcessMaq01.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNomProcessMaq01.setText("--------");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 204));
        jLabel8.setText("Frequencia do Processador:");

        txtCapacidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCapacidade.setForeground(new java.awt.Color(0, 51, 204));
        txtCapacidade.setText("Capacidade Total da Memória:");

        lblTotMemMaq2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotMemMaq2.setForeground(new java.awt.Color(0, 51, 204));
        lblTotMemMaq2.setText("Tamanho do Disco:");

        lblTotMemoMaq01.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotMemoMaq01.setText("--------");

        lblTotDiscoMaq01.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotDiscoMaq01.setText("--------");

        lblTotMemMaq3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotMemMaq3.setForeground(new java.awt.Color(0, 51, 204));
        lblTotMemMaq3.setText("Numero de CPUs Fisicas:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 204));
        jLabel12.setText("ID da máquina:");

        lblIdMaq01.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIdMaq01.setText("-------");

        lblNumCpuFisMaq01.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNumCpuFisMaq01.setText("--------");

        btnVerMedidas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnVerMedidas.setText("Ver medidas");
        btnVerMedidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnVerMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMedidasActionPerformed(evt);
            }
        });

        lblFreqProcessMaq01.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFreqProcessMaq01.setText("--------");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 204, 255));
        jLabel2.setText("     TECH HEALTH   ");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Seja bem vindo(a)");

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNome.setText("---");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFabricanMaq01, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSist_OperMaq01, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomProcessMaq01, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAlaMaq01, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(64, 64, 64)
                        .addComponent(lblFreqProcessMaq01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCapacidade)
                        .addGap(44, 44, 44)
                        .addComponent(lblTotMemoMaq01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotMemMaq2)
                            .addComponent(lblTotMemMaq3))
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumCpuFisMaq01, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotDiscoMaq01, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(119, 119, 119))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(70, 70, 70)
                        .addComponent(lblIdMaq01)
                        .addGap(578, 578, 578))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVerMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(633, 633, 633))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(248, 248, 248)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(lblHospital01, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblHospital01)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblNome))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblIdMaq01))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblAlaMaq01))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSist_OperMaq01)
                            .addComponent(jLabel6))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblFabricanMaq01))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblNomProcessMaq01)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblFreqProcessMaq01))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCapacidade)
                            .addComponent(lblTotMemoMaq01))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotMemMaq2)
                            .addComponent(lblTotDiscoMaq01))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotMemMaq3)
                            .addComponent(lblNumCpuFisMaq01))))
                .addGap(79, 79, 79)
                .addComponent(btnVerMedidas)
                .addGap(333, 333, 333))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JButton btnVerMedidas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblAlaMaq01;
    private javax.swing.JLabel lblFabricanMaq01;
    private javax.swing.JLabel lblFreqProcessMaq01;
    private javax.swing.JLabel lblHospital01;
    private javax.swing.JLabel lblIdMaq01;
    private javax.swing.JLabel lblNomProcessMaq01;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumCpuFisMaq01;
    private javax.swing.JLabel lblSist_OperMaq01;
    private javax.swing.JLabel lblTotDiscoMaq01;
    private javax.swing.JLabel lblTotMemMaq2;
    private javax.swing.JLabel lblTotMemMaq3;
    private javax.swing.JLabel lblTotMemoMaq01;
    private javax.swing.JLabel txtCapacidade;
    // End of variables declaration//GEN-END:variables
}
