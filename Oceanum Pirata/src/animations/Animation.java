package animations;

import java.util.HashMap;
import java.util.List;

import org.newdawn.slick.opengl.Texture;

import utils.FileHandler;

public class Animation {
	
	
	private Texture Active;
	private boolean playing;
	private int framesize;
	private List<Texture> texes;
	private List<Integer> delay;
	
	
	
	public Animation(List<Texture> texes, List<Integer> delay){
		this.texes = texes;
		framesize = texes.size();
		this.delay = delay;
		Active = texes.get(0);
	
	}
	int actualframe = 0;
	int towait = 0;
	int iterator = 0;
	public void Update(){
		if(playing){
			towait = delay.get(iterator);
			Active = texes.get(iterator);
			actualframe++;
			if(actualframe > towait){
				iterator++;
				towait = 0;
				actualframe = 0;
			}
			if(iterator > framesize-1){
				iterator = 0;
				towait =0;
				actualframe = 0;
			}
			
		}
			
	}
	
	public void Play(){
		if(playing){
			return;
		}else{
			playing = true;
			return;
		}
	}
	
	public void Stop(){
		playing = false;
	}

	public Texture getActive() {
		return Active;
	}

	public boolean isPlaying() {
		return playing;
	}

}
