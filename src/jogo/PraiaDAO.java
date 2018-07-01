package jogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Conexão;

public class PraiaDAO {
private Connection conexao;

	public void logarPraiasDoJogo(ArrayList<Praia> praiasDoJogo) {
		String sql = "SELECT * FROM Praia order by idpraia";
		try {
			conexao = Conexão.faz_conexão();
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();
			
			while(rs.next()) {
				Praia p = new Praia();
				p.setId(rs.getInt("idPraia"));
				p.setNome(rs.getString("nomePraia"));
				p.setXpmin(rs.getInt("xpnesc"));
				praiasDoJogo.add(p);
			}
			conexao.close();
			comando.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
