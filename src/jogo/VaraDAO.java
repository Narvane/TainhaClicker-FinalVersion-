package jogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VaraDAO {
	private Connection conexao;

	
	public VaraDAO() throws SQLException {	
		String urlDoBanco = "jdbc:mysql://localhost:3306/TainhaClickerDB?useSSL=false";
		String usuarioDoBanco = "root";
		String senhaDoBanco = "root";
		this.conexao = DriverManager.getConnection(urlDoBanco, usuarioDoBanco, senhaDoBanco);
		System.out.println("Conexao: " + this.conexao);
	}
	public void logarVarasDoJogo(ArrayList<Vara> varasDoJogo) {
		String sql = "SELECT * FROM Vara order by idvara";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();
			
			while(rs.next()) {
				Vara v = new Vara();
				v.setId(rs.getInt("idVara"));
				v.setNome(rs.getString("nomeVara"));
				v.setTempoDeArremesso(rs.getInt("TempoDeArremesso"));
				v.setPreco(rs.getInt("precovara"));
				varasDoJogo.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
