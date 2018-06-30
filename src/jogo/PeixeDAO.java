package jogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PeixeDAO {
private Connection conexao;

	
	public PeixeDAO() throws SQLException {	
		String urlDoBanco = "jdbc:mysql://localhost:3306/TainhaClickerDB?useSSL=false";
		String usuarioDoBanco = "root";
		String senhaDoBanco = "root";
		this.conexao = DriverManager.getConnection(urlDoBanco, usuarioDoBanco, senhaDoBanco);
		System.out.println("Conexao: " + this.conexao);
	}
	public void logarPeixeDoJogo(ArrayList<Peixe> peixesDoJogo) {
		String sql = "SELECT * FROM Peixe order by idpeixe";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();
			
			while(rs.next()) {
				Peixe p = new Peixe();
				p.setIdPeixe(rs.getInt("idPeixe"));
				p.setNome(rs.getString("nomepeixe"));
				p.setPreco(rs.getInt("valor"));
				peixesDoJogo.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void LogarPeixesNaPraia(ArrayList<Peixe> peixesDoJogo) {
		String sql = "SELECT * FROM peixedapraia;";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();
			
			while(rs.next()) {
				Peixe p = new Peixe();
				p.setIdPeixe(rs.getInt("idPeixe"));
				p.setNome(rs.getString("nomepeixe"));
				p.setPreco(rs.getInt("valorpeixe"));
				peixesDoJogo.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
