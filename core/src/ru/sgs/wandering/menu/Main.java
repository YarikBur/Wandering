package ru.sgs.wandering.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sgstudio.sgs02.utils.Settings;
import com.sgstudio.sgs02.utils.Variables;

import ru.sgs.wandering.gui.Cell;
import ru.sgs.wandering.gui.Inventory;
import ru.sgs.wandering.gui.Profile;

public class Main implements Screen {
	SpriteBatch batch;
	OrthographicCamera cam;
	
	Inventory inventory;
	Cell cell;
	Texture gui;
	Profile profile;
	@Override
	public void show() {
		cam = new OrthographicCamera();
		cam.viewportWidth = Variables.stringToInt(Settings.getProperty("width"));
		cam.viewportHeight = Variables.stringToInt(Settings.getProperty("height"));
		cam.position.set(cam.viewportWidth/2, cam.viewportHeight/2, 0);
		cam.update();
		batch = new SpriteBatch();

		cell = new Cell();
		cell.setTexture();
		
		inventory = new Inventory();
		inventory.setTexture();
		gui = new Texture("gui.png");
		profile = new Profile();
	}
	
	int scroll = 0;
	
	@Override
	public void render(float delta) {
		handleInput();
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		
		Gdx.gl.glClearColor(color(149), color(124), color(120), 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		batch.begin();
		//batch.draw(gui, 0, 0);
		inventory.setCellY(scroll);
		inventory.render(batch, ((Variables.stringToInt(Settings.getProperty("width"))/100)*78.5f)/2, ((Variables.stringToInt(Settings.getProperty("height"))/100)*10f)+2);
		profile.render(batch, ((Variables.stringToInt(Settings.getProperty("width"))/100)*78.5f)/2, ((Variables.stringToInt(Settings.getProperty("height"))/100)*10f)+45*2);
		batch.end();
	}

	private float color(int color) {
		return color/255f;
	}
	
	private float rotationSpeed = 0.5f;
	
	private void handleInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			cam.zoom += 0.02;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
			cam.zoom -= 0.02;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			cam.translate(-3, 0, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			cam.translate(3, 0, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			cam.translate(0, -3, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			cam.translate(0, 3, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			cam.rotate(-rotationSpeed, 0, 0, 1);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.E)) {
			cam.rotate(rotationSpeed, 0, 0, 1);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.Z))
			scroll--;
		if(Gdx.input.isKeyPressed(Input.Keys.X))
			scroll++;
		
		if(Gdx.input.isButtonPressed(0)) {
			if((600-Gdx.input.getY()) >= inventory.getScroll().getMinYScroll() && (600-Gdx.input.getY()) <= inventory.getScroll().getMaxYScroll()+7)
				if(Gdx.input.getX() >= inventory.getScroll().getX() && Gdx.input.getX() <= (inventory.getScroll().getX()+(7*2))) {
					inventory.getScroll().scroll(600-Gdx.input.getY()-7);
					System.out.println((600-Gdx.input.getY()) + "  " + inventory.getScroll().getY());
				}
		}
	}

	@Override
	public void resize(int width, int height) {
		Settings.setProperty("width", width + "");
		Settings.setProperty("height", height + "");
		
		inventory.setResolution();
		cell.setResolution();
		
		cam.viewportWidth = Variables.stringToInt(Settings.getProperty("width"));
		cam.viewportHeight = Variables.stringToInt(Settings.getProperty("height"));
		cam.update();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}

}
