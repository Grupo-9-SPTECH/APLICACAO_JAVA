/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidas;

import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.github.britooo.looca.api.util.Conversor;
import java.util.List;

/**
 *
 * @author rmsouza
 */
public class Computador {

    Sistema sistema = new Sistema();
    Processador processador = new Processador();
    DiscoGrupo grupoDeDiscos = new DiscoGrupo();
    List<Disco> discos = grupoDeDiscos.getDiscos();
    Memoria memoria = new Memoria();
    
    //ATRIBUTOS
    private Integer idMaquina;
    private String nome_Hospital;
    private String ala_Hospitalar;
    private String sistema_Operacional;
    private String fabricante;
    private String nome_Processador;
    private Double frequencia_Processador;
    private Double capacidade_Total_Memoria;
    private Double tamanho_Disco;
    private Integer numero_CPU_fisica;

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public String pegarNomeFabricante() {
        String fabricante = sistema.getFabricante();
        return fabricante;
    }

    public String pegarNomeSistemaOperacional() {
        String sistema_Operacional = sistema.getSistemaOperacional();
        return sistema_Operacional;
    }

    public String pegarNome_Processador() {
        String nome_Processador = processador.getNome();
        return nome_Processador;
    }

    public Integer pegarNumero_CPU_fisica() {
        Integer numero_CPU_fisica = processador.getNumeroCpusFisicas();
        return numero_CPU_fisica;
    }

    public Double pegarFrequencia(){
        Double frequencia_Processador = Double.parseDouble(Conversor.formatarBytes(processador.getFrequencia()).replace("GiB", "").replaceAll(",", "."));
        return frequencia_Processador;
    }
    
    public Double pegarTamanho_Disco() {
        Double tamanho_Disco = 0.0;
        for (Disco itemDisco : discos) {
            for (int contDisco = (discos.size() - 1); contDisco < discos.size(); contDisco++) {
                tamanho_Disco = Double.parseDouble(Conversor.formatarBytes(itemDisco.getTamanho()).replace("GiB", "").replaceAll(",", "."));
            }
            break;
        }
        return tamanho_Disco;
    }
    
    public Double pegarMemoria_Total (){
        Double capacidade_Total_Memoria = Double.parseDouble(Conversor.formatarBytes(memoria.getTotal()).replace("GiB", "").replaceAll(",", "."));
        return capacidade_Total_Memoria;     
    }
   
    //GETTERS e SETTERS
    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNome_Hospital() {
        return nome_Hospital;
    }

    public void setNome_Hospital(String nome_Hospital) {
        this.nome_Hospital = nome_Hospital;
    }

    public String getAla_Hospitalar() {
        return ala_Hospitalar;
    }

    public void setAla_Hospitalar(String ala_Hospitalar) {
        this.ala_Hospitalar = ala_Hospitalar;
    }

    public String getSistema_Operacional() {
        return sistema_Operacional;
    }

    public void setSistema_Operacional(String sistema_Operacional) {
        this.sistema_Operacional = sistema_Operacional;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getNome_Processador() {
        return nome_Processador;
    }

    public void setNome_Processador(String nome_Processador) {
        this.nome_Processador = nome_Processador;
    }

    public Double getCapacidade_Total_Memoria() {
        return capacidade_Total_Memoria;
    }

    public void setCapacidade_Total_Memoria(Double capacidade_Total_Memoria) {
        this.capacidade_Total_Memoria = capacidade_Total_Memoria;
    }

    public Double getTamanho_Disco() {
        return tamanho_Disco;
    }

    public void setTamanho_Disco(Double tamanho_Disco) {
        this.tamanho_Disco = tamanho_Disco;
    }

    public Integer getNumero_CPU_fisica() {
        return numero_CPU_fisica;
    }

    public void setNumero_CPU_fisica(Integer numero_CPU_fisica) {
        this.numero_CPU_fisica = numero_CPU_fisica;
    }

    public Double getFrequencia_Processador() {
        return frequencia_Processador;
    }

    public void setFrequencia_Processador(Double frequencia_Processador) {
        this.frequencia_Processador = frequencia_Processador;
    }

    //TO STRING -> COMO VAI APARECER A MENSAGEM
    @Override
    public String toString() {
        //StringBuilder sbnormal = new StringBuilder();
        final StringBuilder sb = new StringBuilder();
        //StringBuilder stb = new StringBuilder();

        sb.append("\nID da Maquina: ")
                .append(getIdMaquina())
                .append("\n");

        sb.append("\nNome do Hospital: ")
                .append(getNome_Hospital())
                .append("\n");

        sb.append("Ala Hospitalar: ")
                .append(getAla_Hospitalar())
                .append("\n");

        sb.append("Sistema Operacional: ")
                .append(getSistema_Operacional())
                .append("\n");

        sb.append("Fabricante: ")
                .append(getFabricante())
                .append("\n");

        sb.append("Nome do Processador: ")
                .append(getNome_Processador())
                .append("\n");

        sb.append("Frequencia do Processador: ")
                .append(getFrequencia_Processador())
                .append("\n");

        sb.append("Capacidade Total da Memoria: ")
                .append(getCapacidade_Total_Memoria())
                .append(" GiB")
                .append("\n");

        sb.append("Tamanho do Disco: ")
                .append(getTamanho_Disco())
                .append(" GiB")
                .append("\n");

        sb.append("Numero de CPUs fisicas: ")
                .append(getNumero_CPU_fisica())
                .append("\n");

        return sb.toString();
    }

}
