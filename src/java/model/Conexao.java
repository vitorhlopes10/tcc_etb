package model;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public static Connection conectar() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/academia", "root", "");
    }
}
