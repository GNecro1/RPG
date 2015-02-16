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
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S) && down) {
			y += 2 * delta;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)&& left) {
			x -= 2 * delta;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)&& right) {
			x += 2 * delta;
		}
		resetMovment();
		//TODO: COLLISION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! NOT GOOOD
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				if (t[i][j].isSolid() && getBounds().intersects(t[i][j].getBounds())) {
					Rectangle2D col = t[i][j].getBounds().intersection(getBounds());
					double xx = t[i][j].getBounds().x - col.getX();
					double yy = t[i][j].getBounds().y - col.getY();
					if(yy > 2){
						y = preY;
						up = false;
					}
					else if(yy < 3){
						y = preY;
						down = false;
					}
					if(xx > 2){
						x = preX;
						left = false;
					}
					else if(xx < 3){
						x = preX;
						right = false;
					}
				}
			}
		}

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
