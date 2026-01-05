package br.com.banco.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMYSQL {




    private static final String URL =
            "jdbc:mysql://localhost:3306/banco"
                    + "?useSSL=false"
                    + "&serverTimezone=UTC"
                    + "&characterEncoding=UTF-8";

    private static final String USER = "root";
        private static final String PASSWORD = "1984";

    // Construtor privado (boa prática)
    private ConexaoMYSQL() {
    }

    // Método correto de conexão
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar no MySQL.");
            throw new RuntimeException(e);
        }
    }
}


