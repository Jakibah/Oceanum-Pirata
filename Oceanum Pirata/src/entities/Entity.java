package entities;

import org.lwjgl.util.Rectangle;

import main.Main;
import main.Screen;
import states.Game;
import tiles.Chunk;
import tiles.Tile;

public abstract class Entity {
	
	private float x,y,width,height;
	private Rectangle collider;
	
	private int Direction = 2;
	
	public Entity(float x, float y, float width, float height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collider = new Rectangle();
	}
	
	public void move(float xa, float ya){
		if(xa !=0 && ya !=0){
			move(xa, 0);
			move(0, ya);
			return;
		}
		
		if(xa > 0) Direction = 1;
		if(xa < 0) Direction = 3;
		if(ya > 0) Direction = 2;
		if(ya < 0) Direction = 0;
		
		if(!Collision(xa,ya)){
			x += xa;
			y += ya;
		}
	}
	
	private boolean Collision(float xa, float ya) {
		boolean solid = false;
		if(Direction == 1){
			xa+=33;
		}
		if(Direction == 2){
			ya+=33;
		}
		Tile t = Chunk.getTileAt(Game.ActiveChunk.getTiles(), x+xa, y+ya);
			if(t!=null && t.getType().isSolid() && Screen.isColliding(this.getCollider(), t.getCollider())){
				solid = true;
			}
		return solid;
	}

	public void Update(){
		collider.setBounds((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight()); 
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

	public Rectangle getCollider() {
		return collider;
	}

	public void setCollider(Rectangle collider) {
		this.collider = collider;
	}
	

}
