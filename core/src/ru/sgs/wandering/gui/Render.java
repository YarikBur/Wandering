package ru.sgs.wandering.gui;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Класс для рисовки секстур
 * @author Yarik
 * @version 0.1
 */
public class Render {
	private static final float scale = 2;
	
	/**
	 * Рисует спрошную текстуру
	 * @param batch
	 * @param f - х координата
	 * @param g - у координата
	 * @param width - ширина текстуры
	 * @param height - высота текстуры
	 * @param textureRegions - текстура
	 */
	public static void render(SpriteBatch batch, float f, float g, float width, float height, Map<String, TextureRegion> textureRegions) {
		float Width = width/2;
		float Height = height/2;
		
		for(float y=g; y < Height + g; y++)
			for(float x=f; x < Width + f; x++) {
				if(x==f) {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_0"), x, y, scale);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_0"), x, y, scale);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles0_0"), x, y, scale);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles1_0"), x, y, scale);
					else
						Scale.draw(batch, textureRegions.get("tiles1_1"), x, y, scale);
				} else if(x==f+1) {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_1"), x, y, scale);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_1"), x, y, scale);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles0_1"), x, y, scale);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles1_1"), x, y, scale);
					else
						Scale.draw(batch, textureRegions.get("tiles1_2"), x, y, scale);
				} else if(x==Width+f-1) {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_5"), x, y, scale);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_4"), x, y, scale);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles5_0"), x, y, scale);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles5_1"), x, y, scale);
					else
						Scale.draw(batch, textureRegions.get("tiles5_2"), x, y, scale);
				} else if(x==Width+f-2) {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_4"), x, y, scale);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_4"), x, y, scale);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles4_1"), x, y, scale);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles4_1"), x, y, scale);
					else
						Scale.draw(batch, textureRegions.get("tiles4_2"), x, y, scale);
				} else {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_2"), x, y, scale);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_2"), x, y, scale);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles2_0"), x, y, scale);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles2_1"), x, y, scale);
					else
						Scale.draw(batch, textureRegions.get("tiles2_2"), x, y, scale);
				}
			}
	}
	
	/**
	 * Рисует текстуру с вырезом по координатам
	 * @param batch
	 * @param f - х координата
	 * @param g - у координата
	 * @param width - ширина текстуры
	 * @param height - высота текстуры
	 * @param textureRegions - текстура
	 * @param up - расстояние до выреза сверху
	 * @param right - расстояние до выреза справа
	 * @param down - расстояние до выреза снизу
	 * @param left - расстояние до выреза слева
	 */
	public static void render(SpriteBatch batch, float f, float g, float width, float height, Map<String, TextureRegion> textureRegions, float up, float right, float down, float left) {
		float Width = width/2;
		float Height = height/2;
		
		for(float y=g; y < Height + g; y++)
			X: for(float x=f; x < Width + f; x++) {
				if(x==f) {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_0"), x, y, scale);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_0"), x, y, scale);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles0_0"), x, y, scale);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles1_0"), x, y, scale);
					else
						Scale.draw(batch, textureRegions.get("tiles1_1"), x, y, scale);
				} else if(x==f+1) {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_1"), x, y, scale);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_1"), x, y, scale);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles0_1"), x, y, scale);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles1_1"), x, y, scale);
					else
						Scale.draw(batch, textureRegions.get("tiles1_2"), x, y, scale);
				} else if(x==Width+f-1) {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_5"), x, y, scale);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_4"), x, y, scale);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles5_0"), x, y, scale);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles5_1"), x, y, scale);
					else
						Scale.draw(batch, textureRegions.get("tiles5_2"), x, y, scale);
				} else if(x==Width+f-2) {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_4"), x, y, scale);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_4"), x, y, scale);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles4_1"), x, y, scale);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles4_1"), x, y, scale);
					else
						Scale.draw(batch, textureRegions.get("tiles4_2"), x, y, scale);
				} else if(x>=f+left && x<= Width+f-right && y>=g+down && y<=Height+g-up-1){
					continue X;
				} else {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_2"), x, y, scale);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_2"), x, y, scale);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles2_0"), x, y, scale);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles2_1"), x, y, scale);
					else
						Scale.draw(batch, textureRegions.get("tiles2_2"), x, y, scale);
				}
			}
	}
	
	/**
	 * Рисует обрезанную текстуру
	 * @param batch
	 * @param f - х координата
	 * @param g - у координата
	 * @param width - ширина текстуры
	 * @param height - высота текстуры
	 * @param textureRegions - текстура
	 * @param up - сколько обрезать сверху
	 * @param down - сколько обрезать снизу
	 */
	public static void render(SpriteBatch batch, float f, float g, float width, float height, Map<String, TextureRegion> textureRegions, float up, float down) {
		float Width = width/2;
		float Height = height/2;
		
		Y: for(float y=g; y < Height + g; y++) {
			if(y<=g+down)
				continue Y;
			else if(y>=Height+g-up)
				continue Y;
			else
				for(float x=f; x < Width + f; x++) {
					if(x==f) {
						if(y==g)
							Scale.draw(batch, textureRegions.get("tiles5_0"), x, y, scale);
						else if(y==g+1)
							Scale.draw(batch, textureRegions.get("tiles4_0"), x, y, scale);
						else if(y==Height+g-1)
							Scale.draw(batch, textureRegions.get("tiles0_0"), x, y, scale);
						else if(y==Height+g-2)
							Scale.draw(batch, textureRegions.get("tiles1_0"), x, y, scale);
						else
							Scale.draw(batch, textureRegions.get("tiles1_1"), x, y, scale);
					} else if(x==f+1) {
						if(y==g)
							Scale.draw(batch, textureRegions.get("tiles5_1"), x, y, scale);
						else if(y==g+1)
							Scale.draw(batch, textureRegions.get("tiles4_1"), x, y, scale);
						else if(y==Height+g-1)
							Scale.draw(batch, textureRegions.get("tiles0_1"), x, y, scale);
						else if(y==Height+g-2)
							Scale.draw(batch, textureRegions.get("tiles1_1"), x, y, scale);
						else
							Scale.draw(batch, textureRegions.get("tiles1_2"), x, y, scale);
					} else if(x==Width+f-1) {
						if(y==g)
							Scale.draw(batch, textureRegions.get("tiles5_5"), x, y, scale);
						else if(y==g+1)
							Scale.draw(batch, textureRegions.get("tiles4_4"), x, y, scale);
						else if(y==Height+g-1)
							Scale.draw(batch, textureRegions.get("tiles5_0"), x, y, scale);
						else if(y==Height+g-2)
							Scale.draw(batch, textureRegions.get("tiles5_1"), x, y, scale);
						else
							Scale.draw(batch, textureRegions.get("tiles5_2"), x, y, scale);
					} else if(x==Width+f-2) {
						if(y==g)
							Scale.draw(batch, textureRegions.get("tiles5_4"), x, y, scale);
						else if(y==g+1)
							Scale.draw(batch, textureRegions.get("tiles4_4"), x, y, scale);
						else if(y==Height+g-1)
							Scale.draw(batch, textureRegions.get("tiles4_1"), x, y, scale);
						else if(y==Height+g-2)
							Scale.draw(batch, textureRegions.get("tiles4_1"), x, y, scale);
						else
							Scale.draw(batch, textureRegions.get("tiles4_2"), x, y, scale);
					} else {
						if(y==g)
							Scale.draw(batch, textureRegions.get("tiles5_2"), x, y, scale);
						else if(y==g+1)
							Scale.draw(batch, textureRegions.get("tiles4_2"), x, y, scale);
						else if(y==Height+g-1)
							Scale.draw(batch, textureRegions.get("tiles2_0"), x, y, scale);
						else if(y==Height+g-2)
							Scale.draw(batch, textureRegions.get("tiles2_1"), x, y, scale);
						else
							Scale.draw(batch, textureRegions.get("tiles2_2"), x, y, scale);
					}
				}
		}
	}
}
