package ru.sgs.wandering.gui;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface GUI {
	void setTexture();
	void render(SpriteBatch batch, float x, float y);
	void setResolution();
	float getWigth();
	float getHeight();
	Map<String, TextureRegion> getTextureRegions();
	TextureRegion getTextureRegions(String key);
}
