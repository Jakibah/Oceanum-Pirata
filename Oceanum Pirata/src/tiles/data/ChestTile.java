package tiles.data;

import tiles.InteractableTile;
import tiles.TileType;

public class ChestTile extends InteractableTile{

	
	//TODO make this take items
	public ChestTile(float x, float y, float width, float height) {
		super(TileType.Chest, x, y, width, height, x, y+32, width, 10);

	}

	@Override
	public void Update() {
		super.Update();
		
	}

	@Override
	public void interact() {
		//TODO delete next line
		System.out.println("Opened da chest and a nigger came out");
		
	}

}
