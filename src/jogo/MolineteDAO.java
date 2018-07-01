package jogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.Conexão;


public class MolineteDAO {
private Connection conexao;

	public void logarMolinetesDoJogo(ArrayList<Molinete> molinetesDoJogo) {
		String sql = "SELECT * FROM Molinete order by idmolinete";
		try {
			conexao = Conexão.faz_conexão();
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
			conexao.close();
			comando.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
