package jogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PraiaDAO {
private Connection conexao;

	
	public PraiaDAO() throws SQLException {	
		String urlDoBanco = "jdbc:mysql://localhost:3306/TainhaClickerDB?useSSL=false";
		String usuarioDoBanco = "root";
		String senhaDoBanco = "root";
		this.conexao = DriverManager.getConnection(urlDoBanco, usuarioDoBanco, senhaDoBanco);
		System.out.println("Conexao: " + this.conexao);
	}
	public void logarPraiasDoJogo(ArrayList<Praia> praiasDoJogo) {
		String sql = "SELECT * FROM Praia order by idpraia";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();
			
			while(rs.next()) {
				Praia p = new Praia();
				p.setId(rs.getInt("idPraia"));
				p.setNome(rs.getString("nomePraia"));
				p.setXpmin(rs.getInt("xpnesc"));
				praiasDoJogo.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
