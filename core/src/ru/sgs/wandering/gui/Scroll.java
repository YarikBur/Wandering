package ru.sgs.wandering.gui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Scroll extends GUISuper implements SCROLLS{
	private float xScroll;
	private float yScroll;
	private float minYScroll;
	private float maxYScroll;
	
	private boolean create=false;
	
	public Scroll(String texture, float width, float height) {
		this.setTexture(texture);
		this.setResolution(width, height);
	}

	@Override
	public void render(SpriteBatch batch, float x, float y) {
		minYScroll = y+16;
		maxYScroll = y+Height-16;
		if(!create) {
			yScroll = maxYScroll;
			create = true;
		}
		for(int i=0; i<(14+Height)/8; i++)
			batch.draw(textureRegions.get("tiles0_2"), x, y+(i*7), textureRegions.get("tiles0_2").getRegionWidth()*2, textureRegions.get("tiles0_2").getRegionHeight()*2);
		batch.draw(textureRegions.get("tiles0_1"), x, y, textureRegions.get("tiles0_1").getRegionWidth()*2, textureRegions.get("tiles0_1").getRegionHeight()*2);
		batch.draw(textureRegions.get("tiles0_0"), x, y+Height, textureRegions.get("tiles0_0").getRegionWidth()*2, textureRegions.get("tiles0_0").getRegionHeight()*2);
		batch.draw(textureRegions.get("tiles0_3"), x, yScroll, textureRegions.get("tiles0_3").getRegionWidth()*2, textureRegions.get("tiles0_3").getRegionHeight()*2);
	}
	
	@Override
	public void scroll(float y) {
		if(y>=maxYScroll)
			y = maxYScroll;
		else if(y<=minYScroll)
			y = minYScroll;
		
		yScroll = y;
	}

	@Override
	public float getX() {
		return this.xScroll;
	}

	@Override
	public float getY() {
		return this.yScroll;
	}

	@Override
	public void setY(float y) {
		this.yScroll = y;
	}

	@Override
	public void setMinYScroll(float y) {
		this.minYScroll = y;
	}

	@Override
	public void setMaxYScroll(float y) {
		this.maxYScroll = y;
	}

	@Override
	public float getMinYScroll() {
		return this.minYScroll;
	}

	@Override
	public float getMaxYScroll() {
		return this.maxYScroll;
	}

	@Override
	public void setX(float x) {
		this.xScroll = x;
	}

}
