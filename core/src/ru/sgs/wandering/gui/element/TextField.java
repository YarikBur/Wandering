package ru.sgs.wandering.gui.element;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgs.wandering.gui.render.Render;
import ru.sgs.wandering.gui.render.Text;

public class TextField extends GUISuper {
	private String text;
	private boolean black;
	private float textSize;
	private Text textClass;
	
	public TextField(float width, float height, boolean black, float textSize) {
		this.setResolution(width, height);
		this.setBlack(black);
		this.setTextSize(textSize);
		
		textClass = new Text();
		textClass.createFont(textSize, 0, 0, 0, 1);
	}
	
	public boolean getBlack() {
		return black;
	}
	
	public void setBlack(boolean black) {
		if(black)
			this.setTexture("descriptionD.png");
		else
			this.setTexture("descriptionW.png");
		this.black = black;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public float getTextSize() {
		return textSize;
	}
	
	public void setTextSize(float textSize) {
		this.textSize = textSize;
	}
	
	@Override
	public void render(SpriteBatch batch, float f, float g) {
		Render.render(batch, f, g, this.getWigth(), this.getHeight(), this.getTextureRegions());
		textClass.render(batch, text, (int) f+2, (int) (g+Height/2-2));
	}
}
