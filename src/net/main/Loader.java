package net.main;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Loader {
	public static Texture getTexture(String path) {
		String fileType = "PNG";
		Texture t = null;
		try {
			t = TextureLoader.getTexture(fileType, ResourceLoader.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return t;
	}
}
