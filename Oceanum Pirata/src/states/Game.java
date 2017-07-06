package states;

import org.lwjgl.opengl.GL11;

import entities.Player;
import main.Screen;
import tiles.Chunk;
import utils.ChunkGenerator;

public class Game extends GameState {
	
	

	public Game(String name) {
		super(name, StateType.Game);
		
	}
	
	public Player p;
	public Chunk c = new Chunk(0, 0, null);
	public static Chunk ActiveChunk = null;

	@Override
	public void Start() {
		//TODO character drawing uncollidable top member
		p = new Player(Screen.QuickLoad("Player"), -300, 0, 32, 32, 1, 1.5f);
		c.setTiles(ChunkGenerator.Empty(c.getXid(), c.getYid()));
		ActiveChunk = c;
	}

	@Override
	public void Update() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		ActiveChunk.Update();
		p.Update();
		
	
	}

	@Override
	public void Stop() {
		System.out.println("Saving");

	}
	
	public static void SetActiveChunk(Chunk chunk){
		ActiveChunk = chunk;
	}

}
