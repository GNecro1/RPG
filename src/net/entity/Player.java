package net.entity;

import net.main.Render;

import org.lwjgl.input.Keyboard;

public class Player {

	public float x, y, width = 32, height = 32;

	public Player() {
		x = Render.WIDTH / 2 - width / 2;
		y = Render.HEIGHT / 2 - height / 2;
	}

	public void tick(double delta) {
		float preX = x;
		float preY = y;
		
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			y -= 2 * delta;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			y += 2 * delta;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			x -= 2 * delta;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			x += 2 * delta;
		}
		
		Render.xOff = Render.WIDTH / 2 - x - width/2;
		Render.yOff = Render.HEIGHT / 2 - y - height/2;
	}

	public void render() {
		Render.fillRect(x, y, width, height);
	}

}
