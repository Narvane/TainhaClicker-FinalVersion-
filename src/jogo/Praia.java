package jogo;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Praia {
	private Pescador pescador;
	private String nome;
	private int xpmin;
	private ArrayList<Peixe> Peixes;
	private ImageIcon Imagem;
	private ImageIcon Fundo;
	private int idPraia;
	private int id;
	private Peixe PeixeAleatorio;
	
	//construtor
	public Praia() {
		Peixes = new ArrayList<Peixe>();
		xpmin = 0;
		Imagem = null;
		Fundo = null;
	}
	//metodos
	public void enviarPeixe() {
		Random r = new Random();
		int RM = r.nextInt(10);
			int AUX = 0;
			
			switch (RM) {
			case 9|8|7:
				AUX =3;
				break;
			case 6|5|1:
				AUX =2;
				break;
			case 3|2|1|0:
				AUX=1;
				break;
			}
			PeixeAleatorio = Peixes.get(AUX);
	}
	
	public void AddPeixe(Peixe p) {
		this.Peixes.add(p);
	}
	public Peixe GetPeixe(int indexp) {
		return Peixes.get(indexp);
	}
	public int Quantidade() {
		return Peixes.size();
	}
	//getters and setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getXpmin() {
		return xpmin;
	}
	public void setXpmin(int xpmin) {
		this.xpmin = xpmin;
	}
	public ImageIcon getImagem() {
		return Imagem;
	}
	public void setImagem(ImageIcon url) {
		Imagem = url;
	}
	public ImageIcon getFundo() {
		return Fundo;
	}
	public void setFundo(ImageIcon fundo) {
		Fundo = fundo;
	}
	public int getIdPraia() {
		return idPraia;
	}
	public void setIdPraia(int idPraia) {
		this.idPraia = idPraia;
	}
	public int getId() {
		return id;
	}
	public void setId(int ID) {
		this.id = ID;
	}
	public Pescador getPescador() {
		return pescador;
	}
	public void setPescador(Pescador pescador) {
		this.pescador = pescador;
	}
	public Peixe getPeixeAleatorio() {
		enviarPeixe();
		return PeixeAleatorio;
	}
	
}
