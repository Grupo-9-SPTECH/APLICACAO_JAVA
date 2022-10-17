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
import java.util.List;
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

        //CRIANDO VARIAVES DAS MEDIDAS
        String nome_Processador = processador.getNome();
        Integer numero_CPU_fisica = processador.getNumeroCpusFisicas();
        //Long capacidade_Total_Memoria = Conversor.formatarBytes(memoria.getTotal());   -------- PS: essa foi direto no insert
        String sistema_Operacional = sistema.getSistemaOperacional();
        String fabricante = sistema.getFabricante();
        //Disco tbm foi no insert
        //Freq do processador foi no insert
        
        //INSERINDO VALORES
        //MAQUINA 1
        for (Disco itemDisco : discos) {
            for (int contDisco = (discos.size() - 1); contDisco < discos.size(); contDisco++) {
                banco.update("INSERT INTO maquina VALUES (?, ?,?, ?, ?, ?, ?, ?, ?)",
                        "Recepção", sistema_Operacional, fabricante, nome_Processador, Conversor.formatarBytes(processador.getFrequencia()), Conversor.formatarBytes(memoria.getTotal()),
                        Conversor.formatarBytes(itemDisco.getTamanho()), numero_CPU_fisica, "1");
            }
            break;
        }
        
        


        //ADICIONANDO NA LISTAMAQUINAS O SELECT DA TABELA
        List<Computador> listaMaquinas = banco.query("select Hospital.nome_Hospital, ala_Hospitalar, sistema_Operacional, fabricante, nome_Processador, capacidade_Total_Memoria, tamanho_Disco, numero_CPU_fisica from maquina\n"
                + "right join hospital on maquina.fkHospital = hospital.idHospital;", new BeanPropertyRowMapper(Computador.class));

        //EXIBINDO TODAS AS 4 MAQUINAS
        System.out.println("\nInformações das maquinas:");
        for (Computador itemComputador : listaMaquinas) {
            System.out.println(itemComputador);
        }

    }
}
