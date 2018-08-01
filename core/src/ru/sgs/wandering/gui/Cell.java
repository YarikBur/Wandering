package ru.sgs.wandering.gui;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sgstudio.sgs02.utils.Settings;
import com.sgstudio.sgs02.utils.Tiles;
import com.sgstudio.sgs02.utils.Variables;

public class Cell implements GUI{
	private static float Width;
	private static float Height;
	
	private static Tiles tiles;
	private static Map<String, TextureRegion> textureRegions;
	
	@Override
	public void setTexture() {
		tiles = new Tiles();
//		tiles.createAtlas("gui/cell.png", 3, 3);
		tiles.createAtlas("gui/cell.png", 6, 6);
		textureRegions = tiles.getTextureRegion();
	}
	
	@Override
	public void render(SpriteBatch batch, float f, float g) {
		Render.render(batch, f, g, Width, Height, getTextureRegions());
	}

	@Override
	public void setResolution() {
		Width = (Variables.stringToInt(Settings.getProperty("width"))/100)*3.75f;
		Height = (Variables.stringToInt(Settings.getProperty("height"))/100)*5f;
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
