package ru.sgs.wandering.gui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Scale {
	public static void draw(SpriteBatch batch,TextureRegion texture, float x, float y, int scale) {
		batch.draw(texture, x, y, -x, -y, texture.getRegionWidth(), texture.getRegionHeight(), texture.getRegionWidth()*scale, texture.getRegionHeight()*scale, 0);
	}
}
