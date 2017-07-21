package tiles;

import main.Main;
import main.Screen;

public abstract class Tile {
	
	private TileType type;
	private float x,y,width,height;
	
	public Tile(TileType type, float x, float y, float width, float height){
		this.type = type;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public void Update(){
		
		if(x > (Main.GAME.p.getX() - Screen.RadiusX) - 32 && x < (Main.GAME.p.getX() + Screen.RadiusX) + 32){
			if(y > (Main.GAME.p.getY() - Screen.RadiusY) -32 && y < (Main.GAME.p.getY() + Screen.RadiusY) + 32){
		Screen.DrawQuadGameTex(type.getTex(), x, y, width, height);
		}
		}
	}

	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	
	

}
