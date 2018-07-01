package jogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Conexão;

public class SamburaDAO {
private Connection conexao;


	public void logarPeixesNoBalaio(ArrayList<Peixe> peixesDoJogo,Pescador p) {
		String sql = "SELECT peixesdobalaio.idBalaio, peixesdobalaio.idPeixe FROM pescador join peixesdobalaio on (peixesdobalaio.idBalaio = pescador.idBalaio) where idPescador=?;\r\n" + 
				"\r\n" + 
				"";
		try {
			conexao = Conexão.faz_conexão();
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setInt(1, p.getId());
			ResultSet rs = comando.executeQuery();
			
			while(rs.next()) {
				for (int j = 0; j < peixesDoJogo.size(); j++) {
					if(peixesDoJogo.get(j).getIdPeixe() == rs.getInt("idPeixe")) {
						p.getSambura().AddPeixe(peixesDoJogo.get(j));
						System.out.println("========="+p.getSambura().GetPeixe(j));
					}
				}
			}
			conexao.close();
			comando.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
