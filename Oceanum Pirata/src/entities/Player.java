package entities;

import org.lwjgl.util.Rectangle;
import org.newdawn.slick.opengl.Texture;

import animations.Animation;
import database.Textures;
import main.Screen;
import tiles.Chunk;
import utils.InputHandler;

public class Player extends Entity {
	private Texture tex;
	private float WalkSpeed; 
	private float RunSpeed;
	private float ActualSpeed;
	private Rectangle Collider;

	Animation a = null;
	public Player(Texture tex, float x, float y, float width, float height, float WalkSpeed, float RunSpeed) {
		super(x, y, width, height);
		this.tex = tex;
		this.WalkSpeed = WalkSpeed;
		this.RunSpeed = RunSpeed;
		ActualSpeed = WalkSpeed;
		Collider = new Rectangle((int)x, (int)y, (int)width, (int)height);
		Texture[] texes = new Texture[4];
		texes[0] = Textures.PLAYER;
		texes[1] = Textures.CHEST;
		texes[2] = Textures.WATER;
		texes[3] = Textures.SAND;
		
		a = new Animation(120, texes);
		
		

	}
	
	@Override
	public void Update() {
		super.Update();
		a.Play();
		a.Update();
		tex = a.getActive();
		Screen.DrawQuadGameTex(tex, this.getX(), this.getY(), this.getWidth(), this.getHeight());
		
		if(InputHandler.Running){
			
			ActualSpeed = RunSpeed;
			
		}else{
			ActualSpeed = WalkSpeed;
			
		}
		Collider.setLocation((int)this.getX(), (int)this.getY());
		System.out.println("Xid: " + Chunk.getChunkAt(this.getX(), this.getY()).getXid() + ", Yid: " + Chunk.getChunkAt(this.getX(), this.getY()).getYid());
	}
	
	

	public Texture getTex() {
		return tex;
	}

	public void setTex(Texture tex) {
		this.tex = tex;
	}

	public float getActualSpeed() {
		return ActualSpeed;
	}

	public void setActualSpeed(float actualSpeed) {
		ActualSpeed = actualSpeed;
	}

	public float getRunSpeed() {
		return RunSpeed;
	}

	public void setRunSpeed(float runSpeed) {
		RunSpeed = runSpeed;
	}

	public float getWalkSpeed() {
		return WalkSpeed;
	}

	public void setWalkSpeed(float walkSpeed) {
		WalkSpeed = walkSpeed;
	}

	public Rectangle getCollider() {
		return Collider;
	}

	public void setCollider(Rectangle collider) {
		Collider = collider;
	}

	
}