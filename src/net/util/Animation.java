package net.util;

import java.util.ArrayList;

import net.main.Main;
import net.main.Render;

import org.newdawn.slick.opengl.Texture;

public class Animation {

	private ArrayList<Texture> tex = new ArrayList<Texture>();

	private double change = 0;
	private long time = 0;
	private int index = 0;
	private int maxIndex = -1;
	
	public Animation(double changeInSeconds) {
		change = changeInSeconds * 1000000000;
		Main.animations.add(this);
	}

	public void addTexture(Texture t) {
		tex.add(t);
		maxIndex++;
	}

	public void render(float x, float y, float width, float height) {
		Render.drawTexture(tex.get(index), x, y, width, height);
	}

	public void tick(double delta) {
		time += System.currentTimeMillis();
		if (time > change) {
			time = 0;
			if (index == maxIndex) {
				index = 0;
			} else {
				index++;
			}
		}
	}
}
