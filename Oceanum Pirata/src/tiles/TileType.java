package tiles;

import org.newdawn.slick.opengl.Texture;

import database.Textures;
import main.Screen;

public enum TileType {
	
	
	Grass(false, Textures.GRASS), Chest(true, Textures.CHEST), Water(false, Textures.WATER), Sand(false, Textures.SAND);
	
	private boolean solid;
	private Texture tex;
	
	TileType(boolean solid, Texture tex){
		this.setSolid(solid);
		this.setTex(tex);
		
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

}
