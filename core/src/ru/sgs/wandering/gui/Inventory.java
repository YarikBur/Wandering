package ru.sgs.wandering.gui;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Inventory extends GUISuper {
	private static float cellY;
	private static Scroll scroll;
	
	public Inventory(String texture, float width, float height) {
		this.setTexture(texture);
		this.setResolution(width, height);
		this.setCells(24);
		
		scroll = new Scroll("scroll.png", 7, 20);
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
					cell[i].render(batch, x, y-cellY-7, true);
			}
			i++;
		}
		
		//Inventory
		Render.render(batch, f, g, Width, Height, getTextureRegions(), 3, 11, 3, 3);
		
		//Scroll
		scroll.setX(f*2+Width-18);
		scroll.render(batch, f*2+Width-18, g*2+4);
	}
}
