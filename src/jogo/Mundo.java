package jogo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import views.ViewGame;

public class Mundo{
	public Pescador Pescador;
	private ArrayList<Peixe> PeixesDoJogo;
	public ArrayList<Praia> PraiasDoJogo;

	public Mundo() {
		PeixesDoJogo = new ArrayList<Peixe>();
		PraiasDoJogo = new ArrayList<Praia>();
		Pescador = new Pescador();
		
		PraiaDAO praiadao = new PraiaDAO();
		PeixeDAO peixeDAO = new PeixeDAO();
		MundoDAO PP = new MundoDAO();
		
		
		praiadao.logarPraiasDoJogo(PraiasDoJogo);
		peixeDAO.logarPeixeDoJogo(PeixesDoJogo);
		PP.logarPeixeDaPraia(PeixesDoJogo, PraiasDoJogo);
		
		
		PeixesDoJogo.get(0).setImagem(new ImageIcon(ViewGame.class.getResource("/Imagens/Baiacu.png")));
		PeixesDoJogo.get(1).setImagem(new ImageIcon(ViewGame.class.getResource("/Imagens/Bagre.png")));
		PeixesDoJogo.get(2).setImagem(new ImageIcon(ViewGame.class.getResource("/Imagens/Peixe Espada.png")));
		PeixesDoJogo.get(3).setImagem(new ImageIcon(ViewGame.class.getResource("/Imagens/Pargo.png")));
		PeixesDoJogo.get(4).setImagem(new ImageIcon(ViewGame.class.getResource("/Imagens/Corvina.png")));
		PeixesDoJogo.get(5).setImagem(new ImageIcon(ViewGame.class.getResource("/Imagens/Papa terra.gif")));
		PeixesDoJogo.get(6).setImagem(new ImageIcon(ViewGame.class.getResource("/Imagens/Robalo.gif")));
		PeixesDoJogo.get(7).setImagem(new ImageIcon(ViewGame.class.getResource("/Imagens/Garoupa.png")));
		PeixesDoJogo.get(8).setImagem(new ImageIcon(ViewGame.class.getResource("/Imagens/Anchova.png")));
		PeixesDoJogo.get(9).setImagem(new ImageIcon(ViewGame.class.getResource("/Imagens/Linguado.gif")));
		PeixesDoJogo.get(10).setImagem(new ImageIcon(ViewGame.class.getResource("/Imagens/PescadaAmarela.gif")));
		PeixesDoJogo.get(11).setImagem(new ImageIcon(ViewGame.class.getResource("/Imagens/Tainha.png")));
		
		
		PraiasDoJogo.get(0).setFundo(new ImageIcon(ViewGame.class.getResource("/Imagens/BeiraMarPraia.png")));
		PraiasDoJogo.get(1).setFundo(new ImageIcon(ViewGame.class.getResource("/Imagens/JoaquinaPraia.png")));
		PraiasDoJogo.get(2).setFundo(new ImageIcon(ViewGame.class.getResource("/Imagens/DanielaPraia.png")));
		PraiasDoJogo.get(3).setFundo(new ImageIcon(ViewGame.class.getResource("/Imagens/InglesesPraia.png")));
		PraiasDoJogo.get(4).setFundo(new ImageIcon(ViewGame.class.getResource("/Imagens/JurerePraia.png")));
		
		PraiasDoJogo.get(0).setImagem(new ImageIcon(ViewGame.class.getResource("/Imagens/BeiraMarPraia.png")));
		PraiasDoJogo.get(1).setImagem(new ImageIcon(ViewGame.class.getResource("/Imagens/JoaquinaPraia.png")));
		PraiasDoJogo.get(2).setImagem(new ImageIcon(ViewGame.class.getResource("/Imagens/DanielaPraia.png")));
		PraiasDoJogo.get(3).setImagem(new ImageIcon(ViewGame.class.getResource("/Imagens/InglesesPraia.png")));
		PraiasDoJogo.get(4).setImagem(new ImageIcon(ViewGame.class.getResource("/Imagens/JurerePraia.png")));
		
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

