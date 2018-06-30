package jogo;

import javax.swing.ImageIcon;

public abstract class Equipamentos {
	private String nome;
	private double preco;
	private ImageIcon miniatura;
	private ImageIcon Imagem;
	private int id;
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
	public ImageIcon getMiniatura() {
		return miniatura;
	}
	public void setMiniatura(ImageIcon miniatura) {
		this.miniatura = miniatura;
	}
	public ImageIcon getImagem() {
		return Imagem;
	}
	public void setImagem(ImageIcon imagem) {
		Imagem = imagem;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
}
