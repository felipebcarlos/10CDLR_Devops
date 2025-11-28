import java.util.Date;
 
import com.example.demo.configuration.AppUser;
import com.example.demo.configuration.LoggedInUser;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
import java.sql.*;
public class ExemploVulnerabilidade {
 
    public static void main(String[] args) {
        String userInput = args[0]; // Supondo que userInput seja a entrada do usuário
 
        // Conexão com o banco de dados (apenas para fins de exemplo)
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "usuario", "senha")) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuarios WHERE nome = ?");
            statement.setString(1, userInput);
            ResultSet resultSet = statement.executeQuery();

         // --> TRECHO VULNERÁVEL A SER REMOVIDO/CORRIGIDO <--
         String userInput = args[0]; // Supondo que userInput seja a entrada do usuário (DUPLICADO)
        Statement statement = connection.createStatement();
        // Consulta SQL vulnerável à injeção
        String query = "SELECT * FROM usuarios WHERE nome = '" + userInput + "'";
        // Execução da consulta
        ResultSet resultSet1 = statement.executeQuery(query);
         // ----------------------------------------------------
 
            // Processamento dos resultados (dessa parte em diante o código já usa a consulta segura)
            while (resultSet.next()) {
                // ...
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
