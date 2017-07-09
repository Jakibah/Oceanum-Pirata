package tiles;

import main.Main;

public class Chunk {

	private int Xid, Yid;
	private Tile[][] tiles;

	public Chunk(int Xid, int Yid, Tile[][] tiles) {
		this.setXid(Xid);
		this.setYid(Yid);
		this.tiles = tiles;
	}

	public void Update() {
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				tiles[i][j].Update();
			}
		}
	}

	public static Tile getTileAt(Tile[][] tileset, float x, float y) {
		Tile t = null;

		for (int i = 0; i < tileset.length; i++) {
			for (int j = 0; j < tileset[i].length; j++) {
				if (x >= tileset[i][j].getX() && x <= tileset[i][j].getX() + 32) {
					if (y >= tileset[i][j].getY() && y <= tileset[i][j].getY() + 32) {
						t = tileset[i][j];
						
					}
				}
			}
		}

		return t;
	}

	public static void setTileAt(Tile t, float x, float y) {
		Tile tochange = Chunk.getTileAt(Main.GAME.ActiveChunk.getTiles(), x, y);
		for (int i = 0; i < Main.GAME.ActiveChunk.getTiles().length; i++) {
			for (int j = 0; j < Main.GAME.ActiveChunk.getTiles()[i].length; j++) {
				if(Main.GAME.ActiveChunk.getTiles()[i][j] == tochange){
					Main.GAME.ActiveChunk.getTiles()[i][j] = null;
					Main.GAME.ActiveChunk.getTiles()[i][j] = t;
					return;
				}
			}
		}
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public int getXid() {
		return Xid;
	}

	public void setXid(int xid) {
		Xid = xid;
	}

	public int getYid() {
		return Yid;
	}

	public void setYid(int yid) {
		Yid = yid;
	}

}
