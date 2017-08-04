package tiles;

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.Rectangle;

import database.Textures;
import items.GroundItem;
import items.Item;
import items.Sack;
import main.Main;
import main.Screen;
import utils.ChunkGenerator;
import utils.NoiseGenerator;
import utils.SimplexNoise;

public class Chunk {

	private int Xid, Yid;
	private Tile[][] tiles;
	private Rectangle body = new Rectangle(), north = new Rectangle(), south = new Rectangle(), west = new Rectangle(), east = new Rectangle();
	
	
	public GroundItem[] items = new GroundItem[300];
	public Sack[] sacks = new Sack[300];

	public Chunk(int Xid, int Yid, Tile[][] tiles) {
		this.setXid(Xid);
		this.setYid(Yid);
		this.tiles = tiles;
	}

	public void Update() {
		if(!this.body.intersects(Main.GAME.p.getCollider())){
			
		}
		north.setBounds(Xid * 3200, Yid * 3200, 3200, (Display.getHeight() / 2));
		west.setBounds(Xid * 3200, Yid * 3200, Display.getWidth() / 2,3200);
		south.setBounds(Xid * 3200, (Yid * 3200) + 3200 - (Display.getHeight() / 2), 3200, Display.getHeight() / 2);
		east.setBounds((Xid * 3200) + 3200 - (Display.getWidth() / 2), Yid * 3200, Display.getWidth() / 2,3200);
		body.setBounds((Xid * 3200) - (Display.getWidth() / 2), (Yid * 3200) - (Display.getHeight() / 2), 3200 + (Display.getWidth()), 3200 + (Display.getHeight()));
		//Screen.DrawQuadGameTex(Textures.CHEST, body.getX(), body.getY(), body.getWidth(), body.getHeight());
		
		if(this.north.intersects(Main.GAME.p.getCollider())){
			if(Chunk.getChunkAt(this.getXid() * 3200, this.getYid() * 3200 - 10) == null){
				float[][] noise = NoiseGenerator.generateOctavedSimplexNoise(this.Xid * 100, (this.Yid * 100) - 100, 100, 100, 8, 0.3f, 0.005f);
			Main.GAME.ActiveChunksToAdd.add(new Chunk(this.getXid(), this.getYid() - 1, ChunkGenerator.FromSimplexNoise(noise,this.getXid(), this.getYid() - 1)));
			}
				}
		if(this.west.intersects(Main.GAME.p.getCollider())){
			if(Chunk.getChunkAt(this.getXid() * 3200 - 10, this.getYid() * 3200) == null){
				float[][] noise = NoiseGenerator.generateOctavedSimplexNoise((this.getXid() * 100 - 100), this.getYid() * 100,100, 100, 8, 0.3f, 0.005f);
				Main.GAME.ActiveChunksToAdd.add(new Chunk(this.getXid() - 1, this.getYid(), ChunkGenerator.FromSimplexNoise(noise, this.getXid()-1, this.getYid())));
				}
		}
		if(this.south.intersects(Main.GAME.p.getCollider())){
			if(Chunk.getChunkAt(this.getXid() * 3200, this.getYid() * 3200 + 3210) == null){
				float[][] noise = NoiseGenerator.generateOctavedSimplexNoise(this.getXid() * 100, (this.getYid() * 100) + 100, 100, 100, 8, 0.3f, 0.005f);
				Main.GAME.ActiveChunksToAdd.add(new Chunk(this.getXid(), this.getYid() + 1, ChunkGenerator.FromSimplexNoise(noise, this.getXid(), this.getYid() + 1)));
				}
		}
		if(this.east.intersects(Main.GAME.p.getCollider())){
			if(Chunk.getChunkAt(this.getXid() * 3200 + 3210, this.getYid() * 3200) == null){
				System.out.println("Run");
				float[][] noise = NoiseGenerator.generateOctavedSimplexNoise((this.getXid() * 100) + 100, this.getYid() * 100, 100, 100, 8, 0.3f, 0.005f);
				Main.GAME.ActiveChunksToAdd.add(new Chunk(this.getXid() + 1, this.getYid() , ChunkGenerator.FromSimplexNoise(noise,this.getXid() + 1, this.getYid())));
				}
		}
		if(!this.body.intersects(Main.GAME.p.getCollider())){
			Main.GAME.ActiveChunksToRemove.add(this);
		}
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				tiles[i][j].Update();
			}
		}
		UpdateItems();
	}
	
	public void AddItem(GroundItem g){
		for(int i = 0; i < items.length; i++){
			if(items[i] == null){
				items[i] = g;
				return;
			}
		}
	}
	
	public void AddSack(Sack s){
		for(int i = 0; i < sacks.length; i++){
			if(sacks[i] == null){
				sacks[i] = s;
				return;
			}
		}
	}
	
	public void RemoveItem(GroundItem g){
		for(int i = 0; i < items.length; i++){
			if(items[i] == g){
				items[i] = null;
				return;
			}
		}
	}
	public void RemoveSacks(Sack s){
		for(int i = 0; i < sacks.length; i++){
			if(sacks[i] == s){
				sacks[i] = null;
				return;
			}
		}
	}
	
	
	public void UpdateItems(){
		for(int i = 0; i < items.length; i++){
			if(items[i] != null){
			items[i].Update();
			}
			for(int j = 0; j < items.length; j++){
				if(items[i] != null && items[j] != null){
				GroundItem.Merge(items[i], items[j]);
			}
			}
		}
		
		for(int i = 0; i < sacks.length; i++){
			if(sacks[i] != null){
				sacks[i].Update();
			}
			for(int j = 0; j < sacks.length; j++){
				if(sacks[i] != null && sacks[j] != null){
					Sack.Merge(sacks[i], sacks[j]);
				}
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
		Tile tochange = Chunk.getTileAt(Chunk.getChunkAt(x, y).getTiles(), x, y);
		for (int i = 0; i < Chunk.getChunkAt(x, y).getTiles().length; i++) {
			for (int j = 0; j < Chunk.getChunkAt(x, y).getTiles()[i].length; j++) {
				if(Chunk.getChunkAt(x, y).getTiles()[i][j] == tochange){
					Chunk.getChunkAt(x, y).getTiles()[i][j] = null;
					Chunk.getChunkAt(x, y).getTiles()[i][j] = t;
					return;
				}
			}
		}
	}
	
	public static Chunk getChunkAt(float x, float y){
		Chunk ret = null;
		for(Chunk c : Main.GAME.ActiveChunks){
			
			if(c.getXid() * 3200 <= x && c.getXid() * 3200 + 3200 >= x){
				//System.out.println("Ok2");
				if(c.getYid() * 3200  <= y && c.getYid() * 3200 + 3200 >= y){
					
					ret = c;
				}
					
				
			}
			
		}
		if(ret == null){
			System.out.println("There is no chunk at: " + x + ", " + y);
		}
		return ret;
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

	public float getHighestPriority() {
		float p = 0;
		for(GroundItem i : items){
			if(i != null){
			if(i.getPriority() > p){
				p = i.getPriority();
			}
		}
		}
		return p;
	}

}
