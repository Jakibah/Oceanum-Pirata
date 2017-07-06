package tiles;

import org.lwjgl.util.Rectangle;

import main.Screen;

public abstract class Tile {
	
	private TileType type;
	private float x,y,width,height;
	private Rectangle collider;
	
	public Tile(TileType type, float x, float y, float width, float height){
		this.type = type;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collider = new Rectangle();
	}
	
	public void Update(){
		collider.setBounds((int) x, (int) y, (int) width, (int) height);
		Screen.DrawQuadGameTex(type.getTex(), x, y, width, height);
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

	public Rectangle getCollider() {
		return collider;
	}

	public void setCollider(Rectangle collider) {
		this.collider = collider;
	}
	
	

}
