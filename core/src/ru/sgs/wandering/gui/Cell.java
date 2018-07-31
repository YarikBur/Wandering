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
		tiles.createAtlas("gui/cell.png", 3, 3);
		textureRegions = tiles.getTextureRegion();
	}
	
	@Override
	public void render(SpriteBatch batch, float f, float g) {
		for(float y=g; y < Height/2 + g-2; y+=2)
			for(float x=f; x < Width/2 + f-2; x+=2) {
				if(x==f) {
					if(y==g)
						Scale.draw(batch, getTextureRegions("tiles2_0"), x, y, 1);
					else if(y==(Height/2 + g) - 3)
						Scale.draw(batch, getTextureRegions("tiles0_0"), x, y, 1);
					else
						Scale.draw(batch, getTextureRegions("tiles1_0"), x, y, 1);
				} else if(x==(Width/2 + f)-3) {
					if(y==g)
						Scale.draw(batch, getTextureRegions("tiles2_2"), x, y, 1);
					else if(y==(Height/2 + g) - 3)
						Scale.draw(batch, getTextureRegions("tiles0_2"), x, y, 1);
					else
						Scale.draw(batch, getTextureRegions("tiles1_2"), x, y, 1);
				} else {
					if(y==g)
						Scale.draw(batch, getTextureRegions("tiles2_1"), x, y, 1);
					else if(y==(Height/2 + g) - 3)
						Scale.draw(batch, getTextureRegions("tiles0_1"), x, y, 1);
					else
						Scale.draw(batch, getTextureRegions("tiles1_1"), x, y, 1);
				}
			}
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
