package net.world;

import net.entity.Player;

public class World {

	private Player p;

	public static final int chunkCount = 16;

	public Chunk[][] c = new Chunk[chunkCount][chunkCount];

	public World() {
		p = new Player();
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				c[i][j] = new Chunk(i, j);
			}
		}
		int i = 1;
		int j = 1;
		index[0][0][0] = i - 1;
		index[0][0][1] = j - 1;

		index[1][0][0] = i;
		index[1][0][1] = j - 1;

		index[2][0][0] = i + 1;
		index[2][0][1] = j - 1;

		index[0][1][0] = i - 1;
		index[0][1][1] = j;

		index[0][2][0] = i - 1;
		index[0][2][1] = j + 1;

		index[1][1][0] = i;
		index[1][1][1] = j;

		index[2][1][0] = i + 1;
		index[2][1][1] = j;

		index[0][2][0] = i - 1;
		index[0][2][1] = j + 1;

		index[1][2][0] = i;
		index[1][2][1] = j + 1;

		index[2][2][0] = i + 1;
		index[2][2][1] = j + 1;
	}

	public void draw() {
		for (int i = 0; i < index.length; i++) {
			for (int j = 0; j < index[0].length; j++) {
				if (index[i][j][0] < 0 || index[i][j][0] > chunkCount - 1 || index[i][j][1] < 0 || index[i][j][1] > chunkCount - 1) {

				} else {
					c[index[i][j][0]][index[i][j][1]].draw();
				}
			}
		}
		p.draw();
	}

	private Integer[][][] index = new Integer[3][3][2];

	public void tick(double delta) {
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				if (p.getBounds().intersects(c[i][j].getBounds())) {
					index[0][0][0] = i - 1;
					index[0][0][1] = j - 1;

					index[1][0][0] = i;
					index[1][0][1] = j - 1;

					index[2][0][0] = i + 1;
					index[2][0][1] = j - 1;

					index[0][1][0] = i - 1;
					index[0][1][1] = j;

					index[0][2][0] = i - 1;
					index[0][2][1] = j + 1;

					index[1][1][0] = i;
					index[1][1][1] = j;

					index[2][1][0] = i + 1;
					index[2][1][1] = j;

					index[0][2][0] = i - 1;
					index[0][2][1] = j + 1;

					index[1][2][0] = i;
					index[1][2][1] = j + 1;

					index[2][2][0] = i + 1;
					index[2][2][1] = j + 1;
				}
			}
		}

		for (int i = 0; i < index.length; i++) {
			for (int j = 0; j < index[0].length; j++) {
				if (index[i][j][0] < 0 || index[i][j][0] > chunkCount - 1 || index[i][j][1] < 0 || index[i][j][1] > chunkCount - 1) {

				} else {
					c[index[i][j][0]][index[i][j][1]].tick(delta);
				}
			}
		}
		p.tick(delta, c[index[1][1][0]][index[1][1][1]].t);
	}

}
