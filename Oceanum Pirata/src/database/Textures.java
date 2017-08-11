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
	WATER = Screen.QuickLoad("Water");
	SAND = Screen.QuickLoad("Sand");
	}
	
	public static Texture CHEST;
	public static Texture COMMON;
	public static Texture EPIC;
	public static Texture GRASS;
	public static Texture LEGENDARY;
	public static Texture PLAYER;
	public static Texture RARE;
	public static Texture WATER;
	public static Texture SAND;
	
	
	public static Texture getByName(String input) {
		Texture toreturn = null;
		
		switch(input.toLowerCase()){
		case "chest":
			toreturn = CHEST;
			break;
		case "common":
			toreturn = COMMON;
			break;
		case "epic":
			toreturn = EPIC;
			break;	
		case "grass":
			toreturn = GRASS;
			break;	
		case "legendary":
			toreturn = LEGENDARY;
			break;	
		case "player":
			toreturn = PLAYER;
			break;
		case "rare":
			toreturn = RARE;
			break;
		case "water":
			toreturn = WATER;
			break;
		case "sand":
			toreturn = SAND;
			break;
		}
		
		return toreturn;
	}
		
	

}
