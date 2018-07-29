package ru.sgs.wandering.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sgstudio.sgs02.utils.Settings;

public class Main implements Screen {
	SpriteBatch batch;
	Texture gui;
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		gui = new Texture("gui.png");
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(gui, 0, 0);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		Settings.setProperty("width", width + ""); 
		Settings.setProperty("height", height + ""); 
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
