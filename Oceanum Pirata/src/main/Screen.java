package main;

import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import states.StateType;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;
import java.io.InputStream;

import javax.management.monitor.Monitor;

public class Screen {
	
	public static String TITLE;

	public static void CreateCanvas(int width, int height, String title, int fps) {
		TITLE = title;
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			// Display.setFullscreen(true);
			Display.setTitle(title);

			Display.create();

		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, width, height, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		Main.Start();
		while (!Display.isCloseRequested()) {
			Display.update();
			Display.sync(fps);
			Main.Update();
		}
		Main.Stop();
		Display.destroy();
		System.exit(0);
	}

	public static void CreateCanvas(String title, int fps) {
		
		try {
			Display.setFullscreen(true);
			Display.setTitle(title);

			Display.create();

		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getDesktopDisplayMode().getWidth(), Display.getDesktopDisplayMode().getHeight(), 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		Main.Start();
		while (!Display.isCloseRequested()) {
			Display.update();
			Display.sync(fps);
			Main.Update();
		}
		Main.Stop();
		Display.destroy();
		System.exit(0);
	}

	public static void DrawQuadGameTex(Texture tex, float x, float y, float width, float height) {
		tex.bind();
		if (Main.ActiveState.getType() == StateType.Game) {
			glTranslatef(x - Main.GAME.p.getX() + Display.getWidth() / 2 - 16,
					y - Main.GAME.p.getY() + Display.getHeight() / 2 - 16, 0);
		} else {
			glTranslatef(x, y, 0);

		}
		//glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glEnd();
		glLoadIdentity();

	}

	/*
	 * public static void DrawQuadTexRot(Texture tex, float x, float y, float
	 * width, float height, float angle){ tex.bind(); glTranslatef(x + width /
	 * 2, y + height / 2, 0); glRotatef(angle, 0, 0, 1); glTranslatef(- width /
	 * 2, - height / 2, 0); glBegin(GL_QUADS); glTexCoord2f(0, 0); glVertex2f(0,
	 * 0); glTexCoord2f(1, 0); glVertex2f(width, 0); glTexCoord2f(1, 1);
	 * glVertex2f(width, height); glTexCoord2f(0, 1); glVertex2f(0, height);
	 * glEnd(); glLoadIdentity(); }
	 */
	public static float LookAt(int myx, int myy, int x, int y) {

		double angleTemp = Math.atan2(y - myy, x - myx);
		return (float) Math.toDegrees(angleTemp) - 90;

	}

	public static Texture loadTexture(String path, String fileType) {
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			tex = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return tex;
	}

	public static Audio loadSound(String path, String fileType) {
		Audio sound = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			sound = AudioLoader.getAudio(fileType, in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sound;
	}

	public static Texture QuickLoad(String name) {
		System.out.println("Loading:" + "res/textures/" + name + ".png");
		Texture tex = null;
		tex = loadTexture("res/textures/" + name + ".png", "PNG");
		return tex;

	}

	public static Audio QuickLoadAudio(String name) {
		System.out.println("Loading:" + "res/sounds/" + name + ".wav");
		Audio sound = null;
		sound = loadSound("res/sounds/" + name + ".wav", "WAV");
		return sound;
	}

	public static boolean isColliding(Rectangle a, Rectangle b) {
		
		if (a.intersects(b)) {
			return true;
		}

		else {
			return false;
		}
	}
}
