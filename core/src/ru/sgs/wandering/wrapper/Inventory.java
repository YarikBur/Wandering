package ru.sgs.wandering.wrapper;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sgstudio.sgs02.utils.Settings;
import com.sgstudio.sgs02.utils.Variables;

public class Inventory extends WrapperSuper {
	ru.sgs.wandering.gui.Inventory inventory;
	
	public Inventory() {
		this.setSize((Variables.stringToInt(Settings.getProperty("width"))/100)*17.5f, 
				(Variables.stringToInt(Settings.getProperty("height"))/100)*28f);
		this.setCoordinates(((Variables.stringToInt(Settings.getProperty("width"))/100)*78.5f)/2, 
				((Variables.stringToInt(Settings.getProperty("height"))/100)*10f)+16);
		this.setTexture("inventory.png");
		
		inventory = new ru.sgs.wandering.gui.Inventory(this.texture, this.width, this.height);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		inventory.render(batch, this.x, this.y);
	}
}
