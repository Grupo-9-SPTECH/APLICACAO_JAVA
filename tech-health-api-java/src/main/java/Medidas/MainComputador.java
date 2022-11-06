/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidas;

//import Funcionario;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;

import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.servicos.Servico;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.github.britooo.looca.api.util.Conversor;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author rmsouza
 */
public class MainComputador {

    public static void main(String[] args) {

        //CONEXAO BANCO
        ConexaoTechHealth connection = new ConexaoTechHealth();
        JdbcTemplate banco = connection.getConexao();

        //instanciando a classe funcionario
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
        } else {
            System.out.println("\nLOGIN ERRADO");
        }

        //CRIANDO O LOOCA + INSTANCIANDO OUTRAS CLASSES DAS MEDIDAS
        Looca looca = new Looca();
        Computador comp = new Computador();
        Processador processador = new Processador();
        Sistema sistema = new Sistema();
        Memoria memoria = new Memoria();
        Conversor conversor = new Conversor();
        DiscoGrupo grupoDeDiscos = new DiscoGrupo();
        List<Disco> discos = grupoDeDiscos.getDiscos();
        ProcessoGrupo grupoProcesso = new ProcessoGrupo();
        List<Processo> processos = grupoProcesso.getProcessos();

        //CRIANDO VARIAVEIS DAS MEDIDAS
        String nome_Processador = processador.getNome();
        Integer numero_CPU_fisica = processador.getNumeroCpusFisicas();
        //Long capacidade_Total_Memoria = Conversor.formatarBytes(memoria.getTotal());   -------- PS: essa foi direto no insert
        String sistema_Operacional = sistema.getSistemaOperacional();
        String fabricante = sistema.getFabricante();
        //Disco tbm foi no insert
        //Freq do processador foi no insert

        //INSERINDO VALORES
        //MAQUINA 
        System.out.println("\n\nCADASTRO DA MÁQUINA");
        for (Disco itemDisco : discos) {
            for (int contDisco = (discos.size() - 1); contDisco < discos.size(); contDisco++) {

                // input para o usuario escrever qual ala hospitalar a maquina esta
                System.out.println("\nAla em que a máquina está inserida: ");
                Scanner leitor3 = new Scanner(System.in);
                String alaHospitalar = leitor3.nextLine();
                Double tamanho_Disco = Double.parseDouble(Conversor.formatarBytes(itemDisco.getTamanho()).replace("GiB", "").replaceAll(",", "."));
                Double frequencia_Processador = Double.parseDouble(Conversor.formatarBytes(processador.getFrequencia()).replace("GiB", "").replaceAll(",", "."));
                Double capacidade_Total_Memoria = Double.parseDouble(Conversor.formatarBytes(memoria.getTotal()).replace("GiB", "").replaceAll(",", "."));

                banco.update("INSERT INTO maquina VALUES (?, ?,?, ?, ?, ?, ?, ?, ?)",
                        //null,
                        alaHospitalar, sistema_Operacional, fabricante, nome_Processador, frequencia_Processador,
                        capacidade_Total_Memoria,
                        tamanho_Disco, numero_CPU_fisica, "1");

                System.out.println("Maquina Inserida");

            }
            break;
        }

        //adicionando o select da maquina numa lista
        List<Computador> listaMaquinas = banco.query("select Hospital.nome_Hospital, idMaquina, ala_Hospitalar, sistema_Operacional, "
                + "fabricante, nome_Processador, "
                + "frequencia_Processador, capacidade_Total_Memoria, tamanho_Disco, numero_CPU_fisica from maquina\n"
                + " right join hospital on maquina.fkHospital = hospital.idHospital;", new BeanPropertyRowMapper(Computador.class));

        //mostrando na tela a maquina do usuario
        System.out.println("\nSua máquina é essa: ");
        for (Computador itemMaquina : listaMaquinas) {
            if (itemMaquina.getIdMaquina() == (listaMaquinas.size())) {
                System.out.println(itemMaquina);
            }

        }

        //CRIANDO VARIAVEIS PRA PEGAR AS MEDIDAS
        //Long memoria_Em_Uso = Conversor.formatarBytes(memoria.getEmUso()); -------- PS: essa foi direto no insert       
        //Double percent_Uso_Ram_Processo = processo.getUsoMemoria();
        //Long numero_Leituras_Disco = disco.getLeituras();
        //INSERINDO VALORES NA TABELA de 5 em 5 segundos
        new Timer().scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {

                //variaveis
                //fk do computador
                Integer fkComp = listaMaquinas.size();
                Double uso_Processador = processador.getUso() / 10;

                for (Processo itemProcesso : processos) {

                    for (int cont = (processos.size() - 1); cont < processos.size(); cont++) {

                        //variaveis
                        Double uso_Cpu_Processo = itemProcesso.getUsoCpu();
                        Double uso_Ram_Processo = itemProcesso.getUsoMemoria() * 100000;

                        for (Disco itemDisco : discos) {

                            for (int contDisco = (discos.size() - 1); contDisco < discos.size(); contDisco++) {

                                //variaveis pra pegar o momento da medida
                                Date dataHoraAtual = new Date();
                                String data = new SimpleDateFormat("dd/MM/yyyy ").format(dataHoraAtual);
                                String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
                                String momento = data + hora;

                                Double memoria_Em_Uso = Double.parseDouble(Conversor.formatarBytes(memoria.getEmUso()).replace("GiB", "").replaceAll(",", "."));
                                String usoDiscoGb = Conversor.formatarBytes(itemDisco.getBytesDeEscritas() + itemDisco.getBytesDeLeitura());
                                String usoNumbersOnly = usoDiscoGb.replace("GiB", "").replaceAll(",", ".");
                                Double usoDisco = Double.parseDouble(usoNumbersOnly);
                                Double tamanho_Disco = Double.parseDouble(Conversor.formatarBytes(itemDisco.getTamanho()).substring(0, 5).replaceAll(",", "."));
                                Double capacidade_Total_Memoria = Double.parseDouble(Conversor.formatarBytes(memoria.getTotal()).substring(0, 5).replaceAll(",", "."));

                                Double percent_Memoria_Em_Uso = (memoria_Em_Uso * 100) / capacidade_Total_Memoria;
                                Double percent_Uso_Disco = (usoDisco * 100) / tamanho_Disco;

                                banco.update("INSERT INTO medida VALUES ( ?, ?, ?, ?, ?, ?, ?)",
                                        //null,
                                        percent_Memoria_Em_Uso,
                                        uso_Cpu_Processo,
                                        uso_Processador, uso_Ram_Processo,
                                        percent_Uso_Disco, momento, fkComp);

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

                        }
                    }

                    break;

                }

            }

        }, 0, 5000);

    }
}
