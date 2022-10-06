
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rmsouza
 */
public class TesteMain {
    
    public static void main(String[] args) {
        ConexaoTechHealth connection = new ConexaoTechHealth();
        
        JdbcTemplate banco = connection.getConexao();
        
        // Dropando a tabela caso já exista.
        //banco.execute("DROP TABLE IF EXISTS usuario");
        
        //cria longos textos de maneira organizada.
        //StringBuilder createStatement = new StringBuilder();

        //craindo tabela
        // o método append funciona como se fosse uma concatenação.
//        createStatement.append("CREATE TABLE usuario (");
//        createStatement.append("id INT PRIMARY KEY AUTO_INCREMENT,");
//        createStatement.append("nome VARCHAR(255),");
//        createStatement.append("cnpj VARCHAR(255),");
//        createStatement.append("email VARCHAR(255),");
//        createStatement.append("senha VARCHAR(255)");
//        createStatement.append(")");
        
        // Executando o comando de criação de fato.
        //banco.execute(createStatement.toString());
        
        // Texto padrão para insert, id
        //String insertStatement = "INSERT INTO usuario VALUES (null, ?, ?, ?, ?)";
        
        //inserindo valores
        //banco.update(insertStatement, "raul", "132143432321", "raul@email.com",  "mentos");
//        banco.update(insertStatement, "joao", "53657877456", "joao@safra.com",  "senha123");
//        banco.update(insertStatement, "luan", "9786543457", "luan@vr.com",  "amoluan");
//        banco.update(insertStatement, "leo", "19875645465", "leo@sptech.com",  "signoleo");
//        banco.update(insertStatement, "gui", "098654352415", "gui@gmail.com",  "palmeiras");
        
        
        // Exibindo o resultado
        List<Funcionario> listaFuncionarios = banco.query("SELECT email, senha FROM usuario", new BeanPropertyRowMapper(Funcionario.class));

        System.out.println("\nEXIBINDO DA MANEIRA MAIS ÚTIL:");
        for (Funcionario itemFuncionario : listaFuncionarios) {
            System.out.println(itemFuncionario);
        }
    }
    
}
