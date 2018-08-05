package ru.sgs.wandering.gui;

import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sgstudio.sgs02.utils.Tiles;

public class Scroll implements GUI{
	private static Tiles tiles;
	private static Map<String, TextureRegion> textureRegions;
	
	private float Height;
	
	public Scroll() {
		setTexture();
	}
	
	public void setHeight(float height) {
		Height = height;
	}
	
	@Override
	public void setTexture() {
		tiles = new Tiles();
		tiles.createAtlas("gui/scroll.png", 1, 4);
		textureRegions = tiles.getTextureRegion();
	}

	@Override
	public void render(SpriteBatch batch, float x, float y) {
		batch.draw(textureRegions.get("tiles0_1"), x, y, textureRegions.get("tiles0_1").getRegionWidth()*2, textureRegions.get("tiles0_1").getRegionHeight()*2);
		
	}

	@Override
	public void setResolution() {

	}

	@Override
	public float getWigth() {
		return 7;
	}

	@Override
	public float getHeight() {
		return Height;
	}

	@Override
	public Map<String, TextureRegion> getTextureRegions() {
		return textureRegions;
	}

	@Override
	public TextureRegion getTextureRegions(String key) {
		return textureRegions.get(key);
	}

}
