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
	private static float cellY;
	private static Cell[] cell;
	
	private static Map<String, TextureRegion> textureRegions;
	
	public Inventory() {
		cell = new Cell[24];
		for(int i=0; i<cell.length; i++) {
			cell[i] = new Cell();
		}
		cell[0].setY(cell.length/4);
	}
	
	@Override
	public void setTexture() {
		tiles = new Tiles();
		tiles.createAtlas("gui/inventory.png", 6, 6);
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
		//Cell
		int i=0;
		for(float y=g+3; y < g + 3 + (cell.length/4)*14; y+=14) {
			cell[i].setH(g);
			for(float x=f + 3; x < f + 3 + (cell.length/6)*14; x+=14) {
					cell[i].render(batch, x, y-cellY);
			}
			i++;
		}
		
		//Inventory
		Render.render(batch, f, g, Width, Height, getTextureRegions(), 3, 11, 3, 3);
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

	public float getCellY() {
		return cellY;
	}

	public void setCellY(float cellY) {
		Inventory.cellY = cellY;
	}
}
