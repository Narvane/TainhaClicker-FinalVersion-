package jogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class IscaDAO {
		private Connection conexao;

		
		public IscaDAO() throws SQLException {	
			String urlDoBanco = "jdbc:mysql://localhost:3306/TainhaClickerDB?useSSL=false";
			String usuarioDoBanco = "root";
			String senhaDoBanco = "root";
			this.conexao = DriverManager.getConnection(urlDoBanco, usuarioDoBanco, senhaDoBanco);
			System.out.println("Conexao: " + this.conexao);
		}
		public void logarIscasDoJogo(ArrayList<Isca> iscasDoJogo) {
			String sql = "SELECT * FROM Isca order by idisca";
			try {
				PreparedStatement comando = conexao.prepareStatement(sql);
				ResultSet rs = comando.executeQuery();
				
				while(rs.next()) {
					Isca i = new Isca();
					i.setId(rs.getInt("idIsca"));
					i.setNome(rs.getString("nomeIsca"));
					i.setTempoDeEspera(rs.getInt("TempoDeEspera"));
					i.setPreco(rs.getInt("precoIsca"));
					iscasDoJogo.add(i);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
