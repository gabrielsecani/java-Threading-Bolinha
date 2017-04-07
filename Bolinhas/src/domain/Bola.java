package domain;

import java.awt.Color;
import java.awt.Graphics;

public class Bola extends Thread {

	Tabuleiro tabuleiro;

	private int xpos, ypos, xinc, yinc;

	private final Color cor;

	private final static int largura = 10;
	private final static int altura = 10;
	private int sleeptime = -1;

	public Bola(Tabuleiro tabuleiro, int xpos, int ypos, int xinc, int yinc,
			Color col, int sleeptime) {

		super("Bola-cor:" + col);

		this.tabuleiro = tabuleiro;
		this.xpos = xpos;
		this.ypos = ypos;
		if (xinc == 0) xinc = 1;
		this.xinc = xinc;
		if (yinc == 0) yinc = -1;
		this.yinc = yinc;
		this.cor = col;
		if (sleeptime < 10) sleeptime = 10;
		this.sleeptime = sleeptime;

		tabuleiro.incluirBola(this);
	}

	public void run() {
		while (true)
			movimentar();
	}

	public void movimentar() {
		if (xpos >= tabuleiro.getWidth() - largura || xpos <= 0)
			xinc = -xinc;

		if (ypos >= tabuleiro.getHeight() - altura || ypos <= 0)
			yinc = -yinc;
		try {
			Thread.sleep(this.sleeptime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		reposicionar();
		tabuleiro.repaint();
	}

	public synchronized void reposicionar() {
		xpos += xinc;
		ypos += yinc;
	}

	public synchronized void desenhar(Graphics graphics) {
		graphics.setColor(cor);
		graphics.fillOval(xpos, ypos, largura, altura);
	}


}
