package jogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MundoDAO {
private Connection conexao;

	
	public MundoDAO() throws SQLException {	
		String urlDoBanco = "jdbc:mysql://localhost:3306/TainhaClickerDB?useSSL=false";
		String usuarioDoBanco = "root";
		String senhaDoBanco = "root";
		this.conexao = DriverManager.getConnection(urlDoBanco, usuarioDoBanco, senhaDoBanco);
		System.out.println("Conexao: " + this.conexao);
	}
	public void logarPeixeDaPraia(ArrayList<Peixe> p , ArrayList<Praia> pr) {
		String sql = "SELECT * FROM peixeDaPraia";
		try {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
