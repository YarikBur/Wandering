package ru.sgs.wandering.gui;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sgstudio.sgs02.utils.Tiles;

public class Profile implements GUI {
	private static float Width;
	private static float Height;
	private static Tiles tiles;
	private static Cell[] cell;
	private static Map<String, TextureRegion> textureRegions;
	
	public Profile() {
		setTexture();
		setResolution();
	}
	
	@Override
	public void setTexture() {
		tiles = new Tiles();
		tiles.createAtlas("gui/inventory.png", 6, 6);
		textureRegions = tiles.getTextureRegion();
	}

	@Override
	public void render(SpriteBatch batch, float x, float y) {
		
	}

	@Override
	public void setResolution() {
		
	}

	@Override
	public float getWigth() {
		return Width;
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
