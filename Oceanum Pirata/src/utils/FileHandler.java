package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
	
	public static List<String> loadAnimation(String filename){
		List<String> toreturn = null;
		File toread = new File("src/res/animations/" +filename+ ".anim");
		try {
			toreturn = Files.readAllLines(toread.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return toreturn;
		
	}
	
	

}
