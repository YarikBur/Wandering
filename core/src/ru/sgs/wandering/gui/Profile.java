package ru.sgs.wandering.gui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Profile extends GUISuper {
	public Profile(String texture, float width, float height) {
		this.setTexture(texture);
		this.setResolution(width, height);
		this.setCells(9);
	}

	@Override
	public void render(SpriteBatch batch, float f, float g) {
		//Profile
		Render.render(batch, f, g, Width, Height, this.getTextureRegions());
		
		//Cell
		cell[0].render(batch, f+27, g+100); //шлем
		cell[1].render(batch, f+27, g+76);  //броня
		cell[2].render(batch, f+27, g+52);  //штаны
		cell[3].render(batch, f+27, g+28);  //ботинки
		cell[4].render(batch, f+16, g+4);   //левое кольцо
		cell[5].render(batch, f+38, g+4);   //правое кольцо
		cell[6].render(batch, f+5, g+64);   //левая рука
		cell[7].render(batch, f+49, g+64);  //правая рука
		cell[8].render(batch, f+49, g+89);  //ожерелье
	}
	
}
