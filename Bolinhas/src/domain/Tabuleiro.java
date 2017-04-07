package domain;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Tabuleiro extends JPanel {

	private static final long serialVersionUID = 1L;

	private int largura = 500;
	private int altura = 250;

	private final static Color BACKGROUND_COLOR = Color.WHITE;

	private ArrayList<Bola> listaBolas = new ArrayList<Bola>();

	public Tabuleiro() {
		criarTabuleiro();
	}

	public Tabuleiro(int larguraX, int alturaY) {
		largura = larguraX;
		altura = alturaY;
		criarTabuleiro();
	}

	public void criarTabuleiro() {
		setOpaque(true);
		setBackground(BACKGROUND_COLOR);
		setPreferredSize(new Dimension(largura, altura));
	}

	public void incluirBola(final Bola b) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				listaBolas.add(b);
				repaint();
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Bola bola : listaBolas)
			bola.desenhar(g);
	}
}
