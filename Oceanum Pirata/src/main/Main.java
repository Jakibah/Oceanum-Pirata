package main;

import states.Game;
import states.GameState;
import utils.InputHandler;

public class Main {

	public static final Game GAME = new Game("Game");
	
	public static GameState ActiveState;
	
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
		InputHandler.Update(ActiveState.getType());
		ActiveState.Update();
		
		
	}

	public static void Stop() {
		ActiveState.Stop();
		
	}

}
