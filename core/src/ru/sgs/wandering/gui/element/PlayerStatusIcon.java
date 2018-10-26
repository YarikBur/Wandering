package ru.sgs.wandering.gui.element;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sgstudio.sgs02.utils.Tiles;

import ru.sgs.wandering.gui.render.Scale;

public class PlayerStatusIcon extends GUISuper {
	private float scale;
	
	public PlayerStatusIcon(String texture, float scale) {
		this.setTexture(texture);
		this.scale = scale;
		setResolution();
	}
	
	public void setResolution() {
		this.Width = getTextureRegions("tiles0_0").getRegionWidth()*scale;
		this.Height = getTextureRegions("tiles0_0").getRegionHeight()*scale;
	}
	
	@Override
	public void setTexture(String texture) {
		this.tiles = new Tiles();
		this.tiles.createAtlas("gui/" + texture, 1, 1);
		this.textureRegions = this.tiles.getTextureRegion();
	}
	
	@Override
	public void render(SpriteBatch batch, float x, float y) {
		Scale.draw2(batch, getTextureRegions("tiles0_0"), x*scale, y*scale, scale);
	}
}
