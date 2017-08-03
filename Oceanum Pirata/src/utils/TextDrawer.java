package utils;


	import java.awt.Font;
	import java.awt.FontFormatException;
	import java.io.IOException;
	import java.io.InputStream;

	import org.newdawn.slick.Color;
	import org.newdawn.slick.TrueTypeFont;
	import org.newdawn.slick.util.ResourceLoader;

	public class TextDrawer {
		private TrueTypeFont fontdrawer;
		private String font;
		private int size;

		public TextDrawer(String font, int size) {
			this.size = size;
			this.font = font;
			//System.out.println("INFO: Text renderer Loaded = true");
			try {
				InputStream inputStream = ResourceLoader
						.getResourceAsStream("res/fonts/" + font + ".ttf");
				System.out.println("Loading:" + "res/fonts/" + font + ".ttf");
				Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
				Font awtFont2 = awtFont.deriveFont(awtFont.getStyle(), size);
				this.fontdrawer = new TrueTypeFont(awtFont2, false);
			} catch (FontFormatException | IOException e) {
				e.printStackTrace();
			}
		}

		public TextDrawer(String font) {
			this.font = font;
			//System.out.println("INFO: Text renderer Loaded = true");
			System.out.println("Loading:" + "res/fonts/" + font + ".ttf");
			try {
				InputStream inputStream = ResourceLoader
						.getResourceAsStream("res/fonts/" + font + ".ttf");
				Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
				Font awtFont2 = awtFont.deriveFont(awtFont.getStyle(), 20);
				this.fontdrawer = new TrueTypeFont(awtFont2, false);
			} catch (FontFormatException | IOException e) {
				e.printStackTrace();
			}
		}

		public void Draw(int x, int y, String text) {
			fontdrawer.drawString(x, y, text);
		}


		public void Draw(int x, int y, String text, Color c) {
			fontdrawer.drawString(x, y, text, c);
		}

		public String getFont() {
			return font;
		}

		public void setFont(String font) {
			this.font = font;
		}

	}


