package net.world;

import net.entity.Player;
import net.main.Render;

public class World {
	
	private Tile[][] t = new Tile[16][16];
	private Player p;
	
	public World(){
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j] = new Tile(i*64,j*64,TileType.Grass);
			}
		}
		t[0][0] = new Tile(0,0,TileType.Mud);
		p = new Player();
	}
	
	public void draw(){
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j].draw();
			}
		}
		p.render();
	}
	
	public void tick(double delta){
		p.tick(delta);
	}

}
