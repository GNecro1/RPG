package net.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable {

	public Main() {
		setPreferredSize(new Dimension(800, 600));
	}

	public void render(Graphics2D g) {

	}

	public void tick(double delta) {

	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		Main m = new Main();
		jf.add(m);
		jf.pack();
		jf.requestFocus();
		jf.setTitle("RPG");
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(3);
		jf.setLocationRelativeTo(null);
		m.start();
	}

	private synchronized void start() {
		Thread t = new Thread(this);
		t.start();
	}

	public int FpsCounter = 0;
	public int FPS = 60;

	public void run() {
		long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
		long lastFpsTime = 0;

		while (true) {
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / ((double) OPTIMAL_TIME);

			lastFpsTime += updateLength;
			FpsCounter++;

			if (lastFpsTime >= 1000000000) {
				lastFpsTime = 0;
				FPS = FpsCounter;
				FpsCounter = 0;
			}

			tick(delta);
			draw();

			try {
				long sleepTime = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000;
				if (sleepTime < 0) {
					sleepTime = 0L;
				}
				Thread.sleep(sleepTime);
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
	}

	private void draw() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}
		Graphics g1 = bs.getDrawGraphics();
		Graphics2D g = (Graphics2D) g1;
		g.clearRect(0, 0, getWidth(), getHeight());
		render(g);
		g.setFont(new Font("Arial", 0, 16));
		g.setColor(Color.black);
		g.drawString("FPS : " + FPS, 8, 16);
		bs.show();
		g.dispose();
	}
}
