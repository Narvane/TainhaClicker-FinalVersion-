package jogo;

import javax.swing.ImageIcon;

public class Peixe {
	private String nome;
	private double preco;
	private ImageIcon Imagem;
	private int idPeixe;
	private int index;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public ImageIcon getImagem() {
		return Imagem;
	}
	public void setImagem(ImageIcon imagem) {
		Imagem = imagem;
	}
	public int getIdPeixe() {
		return idPeixe;
	}
	public void setIdPeixe(int idPeixe) {
		this.idPeixe = idPeixe;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
}
