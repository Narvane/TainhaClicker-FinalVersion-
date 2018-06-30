package jogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MolineteDAO {
private Connection conexao;

	
	public MolineteDAO() throws SQLException {	
		String urlDoBanco = "jdbc:mysql://localhost:3306/TainhaClickerDB?useSSL=false";
		String usuarioDoBanco = "root";
		String senhaDoBanco = "root";
		this.conexao = DriverManager.getConnection(urlDoBanco, usuarioDoBanco, senhaDoBanco);
		System.out.println("Conexao: " + this.conexao);
	}
	public void logarMolinetesDoJogo(ArrayList<Molinete> molinetesDoJogo) {
		String sql = "SELECT * FROM Molinete order by idmolinete";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();
			
			while(rs.next()) {
				Molinete m = new Molinete();
				m.setId(rs.getInt("idMolinete"));
				m.setNome(rs.getString("nomeMolinete"));
				m.setTempoDePuxe(rs.getInt("TempoDePuxe"));
				m.setPreco(rs.getInt("precomolinete"));
				molinetesDoJogo.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
