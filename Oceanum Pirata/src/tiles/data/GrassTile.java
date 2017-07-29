package tiles.data;

import main.Main;
import tiles.Chunk;
import tiles.Tile;
import tiles.TileType;

public class GrassTile extends Tile {

	public GrassTile(float x, float y, float width, float height) {
		super(TileType.Grass, x, y, width, height);

	}
	private boolean first = true;
	private int sides = 0;
	@Override
	public void Update() {
		super.Update();

		if(first == true){
			first = false;
			if(Chunk.getTileAt(Main.GAME.ActiveChunk.getTiles(), this.getX(), this.getY() + 32) instanceof SandTile){
				sides++;
			} if (Chunk.getTileAt(Main.GAME.ActiveChunk.getTiles(), this.getX() + 32, this.getY()) instanceof SandTile){
				sides++;
			}if(Chunk.getTileAt(Main.GAME.ActiveChunk.getTiles(), this.getX(), this.getY() - 32) instanceof SandTile){
				sides++;
			}if(Chunk.getTileAt(Main.GAME.ActiveChunk.getTiles(), this.getX() - 32, this.getY()) instanceof SandTile){
				sides++;
			}
			if(sides > 3){
				Chunk.setTileAt(new SandTile(this.getX(),  this.getY(),  32 , 32), this.getX(), this.getY());
			}
		}
		
	}

}
