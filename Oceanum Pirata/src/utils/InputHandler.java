package utils;

import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import database.Sounds;
import database.Textures;
import entities.Entity;
import entities.Player;
import items.GroundItem;
import items.Item;
import items.data.TestItem;
import main.Main;
import main.Screen;
import states.StateType;
import tiles.Chunk;
import tiles.data.ChestTile;

public class InputHandler {
	
	public static boolean Running = false;
	public static boolean looplock = false;
	public static int MouseX, MouseY, GUIMouseX, GUIMouseY;
	
	public static void Update(StateType type){
		if(type == StateType.Menu){
			MenuInput();
		}else if(type == StateType.Game){
			GameInput();
		}
		
	}
	//TODO add player.getTileInFront
	
	private static void GameInput() {
		Player p = Main.GAME.p;
		GUIMouseX = Mouse.getX();
		GUIMouseY = Display.getHeight() - Mouse.getY();
		MouseX = (int) (Mouse.getX() + Main.GAME.p.getX() - (Display.getWidth() / 2) + 16);
		MouseY = (int) (Display.getHeight() - Mouse.getY() + Main.GAME.p.getY() - (Display.getHeight() / 2) + 16); 
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
			//System.out.println("B");
			//Chunk.setTileAt(new ChestTile(Chunk.getTileAt(Main.GAME.ActiveChunk.getTiles(), Main.GAME.p.getX() + 100, Main.GAME.p.getY()).getX(), Chunk.getTileAt(Main.GAME.ActiveChunk.getTiles(), Main.GAME.p.getX() + 100, Main.GAME.p.getY()).getY(), 32, 32), Main.GAME.p.getX() + 100, Main.GAME.p.getY());
			//new GroundItem(new TestItem(), Main.GAME.p.getX(), Main.GAME.p.getY());
			//long starttime = System.currentTimeMillis();
			//Random r = new Random(Main.GAME.seed);
			//SimplexNoise ns = new SimplexNoise(r, 0.3f, 6000, 6000, 0, 0);
			//ns.initialise();
			//System.out.println(System.currentTimeMillis() - starttime + "ms");
			//System.exit(-1);
			SoundPlayer.PlaySound(Sounds.TEST, 0, 0);
			looplock = true;
			
		}
		if(!Keyboard.isKeyDown(Keyboard.KEY_B) && looplock){
			looplock = false;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			SoundPlayer.StopAll();
		}
			
			
			
		}
	

	private static void MenuInput() {
		MouseX = Mouse.getX();
		MouseY = Display.getHeight() - Mouse.getY();
		
	}

}
