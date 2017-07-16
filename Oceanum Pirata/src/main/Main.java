package main;

import states.Game;
import states.GameState;
import utils.InputHandler;

public class Main {

	public static final Game GAME = new Game("Game");
	
	public static GameState ActiveState;
	static long starttime = 0;
	static long endtime = 0;
	
	public static void main(String[] args) {
		Screen.CreateCanvas(1080, 720, "Oceanum Pirata", 120);
		//Screen.CreateCanvas("Oceanum Pirata", 120);

	}
		
	public static void Start() {
		//TODO change hardcoded start state to menu
		ActiveState = GAME;
		ActiveState.Start();
	}

	public static void Update() {
		starttime = System.currentTimeMillis();
		InputHandler.Update(ActiveState.getType());
		ActiveState.Update();
		endtime = System.currentTimeMillis();
		System.out.println("Time per update: " + (endtime - starttime));
		
		
	}

	public static void Stop() {
		ActiveState.Stop();
		
	}

}
