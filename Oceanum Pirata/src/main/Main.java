package main;

import org.lwjgl.opengl.Display;

import database.Textures;
import states.Game;
import states.GameState;
import states.Menu;
import utils.InputHandler;

public class Main {

	public static final Game GAME = new Game("Game");
	public static final Menu MENU = new Menu("Menu");
	
	public static GameState ActiveState;
	static long starttime = 0;
	static long fpststart = 0;
	static double currenttime = 0;
	static int currentfps;
	static long fpst;
	
	public static void main(String[] args) {
		Screen.CreateCanvas(1080, 720, "Oceanum Pirata", 120);
		//Screen.CreateCanvas("Oceanum Pirata", 120);

	}
		
	public static void Start() {
		//TODO change hardcoded start state to menu
		currenttime = System.currentTimeMillis() / 1000;
		starttime = (long)currenttime;
		Textures.Init();
		ActiveState = MENU;
		ActiveState.Start();
	}

	public static void Update() {
		currenttime = System.currentTimeMillis() / 1000;
		fpststart = System.currentTimeMillis();
		InputHandler.Update(ActiveState.getType());
		ActiveState.Update();
		currentfps++;
		fpst = System.currentTimeMillis() - fpststart; 
		if(currenttime - starttime > 0){
			starttime = (long)currenttime;
			Display.setTitle(Screen.TITLE + "   " + currentfps + "fps" + ",  " + fpst + "ms/f");
			
			currentfps = 0;
		}
		
		
		
		
	}

	public static void Stop() {
		ActiveState.Stop();
		
	}

}
