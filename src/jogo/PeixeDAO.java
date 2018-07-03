package jogo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Conexão;

public class PeixeDAO {
private Connection conexao;

	public void logarPeixeDoJogo(ArrayList<Peixe> peixesDoJogo) {
		String sql = "SELECT * FROM Peixe order by idpeixe";
		try {
			conexao = Conexão.faz_conexão();
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();
			
			while(rs.next()) {
				Peixe p = new Peixe();
				p.setIdPeixe(rs.getInt("idPeixe"));
				p.setNome(rs.getString("nomepeixe"));
				p.setPreco(rs.getInt("valor"));
				peixesDoJogo.add(p);
			}
			conexao.close();
			comando.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void LogarPeixesNaPraia(ArrayList<Peixe> peixesDoJogo) {
		String sql = "SELECT * FROM peixedapraia;";
		try {
			conexao = Conexão.faz_conexão();
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();
			
			while(rs.next()) {
				Peixe p = new Peixe();
				p.setIdPeixe(rs.getInt("idPeixe"));
				p.setNome(rs.getString("nomepeixe"));
				p.setPreco(rs.getInt("valorpeixe"));
				peixesDoJogo.add(p);
			}
			conexao.close();
			comando.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
