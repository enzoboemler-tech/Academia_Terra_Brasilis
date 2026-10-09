package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static final String URL =
            "jdbc:mysql://localhost:3306/academia_terra_brasilis";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Método para retornar a conexão
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        }catch (Exception e){
            throw new RuntimeException("Erro ao conectar no banco: ",e);
        }
    }
}









