package items.data;

import org.newdawn.slick.opengl.Texture;

import database.Textures;
import items.Item;
import items.ItemType;
import items.Rarity;
import main.Screen;

public class TestItem2 extends Item{

	public TestItem2() {
		super(Textures.PLAYER, 32, 32, 1, false, ItemType.Misc, Rarity.Rare);
	}
	
	

}



