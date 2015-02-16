package net.world;

import java.awt.Rectangle;

import net.main.Loader;
import net.main.Render;

import org.newdawn.slick.opengl.Texture;

public class Tile{

	private float x, y, width, height;
	private Texture t;
	private TileType type;

	public Tile(float x, float y, TileType type) {
		this.x = x;
		this.y = y;
		width = 64;
		height = 64;
		this.type = type;
		t= Loader.getTexture(type.t);
	}

	public void draw() {
		Render.drawTexture(t, x, y, width, height);
	}
	
	public void tick(double delta){
		
	}

	public double getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Texture getT() {
		return t;
	}

	public void setT(Texture t) {
		this.t = t;
	}

	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}
	
	public boolean isSolid(){
		return type.solid;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, (int) width, (int) height);
	}
}
