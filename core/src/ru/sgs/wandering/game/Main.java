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
import ru.sgs.wandering.gui.Console;
import ru.sgs.wandering.gui.Description;
import ru.sgs.wandering.gui.Inventory;
import ru.sgs.wandering.gui.Profile;
import ru.sgs.wandering.gui.TextField;

public class Main implements Screen {
	SpriteBatch batch;
	OrthographicCamera cam;
	
	Inventory inventory;
	Cell cell;
	Texture gui;
	Profile profile;
	Description description;
	TextField descriptionName;
	TextField descriptionItem;
	Console console;
	TextField consoleInput;
	TextField consoleOutput;
	
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
		inventory = new Inventory("inventory.png", ((Variables.stringToInt(Settings.getProperty("width"))/100)*17.5f), (Variables.stringToInt(Settings.getProperty("height"))/100)*28f);
		profile = new Profile("inventory.png", ((Variables.stringToInt(Settings.getProperty("width"))/100)*17.5f), ((Variables.stringToInt(Settings.getProperty("height"))/100)*40f) + 4f);
		description = new Description("inventory.png", ((Variables.stringToInt(Settings.getProperty("width"))/100)*17.5f), ((Variables.stringToInt(Settings.getProperty("height"))/100*19f) + 2f));
		descriptionName = new TextField(((Variables.stringToInt(Settings.getProperty("width"))/100)*14f)+2, ((Variables.stringToInt(Settings.getProperty("height"))/100*2f) + 4f), true, 5);
		descriptionItem = new TextField(((Variables.stringToInt(Settings.getProperty("width"))/100)*14f)+2, ((Variables.stringToInt(Settings.getProperty("height"))/100*14f) + 6f), false, 5);
		console = new Console("inventory.png", ((Variables.stringToInt(Settings.getProperty("width"))/100)*73f), ((Variables.stringToInt(Settings.getProperty("height"))/100*21f) + 2f));
		consoleInput = new TextField(((Variables.stringToInt(Settings.getProperty("width"))/100)*71f) + 4f, ((Variables.stringToInt(Settings.getProperty("height"))/100*3f)+2), true, 7);
		consoleOutput = new TextField(((Variables.stringToInt(Settings.getProperty("width"))/100)*71f) +4f, ((Variables.stringToInt(Settings.getProperty("height"))/100*16f)+2), true, 5);
		
		
		descriptionName.setText("Name Item");
		descriptionItem.setText("Description \nItem");
		consoleInput.setText("computer@login:~$ help");
		consoleOutput.setText("This is output console commands");
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
		inventory.render(batch, ((Variables.stringToInt(Settings.getProperty("width"))/100)*78.5f)/2, ((Variables.stringToInt(Settings.getProperty("height"))/100)*10f)+16);
		profile.render(batch, ((Variables.stringToInt(Settings.getProperty("width"))/100)*78.5f)/2, ((Variables.stringToInt(Settings.getProperty("height"))/100)*10f)+106);
		description.render(batch, ((Variables.stringToInt(Settings.getProperty("width"))/100)*78.5f)/2, ((Variables.stringToInt(Settings.getProperty("height"))/100)+6f));
		descriptionItem.render(batch, ((Variables.stringToInt(Settings.getProperty("width"))/100)*78.5f)/2+3, ((Variables.stringToInt(Settings.getProperty("height"))/100)+9f));
		descriptionName.render(batch, ((Variables.stringToInt(Settings.getProperty("width"))/100)*78.5f)/2+3, ((Variables.stringToInt(Settings.getProperty("height"))/100)+53f));
		console.render(batch, ((Variables.stringToInt(Settings.getProperty("width"))/100)*4f)/2, ((Variables.stringToInt(Settings.getProperty("width"))/100)*3f)/2);
		consoleInput.render(batch, ((Variables.stringToInt(Settings.getProperty("width"))/100)*4f)/2+3, ((Variables.stringToInt(Settings.getProperty("width"))/100)*3f)/2+3);
		consoleOutput.render(batch, ((Variables.stringToInt(Settings.getProperty("width"))/100)*4f)/2+3, ((Variables.stringToInt(Settings.getProperty("width"))/100)*3f));
		
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
