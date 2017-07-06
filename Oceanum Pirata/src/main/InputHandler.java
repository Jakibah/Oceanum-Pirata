package main;

import org.lwjgl.input.Keyboard;

import entities.Entity;
import entities.Player;
import states.StateType;

public class InputHandler {
	
	public static boolean Running = false;
	
	public static void Update(StateType type){
		if(type == StateType.Menu){
			MenuInput();
		}else if(type == StateType.Game){
			GameInput();
		}
		
	}

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
		
	}

	private static void MenuInput() {
		
		
	}

}
