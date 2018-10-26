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

import ru.sgs.wandering.gui.element.Cell;
import ru.sgs.wandering.gui.wrapper.Console;
import ru.sgs.wandering.gui.wrapper.Description;
import ru.sgs.wandering.gui.wrapper.Inventory;
import ru.sgs.wandering.gui.wrapper.Map;
import ru.sgs.wandering.gui.wrapper.PlayerStatus;
import ru.sgs.wandering.gui.wrapper.Process;
import ru.sgs.wandering.gui.wrapper.Profile;

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
		map = new Map();
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
		
		map.render(batch);
		
		status.render(batch);
		
		batch.end();
		
		map.renderGame(batch);
	}

	private float color(int color) {
		return color/255f;
	}
	
//	private float rotationSpeed = 0.5f;
	
	private void handleInput() {
		if(Gdx.input.isKeyJustPressed(Input.Keys.Q))
			status.addCol("HP", true, true);
		if(Gdx.input.isKeyJustPressed(Input.Keys.W))
			status.addCol("HP", false, true);
		if(Gdx.input.isKeyJustPressed(Input.Keys.A))
			status.addCol("Energy", true, true);
		if(Gdx.input.isKeyJustPressed(Input.Keys.S))
			status.addCol("Energy", false, true);
		if(Gdx.input.isKeyJustPressed(Input.Keys.Z))
			status.addCol("Stamina", true, true);
		if(Gdx.input.isKeyJustPressed(Input.Keys.X))
			status.addCol("Stamina", false, true);
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.E))
			status.addCol("HP", false, false);
		if(Gdx.input.isKeyJustPressed(Input.Keys.D))
			status.addCol("Energy", false, false);
		if(Gdx.input.isKeyJustPressed(Input.Keys.C))
			status.addCol("Stamina", false, false);
		
//		if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
//			cam.zoom += 0.02;
//		}
//		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
//			cam.zoom -= 0.02;
//		}
//		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
//			cam.translate(-3, 0, 0);
//		}
//		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
//			cam.translate(3, 0, 0);
//		}
//		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
//			cam.translate(0, -3, 0);
//		}
//		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
//			cam.translate(0, 3, 0);
//		}
//		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
//			cam.rotate(-rotationSpeed, 0, 0, 1);
//		}
//		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
//			cam.rotate(rotationSpeed, 0, 0, 1);
//		}
//		if(Gdx.input.isKeyPressed(Input.Keys.Z))
//			scroll--;
//		if(Gdx.input.isKeyPressed(Input.Keys.X))
//			scroll++;
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
