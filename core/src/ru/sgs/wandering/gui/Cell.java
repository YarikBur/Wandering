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
	
	private String itemName;
	private int itemQuantity;
	private float h;
	private static float y;
	
	public void setH(float y) {
		this.h = y;
	}
	
	public float getH() {
		return h;
	}
	
	public void setY(float y) {
		Cell.y = y;
	}
	
	public float getY() {
		return y;
	}
	
	public void setItemName(String name) {
		this.itemName = name;
	}
	
	public String getItemName() {
		return this.itemName;
	}
	
	public void setItemQuantity(int quantity) {
		this.itemQuantity = quantity;
	}
	
	public int getItemQuantity() {
		return this.itemQuantity;
	}
	
	@Override
	public void setTexture() {
		tiles = new Tiles();
		tiles.createAtlas("gui/cell.png", 6, 6);
		textureRegions = tiles.getTextureRegion();
	}
	
	@Override
	public void render(SpriteBatch batch, float f, float g) {
		if((h+3 + y*14 - 7) < g+14) {
			Render.render(batch, f, g, Width, Height, getTextureRegions(), g+14-(h+3 + y*14 - 7), 0);
		} else if(h-g < 1)
			Render.render(batch, f, g, Width, Height, getTextureRegions());
		else if(h-g > 1) {
			Render.render(batch, f, g, Width, Height, getTextureRegions(), 0, h-g);
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
