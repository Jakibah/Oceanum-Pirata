package entities;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.Rectangle;
import org.newdawn.slick.opengl.Texture;

import animations.Animation;
import database.Textures;
import main.Screen;
import tiles.Chunk;
import utils.FileHandler;
import utils.InputHandler;

public class Player extends Entity {
	private Texture tex;
	private float WalkSpeed; 
	private float RunSpeed, SailSpeed;
	private float ActualSpeed;
	private Rectangle Collider;
	private float angle = 0;
	private float Xtarget, Ytarget;
	public boolean sail;
	

	public Animation a = null;
	public Player(Texture tex, float x, float y, float width, float height, float WalkSpeed, float RunSpeed, EntityType type, float SailSpeed) {
		super(type, x, y, width, height);
		this.tex = tex;
		this.WalkSpeed = WalkSpeed;
		this.RunSpeed = RunSpeed;
		ActualSpeed = WalkSpeed;
		this.SailSpeed = SailSpeed;
		Xtarget = x;
		Ytarget = y;
		sail = false;
		Collider = new Rectangle((int)x, (int)y, (int)width, (int)height);
		
		
		a = FileHandler.String2Animation(FileHandler.loadAnimation("Test"));
		a.Play();
		
		
		

	}
	
	@Override
	public void Update() {
		super.Update();
		if(this.getType().equals(EntityType.Land)){
		
		a.Update();
		
		Screen.DrawQuadGameTex(a.getActive(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), true);
		
		if(InputHandler.Running){
			
			ActualSpeed = RunSpeed;
			
		}else{
			ActualSpeed = WalkSpeed;
			
		}
		}else if(this.getType().equals(EntityType.Sea)){
			a.Update();
			Screen.DrawQuadGameTex(a.getActive(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), angle, true);
			ActualSpeed = SailSpeed;
			System.out.println(sail);
			if(sail){
				this.move((this.getXtarget() - this.getX())/(64*ActualSpeed),(this.getYtarget() - this.getY())/(64*ActualSpeed));
			}
				
			}
		
		Collider.setLocation((int)this.getX(), (int)this.getY());
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

	public float getSailSpeed() {
		return SailSpeed;
	}

	public void setSailSpeed(float sailSpeed) {
		SailSpeed = sailSpeed;
	}

	

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public float getXtarget() {
		return Xtarget;
	}

	public void setXtarget(float xtarget) {
		Xtarget = xtarget;
	}

	public float getYtarget() {
		return Ytarget;
	}

	public void setYtarget(float ytarget) {
		Ytarget = ytarget;
	}

	
}