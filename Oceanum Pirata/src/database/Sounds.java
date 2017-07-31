package database;

import org.newdawn.slick.openal.Audio;

import main.Screen;

public class Sounds {
	
	public static void Init(){
		TEST = Screen.QuickLoadAudio("Test");
	}
	
	public static Audio TEST;

}
