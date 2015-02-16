package net.entity;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import net.main.Render;
import net.world.Tile;

import org.lwjgl.input.Keyboard;

public class Player {

	public float x, y, width = 32, height = 32;

	public Player() {
		x = Render.WIDTH / 2 - width / 2;
		y = Render.HEIGHT / 2 - height / 2;
	}

	public void tick(double delta, Tile[][] t) {
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
		//TODO: COLLISION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! NOT GOOOD
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				if (t[i][j].isSolid() && getBounds().intersects(t[i][j].getBounds())) {
					Rectangle2D col = t[i][j].getBounds().intersection(getBounds());
					if(col.getHeight() > 1 || col.getHeight() < -1){
						y = preY;
					}
					if(col.getWidth() > 1 || col.getWidth() < -1){
						x = preX;
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
		Render.fillRect(x, y, width, height);
	}

}
