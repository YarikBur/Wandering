package ru.sgs.wandering.gui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sgstudio.sgs02.utils.Tiles;

import ru.sgs.wandering.gui.render.Scale;

public class PlayerStatusLines extends GUISuper {
	private int[] col = {1, 1, 1, 1};
	private float scale = 2f;
	
	public PlayerStatusLines(String texture) {
		this.setTexture(texture);
	}
	
	@Override
	public void setTexture(String texture) {
		this.tiles = new Tiles();
		this.tiles.createAtlas("gui/" + texture, 1, 4);
		this.textureRegions = this.tiles.getTextureRegion();
	}
	
	public int[] getCol() {
		return col;
	}
	
	public void setNewCol(int num, boolean full) {
		if(num > 14)
			num = 14;
		 else if(num < 1)
			num = 1;
		int[] newCol = new int[num];
		for(int i=0; i<newCol.length; i++) {
			if(full)
				newCol[i] = 1;
			else
				if(i< col.length)
					newCol[i] = col[i];
				else
					newCol[i] = 0;
		}
		col = newCol;
	}
	
	public void setColColor(int num, int col) {
		this.col[num] = col;
	}
	
	@Override
	public void render(SpriteBatch batch, float x, float y) {
		for(int i=1; i<=col.length; i++) {
			if(col[i-1]==1)
				if(i==col.length)
					Scale.draw2(batch, getTextureRegions("tiles0_1"), x+(getTextureRegions("tiles0_1").getRegionWidth()*i*scale), y, scale);
				else
					Scale.draw2(batch, getTextureRegions("tiles0_0"), x+(getTextureRegions("tiles0_0").getRegionWidth()*i*scale), y, scale);
			else
				if(i==col.length)
					Scale.draw2(batch, getTextureRegions("tiles0_3"), x+(getTextureRegions("tiles0_3").getRegionWidth()*i*scale), y, scale);
				else
					Scale.draw2(batch, getTextureRegions("tiles0_2"), x+(getTextureRegions("tiles0_2").getRegionWidth()*i*scale), y, scale);
		}
	}
}
