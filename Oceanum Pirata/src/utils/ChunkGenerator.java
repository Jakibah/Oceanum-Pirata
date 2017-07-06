package utils;

import tiles.GrassTile;
import tiles.Tile;

public class ChunkGenerator {
	
	public static Tile[][] Empty(int Xid, int Yid){
		Tile[][] tiles = new Tile[2][10];
		
		for(int i = 0; i < 2; i ++){
			for(int j = 0; j < 10; j++){
				tiles[i][j] = new GrassTile(i * 32 + (Xid * 32 * 100), j * 32 + (Yid * 32 * 100), 32, 32);
			}
		}
		
		return tiles;
	}

}
