package jogo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Mundo{
	public Pescador Pescador;
	private ArrayList<Peixe> PeixesDoJogo;
	public ArrayList<Praia> PraiasDoJogo;

	public Mundo() {
		PeixesDoJogo = new ArrayList<Peixe>();
		PraiasDoJogo = new ArrayList<Praia>();
		Pescador = new Pescador();
		
		try {
			PraiaDAO praiadao = new PraiaDAO();
			PeixeDAO peixeDAO = new PeixeDAO();
			MundoDAO PP = new MundoDAO();
			
			
			praiadao.logarPraiasDoJogo(PraiasDoJogo);
			peixeDAO.logarPeixeDoJogo(PeixesDoJogo);
			PP.logarPeixeDaPraia(PeixesDoJogo, PraiasDoJogo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Peixe GetPeixesDoJogo(int index) {
		return PeixesDoJogo.get(index);
	}
	public Praia GetPraiasDoJogo(int index) {
		return PraiasDoJogo.get(index);
	}
	public ArrayList<Peixe> getPeixesDoJogo() {
		return PeixesDoJogo;
	}
	public void setPeixesDoJogo(ArrayList<Peixe> peixesDoJogo) {
		PeixesDoJogo = peixesDoJogo;
	}
	public ArrayList<Praia> getPraiasDoJogo() {
		return PraiasDoJogo;
	}
	public void setPraiasDoJogo(ArrayList<Praia> praiasDoJogo) {
		PraiasDoJogo = praiasDoJogo;
	}
}

