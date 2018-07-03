package jogo;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import views.ViewGame;

public class Mercado {
	private ArrayList<Vara> VarasDoMercado;
	private ArrayList<Molinete> MolinetesDoMercado;
	private ArrayList<Isca> IscasDoMercado;
	public Pescador Cliente;
	
	public Mercado() {
		VarasDoMercado = new ArrayList<>();
		MolinetesDoMercado = new ArrayList<>();
		IscasDoMercado = new ArrayList<>();
		
		VaraDAO varadao = new VaraDAO();
		MolineteDAO molinetedao = new MolineteDAO();
		IscaDAO iscadao = new IscaDAO();
		
		varadao.logarVarasDoJogo(VarasDoMercado);
		molinetedao.logarMolinetesDoJogo(MolinetesDoMercado);
		iscadao.logarIscasDoJogo(IscasDoMercado);
		
		VarasDoMercado.get(0).setMiniatura(new ImageIcon(ViewGame.class.getResource("/Imagens/VaraBambooMini.png")));
		VarasDoMercado.get(1).setMiniatura(new ImageIcon(ViewGame.class.getResource("/Imagens/VaraFerroMini.png")));
		//VarasDoMercado.get(2).setMiniatura(new ImageIcon(ViewGame.class.getResource("/Imagens/Angelmini.png")));
		//VarasDoMercado.get(3).setMiniatura(new ImageIcon(ViewGame.class.getResource("/Imagens/gladiusmini.png")));
		//VarasDoMercado.get(4).setMiniatura(new ImageIcon(ViewGame.class.getResource("/Imagens/Aquariusmini.png")));
		
		MolinetesDoMercado.get(0).setMiniatura(new ImageIcon(ViewGame.class.getResource("/Imagens/DaywaBG4500Mini.png")));
		//MolinetesDoMercado.get(1).setMiniatura(new ImageIcon(ViewGame.class.getResource("/Imagens/Crossfiremini2.png")));
		//MolinetesDoMercado.get(2).setMiniatura(new ImageIcon(ViewGame.class.getResource("/Imagens/shimanomini.png")));
		//MolinetesDoMercado.get(3).setMiniatura(new ImageIcon(ViewGame.class.getResource("/Imagens/maururedmini.png")));
		//MolinetesDoMercado.get(4).setMiniatura(new ImageIcon(ViewGame.class.getResource("/Imagens/canárioazulmini.png")));
		
		//IscasDoMercado.get(0).setMiniatura(new ImageIcon(ViewGame.class.getResource("/Imagens/pãomini.png")));
		//IscasDoMercado.get(1).setMiniatura(new ImageIcon(ViewGame.class.getResource("/Imagens/minhocamini.png")));
		//IscasDoMercado.get(2).setMiniatura(new ImageIcon(ViewGame.class.getResource("/Imagens/grilosmini.png")));
		//IscasDoMercado.get(3).setMiniatura(new ImageIcon(ViewGame.class.getResource("/Imagens/Peixinhosmini.gif")));
		//IscasDoMercado.get(4).setMiniatura(new ImageIcon(ViewGame.class.getResource("/Imagens/Camarãomini.png")));
	}
	//Metodos principais
	
	public void ComprarVara(Vara varaDaLoja) {
		if (Cliente.getDinheiro() >= varaDaLoja.getPreco()) {
		 Cliente.setVara(varaDaLoja);
		 Cliente.setDinheiro(Cliente.getDinheiro() - varaDaLoja.getPreco());
		}else {
			JOptionPane.showMessageDialog(null, "Dinheiro Insuficiente! Para comprar é necessário :"+ varaDaLoja.getPreco()+" R$");
		}
	}
	public void ComprarMolinete(Molinete molineteDaLoja) {
		if(Cliente.getDinheiro() >= molineteDaLoja.getPreco()) {
		Cliente.setMolinete(molineteDaLoja);
		Cliente.setDinheiro(Cliente.getDinheiro() - molineteDaLoja.getPreco());
		}else {
			JOptionPane.showMessageDialog(null, "Dinheiro Insuficiente! Para comprar é necessário :"+ molineteDaLoja.getPreco()+" R$");
		}
	}
	public void ComprarIsca(Isca iscaDaLoja) {
		if (Cliente.getDinheiro() >= iscaDaLoja.getPreco()) {
			Cliente.setIsca(iscaDaLoja);
			Cliente.setDinheiro(Cliente.getDinheiro() - iscaDaLoja.getPreco());
		}else {
			JOptionPane.showMessageDialog(null, "Dinheiro Insuficiente! Para comprar é necessário :"+ iscaDaLoja.getPreco()+" R$");
		}
	}
	public void Vender() {
		if (Cliente.getBalaio().QuantidadePeixe() != 0) {
			for(int i = 0; i<Cliente.getBalaio().QuantidadePeixe();i++) {
				Cliente.setDinheiro(Cliente.getDinheiro() + Cliente.getBalaio().GetPeixe(i).getPreco());
			}
			for(int j = 0; j<Cliente.getBalaio().QuantidadePeixe();j++) {
				Cliente.getBalaio().RemoveAll(Cliente.getBalaio().GetPeixe(j));
				}
		}else {
			JOptionPane.showMessageDialog(null, "Samburá vazio!");
		}
	}
	
	
	//Metodos auxiliares
	public Vara GetVaraDoMercado(int index) {
		return VarasDoMercado.get(index);
	}
	public Molinete GetMolineteDoMercado(int index) {
		return MolinetesDoMercado.get(index);
	}
	public Isca GetIscaDoMercado(int index) {
		return IscasDoMercado.get(index);
	}
	public void addVaraMercado(Vara v) {
		this.VarasDoMercado.add(v);
	}
	public ArrayList<Vara> getVarasDoMercado() {
		return VarasDoMercado;
	}
	public void setVarasDoMercado(ArrayList<Vara> varasDoMercado) {
		VarasDoMercado = varasDoMercado;
	}
	public ArrayList<Molinete> getMolinetesDoMercado() {
		return MolinetesDoMercado;
	}
	public void setMolinetesDoMercado(ArrayList<Molinete> molinetesDoMercado) {
		MolinetesDoMercado = molinetesDoMercado;
	}
	public ArrayList<Isca> getIscasDoMercado() {
		return IscasDoMercado;
	}
	public void setIscasDoMercado(ArrayList<Isca> iscasDoMercado) {
		IscasDoMercado = iscasDoMercado;
	}
}
