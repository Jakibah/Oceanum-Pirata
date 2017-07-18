package database;

import org.newdawn.slick.opengl.Texture;

import main.Screen;

public class Textures {
	
	public static void Init(){
	CHEST = Screen.QuickLoad("Chest");
	COMMON = Screen.QuickLoad("Common");
	EPIC = Screen.QuickLoad("Epic");
	GRASS = Screen.QuickLoad("Grass");
	LEGENDARY = Screen.QuickLoad("Legendary");
	PLAYER = Screen.QuickLoad("Player");
	RARE = Screen.QuickLoad("Rare");
	}
	
	public static Texture CHEST;
	public static Texture COMMON;
	public static Texture EPIC;
	public static Texture GRASS;
	public static Texture LEGENDARY;
	public static Texture PLAYER;
	public static Texture RARE;
		
	

}
