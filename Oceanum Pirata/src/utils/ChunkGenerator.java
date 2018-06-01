package utils;

import tiles.Tile;
import tiles.data.GrassTile;
import tiles.data.SandTile;
import tiles.data.WaterTile;

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
	
	public static Tile[][] FromSimplexNoise(float[][] noise ,int Xid, int Yid){
		Tile[][] tiles = new Tile[100][100];
		float noisemap[][] = noise;
		for(int x = 0; x < tiles.length; x++){
			for(int y = 0; y < tiles[x].length; y++){
				float actual = noisemap[x][y];
				//System.out.println(actual);
				if(actual > 0.9f){
					tiles[x][y] = new GrassTile(x * 32 + (Xid * 32 * 100), y * 32 + (Yid * 32 * 100), 32, 32);
					//break;
				}else if (actual > 0.8f && actual < 0.9f){
					tiles[x][y] = new SandTile(x * 32 + (Xid * 32 * 100), y * 32 + (Yid * 32 * 100), 32, 32);
					//break;
				}else{
					tiles[x][y] = new WaterTile(x * 32 + (Xid * 32 * 100), y * 32 + (Yid * 32 * 100), 32, 32);
				}
			}
		}
		return tiles;
		
	}

}
