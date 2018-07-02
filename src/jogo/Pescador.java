package jogo;

import java.util.Random;
import javax.swing.JOptionPane;

public class Pescador {
	private String nome;
	private double Dinheiro;
	private Vara vara;
	private Molinete molinete;
	private Isca isca;
	private int Score;
	private Sambura sambura;
	private String Senha;
	private Praia praiaAtual;
	private XpBar XpBar;
	private  Peixe mao;
	private int Equips;
	private int id;

	
	//Construtor
	public Pescador() {
		this.sambura = new Sambura();
		this.XpBar = new XpBar();
		this.vara = new Vara();
		this.molinete = new Molinete();
		this.isca = new Isca();
		this.praiaAtual = new Praia();
		this.mao = null;
		this.praiaAtual.setPescador(this);
	}
	//Metodos
	public void puxar() {
		mao = praiaAtual.getPeixeAleatorio();
	}
	
	public void EscolherPraia(Praia praiaEscolhida) {
		if (XpBar.getXp2() >= praiaEscolhida.getXpmin()) {
			praiaAtual = praiaEscolhida;
			praiaEscolhida.setPescador(this);
		} else {
			JOptionPane.showMessageDialog(null, "Necessário no minimo "+ praiaEscolhida.getXpmin()+" de xp!");
		}
	}
	public void PegarPeixe() {
		sambura.AddPeixe(mao);
		if (sambura.getEspaco() != sambura.QuantidadePeixe()) {
			Score = Score + 1;
			this.XpBar.GanharXP(5);
		}
		mao = null;
	}
	public void JogarPeixeFora() {
		mao = null;
	}
	
	public void AprimorarSambura() {
		if (Dinheiro >= sambura.getPreco()) {
			this.Dinheiro = Dinheiro - sambura.getPreco();
			this.sambura.setEspaco(sambura.getEspaco()*2);
			this.sambura.setPreço(sambura.getPreco()*2);
		}else {
			JOptionPane.showMessageDialog(null, "Dinheiro Insuficiente! É necessário :"+ sambura.getPreco() +" R$");
		}
	}

	//Getters and setters
	
	public String getSenha() {
		return Senha;
	}
	public Sambura getSambura() {
		return sambura;
	}
	public void setSambura(Sambura sambura) {
		this.sambura = sambura;
	}
	public XpBar getXpBar() {
		return XpBar;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getDinheiro() {
		return Dinheiro;
	}
	public void setDinheiro(double dinheiro) {
		Dinheiro = dinheiro;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public Vara getVara() {
		return vara;
	}
	public void setVara(Vara vara) {
		this.vara = vara;
	}
	public Molinete getMolinete() {
		return molinete;
	}
	public void setMolinete(Molinete molinete) {
		this.molinete = molinete;
	}
	public Isca getIsca() {
		return isca;
	}
	public void setIsca(Isca isca) {
		this.isca = isca;
	}
	public Praia getPraiaAtual() {
		return praiaAtual;
	}
	public Peixe getMao() {
		return mao;
	}
	public void setMao(Peixe mao) {
		this.mao = mao;
	}
	public int getEquips() {
		return Equips;
	}
	public void setEquips(int equips) {
		Equips = equips;
	}
	public void setPraiaAtual(Praia praiaAtual) {
		this.praiaAtual = praiaAtual;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
