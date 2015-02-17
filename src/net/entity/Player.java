package net.entity;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import net.main.Render;
import net.world.Tile;

import org.lwjgl.input.Keyboard;

public class Player {

	public float x, y, width = 32, height = 32;
	private boolean up,down,left,right;

	public Player() {
		x = Render.WIDTH / 2 - width / 2;
		y = Render.HEIGHT / 2 - height / 2;
		resetMovment();
	}

	public void tick(double delta, Tile[][] t) {
		float preX = x;
		float preY = y;

		if (Keyboard.isKeyDown(Keyboard.KEY_W) && up) {
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
		if (Keyboard.isKeyDown(Keyboard.KEY_S) && down) {
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
		if (Keyboard.isKeyDown(Keyboard.KEY_A)&& left) {
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
		if (Keyboard.isKeyDown(Keyboard.KEY_D)&& right) {
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
		resetMovment();
		//TODO: COLLISION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! NOT GOOOD

		Render.xOff = Render.WIDTH / 2 - x - width / 2;
		Render.yOff = Render.HEIGHT / 2 - y - height / 2;
	}

	private void resetMovment() {
		up = true;
		down = true;
		left = true;
		right = true;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, (int) width, (int) height);
	}

	public void render() {
		Render.fillRect(x, y, width, height);
	}

}
