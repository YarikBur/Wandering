package ru.sgs.wandering.gui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Process extends GUISuper {
	public Process(String texture, float width, float height) {
		this.setTexture(texture);
		this.setResolution(width, height);
	}
	
	@Override
	public void render(SpriteBatch batch, float x, float y) {
		Render.render(batch, x, y, getWigth(), getHeight(), this.getTextureRegions(), 3, 4, 3, 3);
	}
}
