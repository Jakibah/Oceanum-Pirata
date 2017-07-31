package utils;

import java.util.ArrayList;

import org.newdawn.slick.openal.Audio;

public class SoundPlayer {
	
	public static ArrayList<Audio> playing = new ArrayList<Audio>();
	
	public static void PlaySound(Audio a){
		a.playAsSoundEffect(1, 1, false);
		playing.add(a);
	}
	
	public static void PlayMusic(Audio a){
		a.playAsMusic(1, 1, true);
		playing.add(a);
	}
	
	public static void StopAll(){
		for(Audio a : playing){
			a.stop();
		}
		playing.clear();
	}

}
