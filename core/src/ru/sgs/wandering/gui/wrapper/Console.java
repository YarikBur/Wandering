package ru.sgs.wandering.gui.wrapper;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sgstudio.sgs02.utils.Settings;
import com.sgstudio.sgs02.utils.Variables;

import ru.sgs.wandering.gui.element.TextField;

public class Console extends WrapperSuper {
	ru.sgs.wandering.gui.element.Console console;
	TextField consoleInput;
	TextField consoleOutput;
	private float[] consoleInC = new float[2];
	private float[] consoleOutC = new float[2];
	
	public Console() {
		this.setSize((Variables.stringToInt(Settings.getProperty("width"))/100)*73f,
				(Variables.stringToInt(Settings.getProperty("height"))/100*21f) + 2f);
		this.setCoordinates(((Variables.stringToInt(Settings.getProperty("width"))/100)*4f)/2,
				((Variables.stringToInt(Settings.getProperty("height"))/100)*2f)/2);
		this.setTexture("inventory.png");
		
		
		consoleInput = new TextField(((Variables.stringToInt(Settings.getProperty("width"))/100)*71.5f), 
				((Variables.stringToInt(Settings.getProperty("height"))/100*3f)+2), true, 7);
		consoleOutput = new TextField(((Variables.stringToInt(Settings.getProperty("width"))/100)*71.5f), 
				((Variables.stringToInt(Settings.getProperty("height"))/100*16f)+2), false, 5);
		
		//TextFiled consoleInput coorzdinates x, y
		consoleInC[0] = ((Variables.stringToInt(Settings.getProperty("width"))/100)*4.8f)/2;
		consoleInC[1] = ((Variables.stringToInt(Settings.getProperty("height"))/100)*3f)/2;
		
		////TextFiled consoleOutput coordinates x, y
		consoleOutC[0] = ((Variables.stringToInt(Settings.getProperty("width"))/100)*4.8f)/2;
		consoleOutC[1] = ((Variables.stringToInt(Settings.getProperty("height"))/100)*6f)/2;
		
		
		console = new ru.sgs.wandering.gui.element.Console(this.texture, this.width, this.height);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		console.render(batch, this.x, this.y +6);
		consoleInput.render(batch, consoleInC[0], consoleInC[1] +6);
		consoleOutput.render(batch, consoleOutC[0], consoleOutC[1] +6);
	}
	
	public void setInputText(String text) {
		consoleInput.setText(text);
	}
	
	public String getInputText() {
		return consoleOutput.getText();
	}
	
	public void setOutputText(String text) {
		consoleOutput.setText(text);
	}
}
