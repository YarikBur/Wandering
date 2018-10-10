package ru.sgs.wandering.gui;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sgstudio.sgs02.utils.Settings;
import com.sgstudio.sgs02.utils.Tiles;
import com.sgstudio.sgs02.utils.Variables;

public class Profile implements GUI {
	private static float Width;
	private static float Height;
	private static Tiles tiles;
	private static Cell[] cell;
	private static Map<String, TextureRegion> textureRegions;
	private static float cellY;
	
	public Profile() {
		setTexture();
		setResolution();
		cell = new Cell[9];
		for(int i=0; i<cell.length; i++) {
			cell[i] = new Cell();
		}
		cell[0].setY(cell.length/4);
	}
	
	public static Cell[] getCell() {
		return cell;
	}

	public static void setCell(Cell[] cell) {
		Profile.cell = cell;
	}

	@Override
	public void setTexture() {
		tiles = new Tiles();
		tiles.createAtlas("gui/inventory.png", 6, 6);
		textureRegions = tiles.getTextureRegion();
	}

	@Override
	public void render(SpriteBatch batch, float f, float g) {
		//Cell
//		int i=0;
//		for(float y=g+3; y < g + 3 + (cell.length/4)*14; y+=14) {
//			cell[i].setH(g);
//			for(float x=f + 3; x < f + 3 + (cell.length/6)*14; x+=14) {
//					cell[i].render(batch, x, y-cellY-7);
//			}
//			i++;
//		}
		
		//Profile
		Render.render(batch, f, g, Width, Height, getTextureRegions());
	}

	@Override
	public void setResolution() {
		Width = (Variables.stringToInt(Settings.getProperty("width"))/100)*17.5f;
		Height = (Variables.stringToInt(Settings.getProperty("height"))/100)*38f;
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
