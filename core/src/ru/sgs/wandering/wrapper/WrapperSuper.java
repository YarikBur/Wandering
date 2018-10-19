package ru.sgs.wandering.wrapper;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Главный класс для обертки gui
 * @author yaroslav
 */
public class WrapperSuper {
	protected int x;
	protected int y;
	protected float width;
	protected float height;
	protected String texture;
	
	/**
	 * Метод для отрисовки окна
	 * @param batch
	 */
	protected void render(SpriteBatch batch) { }
	
	/**
	 * Метод для установки текстуры
	 * @param texture - Название текстуры
	 */
	protected void setTexture(String texture) {
		this.texture = texture;
	}
	
	/**
	 * Метод для установки размеров окна
	 * @param width - Ширина окна
	 * @param height - Высота окна
	 */
	protected void setSize(float width, float height) {
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Метод для установки координат окна
	 * @param x - X координата
	 * @param y - Y координата
	 */
	protected void setCoordinates(float x, float y) {
		this.x = (int) x;
		this.y = (int) y;
	}
}
