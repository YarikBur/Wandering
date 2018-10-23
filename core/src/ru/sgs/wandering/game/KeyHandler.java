package ru.sgs.wandering.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class KeyHandler {
	public static void move(OrthographicCamera cam) {
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			cam.translate(-3, 0, 0);
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
			cam.translate(3, 0, 0);
	}
}
