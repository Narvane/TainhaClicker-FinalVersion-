package jogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connection.Conexão;

public class PescadorDAO {
	
public boolean Acesso = false;
private Connection conexao;

	public void CadastrarPescador(Pescador p) {		
		String sql = "INSERT INTO items(idVara, idMolinete, idIsca) VALUES( 1, 1, 1);";
		String sql1 = "INSERT INTO balaio(precodeupgrade, espaco) VALUES(20, 5);";
		String sql2 = "INSERT INTO xpBar(xp1, xp2) VALUES (0, 100);";
		String sql3 ="INSERT INTO pescador(nomepescador, senha, dinheiro, idPraia, idItems, idBalaio, idXpbar, score) VALUES(? , md5(?) , 0, 1, last_insert_id(), last_insert_id(), last_insert_id(), 0);";
		try {
			conexao = Conexão.faz_conexão();
			PreparedStatement stmt = conexao.prepareStatement(sql);		
			stmt.executeUpdate();
			
			PreparedStatement stmt1 = conexao.prepareStatement(sql1);		
			stmt1.executeUpdate();
			
			PreparedStatement stmt2 = conexao.prepareStatement(sql2);	
			stmt2.executeUpdate();
			
			PreparedStatement stmt3 = conexao.prepareStatement(sql3);
			stmt3.setString(1, p.getNome());
			stmt3.setString(2, p.getSenha());		
			stmt3.executeUpdate();
	
			conexao.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void LogarPescador(Pescador p, Mercado mercado, Mundo mundo) {
		String sql = "SELECT *FROM Pescador join items on (Pescador.idItems = Items.idItems) join balaio on (balaio.idbalaio = pescador.idbalaio) join xpbar on (xpbar.idxpbar = pescador.idxpbar) WHERE nomePescador=? and senha=md5(?)";
		try {
			conexao = Conexão.faz_conexão();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getSenha());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				p.setId(rs.getInt("idPescador"));
				p.setNome(rs.getString("NomePescador"));
				p.setDinheiro(rs.getDouble("Dinheiro"));
				p.setScore(rs.getInt("Score"));
				p.getSambura().setIdSambura(rs.getInt("idBalaio"));
				p.getSambura().setEspaco(rs.getInt("espaco"));
				p.getSambura().setPreço(rs.getDouble("precodeupgrade"));
				p.getXpBar().setXp1(rs.getInt("xp1"));
				p.getXpBar().setXp2(rs.getInt("xp2"));
				p.setEquips(rs.getInt("idItems"));
				for (int i = 0; i < mercado.getVarasDoMercado().size(); i++) {
					if(mercado.getVarasDoMercado().get(i).getId() == rs.getInt("idVara")) {
						p.setVara(mercado.GetVaraDoMercado(i));
					}
				}
				for (int i = 0; i < mercado.getMolinetesDoMercado().size(); i++) {
					if(mercado.getMolinetesDoMercado().get(i).getId() == rs.getInt("idMolinete")) {
						p.setMolinete(mercado.GetMolineteDoMercado(i));
					}
				}
				for (int i = 0; i < mercado.getIscasDoMercado().size(); i++) {
					if(mercado.getIscasDoMercado().get(i).getId() == rs.getInt("idIsca")) {
						p.setIsca(mercado.GetIscaDoMercado(i));
					}
				}
				for (int i = 0; i < mundo.getPraiasDoJogo().size(); i++) {
					if(mundo.getPraiasDoJogo().get(i).getId() == rs.getInt("idPraia")) {
						p.setPraiaAtual(mundo.GetPraiasDoJogo(i));
					}
				}
				InserirPeixes(p, mundo.getPeixesDoJogo());
				Acesso = true;
		}
			stmt.close();
			conexao.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			Acesso = false;
		}
	}
	public void SalvarEquips(Pescador p) {
		String sql = "UPDATE items SET idvara=?, idmolinete=?, idisca=? WHERE idItems=?";
		try {
			conexao = Conexão.faz_conexão();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, p.getVara().getId());
			stmt.setInt(2, p.getMolinete().getId());
			stmt.setInt(3, p.getIsca().getId());
			stmt.setInt(4, p.getEquips());
			stmt.executeUpdate();
			
			stmt.close();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void InserirPeixes(Pescador p, ArrayList<Peixe> peixesDoMundo) {
		String sql = "SELECT * FROM peixesdobalaio WHERE idBalaio=?";
		try {
			conexao = Conexão.faz_conexão();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, p.getSambura().getIdSambura());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				for (int i = 0; i < peixesDoMundo.size(); i++) {
					if(peixesDoMundo.get(i).getIdPeixe() == rs.getInt("idPeixe")) {
						p.getSambura().AddPeixe(peixesDoMundo.get(i));
					}
				}
			}
			conexao.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void SalvarPeixes(Pescador p) {
		String sql = "DELETE FROM peixesdobalaio where idBalaio=?";
		String sql2 = "INSERT INTO peixesDoBalaio(idBalaio, idPeixe) VALUES (?, ?)";
			try {
				conexao = Conexão.faz_conexão();
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, p.getSambura().getIdSambura());
				stmt.executeUpdate();
				
				PreparedStatement stmt2 = conexao.prepareStatement(sql2);
			for (int i = 0; i < p.getSambura().QuantidadePeixe(); i++) {
				stmt2.setInt(1, p.getSambura().getIdSambura());
				stmt2.setInt(2, p.getSambura().GetPeixe(i).getIdPeixe());
				stmt2.executeUpdate();
			}
			stmt.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void SalvarPescador(Pescador p) {
		String sql = "UPDATE pescador \r\n" + 
				"join balaio on (balaio.idBalaio = pescador.idBalaio) \r\n" + 
				"join xpbar on (xpbar.idXpBar = pescador.idXpBar) \r\n" + 
				"SET dinheiro=?, idpraia=?, espaco=?, precodeupgrade=?, xp1 = ?, xp2=?, score=? WHERE idPescador=?;";
		try {
			conexao = Conexão.faz_conexão();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(8, p.getId());
			stmt.setDouble(1, p.getDinheiro());
			stmt.setInt(2, p.getPraiaAtual().getId());
			stmt.setInt(3, p.getSambura().getEspaco());
			stmt.setDouble(4, p.getSambura().getPreco());
			stmt.setInt(5, p.getXpBar().getXp1());
			stmt.setInt(6, p.getXpBar().getXp2());
			stmt.setInt(7, p.getScore());
			stmt.executeUpdate();
			
			stmt.close();
			conexao.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
