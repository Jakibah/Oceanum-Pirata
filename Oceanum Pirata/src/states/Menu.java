package states;

import org.lwjgl.opengl.GL11;

import database.Textures;
import gui.Button;
import gui.GUI;
import main.Screen;

public class Menu extends GameState {

	public GUI[] guis = new GUI[50];
	public GUI[] guistoremove = new GUI[50];
	
	public Menu(String name) {
		super(name, StateType.Menu);
		
	}
	
	public Button b1;

	@Override
	public void Start() {
		b1 = new Button(Textures.PLAYER, Textures.GRASS, Textures.CHEST, 0, 0, 100, 100, new Runnable(){

			@Override
			public void run() {
				System.out.println("Clicked");
				b1.Destroy();
			}
			
		});

	}

	@Override
	public void Update() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		for(int i = 0; i < guis.length; i++){
			if(guis[i] != null){
			guis[i].Update();
		}
		}
		CheckForDuplicates();
	}

	private void CheckForDuplicates() {
		for(int i = 0; i < guistoremove.length; i++){
			if(guistoremove[i] != null){
				for(int j = 0; j < guis.length; j++){
					if(guis[j] != null){
						if(guis[j] == guistoremove[i]){
							guis[j] = null;
						}
					}
				}
			}
		}
		for(int i = 0; i < guistoremove.length; i++){
			guistoremove[i] = null;
		}
	}

	@Override
	public void Stop() {
		// TODO Auto-generated method stub

	}
	public void RemoveGUI(GUI g){
		for(int i = 0; i < guistoremove.length; i++){
			if(guistoremove[i] == null){
				guistoremove[i] = g;
				return;
			}
		}	
	}
	
	public void AddGUI(GUI g){
		for(int i = 0; i < guis.length; i++){
			if(guis[i] == null){
				guis[i] = g;
				return;
			}
		}
	}

}
