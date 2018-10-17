package ru.sgs.wandering.gui;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sgstudio.sgs02.utils.Tiles;

public class GUISuper implements GUI {
	
	protected float Width;
	protected float Height;
	protected Cell[] cell;
	protected Tiles tiles;
	protected Map<String, TextureRegion> textureRegions;
	
	public void setCells(int quantity) {
		cell = new Cell[quantity];
		for(int i=0; i<cell.length; i++) {
			cell[i] = new Cell("cell.png");
		}
	}
	
	@Override
	public void setTexture(String texture) {
		tiles = new Tiles();
		tiles.createAtlas("gui/" + texture, 6, 6);
		textureRegions = tiles.getTextureRegion();
	}

	@Override
	public void render(SpriteBatch batch, float x, float y) { }

	@Override
	public void render(SpriteBatch batch, float f, float g, boolean inventory) { }

	@Override
	public void setResolution(float width, float height) {
		Width = width;
		Height = height;
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
