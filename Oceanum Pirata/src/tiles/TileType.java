package tiles;

import org.newdawn.slick.opengl.Texture;

import main.Screen;

public enum TileType {
	
	//TODO recode to solid for collision testing
	Grass(true, Screen.QuickLoad("Grass"));
	
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
