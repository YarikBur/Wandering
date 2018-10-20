package ru.sgs.wandering.game;

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
import ru.sgs.wandering.gui.Map;
import ru.sgs.wandering.wrapper.Console;
import ru.sgs.wandering.wrapper.Description;
import ru.sgs.wandering.wrapper.Inventory;
import ru.sgs.wandering.wrapper.PlayerStatus;
import ru.sgs.wandering.wrapper.Process;
import ru.sgs.wandering.wrapper.Profile;

public class Main implements Screen {
	SpriteBatch batch;
	OrthographicCamera cam;
	
	Inventory inventory;
	Cell cell;
	Texture gui;
	Profile profile;
	Process process;
	Description description;
	Console console;
	Map map;
	PlayerStatus status;
	
	@Override
	public void show() {
		cam = new OrthographicCamera();
		cam.viewportWidth = Variables.stringToInt(Settings.getProperty("width"));
		cam.viewportHeight = Variables.stringToInt(Settings.getProperty("height"));
		cam.position.set(cam.viewportWidth/2, cam.viewportHeight/2, 0);
		cam.update();
		batch = new SpriteBatch();

		cell = new Cell("cell.png");
		
		gui = new Texture("gui/new_gui.png");
		inventory = new Inventory();
		profile = new Profile();
		description = new Description();
		process = new Process();
		map = new Map("inventory.png", ((Variables.stringToInt(Settings.getProperty("width"))/100)*73f), ((Variables.stringToInt(Settings.getProperty("height"))/100)*50f));
		status = new PlayerStatus();
		
		console = new Console();
		
		process.setProcessList("Test process    [====================>] 100%\n"
				+ "Test process2  [=========>                   ]  45%");
		description.setDescriptionName("Name Item");
		description.setDescriptionItem("Description \nItem");
		console.setInputText("computer@login:/$ help");
		console.setOutputText("This is output console commands");
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
//		batch.draw(gui, 0, 0);
		inventory.render(batch);
		profile.render(batch);
		description.render(batch);
		process.render(batch);
		console.render(batch);
		
		map.render(batch, ((Variables.stringToInt(Settings.getProperty("width"))/100)*4f)/2, ((Variables.stringToInt(Settings.getProperty("height"))/100)*13f) + 4f);
		
		status.render(batch);
		
		batch.end();
	}

	private float color(int color) {
		return color/255f;
	}
	
	private float rotationSpeed = 0.5f;
	
	private void handleInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
			cam.zoom += 0.02;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
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
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			cam.rotate(-rotationSpeed, 0, 0, 1);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			cam.rotate(rotationSpeed, 0, 0, 1);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.Z))
			scroll--;
		if(Gdx.input.isKeyPressed(Input.Keys.X))
			scroll++;
		
	}

	@Override
	public void resize(int width, int height) {
		Settings.setProperty("width", width + "");
		Settings.setProperty("height", height + "");
		
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
