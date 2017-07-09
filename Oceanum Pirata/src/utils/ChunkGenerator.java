package utils;

import tiles.GrassTile;
import tiles.Tile;

public class ChunkGenerator {
	
	public static Tile[][] Empty(int Xid, int Yid){
		Tile[][] tiles = new Tile[100][100];
		
		for(int i = 0; i < 100; i ++){
			for(int j = 0; j < 100; j++){
				tiles[i][j] = new GrassTile(i * 32 + (Xid * 32 * 100), j * 32 + (Yid * 32 * 100), 32, 32);
			}
		}
		
		return tiles;
	}

}
