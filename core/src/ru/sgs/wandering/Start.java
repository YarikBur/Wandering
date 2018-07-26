package ru.sgs.wandering;

import com.badlogic.gdx.Game;

import ru.sgs.wandering.menu.Main;

public class Start extends Game {
	private static Main menu;
	
	@Override
	public void create () {
		menu = new Main();
		
		this.setScreen(menu);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
	}
}
