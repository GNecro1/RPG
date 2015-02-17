package net.main;

import static net.main.Render.Begin;

import java.util.ArrayList;

import net.util.Animation;
import net.world.World;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class Main {

	public World world;
	public static ArrayList<Animation> animations = new ArrayList<Animation>();

	public Main() {
		Begin();
		init();
		run();
	}

	public void init() {
		world = new World();
	}

	public void tick(double delta) {
		for(Animation a : animations){
			a.tick(delta);
		}
		world.tick(delta);
	}

	public void render() {
		world.draw();
	}

	public int FpsCounter = 0;
	public int FPS = 60;

	public void run() {
		long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
		long lastFpsTime = 0;
		double delta = 0;
		int tick = 0;
		while (!Display.isCloseRequested()) {
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			delta += updateLength / ((double) OPTIMAL_TIME);

			lastFpsTime += updateLength;
			FpsCounter++;

			if (lastFpsTime >= 1000000000) {
				lastFpsTime = 0;
				System.out.println("FPS : " + FpsCounter + " TICKS : " + tick);
				FPS = FpsCounter;
				FpsCounter = 0;
				tick = 0;
			}
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			if (delta > 1.0D) {
				tick(delta);
				delta -= 1.0D;
				tick++;
			}
			render();

			Display.update();
		}
		Display.destroy();
	}

	public static void main(String[] args) {
		new Main();
	}
}
