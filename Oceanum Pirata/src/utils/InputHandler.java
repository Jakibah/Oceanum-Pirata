package utils;

import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.Rectangle;

import database.Sounds;
import database.Textures;
import entities.Entity;
import entities.EntityType;
import entities.Player;
import items.GroundItem;
import items.Item;
import items.data.TestItem;
import main.Main;
import main.Screen;
import states.Game;
import states.StateType;
import tiles.Chunk;
import tiles.Tile;
import tiles.data.ChestTile;

public class InputHandler {

	public static boolean Running = false;
	public static boolean looplock = false;
	public static int MouseX, MouseY, GUIMouseX, GUIMouseY;

	public static void Update(StateType type) {
		if (type == StateType.Menu) {
			MenuInput();
		} else if (type == StateType.Game) {
			GameInput();
		}

	}

	private static void GameInput() {
		Player p = Main.GAME.p;
		GUIMouseX = Mouse.getX();
		GUIMouseY = Display.getHeight() - Mouse.getY();
		MouseX = (int) (Mouse.getX() + Main.GAME.p.getX() - (Display.getWidth() / 2) + 16);
		MouseY = (int) (Display.getHeight() - Mouse.getY() + Main.GAME.p.getY() - (Display.getHeight() / 2) + 16);
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			Running = true;
		} else {
			Running = false;
		}
		if (Main.GAME.p.getType().equals(EntityType.Land)) {
			if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
				p.move(0, -p.getActualSpeed());

			}
			if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
				p.move(0, p.getActualSpeed());

			}
			if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
				p.move(-p.getActualSpeed(), 0);

			}
			if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
				p.move(p.getActualSpeed(), 0);

			}
		} else if (Main.GAME.p.getType().equals(EntityType.Sea)) {
			if (Mouse.isButtonDown(0)) {
				Main.GAME.p.setAngle(Screen.LookAt((int) Main.GAME.p.getX(), (int) Main.GAME.p.getY(), MouseX, MouseY));
				Main.GAME.p.sail = true;
				Main.GAME.p.setXtarget(MouseX);
				Main.GAME.p.setYtarget(MouseY);

			}
		}

		// TODO delete this check
		if (Keyboard.isKeyDown(Keyboard.KEY_B) && !looplock) {
			// System.out.println("B");
			// Chunk.setTileAt(new
			// ChestTile(Chunk.getTileAt(Main.GAME.ActiveChunk.getTiles(),
			// Main.GAME.p.getX() + 100, Main.GAME.p.getY()).getX(),
			// Chunk.getTileAt(Main.GAME.ActiveChunk.getTiles(),
			// Main.GAME.p.getX() + 100, Main.GAME.p.getY()).getY(), 32, 32),
			// Main.GAME.p.getX() + 100, Main.GAME.p.getY());
			// new GroundItem(new TestItem(), Main.GAME.p.getX(),
			// Main.GAME.p.getY());
			// long starttime = System.currentTimeMillis();
			// Random r = new Random(Main.GAME.seed);
			// SimplexNoise ns = new SimplexNoise(r, 0.3f, 6000, 6000, 0, 0);
			// ns.initialise();
			// System.out.println(System.currentTimeMillis() - starttime +
			// "ms");
			// System.exit(-1);
			// SoundPlayer.PlaySound(Sounds.TEST, 0, 0);
			
			if (Main.GAME.p.getType().equals(EntityType.Land)) {
				Main.GAME.p.setType(EntityType.Sea);
				Main.GAME.p.setX(Main.GAME.p.getX() + 50);
			} else {
				Main.GAME.p.setType(EntityType.Land);
				Main.GAME.p.setX(Main.GAME.p.getX() - 50);
			}
			// Main.GAME.p.a.Play();
			looplock = true;

		}
		if (!Keyboard.isKeyDown(Keyboard.KEY_B) && looplock) {
			looplock = false;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			// SoundPlayer.StopAll();
			// Main.GAME.p.a.Stop();
		}

	}

	public static boolean anyCollision(float x, float y, EntityType type) {
		Rectangle rect = new Rectangle();
		rect.setBounds((int)x,(int)y,32,32);
		for(Chunk c : Game.ActiveChunks) {
			for(int i = 0; i < c.getTiles().length; i++) {
				for(int j = 0; j < c.getTiles()[i].length; j++) {
					if(type.equals(EntityType.Land)) {
				if(c.getTiles()[i][j].getType().isSolid() || !c.getTiles()[i][j].getType().isWalkable()) {
				if(rect.intersects(c.getTiles()[i][j].getCollider())){	
				
					return true;
				}
				}
				}
			
					else if(type.equals(EntityType.Sea)) {
						if(c.getTiles()[i][j].getType().isSolid() ||c.getTiles()[i][j].getType().isWalkable()) {
							if(rect.intersects(c.getTiles()[i][j].getCollider())){	
								
								return true;
							}
						}
			}
		}
		}
		
	}
		return false;
	}

	private static void MenuInput() {
		MouseX = Mouse.getX();
		MouseY = Display.getHeight() - Mouse.getY();

	}

}
