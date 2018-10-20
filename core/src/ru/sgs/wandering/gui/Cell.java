package ru.sgs.wandering.gui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sgstudio.sgs02.utils.Settings;
import com.sgstudio.sgs02.utils.Variables;

import ru.sgs.wandering.gui.render.Render;

public class Cell extends GUISuper {
	private static float Width;
	private static float Height;
	
	private String itemName;
	private int itemQuantity;
	private float h;
	private static float y;
	
	public Cell(String texture) {
		this.setTexture(texture);
		Width = (Variables.stringToInt(Settings.getProperty("width"))/100)*3.75f;
		Height = (Variables.stringToInt(Settings.getProperty("height"))/100)*5f;
	}
	
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
	public void render(SpriteBatch batch, float x, float y) {
		Render.render(batch, x, y, Width, Height, getTextureRegions());
	}
	
	@Override
	public void render(SpriteBatch batch, float f, float g, boolean inventory) {
		if((h+3 + 6*14 - 7) < g+14) {
			Render.render(batch, f, g, Width, Height, getTextureRegions(), g+14-(h+3 + 6*14 - 7), 0);
		} else if(g > 0) {
			Render.render(batch, f, g, Width, Height, getTextureRegions(), 0, h-g);
		} else if(g < 0)
			Render.render(batch, f, g, Width, Height, getTextureRegions());
	}
}
