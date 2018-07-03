package jogo;

import java.util.ArrayList;

public class Balaio {
	private double precoDeAprimoramento;
	private ArrayList<Peixe> peixes;
	private int Espaco;
	private int idBalaio;
	public Balaio() {
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
	public int getIdBalaio() {
		return idBalaio;
	}
	public void setIdBalaio(int idBalaio) {
		this.idBalaio = idBalaio;
	}
	
}
