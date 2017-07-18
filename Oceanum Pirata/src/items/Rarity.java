package items;

import org.lwjgl.util.Color;
import org.newdawn.slick.opengl.Texture;

import database.Textures;
import main.Screen;

public enum Rarity {
	
	Common(new Color(255, 255, 255), Textures.COMMON, 0), Rare(new Color(58, 85, 255), Textures.RARE, 1), 
	Epic(new Color(148, 0, 202), Textures.EPIC, 2), Legendary(new Color(255, 162, 0), Textures.LEGENDARY, 3);
	
	private Color color;
	private Texture tex;
	private int priority;
	Rarity(Color color, Texture tex, int priority){
		this.setColor(color);
		this.tex = tex;
		this.priority = priority;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Texture getTex() {
		return tex;
	}
	public void setTex(Texture tex) {
		this.tex = tex;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}

}
