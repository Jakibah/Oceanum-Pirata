package items;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.opengl.Texture;

import main.Main;
import main.Screen;
import tiles.Chunk;

public class Sack {
	
	private float x,y,width,height;
	private Rectangle collider;
	public ArrayList<Item> items = new ArrayList<Item>();
	public int rarity = 0;

	public Sack(float x, float y, float width, float height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		collider = new Rectangle((int) x- 32, (int) y - 32, (int)this.getWidth() * 3, (int)this.getHeight() * 3);
		Chunk.getChunkAt(x, y).AddSack(this);
	}
	
	public int getRarest(){
		int r = 0;
		for(Item i : items){
			if(i.getRarity().getPriority() > r){
				r = i.getRarity().getPriority();
			}
		}
		return r;
	}
	
	public Texture getRarityTexture(){
		switch (rarity){
			case 0:
				return Rarity.Common.getTex();
			case 1:
				return Rarity.Rare.getTex();
			case 2:
				return Rarity.Epic.getTex();
			case 3:
				return Rarity.Legendary.getTex();	
			default :
				return Rarity.Common.getTex();
		}
	}
	
	public void Update(){
		rarity = getRarest();
		Screen.DrawQuadGameTex(getRarityTexture(), x, y, width, height);
		if(Keyboard.isKeyDown(Keyboard.KEY_E) && this.collider.intersects(Main.GAME.p.getCollider())){
			PickUp();
		}
		
		
	}
	
	private void PickUp() {
		System.out.println(items.size());
		
	}
	
	public static void Merge(Sack s1, Sack s2){
		if(Screen.isColliding(s1.getCollider(), s2.getCollider()) && s1 != s2){
			Sack sack = new Sack(s1.getX(), s1.getY(), 32, 32);
			sack.items.addAll(s1.items);
			sack.items.addAll(s2.items);
			s1.Destroy();
			s2.Destroy();
	}
}

	

	private void Destroy() {
		Chunk.getChunkAt(x, y).RemoveSacks(this);
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
