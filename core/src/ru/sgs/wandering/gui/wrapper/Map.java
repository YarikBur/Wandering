package ru.sgs.wandering.gui.wrapper;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sgstudio.sgs02.utils.Settings;
import com.sgstudio.sgs02.utils.Variables;

import ru.sgs.wandering.game.KeyHandler;

public class Map extends WrapperSuper {
	OrthographicCamera cam;
	ru.sgs.wandering.game.Render ren;
	ru.sgs.wandering.gui.element.Map map;
	
	public Map() {
		this.setSize((Variables.stringToInt(Settings.getProperty("width"))/100)*73f, 
				(Variables.stringToInt(Settings.getProperty("height"))/100)*50f);
		this.setCoordinates(((Variables.stringToInt(Settings.getProperty("width"))/100)*4f)/2, 
				((Variables.stringToInt(Settings.getProperty("height"))/100)*13f) + 4f);
		this.setTexture("inventory.png");
		
		map = new ru.sgs.wandering.gui.element.Map(texture, width, height);
	
		init();
	}
	
	private void init() {
		ren = new ru.sgs.wandering.game.Render();
		cam = new OrthographicCamera();
		cam.viewportWidth = Variables.stringToInt(Settings.getProperty("width"));
		cam.viewportHeight = Variables.stringToInt(Settings.getProperty("height"));
		cam.position.set(cam.viewportWidth/2-(x+3)*2, cam.viewportHeight/2-(y+3)*2, 0);
		cam.update();
	}
	
	@Override
	public void render(SpriteBatch batch) {
		map.render(batch, x, y);
	}
	
	public void renderGame(SpriteBatch batch) {
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		
		batch.begin();
		
		ren.render(batch);
		
		batch.end();

		KeyHandler.move(cam);
	}
}
