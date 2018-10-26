package ru.sgs.wandering.gui.element;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgs.wandering.gui.render.Render;

public class Map extends GUISuper {
	public Map(String texture, float width, float height) {
		this.setTexture(texture);
		this.setResolution(width, height);
	}
	
	@Override
	public void render(SpriteBatch batch, float x, float y) {
		Render.render(batch, x, y, getWigth(), getHeight(), this.getTextureRegions(), 3, 4, 3, 3);
	}
}
