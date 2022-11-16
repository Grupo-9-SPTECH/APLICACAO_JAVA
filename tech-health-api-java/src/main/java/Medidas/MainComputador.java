/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidas;

import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import com.github.britooo.looca.api.util.Conversor;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author rmsouza
 */
public class MainComputador {

    public static void main(String[] args) throws IOException {

        //CONEXAO BANCO
        ConexaoTechHealth connection = new ConexaoTechHealth();
        JdbcTemplate banco = connection.getConexao();

        //vm
        ConexaoDocker connection2 = new ConexaoDocker();
        JdbcTemplate bancoVM = connection2.getConexao();

        JSONObject json = new JSONObject();
        Funcionario loginFuncionario = new Funcionario();

        //email
        System.out.println("Digite seu email: ");
        Scanner leitor1 = new Scanner(System.in);
        String strEmail = leitor1.nextLine();

        //senha
        System.out.println("Digite sua senha: ");
        Scanner leitor2 = new Scanner(System.in);
        String strSenha = leitor2.nextLine();

        //puxando os dados do usuario do banco de dados
        List<Funcionario> listaFuncionarios = banco.query("SELECT email, senha FROM usuario", new BeanPropertyRowMapper(Funcionario.class));

        Integer login = 0;
        for (Funcionario itemFuncionario : listaFuncionarios) {

            if (itemFuncionario.getEmail().equals(strEmail) && itemFuncionario.getSenha().equals(strSenha)) {
                login++;
            }

        }

        if (login > 0) {
            System.out.println("LOGIN EFETUADO COM SUCESSO");

            //INSTANCIANDO CLASSES
            Computador comp = new Computador();
            Medida medida = new Medida();
            DiscoGrupo grupoDeDiscos = new DiscoGrupo();
            List<Disco> discos = grupoDeDiscos.getDiscos();

            //caminho do log
            FileWriter arq;
            if (comp.pegarNomeFabricante().equals("Microsoft")) {
                arq = new FileWriter("C:\\Users\\Public//maquina.txt");

            } else {
                arq = new FileWriter("/home/ubuntu/Desktop//maquina.txt");

            }

            //COMEÇO DO LOG
            PrintWriter gravarArq = new PrintWriter(arq);

            //CADASTRO DA MAQUINA
            System.out.println("\n\nCADASTRO DA MÁQUINA");

            // input para o usuario escrever qual ala hospitalar a maquina esta
            System.out.println("\nAla em que a máquina está inserida: ");
            Scanner leitor3 = new Scanner(System.in);
            String alaHospitalar = leitor3.nextLine();

            //azure
            banco.update("INSERT INTO maquina VALUES (?, ?,?, ?, ?, ?, ?, ?, ?)",
                    alaHospitalar, comp.pegarNomeSistemaOperacional(), comp.pegarNomeFabricante(), comp.pegarNome_Processador(),
                    comp.pegarFrequencia(), comp.pegarMemoria_Total(), comp.pegarTamanho_Disco(), comp.pegarNumero_CPU_fisica(), "1");
            
            System.out.println("Dados Inseridos no SQL Server");
            
            //vm
            bancoVM.update("INSERT INTO maquina VALUES (?, ?, ?,?, ?, ?, ?, ?, ?, ?)",
                    null, alaHospitalar, comp.pegarNomeSistemaOperacional(), comp.pegarNomeFabricante(), comp.pegarNome_Processador(),
                    comp.pegarFrequencia(), comp.pegarMemoria_Total(), comp.pegarTamanho_Disco(), comp.pegarNumero_CPU_fisica(), "1");

            System.out.println("Dados Inseridos no MySQL");
            
            System.out.println("Maquina Inserida");

            Date dataHoraAtual = new Date();
            String dataLog = new SimpleDateFormat("dd/MM/yyyy ").format(dataHoraAtual);
            String horaLog = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
            String momentoLog = dataLog + horaLog;

            //adicionando o select da maquina numa lista
            List<Computador> listaMaquinas = banco.query("select Hospital.nome_Hospital, idMaquina, ala_Hospitalar, sistema_Operacional, "
                    + "fabricante, nome_Processador, "
                    + "frequencia_Processador, capacidade_Total_Memoria, tamanho_Disco, numero_CPU_fisica from maquina\n"
                    + " right join hospital on maquina.fkHospital = hospital.idHospital;", new BeanPropertyRowMapper(Computador.class));

            //gravando arquivo txt para o log
            gravarArq.printf("Id Maquina: %d\n"
                    + "Ala Hospitalar: %s\n"
                    + "Sistema Operacional: %s\n"
                    + "Fabricante: %s\n"
                    + "Nome do Processador: %s\n"
                    + "Frequencia do Processador: %.2f\n"
                    + "Capacidade da Memoria: %.2f\n"
                    + "Tamanho do Disco: %.2f\n"
                    + "Numero de CPUs Fisicas: %d\n"
                    + "Momento: %s\n\n", listaMaquinas.size(), alaHospitalar, comp.pegarNomeSistemaOperacional(), comp.pegarNomeFabricante(),
                    comp.pegarNome_Processador(), comp.pegarFrequencia(), comp.pegarMemoria_Total(), comp.pegarTamanho_Disco(),
                    comp.pegarNumero_CPU_fisica(), momentoLog
            );

            //log
            gravarArq.printf("+-------------+%n\n");
            arq.close();
            System.out.println("maquina gravada");

            //mostrando na tela a maquina do usuario
            System.out.println("\nSua máquina é essa: ");
            for (Computador itemMaquina : listaMaquinas) {
                if (itemMaquina.getIdMaquina() == (listaMaquinas.size())) {
                    System.out.println(itemMaquina);
                }

            }

            //INSERINDO MEDIDAS NA TABELA de 5 em 5 segundos
            new Timer().scheduleAtFixedRate(new TimerTask() {

                @Override
                public void run() {
                    //fk do computador
                    Integer fkComp = listaMaquinas.size();

                    //variaveis pra pegar o momento da medida
                    Date dataHoraAtual = new Date();
                    String data = new SimpleDateFormat("dd/MM/yyyy ").format(dataHoraAtual);
                    String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
                    String momento = data + hora;
                    //Double percent_Uso_Disco = 0.0;

                    for (Disco itemDisco : discos) {
                        for (int contDisco = (discos.size() - 1); contDisco < discos.size(); contDisco++) {

                            String usoDiscoGb = Conversor.formatarBytes(itemDisco.getBytesDeEscritas() + itemDisco.getBytesDeLeitura());
                            String usoNumbersOnly = "";
                            if (Conversor.formatarBytes(itemDisco.getBytesDeEscritas() + itemDisco.getBytesDeLeitura()).contains("GiB")) {
                                usoNumbersOnly = usoDiscoGb.replace("GiB", "").replaceAll(",", ".");
                            }
                            if (Conversor.formatarBytes(itemDisco.getBytesDeEscritas() + itemDisco.getBytesDeLeitura()).contains("MiB")) {
                                usoNumbersOnly = usoDiscoGb.replace("MiB", "").replaceAll(",", ".");
                            }

                            Double usoDisco = Double.parseDouble(usoNumbersOnly);
                            Double tamanho_Disco = Double.parseDouble(Conversor.formatarBytes(itemDisco.getTamanho()).replace("GiB", "").replaceAll(",", "."));
                            Double percent_Uso_Disco = (usoDisco * 100) / tamanho_Disco;

                            banco.update("INSERT INTO medida VALUES ( ?, ?, ?, ?, ?, ?, ?)",
                                    medida.pegarPercent_Memoria(), medida.pegarCPU_Processo(),
                                    medida.pegarUsoProcessador(), medida.pegarUsoRAM(),
                                    percent_Uso_Disco, momento, fkComp);

                            //insert docker
                            bancoVM.update("INSERT INTO medida VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                                    null, medida.pegarPercent_Memoria(), medida.pegarCPU_Processo(),
                                    medida.pegarUsoProcessador(), medida.pegarUsoRAM(),
                                    percent_Uso_Disco, momento, fkComp);

                            //slack
                            if (medida.pegarPercent_Memoria() > 70.0) {
                                json.put("text", "ID da máquina: " + listaMaquinas.size()
                                        + "\nMemoria acima do limite!!!!"
                                        + "\nMemoria: " + medida.pegarPercent_Memoria()
                                        + "\nMomento: " + momento);
                            }

                            try {
                                Slack.sendMessage(json);
                            } catch (Exception e) {
                                System.out.println("");
                            }
                        }
                        break;
                    }

                    System.out.println("MEDIDAS INSERIDAS");

                    //colocando as medidas numa lista
                    List<Medida> listaMedidas = banco.query("select maquina.idMaquina, idMedida, maquina.ala_Hospitalar, percent_Memoria_Em_Uso, "
                            + "uso_Cpu_Processo, uso_Processador, uso_Ram_Processo, "
                            + "percent_Uso_Disco, momento from medida right join maquina "
                            + "on medida.fkMaquina = maquina.idMaquina "
                            + "where fkMaquina = ? ",
                            new BeanPropertyRowMapper(Medida.class), fkComp);

                    //mostrando a ultima medida inserida
                    System.out.println("\n" + listaMedidas.get(listaMedidas.size() - 1));

                }
            }, 0, 5000);

        } else {
            System.out.println("\nLOGIN ERRADO");
        }
    }

}
