package items;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.Rectangle;

import javafx.scene.shape.Circle;
import main.Main;
import main.Screen;

public class GroundItem {
	
	private Item item;
	private float x, y;
	private float priority;
	private Rectangle collider;
	
	
	public GroundItem(Item item, float x, float y) {
		this.item = item;
		this.x = x;
		this.y = y;
		this.priority = Main.GAME.ActiveChunk.getHighestPriority() + 1;
		collider = new Rectangle((int) x- 32, (int) y - 32, (int)item.getWidth() * 3, (int)item.getHeight() * 32);
		Main.GAME.ActiveChunk.AddItem(this);
	}
	
	public void PickUp(){
		//TODO add to inventory
		Destroy();
	}
	
	public static void Merge(GroundItem i1, GroundItem i2){
			if(Screen.isColliding(i1.getCollider(), i2.getCollider()) && i1 != i2){
				Sack sack = new Sack(i1.getX(), i1.getY(), 32, 32);
				sack.items.add(i1.getItem());
				sack.items.add(i2.getItem());
				i1.Destroy();
				i2.Destroy();
				
		}
	}
	
	public void Update(){
		if(Keyboard.isKeyDown(Keyboard.KEY_E) && Screen.isColliding(collider, Main.GAME.p.getCollider())){
			PickUp();
		}
		Screen.DrawQuadGameTex(item.getTex(), x, y, item.getWidth(), item.getHeight());
		
	}
	
	public void Destroy(){
		Main.GAME.ActiveChunk.RemoveItem(this);
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
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


	public float getPriority() {
		return priority;
	}


	public void setPriority(float priority) {
		this.priority = priority;
	}

	public Rectangle getCollider() {
		return collider;
	}

	public void setCollider(Rectangle collider) {
		this.collider = collider;
	}

}
