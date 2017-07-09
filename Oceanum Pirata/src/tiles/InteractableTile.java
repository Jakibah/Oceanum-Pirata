package tiles;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.Rectangle;

import main.Main;
import main.Screen;

public abstract class InteractableTile extends Tile{
	
	private Rectangle collider;
	private float cx, cy, cwidth, cheight;

	public InteractableTile(TileType type, float x, float y, float width, float height, float cx, float cy, float cwidth, float cheight) {
		super(type, x, y, width, height);
		this.cx = cx;
		this.cy = cy;
		this.cwidth = cwidth;
		this.cheight = cheight;
		collider = new Rectangle((int)cx, (int)cy, (int)cwidth, (int)cheight);
	}

	
	public void Update(){
		super.Update();
		if(Screen.isColliding(collider, Main.GAME.p.getCollider())){
			if(Keyboard.isKeyDown(Keyboard.KEY_E)){
				interact();
			}
		}
	}
	public abstract void interact();
	
	public Rectangle getCollider(){
		return collider;
	}


	public float getCx() {
		return cx;
	}


	public void setCx(float cx) {
		this.cx = cx;
	}


	public float getCy() {
		return cy;
	}


	public void setCy(float cy) {
		this.cy = cy;
	}


	public float getCwidth() {
		return cwidth;
	}


	public void setCwidth(float cwidth) {
		this.cwidth = cwidth;
	}


	public float getCheight() {
		return cheight;
	}


	public void setCheight(float cheight) {
		this.cheight = cheight;
	}


	public void setCollider(Rectangle collider) {
		this.collider = collider;
	}


}

