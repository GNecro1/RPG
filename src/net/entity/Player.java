package net.entity;

import java.awt.Rectangle;

import net.main.Loader;
import net.main.Render;
import net.util.Animation;
import net.world.Tile;

import org.lwjgl.input.Keyboard;

public class Player {

	public float x, y, width = 32, height = 32;
	private int dir = 0;
	private Animation a;

	public Player() {
		x = Render.WIDTH / 2 - width / 2;
		y = Render.HEIGHT / 2 - height / 2;
		a = new Animation(10);
		a.addTexture(Loader.getTexture("img/grass.png"));
		a.addTexture(Loader.getTexture("img/mud.png"));
		a.addTexture(Loader.getTexture("img/grass.png"));
		a.addTexture(Loader.getTexture("img/mud.png"));
		a.addTexture(Loader.getTexture("img/grass.png"));
		a.addTexture(Loader.getTexture("img/mud.png"));
		a.addTexture(Loader.getTexture("img/grass.png"));
	}

	public void tick(double delta, Tile[][] t) {
		float preX = x;
		float preY = y;

		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			dir = 0;
			y += 2 * delta;
			for (int i = 0; i < t.length; i++) {
				for (int j = 0; j < t[0].length; j++) {
					if (t[i][j].isSolid() && getBounds().intersects(t[i][j].getBounds())) {
						y = preY;
						continue;
					}
				}
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			dir = 1;
			y -= 2 * delta;
			for (int i = 0; i < t.length; i++) {
				for (int j = 0; j < t[0].length; j++) {
					if (t[i][j].isSolid() && getBounds().intersects(t[i][j].getBounds())) {
						y = preY;
						continue;
					}
				}
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			dir = 2;
			x -= 2 * delta;
			for (int i = 0; i < t.length; i++) {
				for (int j = 0; j < t[0].length; j++) {
					if (t[i][j].isSolid() && getBounds().intersects(t[i][j].getBounds())) {
						x = preX;
						continue;
					}
				}
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			dir = 3;
			x += 2 * delta;
			for (int i = 0; i < t.length; i++) {
				for (int j = 0; j < t[0].length; j++) {
					if (t[i][j].isSolid() && getBounds().intersects(t[i][j].getBounds())) {
						x = preX;
						continue;
					}
				}
			}
		}
		Render.xOff = Render.WIDTH / 2 - x - width / 2;
		Render.yOff = Render.HEIGHT / 2 - y - height / 2;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, (int) width, (int) height);
	}

	public void render() {
		a.render(x, y, width, height);
	}
}
