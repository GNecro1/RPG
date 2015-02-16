package net.main;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.awt.Rectangle;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class Render {

	public static final int WIDTH = 832, HEIGHT = 640;

	public static float xOff = 0, yOff = 0;

	public static void Begin() {
		Display.setTitle("GAME");
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace(System.out);
		}
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	}

	public static void drawLine(float startX, float startY, float endX, float endY) {
		glBegin(GL_LINES);
		glVertex2f(startX, startY);
		glVertex2f(endX, endY);
		glEnd();
	}

	public static boolean fillRect(float x1, float y1, float width, float height) {
		float x = x1 + xOff;
		float y = y1 + yOff;
		glBegin(GL_QUADS);
		glVertex2f(x, y);
		glVertex2f(x + width, y);
		glVertex2f(x + width, y + height);
		glVertex2f(x, y + height);
		glEnd();
		return true;
	}

	public static boolean drawTexture(Texture t, float x1, float y1, float width, float height) {
		float x = x1 + xOff;
		float y = y1 + yOff;
		Rectangle r = new Rectangle(), r1 = new Rectangle();
		r1.setBounds((int) -xOff, (int) -yOff, (int) WIDTH, (int) HEIGHT);
		r.setBounds((int) x1, (int) y1, (int) width, (int) height);
		if (!r.intersects(r1)) {
			return false;
		}
		t.bind();
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glEnd();
		glLoadIdentity();
		return true;
	}
	// don't really know if this works.....
	public static float getCameraX() {
		return WIDTH - xOff;
	}

	public static float getCameraY() {
		return HEIGHT - yOff;
	}
}
