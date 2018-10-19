package ru.sgs.wandering.wrapper;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sgstudio.sgs02.utils.Settings;
import com.sgstudio.sgs02.utils.Variables;

public class Profile extends WrapperSuper {
	ru.sgs.wandering.gui.Profile profile;
	
	public Profile() {
		this.setSize((Variables.stringToInt(Settings.getProperty("width"))/100)*17.5f, 
				((Variables.stringToInt(Settings.getProperty("height"))/100)*40f) + 4f);
		this.setCoordinates(((Variables.stringToInt(Settings.getProperty("width"))/100)*78.5f)/2, 
				((Variables.stringToInt(Settings.getProperty("height"))/100)*55f)/2 + 1f);
		this.setTexture("inventory.png");
		
		profile = new ru.sgs.wandering.gui.Profile(this.texture, this.width, this.height);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		profile.render(batch, this.x, this.y);
	}
}
