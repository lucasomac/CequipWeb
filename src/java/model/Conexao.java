package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    public Conexao() {
    }

    private static String status = "Não conectou...";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String serverName = "localhost";
            String mydatabase = "patrimonio";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";
            String password = "1234";
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            System.out.println(status);
            return connection;
        } catch (SQLException ex) {//Não conseguiu conectar ao banco...
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            System.exit(0);
            return null;
        } catch (ClassNotFoundException ex) { //Não encontrou o DRIVER...
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("O driver expecificado nao foi encontrado.");
            System.exit(0);
            return null;
        }
    }

    public String getStatusConnection() {
        return status;
    }

    public static boolean fecharConexao() {
        try {
            Conexao.getConnection().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static Connection reiniciarConexao() throws SQLException {
        fecharConexao();
        return Conexao.getConnection();

    }
}
