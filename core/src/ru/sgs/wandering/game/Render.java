package ru.sgs.wandering.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Render {
	Texture door;
	
	public Render() {
		init();
	}
	
	private void init() {
		door= new Texture("game/door.png");
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(door, 0, 0);
	}
}
