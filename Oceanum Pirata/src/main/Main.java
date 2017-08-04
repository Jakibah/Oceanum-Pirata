package main;

import java.util.Random;

import org.lwjgl.opengl.Display;

import database.Fonts;
import database.Sounds;
import database.Textures;
import states.Game;
import states.GameState;
import states.Menu;
import utils.InputHandler;
import utils.SimplexNoise;
import utils.SoundPlayer;
import utils.TextDrawer;

public class Main {

	public static final Game GAME = new Game("Game");
	public static final Menu MENU = new Menu("Menu");
	
	//Init TextDrawers
	public static TextDrawer Cardinal;
	
	public static GameState ActiveState;
	static long startTtime = 0;
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
		startTtime = (long)currenttime;
		Textures.Init();
		Sounds.Init();
		Fonts.Init();
		Cardinal = new TextDrawer(Fonts.CARDINAL);
		ActiveState = GAME;
		ActiveState.Start();
	}

	public static void Update() {
		currenttime = System.currentTimeMillis() / 1000;
		fpststart = System.currentTimeMillis();
		InputHandler.Update(ActiveState.getType());
		//SoundPlayer.CheckforFinished();
		ActiveState.Update();
		currentfps++;
		fpst = (System.currentTimeMillis() - fpststart); 
		String fpststring = String.valueOf(fpst);
		if(currenttime - startTtime > 0){
			startTtime = (long)currenttime;
			Display.setTitle(Screen.TITLE + "   " + currentfps + "fps" + ",  " + fpststring + "ms/f");
			
			currentfps = 0;
		}
		
		
		
		
	}

	public static void Stop() {
		ActiveState.Stop();
		
	}

}
