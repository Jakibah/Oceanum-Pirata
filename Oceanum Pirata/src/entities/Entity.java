package entities;

import org.lwjgl.util.Point;

import main.Main;
import main.Screen;
import tiles.Chunk;
import tiles.Tile;
import utils.InputHandler;

public abstract class Entity {

	private float x, y, width, height;
	private int Direction = 2;
	private EntityType type;

	public Entity(EntityType type ,float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.setType(type);
		
	}

	public void move(float xa, float ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
}
		if(xa > Screen.RadiusX){
			xa = Screen.RadiusX;
		}
		if(xa < -Screen.RadiusX){
			xa = -Screen.RadiusX;
		}
		if(ya > Screen.RadiusY){
			ya = Screen.RadiusY;
		}
		if(ya < -Screen.RadiusY){
			ya = -Screen.RadiusY;
		}
		if (xa > 0)
			Direction = 1;
		if (xa < 0)
			Direction = 3;
		if (ya > 0)
			Direction = 2;
		if (ya < 0)
			Direction = 0;
		

		float oldx=x;
		float oldy=y;
		if(!InputHandler.anyCollision(x+xa, y+ya, this.getType())) {
			x += xa;
			y += ya;
		}
		if(InputHandler.anyCollision(x+xa, y+ya, this.getType())) {
				x =oldx;
				y =oldy;
			}
		
	}

	

	public void Update() {

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

	public int getDirection() {
		return Direction;
	}

	public void setDirection(int direction) {
		Direction = direction;
	}

	public EntityType getType() {
		return type;
	}

	public void setType(EntityType type) {
		this.type = type;
	}

}
