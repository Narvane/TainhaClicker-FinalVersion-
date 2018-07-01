package jogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.Conexão;

public class IscaDAO {
		private Connection conexao;

		public void logarIscasDoJogo(ArrayList<Isca> iscasDoJogo) {
			
			String sql = "SELECT * FROM Isca order by idisca";
			try {
				conexao = Conexão.faz_conexão();
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
				conexao.close();
				comando.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
