package states;

import main.Main;

public abstract class GameState {
	
	private String name;
	private StateType type;
	
	public GameState(String name, StateType type){
		this.setName(name);
		this.setType(type);
		
	}
	
	public abstract void Start();
	public abstract void Update();
	public abstract void Stop();
	
	public static void ChangeState(GameState state){
		Main.ActiveState.Stop();
		Main.ActiveState = state;
		Main.ActiveState.Start();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public StateType getType() {
		return type;
	}

	public void setType(StateType type) {
		this.type = type;
	}
	
	
	

}
