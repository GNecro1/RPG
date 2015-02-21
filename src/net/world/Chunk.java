package net.world;

import java.awt.Rectangle;

public class Chunk {
	//Number of tiles in one chunk
	public static final int num = 1;
	
	private int xOff, yOff;

	public Tile[][] t = new Tile[num][num];

	public Chunk(int x, int y) {
		xOff = x * 64 * num;
		yOff = y * 64 * num;
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j] = new Tile(i * 64 + xOff, j * 64 + yOff, TileType.Grass);
				/*if (i % 3 == 0 && j % 3 == 0) {
					t[i][j] = new Tile(i * 64 + xOff, j * 64 + yOff, TileType.Mud);
				}*/
			}
		}
		System.out.println("Chunk loaded at " + x + " : " + y);
	}

	public void tick(double delta) {
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j].tick(delta);
			}
		}
	}

	public void draw() {
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j].draw();
			}
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(xOff, yOff, xOff + num * 64, yOff + num * 64);
	}
}
