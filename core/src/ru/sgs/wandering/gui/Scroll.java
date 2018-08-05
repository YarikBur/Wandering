package ru.sgs.wandering.gui;

import java.util.Map;

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
		for(int i=0; i<(14+Height)/8; i++)
			batch.draw(textureRegions.get("tiles0_2"), x, y+(i*7), textureRegions.get("tiles0_2").getRegionWidth()*2, textureRegions.get("tiles0_2").getRegionHeight()*2);
		batch.draw(textureRegions.get("tiles0_1"), x, y, textureRegions.get("tiles0_1").getRegionWidth()*2, textureRegions.get("tiles0_1").getRegionHeight()*2);
		batch.draw(textureRegions.get("tiles0_0"), x, y+Height, textureRegions.get("tiles0_0").getRegionWidth()*2, textureRegions.get("tiles0_0").getRegionHeight()*2);
		batch.draw(textureRegions.get("tiles0_3"), x, y+Height-16, textureRegions.get("tiles0_3").getRegionWidth()*2, textureRegions.get("tiles0_3").getRegionHeight()*2);
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
