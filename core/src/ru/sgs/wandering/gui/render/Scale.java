package ru.sgs.wandering.gui.render;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Scale {
	public static void draw(SpriteBatch batch, TextureRegion texture, float x, float y, float f) {
		batch.draw(texture, x, y, -x, -y, texture.getRegionWidth(), texture.getRegionHeight(), texture.getRegionWidth()*f, texture.getRegionHeight()*f, 0);
	}
	
	public static void draw2(SpriteBatch batch, TextureRegion texture, float x, float y, float f) {
		batch.draw(texture, x, y, texture.getRegionWidth()*f, texture.getRegionHeight()*f);
	}
}
