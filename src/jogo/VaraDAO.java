package jogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.Conexão;

public class VaraDAO {
	private Connection conexao;

	public void logarVarasDoJogo(ArrayList<Vara> varasDoJogo) {
		String sql = "SELECT * FROM Vara order by idvara";
		try {
			conexao = Conexão.faz_conexão();
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
			conexao.close();
			comando.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
