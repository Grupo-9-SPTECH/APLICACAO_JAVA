
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import oshi.hardware.HWDiskStore;
import oshi.software.os.OSFileStore;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rmsouza
 */
public class Looca {
    public static void main(String[] args) {
        Looca looca = new Looca();
        
        //SISTEMA
        System.out.println("\nTrazendo qual o sistema da maquina");
        Sistema sistema = new Sistema();
        System.out.println(sistema);
        
        //MEMORIA
        Memoria memoria = new Memoria();
        System.out.println("\nTrazendo a memoria da maquina");
        System.out.println(memoria);
        
        //TEMPERATURA
        System.out.println("\nTrazendo qual a temperatura atual da maquina");
        Temperatura temperatura = new Temperatura();
        System.out.println(temperatura);
        
        //PROCESSADOR
        System.out.println("\nTrazendo informações do processador da maquina");
        Processador processador = new Processador();
        System.out.println(processador);
        
        //DISCO
        //System.out.println("\nTrazendo qual a temperatura atual da maquina");
        //Disco disco = new Disco((HWDiskStore disco));
        //System.out.println(disco);
        
        //VOLUME
        //System.out.println("\nTrazendo qual a temperatura atual da maquina");
        
        //Volume volume = new Volume();
        //System.out.println(volume);
        
    }
}
