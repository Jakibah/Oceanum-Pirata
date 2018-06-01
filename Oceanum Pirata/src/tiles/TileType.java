package tiles;

import org.newdawn.slick.opengl.Texture;

import database.Textures;
import main.Screen;

public enum TileType {
	
	
	Grass(false, Textures.GRASS, true), Chest(true, Textures.CHEST, false), Water(false, Textures.WATER, false), Sand(false, Textures.SAND, true);
	
	private boolean solid, walkable;
	private Texture tex;
	
	TileType(boolean solid, Texture tex, boolean walkable){
		this.setSolid(solid);
		this.setTex(tex);
		this.setWalkable(walkable);
		
	}

	public boolean isSolid() {
		return solid;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	public Texture getTex() {
		return tex;
	}

	public void setTex(Texture tex) {
		this.tex = tex;
	}

	public boolean isWalkable() {
		return walkable;
	}

	public void setWalkable(boolean walkable) {
		this.walkable = walkable;
	}

}
