package gui;

import main.Main;

public abstract class GUI {
	
	public GUI(){
		Main.MENU.AddGUI(this);
	}
	
	public abstract void Update();
	
	public void Destroy(){
		Main.MENU.RemoveGUI(this);
	}

}
