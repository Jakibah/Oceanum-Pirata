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
	private float RunSpeed, SailSpeed;
	private float ActualSpeed;
	private Rectangle Collider;
	private PlayerType type;
	private float angle = 0;
	private float Xtarget, Ytarget;
	public boolean sail;

	Animation a = null;
	public Player(Texture tex, float x, float y, float width, float height, float WalkSpeed, float RunSpeed, PlayerType type, float SailSpeed) {
		super(x, y, width, height);
		this.tex = tex;
		this.WalkSpeed = WalkSpeed;
		this.RunSpeed = RunSpeed;
		ActualSpeed = WalkSpeed;
		this.type = type;
		this.SailSpeed = SailSpeed;
		Xtarget = x;
		Ytarget = y;
		sail = false;
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
		if(this.getType().equals(PlayerType.Player)){
		a.Play();
		a.Update();
		tex = a.getActive();
		Screen.DrawQuadGameTex(tex, this.getX(), this.getY(), this.getWidth(), this.getHeight(), true);
		
		if(InputHandler.Running){
			
			ActualSpeed = RunSpeed;
			
		}else{
			ActualSpeed = WalkSpeed;
			
		}
		}else if(this.getType().equals(PlayerType.Boat)){
			Screen.DrawQuadGameTex(tex, this.getX(), this.getY(), this.getWidth(), this.getHeight(), angle, true);
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

	public PlayerType getType() {
		return type;
	}

	public void setType(PlayerType type) {
		this.type = type;
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