package ru.sgs.wandering.wrapper;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sgstudio.sgs02.utils.Settings;
import com.sgstudio.sgs02.utils.Variables;

import ru.sgs.wandering.gui.TextField;

public class Process extends WrapperSuper {
	ru.sgs.wandering.gui.Process process;
	private TextField processList;
	private float[] proLiC = new float[2];
	
	public Process() {
		this.setSize((Variables.stringToInt(Settings.getProperty("width"))/100)*39f + 6f,
				(Variables.stringToInt(Settings.getProperty("height"))/100)*16f + 4f);
		this.setCoordinates(((Variables.stringToInt(Settings.getProperty("width"))/100)*37f)/2 + 1f, 
				(Variables.stringToInt(Settings.getProperty("height"))/100)*39.7f);
		this.setTexture("inventory.png");
		
		processList = new TextField((Variables.stringToInt(Settings.getProperty("width"))/100)*38f + 2f, 
				(Variables.stringToInt(Settings.getProperty("height"))/100)*14f + 4f, false, 5);
		
		proLiC[0] = ((Variables.stringToInt(Settings.getProperty("width"))/100)*37f)/2 + 4f;
		proLiC[1] = (Variables.stringToInt(Settings.getProperty("height"))/100)*39.7f + 3f;
		
		
		setProcessList("");
		process = new ru.sgs.wandering.gui.Process(texture, width, height);
	}
	
	public void setProcessList(String text) {
		processList.setText(text);;
	}
	
	@Override
	public void render(SpriteBatch batch) {
		process.render(batch, x, y);
		processList.render(batch, proLiC[0], proLiC[1]);
	}
}
