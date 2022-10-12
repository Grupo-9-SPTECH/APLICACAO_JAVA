/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidas;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.util.Conversor;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.h2.util.LocalDateTimeUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author rmsouza
 */
public class MainMedidas {

    public static void main(String[] args) {

        //CONEXAO BANCO
        ConexaoTechHealth connection = new ConexaoTechHealth();
        JdbcTemplate banco = connection.getConexao();

        //INSTANCIAS
        Looca looca = new Looca();
        Memoria memoria = new Memoria();
        Processador processador = new Processador();
        Conversor conversor = new Conversor();
        Date dataHoraAtual = new Date();

        DiscoGrupo grupoDeDiscos = new DiscoGrupo();
        List<Disco> discos = grupoDeDiscos.getDiscos();
            
        ProcessoGrupo grupoProcesso = new ProcessoGrupo();
        List<Processo> processos = grupoProcesso.getProcessos();

        //CRIANDO VARIAVEIS PRA PEGAR AS MEDIDAS
        //Long memoria_Em_Uso = Conversor.formatarBytes(memoria.getEmUso()); -------- PS: essa foi direto no insert       
        Double percent_Uso_Processador = processador.getUso();
        //Double percent_Uso_Ram_Processo = processo.getUsoMemoria();
        //Long numero_Leituras_Disco = disco.getLeituras();
        String data = new SimpleDateFormat("dd/MM/yyyy ").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        String momento = data + hora;

        
        //INSERINDO VALORES NA TABELA
        for (int i = 1; i <= 4; i++) {
            Integer fkMaquina = i;
            for (Processo itemProcesso : processos) {
                Double percent_Uso_Cpu_Processo = itemProcesso.getUsoCpu();
                Double percent_Uso_Ram_Processo = itemProcesso.getUsoMemoria();
                for (int cont = (processos.size() - 1); cont < processos.size(); cont++) {
                    for (Disco itemDisco : discos) {
                        for (int contDisco = (discos.size() - 1); contDisco < discos.size(); contDisco++) {
                            banco.update("INSERT INTO medida VALUES (?, ?, ?, ?, ?, ?, ?, ?)", null, 
                                    Conversor.formatarBytes(memoria.getEmUso()),
                                    percent_Uso_Cpu_Processo,
                                    percent_Uso_Processador, percent_Uso_Ram_Processo, 
                                    Conversor.formatarBytes(itemDisco.getLeituras()), momento, fkMaquina);
                        }                       
                    }
                }
                break;
            }
        }

        
        System.out.println("MEDIDAS INSERIDAS");

        List<Medida> listaMedidas = banco.query("select maquina.idMaquina, maquina.ala_Hospitalar, memoria_Em_Uso,"
                + "percent_Uso_Cpu_Processo, percent_Uso_Processador, percent_Uso_Ram_Processo,"
                + "numero_Leituras_Disco, momento from medida left join maquina "
                + "on medida.fkMaquina = maquina.idMaquina"
                + " order by idMaquina;", new BeanPropertyRowMapper(Medida.class));

        for (Medida itemMedida : listaMedidas) {
            System.out.println(itemMedida);
        }
    }

}
