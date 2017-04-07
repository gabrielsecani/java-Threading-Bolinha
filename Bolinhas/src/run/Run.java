package run;

import java.awt.Color;
import java.util.Random;

import javax.swing.*;

import domain.Bola;
import domain.Tabuleiro;

public class Run {

	private static int RUN_SLEEPTIME = 100;

	public static void main(String[] a) {

		int largura = 800, altura = 600;

		Thread.currentThread().setName("Run");
		final Tabuleiro tabuleiro = new Tabuleiro(largura, altura);
		final JFrame frame = new JFrame();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(tabuleiro);
				frame.pack();
				frame.setVisible(true);
			}
		});

		int posX, posY, xInc, yInc;
		Color cor;
		Random rnd = new Random();
		for (int i = 1; i < 500; i++) {
			rnd.setSeed(System.currentTimeMillis());
			posX = (int) rnd.nextInt(largura);
			posY = (int) rnd.nextInt(altura);
			rnd.setSeed(System.currentTimeMillis());
			xInc = (int) (rnd.nextInt(50));
			rnd.setSeed(System.currentTimeMillis());
			yInc = -xInc;
			cor = new Color(rnd.nextInt(256), rnd.nextInt(256), rnd
					.nextInt(256));
			rnd.setSeed(System.currentTimeMillis());
			new Bola(tabuleiro, posX, posY, xInc, yInc, cor, (int) (RUN_SLEEPTIME*rnd.nextDouble())).start();
		}
	}

}
