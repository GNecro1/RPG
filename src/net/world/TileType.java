package net.world;

import org.newdawn.slick.opengl.Texture;

public enum TileType {
	
	Grass("img/grass.png", false), Mud("img/mud.png", true);
	
	String t;
	boolean solid;
	
	TileType(String t, boolean solid){
		this.t = t;
		this.solid = solid;
		
	}

}
