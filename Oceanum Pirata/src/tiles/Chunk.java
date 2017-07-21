package tiles;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.Rectangle;

import database.Textures;
import items.GroundItem;
import items.Item;
import items.Sack;
import main.Main;
import main.Screen;

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
			System.out.println("Leaving northern border");
		}
		if(this.west.intersects(Main.GAME.p.getCollider())){
			System.out.println("Leaving western border");
		}
		if(this.south.intersects(Main.GAME.p.getCollider())){
			System.out.println("Leaving southern border");
		}
		if(this.east.intersects(Main.GAME.p.getCollider())){
			System.out.println("Leaving eastern border");
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
