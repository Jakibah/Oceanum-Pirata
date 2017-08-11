package states;

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import database.Textures;
import entities.EntityType;
import entities.Player;
import items.data.TestItem;
import items.data.TestItem2;
import main.Main;
import main.Screen;
import tiles.Chunk;
import utils.ChunkGenerator;
import utils.InputHandler;
import utils.NoiseGenerator;
import utils.SimplexNoise;

public class Game extends GameState {
	
	

	public Game(String name) {
		super(name, StateType.Game);
		
	}
	
	public Player p;
	public Chunk c = new Chunk(0, 0, null);
	//public Chunk ActiveChunk = null;
	public ArrayList<Chunk> ActiveChunks = new ArrayList<Chunk>();
	public ArrayList<Chunk> ActiveChunksToAdd = new ArrayList<Chunk>();
	public ArrayList<Chunk> ActiveChunksToRemove = new ArrayList<Chunk>();
	public int seed = 21;
	int angle = 0;
	TestItem t1;
	TestItem2 t2;

	@Override
	public void Start() {
		//TODO character drawing uncollidable top member
		Random rand = new Random(seed);
		new SimplexNoise(seed);
		
		float[][] noise = NoiseGenerator.generateOctavedSimplexNoise(0, 0, 100, 100, 8, 0.3f, 0.005f);
		p = new Player(Textures.PLAYER, 1600, 1600, 32, 32, 2, 2.5f, EntityType.Sea, 3);
		c.setTiles(ChunkGenerator.FromSimplexNoise(noise , c.getXid(), c.getYid()));
		ActiveChunks.add(c);
	}

	@Override
	public void Update() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		for(Chunk c : ActiveChunks){
			c.Update();
		}
		p.Update();
		
		ActiveChunks.removeAll(ActiveChunksToRemove);
		ActiveChunksToRemove.clear();
		ActiveChunks.addAll(ActiveChunksToAdd);
		ActiveChunksToAdd.clear();
		Main.Cardinal.Draw(10, 10, "U thiccboi");
		//System.out.println(ActiveChunks.size());
	}

	@Override
	public void Stop() {
		System.out.println("Saving");

	}
	
	//public void SetActiveChunk(Chunk chunk){
	//	ActiveChunk = chunk;
	//}

}
