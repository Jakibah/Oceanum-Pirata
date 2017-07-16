package items.data;

import org.newdawn.slick.opengl.Texture;

import items.Item;
import items.ItemType;
import items.Rarity;
import main.Screen;

public class TestItem extends Item{

	public TestItem() {
		super(Screen.QuickLoad("Player"), 32, 32, 1, false, ItemType.Misc, Rarity.Common);
		
	}

}
