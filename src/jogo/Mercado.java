package jogo;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
		if (Cliente.getSambura().QuantidadePeixe() != 0) {
			for(int i = 0; i<Cliente.getSambura().QuantidadePeixe();i++) {
				Cliente.setDinheiro(Cliente.getDinheiro() + Cliente.getSambura().GetPeixe(i).getPreco());
			}
			for(int j = 0; j<Cliente.getSambura().QuantidadePeixe();j++) {
				Cliente.getSambura().RemoveAll(Cliente.getSambura().GetPeixe(j));
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
