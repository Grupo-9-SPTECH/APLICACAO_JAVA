/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidas;

/**
 *
 * @author rmsouza
 */
public class Medida {

    private Integer idMedida;
    private Integer idMaquina;
    private String ala_Hospitalar;
    private String memoria_Em_Uso;
    private String frequencia_Processador;
    private Double percent_Uso_Cpu_Processo;
    private Double percent_Uso_Processador;
    private Double percent_Uso_Ram_Processo;
    private String numero_Leituras_Disco;
    private String momento;

    //get e set

    public Integer getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Integer idMedida) {
        this.idMedida = idMedida;
    }
    
    
    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getMemoria_Em_Uso() {
        return memoria_Em_Uso;
    }

    public void setMemoria_Em_Uso(String memoria_Em_Uso) {
        this.memoria_Em_Uso = memoria_Em_Uso;
    }

    public String getFrequencia_Processador() {
        return frequencia_Processador;
    }

    public void setFrequencia_Processador(String frequencia_Processador) {
        this.frequencia_Processador = frequencia_Processador;
    }

    public Double getPercent_Uso_Cpu_Processo() {
        return percent_Uso_Cpu_Processo;
    }

    public void setPercent_Uso_Cpu_Processo(Double percent_Uso_Cpu_Processo) {
        this.percent_Uso_Cpu_Processo = percent_Uso_Cpu_Processo;
    }

    public Double getPercent_Uso_Processador() {
        return percent_Uso_Processador;
    }

    public void setPercent_Uso_Processador(Double percent_Uso_Processador) {
        this.percent_Uso_Processador = percent_Uso_Processador;
    }

    public Double getPercent_Uso_Ram_Processo() {
        return percent_Uso_Ram_Processo;
    }

    public void setPercent_Uso_Ram_Processo(Double percent_Uso_Ram_Processo) {
        this.percent_Uso_Ram_Processo = percent_Uso_Ram_Processo;
    }

    public String getNumero_Leituras_Disco() {
        return numero_Leituras_Disco;
    }

    public void setNumero_Leituras_Disco(String numero_Leituras_Disco) {
        this.numero_Leituras_Disco = numero_Leituras_Disco;
    }

    public String getMomento() {
        return momento;
    }

    public void setMomento(String momento) {
        this.momento = momento;
    }

    public String getAla_Hospitalar() {
        return ala_Hospitalar;
    }

    public void setAla_Hospitalar(String ala_Hospitalar) {
        this.ala_Hospitalar = ala_Hospitalar;
    }
    
    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder();
        //StringBuilder stb = new StringBuilder();

        sb.append("\nID da Medida: ")
                .append(getIdMedida())
                .append("\n");
        
        sb.append("\nID da maquina: ")
                .append(getIdMaquina())
                .append("\n");

        sb.append("Ala Hospitalar: ")
                .append(getAla_Hospitalar())
                .append("\n");
        
        sb.append("Memoria em Uso: ")
                .append(getMemoria_Em_Uso())
                .append("\n");

//        sb.append("Frequencia do Processador:")
//                .append(getFrequencia_Processador())
//                .append("\n");

        sb.append("%Uso da CPU no processo: ")
                .append(getPercent_Uso_Cpu_Processo())
                .append("\n");

        sb.append("%Uso do Processador:")
                .append(getPercent_Uso_Processador())
                .append("\n");

        sb.append("%Uso da RAM no processo:")
                .append(getPercent_Uso_Ram_Processo())
                .append("\n");

        sb.append("Numero de leituras do Disco: ")
                .append(getNumero_Leituras_Disco())
                .append("\n");

        sb.append("Momento: ")
                .append(getMomento())
                .append("\n");
        
        return sb.toString();

    }

}
