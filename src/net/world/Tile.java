package net.world;

import java.awt.Rectangle;

import org.newdawn.slick.opengl.Texture;

public class Tile extends Rectangle {

	public float x, y, width, height;
	public Texture t;

	public Tile(float x, float y, Texture t) {
		this.x = x;
		this.y = y;
		width = 64;
		height = 64;
		this.t = t;
	}
}
