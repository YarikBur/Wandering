package ru.sgs.wandering.wrapper;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sgstudio.sgs02.utils.Settings;
import com.sgstudio.sgs02.utils.Variables;

import ru.sgs.wandering.gui.TextField;

public class Description extends WrapperSuper {
	ru.sgs.wandering.gui.Description description;
	TextField descriptionName;
	TextField descriptionItem;
	private float[] desNameC = new float[2];
	private float[] desItemC = new float[2];
	
	public Description() {
		this.setSize((Variables.stringToInt(Settings.getProperty("width"))/100)*17.5f, 
				(Variables.stringToInt(Settings.getProperty("height"))/100*19f) + 2f);
		this.setCoordinates(((Variables.stringToInt(Settings.getProperty("width"))/100)*78.5f)/2, 
				(Variables.stringToInt(Settings.getProperty("height"))/100)+6f);
		this.setTexture("inventory.png");
		
		
		descriptionName = new TextField(((Variables.stringToInt(Settings.getProperty("width"))/100)*14f)+2, 
				(Variables.stringToInt(Settings.getProperty("height"))/100*2f) + 4f, true, 5);
		descriptionItem = new TextField(((Variables.stringToInt(Settings.getProperty("width"))/100)*14f)+2, 
				(Variables.stringToInt(Settings.getProperty("height"))/100*14f) + 6f, false, 5);
		
		//TextFiled descriptionName coordinates x, y
		desNameC[0] = ((Variables.stringToInt(Settings.getProperty("width"))/100)*78.5f)/2+3;
		desNameC[1] = (Variables.stringToInt(Settings.getProperty("height"))/100)+53f;
		
		////TextFiled descriptionItem coordinates x, y
		desItemC[0] = ((Variables.stringToInt(Settings.getProperty("width"))/100)*78.5f)/2+3;
		desItemC[1] = (Variables.stringToInt(Settings.getProperty("height"))/100)+9f;
		
		
		description = new ru.sgs.wandering.gui.Description(this.texture, this.width, this.height);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		description.render(batch, x, y);
		descriptionName.render(batch, desNameC[0], desNameC[1]);
		descriptionItem.render(batch, desItemC[0], desItemC[1]);
	}
	
	public void setDescriptionName(String text) {
		descriptionName.setText(text);
	}
	
	public void setDescriptionItem(String text) {
		descriptionItem.setText(text);
	}
}
