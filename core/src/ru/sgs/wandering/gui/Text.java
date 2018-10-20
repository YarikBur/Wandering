package ru.sgs.wandering.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Text {
	private BitmapFont font;
	private static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\\\/?-+=()*&.:;,{}\\\"´~`'<>";
	
	public void createFont(float textSize, int r, int g, int b, int a) {
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("fonts/PixelDigivolveCyrillic.ttf"));
		FreeTypeFontParameter par = new FreeTypeFontParameter();
		par.size = (int) textSize*2;
		par.borderColor = Color.BLACK;
		par.borderWidth = 1;
		par.characters = FONT_CHARACTERS;
		font = gen.generateFont(par);
		gen.dispose();
	}
	
	public void render(SpriteBatch batch, String str, int x, int y) {
		font.draw(batch, str, x*2, y*2);
	}
}
