package net.main;
import org.newdawn.slick.opengl.Texture;

import net.main.Loader;

public class Res {
	
	public static Texture grass,mud;
	
	public static void  init(){
		grass = Loader.getTexture("img/grass.png", "PNG");
		mud = Loader.getTexture("img/mud.png", "PNG");
	}

}
