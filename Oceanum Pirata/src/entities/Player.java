package entities;

import org.newdawn.slick.opengl.Texture;

import main.InputHandler;
import main.Screen;

public class Player extends Entity {
	private Texture tex;
	private float WalkSpeed; 
	private float RunSpeed;
	private float ActualSpeed;

	public Player(Texture tex, float x, float y, float width, float height, float WalkSpeed, float RunSpeed) {
		super(x, y, width, height);
		this.tex = tex;
		this.WalkSpeed = WalkSpeed;
		this.RunSpeed = RunSpeed;
		ActualSpeed = WalkSpeed;
		
		

	}
	
	@Override
	public void Update() {
		super.Update();
		Screen.DrawQuadGameTex(tex, this.getX(), this.getY(), this.getWidth(), this.getHeight());
		
		if(InputHandler.Running){
			
			ActualSpeed = RunSpeed;
			
		}else{
			ActualSpeed = WalkSpeed;
			
		}
		//System.out.println(this.getX() + ", " + this.getY());
		
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

	
}