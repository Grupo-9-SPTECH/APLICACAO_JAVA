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
    private Double percent_Memoria_Em_Uso;
    private Double uso_Cpu_Processo;
    private Double uso_Processador;
    private Double uso_Ram_Processo;
    private Double percent_Uso_Disco;
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

    public String getAla_Hospitalar() {
        return ala_Hospitalar;
    }

    public void setAla_Hospitalar(String ala_Hospitalar) {
        this.ala_Hospitalar = ala_Hospitalar;
    }

    public Double getPercent_Memoria_Em_Uso() {
        return percent_Memoria_Em_Uso;
    }

    public void setPercent_Memoria_Em_Uso(Double percent_Memoria_Em_Uso) {
        this.percent_Memoria_Em_Uso = percent_Memoria_Em_Uso;
    }

    public Double getUso_Cpu_Processo() {
        return uso_Cpu_Processo;
    }

    public void setUso_Cpu_Processo(Double uso_Cpu_Processo) {
        this.uso_Cpu_Processo = uso_Cpu_Processo;
    }

    public Double getUso_Processador() {
        return uso_Processador;
    }

    public void setUso_Processador(Double uso_Processador) {
        this.uso_Processador = uso_Processador;
    }

    public Double getUso_Ram_Processo() {
        return uso_Ram_Processo;
    }

    public void setUso_Ram_Processo(Double uso_Ram_Processo) {
        this.uso_Ram_Processo = uso_Ram_Processo;
    }

    public Double getPercent_Uso_Disco() {
        return percent_Uso_Disco;
    }

    public void setPercent_Uso_Disco(Double percent_Uso_Disco) {
        this.percent_Uso_Disco = percent_Uso_Disco;
    }

    public String getMomento() {
        return momento;
    }

    public void setMomento(String momento) {
        this.momento = momento;
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
                .append(getPercent_Memoria_Em_Uso())
                .append(" %")
                .append("\n");

//        sb.append("Frequencia do Processador:")
//                .append(getFrequencia_Processador())
//                .append("\n");

        sb.append("Uso da CPU no processo: ")
                .append(getUso_Cpu_Processo())
                .append("\n");

        sb.append("Uso do Processador:")
                .append(getUso_Processador())
                .append("\n");

        sb.append("Uso da RAM no processo:")
                .append(getUso_Ram_Processo())
                .append("\n");

        sb.append("Disco em Uso: ")
                .append(getPercent_Uso_Disco())
                .append(" %")
                .append("\n");

        sb.append("Momento: ")
                .append(getMomento())
                .append("\n");
        
        return sb.toString();

    }

}
