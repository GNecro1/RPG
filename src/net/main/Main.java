package net.main;

import static net.main.Render.BeginSesion;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class Main {

	public Main() {
		BeginSesion();
		Res.init();
		run();
	}
	
	public void tick(double delta){
		
	}
	
	public void render(){
		Render.drawTexture(Res.grass, 0, 0, 64, 64);
		Render.drawTexture(Res.mud, 64, 0, 64, 64);
	}
	
	public int FpsCounter = 0;
	public int FPS = 60;
	
	public void run() {
		long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
		long lastFpsTime = 0;
		while (!Display.isCloseRequested()) {
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / ((double) OPTIMAL_TIME);

			lastFpsTime += updateLength;
			FpsCounter++;

			if (lastFpsTime >= 1000000000) {
				lastFpsTime = 0;
				System.out.println("FPS : " + FpsCounter);
				FPS = FpsCounter;
				FpsCounter = 0;
			}
			tick(delta);
			render();
			Display.update();
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
		Display.destroy();
	}

	public static void main(String[] args) {
		Main m = new Main();
	}
}
