package jogo;

public class XpBar {
	private int xp1;
	private int xp2;
	//construtor
	public XpBar() {
		this.xp1 = 0;
		this.xp2=100;
	}
	//metodos
	public void GanharXP(int xp) {
		xp1 = xp1 + xp;
		if (xp1 >= xp2) {
			xp2 = xp2*2;
			xp1 = 0;
		}
	}
	//getters and setters
	public int getXp1() {
		return xp1;
	}

	public void setXp1(int xp1) {
		this.xp1 = xp1;
	}

	public int getXp2() {
		return xp2;
	}

	public void setXp2(int xp2) {
		this.xp2 = xp2;
	}
}
