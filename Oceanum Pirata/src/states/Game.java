package states;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import database.Textures;
import entities.Player;
import items.GroundItem;
import items.Item;
import items.data.TestItem;
import items.data.TestItem2;
import main.Screen;
import tiles.Chunk;
import utils.ChunkGenerator;
import utils.SimplexNoise;

public class Game extends GameState {
	
	

	public Game(String name) {
		super(name, StateType.Game);
		
	}
	
	public Player p;
	public Chunk c = new Chunk(0, 0, null);
	public Chunk ActiveChunk = null;
	TestItem t1;
	TestItem2 t2;

	@Override
	public void Start() {
		//TODO character drawing uncollidable top member
		Random rand = new Random(1234);
		SimplexNoise noise = new SimplexNoise(rand, 0.3f ,100, 100);
		noise.initialise();
		p = new Player(Textures.PLAYER, 1600, 1600, 32, 32, 8, 2.5f);
		c.setTiles(ChunkGenerator.FromSimplexNoise(noise, c.getXid(), c.getYid()));
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
	
	public void SetActiveChunk(Chunk chunk){
		ActiveChunk = chunk;
	}

}
