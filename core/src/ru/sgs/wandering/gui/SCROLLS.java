package ru.sgs.wandering.gui;

public interface SCROLLS {
	float getX();
	float getY();
	float getMinYScroll();
	float getMaxYScroll();
	
	void setY(float y);
	void setX(float x);
	void setMinYScroll(float y);
	void setMaxYScroll(float y);
	void scroll(float y);
}
