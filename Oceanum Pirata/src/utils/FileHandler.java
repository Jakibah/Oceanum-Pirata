package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.newdawn.slick.opengl.Texture;

import animations.Animation;
import database.Textures;

public class FileHandler {

	public static Animation String2Animation(List<String> animation) {
		List<Texture> texes = new ArrayList<Texture>();
		List<Integer> delay = new ArrayList<Integer>();
		
		for(String s : animation){
			String[] actual = s.split(",");
			texes.add(Textures.getByName(actual[0]));
			delay.add(Integer.parseInt(actual[1]));
		}
		
		return new Animation(texes, delay);
	}
	
	

}
