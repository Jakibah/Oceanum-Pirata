package gui;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.opengl.Texture;

import main.Screen;
import utils.InputHandler;

public class Button extends GUI{
	
	private Texture tex, hovertex, clickedtex, actualtex;
	private float x, y, width, height;
	private Runnable run;
	private Rectangle collider;
	
	private boolean hovering;
	
	public Button(Texture tex, Texture hovertex, Texture clickedtex, float x, float y, float width, float height,
			Runnable run) {
		super();
		this.tex = tex;
		this.hovertex = hovertex;
		this.clickedtex = clickedtex;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.run = run;
		actualtex = tex;
		collider = new Rectangle((int)x, (int)y, (int)width, (int)height);
	}
	
	public void Update(){
		//if(Mouse.getX() > this.x && Mouse.getX() < this.width + this.x){
		if(collider.intersects(new Rectangle(InputHandler.MouseX, InputHandler.MouseY, 1, 1))){
			hovering = true;
		}else{
			hovering = false;
		}
		if(hovering == false){
			actualtex = tex;
		}
		if(hovering == true){
			actualtex = hovertex;
			if(Mouse.isButtonDown(0)){
				actualtex = clickedtex;
				run.run();
			}
		}
		Screen.DrawQuadGameTex(actualtex, x, y, width, height, false);
	}
	
	
	
	
	

	public Texture getActualtex() {
		return actualtex;
	}

	public void setActualtex(Texture actualtex) {
		this.actualtex = actualtex;
	}

	public Texture getTex() {
		return tex;
	}

	public void setTex(Texture tex) {
		this.tex = tex;
	}

	public Texture getHovertex() {
		return hovertex;
	}

	public void setHovertex(Texture hovertex) {
		this.hovertex = hovertex;
	}

	public Texture getClickedtex() {
		return clickedtex;
	}

	public void setClickedtex(Texture clickedtex) {
		this.clickedtex = clickedtex;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Runnable getRun() {
		return run;
	}

	public void setRun(Runnable run) {
		this.run = run;
	}

	public boolean isHovering() {
		return hovering;
	}

	public void setHovering(boolean hovering) {
		this.hovering = hovering;
	}

}
