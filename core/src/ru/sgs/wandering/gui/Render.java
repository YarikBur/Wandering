package ru.sgs.wandering.gui;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Render {
	public static void render(SpriteBatch batch, float f, float g, float width, float height, Map<String, TextureRegion> textureRegions) {
		float Width = width/2;
		float Height = height/2;
		
		for(float y=g; y < Height + g; y++)
			for(float x=f; x < Width + f; x++) {
				if(x==f) {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_0"), x, y, 2);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_0"), x, y, 2);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles0_0"), x, y, 2);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles1_0"), x, y, 2);
					else
						Scale.draw(batch, textureRegions.get("tiles1_1"), x, y, 2);
				} else if(x==f+1) {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_1"), x, y, 2);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_1"), x, y, 2);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles0_1"), x, y, 2);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles1_1"), x, y, 2);
					else
						Scale.draw(batch, textureRegions.get("tiles1_2"), x, y, 2);
				} else if(x==Width+f-1) {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_5"), x, y, 2);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_4"), x, y, 2);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles5_0"), x, y, 2);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles5_1"), x, y, 2);
					else
						Scale.draw(batch, textureRegions.get("tiles5_2"), x, y, 2);
				} else if(x==Width+f-2) {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_4"), x, y, 2);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_4"), x, y, 2);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles4_1"), x, y, 2);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles4_1"), x, y, 2);
					else
						Scale.draw(batch, textureRegions.get("tiles4_2"), x, y, 2);
				} else {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_2"), x, y, 2);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_2"), x, y, 2);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles2_0"), x, y, 2);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles2_1"), x, y, 2);
					else
						Scale.draw(batch, textureRegions.get("tiles2_2"), x, y, 2);
				}
			}
	}
	
	public static void render(SpriteBatch batch, float f, float g, float width, float height, Map<String, TextureRegion> textureRegions, float up, float right, float down, float left) {
		float Width = width/2;
		float Height = height/2;
		
		for(float y=g; y < Height + g; y++)
			X: for(float x=f; x < Width + f; x++) {
				if(x==f) {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_0"), x, y, 2);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_0"), x, y, 2);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles0_0"), x, y, 2);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles1_0"), x, y, 2);
					else
						Scale.draw(batch, textureRegions.get("tiles1_1"), x, y, 2);
				} else if(x==f+1) {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_1"), x, y, 2);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_1"), x, y, 2);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles0_1"), x, y, 2);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles1_1"), x, y, 2);
					else
						Scale.draw(batch, textureRegions.get("tiles1_2"), x, y, 2);
				} else if(x==Width+f-1) {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_5"), x, y, 2);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_4"), x, y, 2);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles5_0"), x, y, 2);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles5_1"), x, y, 2);
					else
						Scale.draw(batch, textureRegions.get("tiles5_2"), x, y, 2);
				} else if(x==Width+f-2) {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_4"), x, y, 2);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_4"), x, y, 2);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles4_1"), x, y, 2);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles4_1"), x, y, 2);
					else
						Scale.draw(batch, textureRegions.get("tiles4_2"), x, y, 2);
				} else if(x>=f+left && x<= Width+f-right && y>=g+down && y<=Height+g-up-1){
					continue X;
				} else {
					if(y==g)
						Scale.draw(batch, textureRegions.get("tiles5_2"), x, y, 2);
					else if(y==g+1)
						Scale.draw(batch, textureRegions.get("tiles4_2"), x, y, 2);
					else if(y==Height+g-1)
						Scale.draw(batch, textureRegions.get("tiles2_0"), x, y, 2);
					else if(y==Height+g-2)
						Scale.draw(batch, textureRegions.get("tiles2_1"), x, y, 2);
					else
						Scale.draw(batch, textureRegions.get("tiles2_2"), x, y, 2);
				}
			}
	}
}
