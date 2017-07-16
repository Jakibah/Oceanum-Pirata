package items;

import org.newdawn.slick.opengl.Texture;

public abstract class Item {
	
	private float width,height;
	private int durability;
	private boolean durable;
	private ItemType type;
	private Rarity rarity;
	private Texture tex;

	public Item(Texture tex, float width, float height, int durability, boolean durable, ItemType type, Rarity rarity) {
		this.width = width;
		this.height = height;
		this.setDurable(durable);
		this.rarity = rarity;
		this.type = type;
		this.tex = tex;
		this.durability = durability;
	}
	
	public void Use(){
		if(durable == true){
			Damage();
		}
		
		
		
	}
	
	public void Destroy(){
		//TODO destroy function
	}
	
	public void Damage(){
		durability--;
		if(durability < 1){
			Destroy();
		}
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

	public boolean isDurable() {
		return durable;
	}

	public void setDurable(boolean durable) {
		this.durable = durable;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	public Texture getTex() {
		return tex;
	}

	public void setTex(Texture tex) {
		this.tex = tex;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

}
