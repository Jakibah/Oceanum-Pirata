package utils;

import org.lwjgl.input.Keyboard;

import entities.Entity;
import entities.Player;
import items.GroundItem;
import items.Item;
import items.data.TestItem;
import main.Main;
import states.StateType;
import tiles.Chunk;
import tiles.data.ChestTile;

public class InputHandler {
	
	public static boolean Running = false;
	public static boolean looplock = false;
	
	public static void Update(StateType type){
		if(type == StateType.Menu){
			MenuInput();
		}else if(type == StateType.Game){
			GameInput();
		}
		
	}
	//TODO add player.getTileInFront
	//TODO lootsacks
	private static void GameInput() {
		Player p = Main.GAME.p;
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			Running = true;
		}else{
			Running = false;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			p.move(0, -1 * p.getActualSpeed());
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			p.move(0, 1 * p.getActualSpeed());
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			p.move(-1 * p.getActualSpeed(), 0);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			p.move(p.getActualSpeed(), 0);
		}
		//TODO delete this check
		if(Keyboard.isKeyDown(Keyboard.KEY_B) && !looplock){
			System.out.println("B");
			//Chunk.setTileAt(new ChestTile(Chunk.getTileAt(Main.GAME.ActiveChunk.getTiles(), Main.GAME.p.getX() + 100, Main.GAME.p.getY()).getX(), Chunk.getTileAt(Main.GAME.ActiveChunk.getTiles(), Main.GAME.p.getX() + 100, Main.GAME.p.getY()).getY(), 32, 32), Main.GAME.p.getX() + 100, Main.GAME.p.getY());
			new GroundItem(new TestItem(), Main.GAME.p.getX(), Main.GAME.p.getY());
			looplock = true;
		}
		if(!Keyboard.isKeyDown(Keyboard.KEY_B) && looplock){
			looplock = false;
		}
	}

	private static void MenuInput() {
		
		
	}

}
