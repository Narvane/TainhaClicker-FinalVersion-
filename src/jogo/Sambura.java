package jogo;

import java.util.ArrayList;

public class Sambura {
	private double precoDeAprimoramento;
	private ArrayList<Peixe> peixes;
	private int Espaco;
	private int idSambura;
	public Sambura() {
		peixes = new ArrayList<>();
		precoDeAprimoramento = 100;
		Espaco = 20;
	}
	public void AddPeixe(Peixe p) {
		if (peixes.size() < Espaco) {
			this.peixes.add(p);
		}
	}
	public Peixe GetPeixe(int index) {
		return peixes.get(index);
	}
	public int QuantidadePeixe() {
		return peixes.size();
	}
	public void RemoveAll(Peixe p) {
		this.peixes.removeAll(peixes);
	}
	public int getEspaco() {
		return Espaco;
	}
	public void setEspaco(int espaco) {
		Espaco = espaco;
	}
	public double getPreco() {
		return precoDeAprimoramento;
	}
	public void setPreço(double preco) {
		this.precoDeAprimoramento = preco;
	}
	public int getIdSambura() {
		return idSambura;
	}
	public void setIdSambura(int idSambura) {
		this.idSambura = idSambura;
	}
	
}
