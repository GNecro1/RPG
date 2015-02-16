package net.world;

import org.newdawn.slick.opengl.Texture;

public enum TileType {
	
	Grass("img/grass.png", true), Mud("img/mud.png", false);
	
	String t;
	boolean buildable;
	
	TileType(String t, boolean buildable){
		this.t = t;
		this.buildable = buildable;
		
	}

}
