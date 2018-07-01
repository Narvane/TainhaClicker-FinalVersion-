package jogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Conexão;

public class MundoDAO {
private Connection conexao;

	public void logarPeixeDaPraia(ArrayList<Peixe> p , ArrayList<Praia> pr) {
		String sql = "SELECT * FROM peixeDaPraia";
		try {
			conexao = Conexão.faz_conexão();
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();
			
			while(rs.next()) {						
				for (int i = 0; i < pr.size(); i++) {
					if(pr.get(i).getId() == rs.getInt("idPraia")) {
						for (int j = 0; j < p.size(); j++) {
							if(p.get(j).getIdPeixe() == rs.getInt("idPeixe")) {
								pr.get(i).AddPeixe(p.get(j));
								System.out.println("Peixe: "+pr.get(i).getNome()+" na "+ p.get(j).getNome());
							}
						}
						
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
