package entities;

import org.lwjgl.util.Point;

import main.Main;
import main.Screen;
import tiles.Chunk;
import tiles.Tile;

public abstract class Entity {

	private float x, y, width, height;
	private int Direction = 2;
	private Point corner;
	private Point corner2;
	private EntityType type;

	public Entity(EntityType type ,float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.setType(type);
		corner = new Point((int) x, (int) y + 32);
		corner2 = new Point((int) x + 32, (int) y - 32);
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
		if (Direction == 0) {
			corner.setLocation((int) x, (int) y);
			corner2.setLocation((int) x + 32, (int) y);
		}
		if (Direction == 1) {
			corner.setLocation((int) x + 32, (int) y);
			corner2.setLocation((int) x + 32, (int) y + 32);
		}
		if (Direction == 2) {
			corner = new Point((int) x, (int) y + 32);
			corner2 = new Point((int) x + 32, (int) y + 32);
		}
		if (Direction == 3) {
			corner = new Point((int) x, (int) y);
			corner2 = new Point((int) x, (int) y + 32);
		}

		if (!Collision(xa, ya)) {
			x += xa;
			y += ya;

		} else {
			if (this instanceof Player) {
				Main.GAME.p.sail = false;

			}
		}
	}

	private boolean Collision(float xa, float ya) {
		boolean solid = false;
		
		Tile t = Chunk.getTileAt(corner.getX() + xa,
				corner.getY() + ya);
		Tile t2 = Chunk.getTileAt(corner2.getX() + xa,
				corner2.getY() + ya);
		
			if (this.getType().equals(EntityType.Land)) {
				if (t != null && t.getType().isSolid() || !t.getType().isWalkable()) {
					solid = true;
				}
				if (t2 != null && t2.getType().isSolid() || !t.getType().isWalkable()) {
					solid = true;
				}
			} else if (this.getType().equals(EntityType.Sea)) {
				if (t != null && t.getType().isSolid() || t.getType().isWalkable()) {
					solid = true;
				}
				if (t2 != null && t2.getType().isSolid() || t.getType().isWalkable()) {
					solid = true;
				}
			}else{
				if (t != null && t.getType().isSolid()) {
					solid = true;
				}
				if (t2 != null && t2.getType().isSolid()) {
					solid = true;
				}
			}
			return solid;
			
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
