package tiles.data;

import main.Main;
import tiles.Chunk;
import tiles.Tile;
import tiles.TileType;

public class SandTile extends Tile{

	public SandTile(float x, float y, float width, float height) {
		super(TileType.Sand, x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	private boolean first = true;
	private int sides = 0;
	@Override
	public void Update(){
		super.Update();
		
		if(first == true){
			first = false;
			if(Chunk.getTileAt(Main.GAME.ActiveChunk.getTiles(), this.getX(), this.getY() + 32) instanceof GrassTile &&
					Chunk.getTileAt(Main.GAME.ActiveChunk.getTiles(), this.getX(), this.getY() - 32) instanceof GrassTile){
				Chunk.setTileAt(new GrassTile(this.getX(),  this.getY(),  32 , 32), this.getX(), this.getY());
			}
			
			if(Chunk.getTileAt(Main.GAME.ActiveChunk.getTiles(), this.getX(), this.getY() + 32) instanceof WaterTile){
				sides++;
			} if (Chunk.getTileAt(Main.GAME.ActiveChunk.getTiles(), this.getX() + 32, this.getY()) instanceof WaterTile){
				sides++;
			}if(Chunk.getTileAt(Main.GAME.ActiveChunk.getTiles(), this.getX(), this.getY() - 32) instanceof WaterTile){
				sides++;
			}if(Chunk.getTileAt(Main.GAME.ActiveChunk.getTiles(), this.getX() - 32, this.getY()) instanceof WaterTile){
				sides++;
			}
			if(sides > 2){
				Chunk.setTileAt(new WaterTile(this.getX(),  this.getY(),  32 , 32), this.getX(), this.getY());
			}
		}
	}

}
