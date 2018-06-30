package jogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PescadorDAO {
	
public boolean Acesso =true;
private Connection conexao;

	
	public PescadorDAO() throws SQLException {	
		String urlDoBanco = "jdbc:mysql://localhost:3306/TainhaClickerDB?useSSL=false";
		String usuarioDoBanco = "root";
		String senhaDoBanco = "root";
		this.conexao = DriverManager.getConnection(urlDoBanco, usuarioDoBanco, senhaDoBanco);
		System.out.println("Conexao: " + this.conexao);
	}
	public void LogarPescador(Pescador p, Mercado mercado, Mundo mundo) {
		String sql = "SELECT *FROM Pescador join items on (Pescador.idItems = Items.idItems) WHERE nomePescador=? and senha=md5(?)";
		try {
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, p.getNome());
		stmt.setString(2, p.getSenha());
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			p.setNome(rs.getString("NomePescador"));
			p.setDinheiro(rs.getDouble("Dinheiro"));
			p.setScore(rs.getInt("Score"));
			p.getSambura().setIdSambura(rs.getInt("idBalaio"));
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
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void SalvarEquips(Pescador p) {
		String sql = "UPDATE items SET idvara=?, idmolinete=?, idisca=? WHERE idItems=?";
		try {
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, p.getVara().getId());
		stmt.setInt(2, p.getMolinete().getId());
		stmt.setInt(3, p.getIsca().getId());
		stmt.setInt(4, p.getEquips());
		stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void InserirPeixes(Pescador p, ArrayList<Peixe> peixesDoMundo) {
		String sql = "SELECT * FROM peixesdobalaio WHERE idBalaio=?";
		try {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void SalvarPeixes(Pescador p) {
		String sql = "DELETE FROM peixesdobalaio where idBalaio=?";
		String sql2 = "INSERT INTO peixesDoBalaio(idBalaio, idPeixe) VALUES (?, ?)";
		try {
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, p.getSambura().getIdSambura());
		stmt.executeUpdate();
		
		PreparedStatement stmt2 = conexao.prepareStatement(sql2);
		for (int i = 0; i < p.getSambura().QuantidadePeixe(); i++) {
			stmt2.setInt(1, p.getSambura().getIdSambura());
			stmt2.setInt(2, p.getSambura().GetPeixe(i).getIdPeixe());
			stmt2.executeUpdate();
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void SalvarPescador() {
		
	}
}
