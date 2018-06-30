package jogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MercadoDAO {
private Connection conexao;
	
	public MercadoDAO() throws SQLException {
		String urlDoBanco = "jdbc:mysql://localhost:3306/tainhaclickerDB?useSSL=false";
		String usuarioDoBanco = "root";
		String senhaDoBanco = "root";
		this.conexao = DriverManager.getConnection(urlDoBanco, usuarioDoBanco, senhaDoBanco);
		System.out.println("Conexao: " + this.conexao);
	}
}
