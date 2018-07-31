package ru.sgs.wandering.gui;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sgstudio.sgs02.utils.Settings;
import com.sgstudio.sgs02.utils.Tiles;
import com.sgstudio.sgs02.utils.Variables;

public class Inventory implements GUI{
	private static float Width;
	private static float Height;
	
	private static Tiles tiles;
	private static Cell cell;
	
	private static Map<String, TextureRegion> textureRegions;
	
	public Inventory() {
		cell = new Cell();
	}
	
	@Override
	public void setTexture() {
		tiles = new Tiles();
		tiles.createAtlas("gui/inventory.png", 3, 3);
		textureRegions = tiles.getTextureRegion();
	}
	
	@Override
	public Map<String, TextureRegion> getTextureRegions() {
		return textureRegions;
	}
	
	@Override
	public TextureRegion getTextureRegions(String key) {
		return textureRegions.get(key);
	}
	
	@Override
	public void render(SpriteBatch batch, float f, float g) {
		//Inventory
		for(float y=g; y < Height/2 + g; y+=2)
			X: for(float x=f; x < Width/2 + f; x+=2) {
				if(x==f) {
					if(y==g)
						Scale.draw(batch, getTextureRegions("tiles2_0"), x, y, 1);
					else if(y==(Height/2 + g) - 2)
						Scale.draw(batch, getTextureRegions("tiles0_0"), x, y, 1);
					else
						Scale.draw(batch, getTextureRegions("tiles1_0"), x, y, 1);
				} else if(x==(Width/2 + f)-2) {
					if(y==g)
						Scale.draw(batch, getTextureRegions("tiles2_2"), x, y, 1);
					else if(y==(Height/2 + g) - 2)
						Scale.draw(batch, getTextureRegions("tiles0_2"), x, y, 1);
					else
						Scale.draw(batch, getTextureRegions("tiles1_2"), x, y, 1);
				} else if(x>=f+3 && x<=((Width/2 + f)-15) && y >=g+3 && y<=((Height/2 + g) - 2)-3) {
					continue X;
				} else {
					if(y==g)
						Scale.draw(batch, getTextureRegions("tiles2_1"), x, y, 1);
					else if(y==(Height/2 + g) - 2)
						Scale.draw(batch, getTextureRegions("tiles0_1"), x, y, 1);
					else
						Scale.draw(batch, getTextureRegions("tiles1_1"), x, y, 1);
				}
			}
		
		//Cell
		for(float y=g+3; y < g + 3 + 78; y+=13)
			for(float x=f + 3; x < f + 3 + 52; x+=13) {
				cell.render(batch, x, y);
			}
	}
	
	@Override
	public void setResolution() {
		Width = (Variables.stringToInt(Settings.getProperty("width"))/100)*17.5f;
		Height = (Variables.stringToInt(Settings.getProperty("height"))/100)*28f;
	}
	
	@Override
	public float getWigth() {
		return Width;
	}
	
	@Override
	public float getHeight() {
		return Height;
	}
}
